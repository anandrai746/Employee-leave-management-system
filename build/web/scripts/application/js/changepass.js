var V =new Validate();
$(function()
{       
    $("#userpassword").val("");
    $("#submit").click(function(){
        if(validateChangepass()){
            changePassword();
        }
    });

});

var userlogin= new Object();
function validateChangepass(){
    var userpassword = $.trim($("#userpassword").val());
    var userpasswordconfirm = $.trim($("#userpasswordconfirm").val());

    if(userpassword===""){
        showMsg("userpassword","Enter password");
        return;            
    }else if(userpasswordconfirm===""){
        showMsg("userpasswordconfirm","Enter confirm password");
        return;
    }else if(userpassword!==userpasswordconfirm){
        showMsg("userpasswordconfirm","Enter confirm password is not matching");
        return;
    }else{
        hideMsg("userpassword");
        hideMsg("userpasswordconfirm");            
    }
    userpassword=sha256_digest(userpassword);               
    userlogin.userpassword=userpassword;
    return true;
}
function changePassword(){    
    $.ajax({
        type: "POST",                    
        data: {'option':'1','userpassword':userlogin.userpassword},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){                
                //$("#processing").hide();
                $("#serverresponse").html("Password updated successfully.");
                location.reload();
            }else{
                $("#processing").hide();
                $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#processing").hide();
            $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });      
}