var V =new Validate();
$(function()
{   
    $("#submit").click(function(){
        if(validateProfile()){
            changeProfile();
        }
    });
    $(".reset").click(function(){
     window.location="changeprofile.jsp";
});

});

var userlogin= new Object();
function validateProfile(){
    var userfname = $.trim($("#userfname").val());
    var userlname = $.trim($("#userlname").val());
    var userdob = $.trim($("#userdob").val());
    var usergender = $("input[name='usergender']:checked").val();    
    var usermobile = $.trim($("#usermobile").val());   
    var usergenderL=$("input[name='usergender']:checked").length;
    
    if(userfname===""){
        showMsg("userfname","Enter first name");
        return;            
    }else if(!V.isAlphabetic(userfname)){
        showMsg("userfname","First name should be aplhabetic");
        return;    
    }else{
        hideMsg("userfname");                 
        userlogin.userfname=userfname;
    }

    if(userlname===""){
        showMsg("userlname","Enter last name");
        return;            
    }else if(!V.isAlphabetic(userlname)){
        showMsg("userlname","Last name should be aplhabetic");
        return;    
    }else{
        hideMsg("userlname");                 
        userlogin.userlname=userlname;
    }

    if(userdob===""){
        showMsg("userdob","Enter date of borth");
        return;            
    }else if(!V.isDate(userdob)){
        showMsg("userdob","Date of borth should be in 'YYYY-MM-DD' format");
        return;    
    }else{
        hideMsg("userdob");                 
        userlogin.userdob=userdob;
    }

    if(usergenderL===0){
        showMsg("usergenderM","Select gender");
        return;            
    }else{
        hideMsg("usergenderM");                 
        userlogin.usergender=usergender;
    }    

    if(usermobile===""){
        showMsg("usermobile","Enter mobile number");
        return;            
    }else if(!V.isMobile(usermobile)){
        showMsg("usermobile","Enter a valid mobile number");
        return;    
    }else{
        hideMsg("usermobile");                 
        userlogin.usermobile=usermobile;
    }    
        
    return true;
}
function changeProfile(){
    $.ajax({
        type: "POST",                    
        data: {'option':'3','userlogin':JSON.stringify(userlogin)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){                
                //$("#processing").hide();
                $("#serverresponse").html("Profile updated successfully.");
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