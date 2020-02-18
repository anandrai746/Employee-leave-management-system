var V =new Validate();
jQuery(function()
{   
    $("#useremail").val("admin@gmail.com");
    $("#userpassword").val("admin@123");
    $("#login").click(function(){
        
        var usertype =$.trim($("#usertype").val());
        var useremail =$.trim($("#useremail").val());
        var userpassword = $.trim($("#userpassword").val());
        if(usertype===""){
            showMsg("usertype","Select user type");
            return;
        }
        if(useremail===""){
            showMsg("useremail","Enter user id");
            return;
        }else{
            hideMsg("useremail");
        }
        if(userpassword===""){
            showMsg("userpassword","Enter password");
            return;
        }else{
            hideMsg("userpassword");
        }
        userpassword=sha256_digest(userpassword);
        $("#userpassword").val(userpassword);
        $("#loginForm").submit();
    });
    
});

