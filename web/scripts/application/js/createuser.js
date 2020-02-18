var V =new Validate();  
   
$(function()
{   
    getDatePicker('userdob'); 
    loadAllUsers();
    $("#submit").click(function(){
        if(validateDetails()){
            createUser();
        }  
    });
$(".reset").click(function(){
     window.location="createuser.jsp";
});
});

var userlogin= new Object();
function validateDetails(){
    var useremail  = $.trim($("#useremail").val());
    var userpassword  = $.trim($("#userpassword").val());
    var conuserpassword  = $.trim($("#conuserpassword").val());
    var userfname  = $.trim($("#userfname").val());
    var userlname  = $.trim($("#userlname").val());
    var userdob  = $.trim($("#userdob").val());
    var usermobile  = $.trim($("#usermobile").val());
    var usergender = $("input[name='usergender']:checked").val();
    var usergenderL = $("input[name='usergender']:checked").length;
    var userrole = $("#userrole").val();
    var userstatus = $("#userstatus").val();
    if(useremail==""){ 
        showMsg("useremail","Enter a user id");
        return false;
    }else if(!V.isEmail(useremail)){
        showMsg("useremail","Enter a valid email");
        return false;
    }else{
        hideMsg("useremail");
        userlogin.useremail=useremail;
    }
    
    
    if(userpassword==""){
        showMsg("userpassword","Enter password");
        return false;
    }else if(conuserpassword==""){
        hideMsg("userpassword");
        showMsg("conuserpassword","Enter confirm password");
        return false;
    }else if(userpassword!==conuserpassword){
        showMsg("conuserpassword","Enter confirm password is not matching");
        return false;
    }else{
        userpassword=sha256_digest(userpassword);
        userlogin.userpassword=userpassword;
        hideMsg("userpassword");
        hideMsg("conuserpassword");
       
    }
    
    if(userfname==""){
        showMsg("userfname","Enter first name");
        return false;
    }else if(!V.isAlphabetic(userfname)){
        showMsg("userfname","First name should be alphabetic");
        return false;
    }else{
        hideMsg("userfname");
        userlogin.userfname=userfname;
    }
    
    
    if(userlname==""){
        showMsg("userlname","Enter last name");
        return false;
    }else if(!V.isAlphabetic(userlname)){
        showMsg("userlname","Last name should be alphabetic");
        return false;
    }else{
        hideMsg("userlname");   
        userlogin.userlname=userlname;
    }
    
    if(userdob==""){
        showMsg("userdob","Enter date of birth");
        return false;
    }else if(!V.isDate(userdob)){
        showMsg("userdob","Date of birth should be in'YYYY-MM-DD' format");
        return false;
    }else if(checkDateFutureOrEqual(userdob)){
        showMsg("userdob","Date of birth cannot be a future date");
        return false;
    }
    else{
        hideMsg("userdob");
        userlogin.userdob=userdob;
    
    }
    if(usergenderL==0){
        showMsg("usergenderM","Select gender");
        return false;
   
    }else{
        hideMsg("usergenderL");
        userlogin.usergender=usergender;
    
    }
   
       if(usermobile==""){
        showMsg("usermobile","Enter mobile number");
        return false;
    }else if(!V.isMobile(usermobile)){
        showMsg("usermobile","Enter a valid mobile number");
        return false;
    }else{
        hideMsg("usermobile");
        userlogin.usermobile=usermobile;
    }
    if(userrole=="-1"){
        showMsg("userrole","Select user role");
        return false;
    }else
        {
            hideMsg("userrole");
        userlogin.userrole=userrole;
        }
    if(userstatus=="-1"){
        showMsg("userstatus","Select user status");
        return false;
    }else
        {
            hideMsg("userstatus");
        userlogin.userstatus=userstatus;
        }
    return true;
}
function createUser(){
    $.ajax({
        type: "POST",                    
        data: {'option':'4','userlogin':JSON.stringify(userlogin)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){        
                $("#serverresponse").html("User created successfully.");
                window.location="createuser.jsp";
            }else if(data==="2"){                                
                $("#serverresponse").html("Email already existe");
            }else if(data==="3"){        
                $("#serverresponse").html("Mobile already existe");    
            }else{                
                $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });    
}
var listData = new Object();

  function loadAllUsers(){
   var data = "option=2";
     jQuery.ajax({
        type: "POST",
        dataType: "json",
        data: data,
        url: "UtilController",
        success: function(data) {
            if(data.listUsers.length>0)
            {   
                listData=data.listUsers;
                var res=""
                jQuery.each(data.listUsers, function(index, row) {
                    var slno=index+1;
                    res+="<tr>"
                    res+="<td>"+slno+"</td>"
                    res+="<td>"+row.userfname+ " "+ row.userlname+"</td>"
                    res+="<td>"+row.useremail+"</td>";                                
                    res+="<td>"+row.usermobile+"</td>";                                
                    res+="<td>"+row.processnames+"</td>";                                
                    res+="<td><input type='button' id='assprobtn' name='assprobtn' value='Assign Process' style='width:100%;' onclick=assignIt('"+row.usercode+"') class='button'><br/>";
                    res+="<input type='button' id='resetpassbtn' style='width:100%;' onclick=resetPassword('"+row.usercode+"','"+row.useremail+"') name='resetpassbtn' value='Reset Password'class='button'><br/>";                                
                    if(row.userstatus==='Y'){
                        res+="<input type='button' id='"+row.usercode+"' name='"+row.userstatus+"' value='Disable' class='button' onclick='enbdis(this.id,this.name)' style='color:green;'/>";                                           
                    }else{
                        res+="<input type='button' id='"+row.usercode+"' name='"+row.userstatus+"' value='Enable' class='button' onclick='enbdis(this.id,this.name)'/>";                                           
                    }
                    res+="</td>";                                
                    res+="</tr>";
                });   
                                
                jQuery("#userCont tbody").html(res);               
                      
            }                          
        },
        error: function(e) { 
//            alert(e.status);
//            alert(e.getMessage())
        }
    });         
  }
  function resetPassword(usercode,useremail)
  {
      alert("res pass")
    userlogin.usercode=usercode;
    userlogin.userpassword=sha256_digest(useremail.split("@")[0]+'@123');
      $.ajax({
        type:"POST",
        data:{
            'option':'6',
            'userpassword':userlogin.userpassword,
            'usercode': userlogin.usercode
            },
        url:"ControllerAdmin",
        success: function(data)
        {
            if (data=="1" || parseInt(data)==1){
                alert("Password reset successfully");
            }else {
                        alert("Unable to reset password");
            }
        },
        error: function(e) {
            //alert (e.status);
            $("#serverresponse").html("sorry,unable to process the request...!<br>Please try again...");
        }
    });
      
  }
  
  function assignIt(usercode){
    var data = {'option':'3','usercode':usercode};
    $.ajax({
        type: "POST",                    
        data: data,
        url: "UtilController",
        dataType: 'json',
        success: function(data)
        {
            var index = listData.map(function(d) { return d["usercode"]; }).indexOf(Number(usercode));   
            var userlogin = listData[index];        
            //var userdata = userlogin.userfname+" "+userlogin.userlname+"<br>("+userlogin.useremail+")<br>"+"("+userlogin.usermobile+")";
            var userdata = userlogin.userfname+" "+userlogin.userlname;
            var res="<table style='width:80%;'>";
//            res+="<tr><td><center>Processes Assigned to </center></td></tr>";
            res+="<tr><td style=font:'bold;'><center>Processes Assigned to "+userdata+"</center></td></tr>";
            if(data.listUserprocesses.length>0)
            {                
                $.each(data.listUserprocesses, function(index, row) {
                    if(row.usercode!==null){
                        res+="<tr><td><input type='checkbox' name='processes' value='"+row.processcode+"' checked/> "+row.processname+"</td></tr>";                                        
                    }else{
                        res+="<tr><td><input type='checkbox' name='processes' value='"+row.processcode+"' /> "+row.processname+"</td></tr>";
                    }
                });
                res+="<tr><td><input type='button' id='"+usercode+"' value='Submit' class='button' onclick='assignProcesses(this.id)'/> <span id='serverresponseP' class='error'></span></td></tr>";
                res+="</table>";
                $("#asspro").html(res);     
            }
            $("#asspro").show();
        },
        error: function(e) {
            alert(e.status);
        }
    });     
}

function assignProcesses(usercode)
{
    userlogin.usercode=usercode;
    var processes=[];
    jQuery("input[name='processes']:checked").each(function() {
       processes.push($(this).val());        
    });	
    userlogin.processes=processes;    
    $.ajax({
        type: "POST",                    
        data: {'option':'11','userlogin':JSON.stringify(userlogin)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data=="1" || parseInt(data)==1){        
                $("#serverresponseP").html("Processes assigned successfully.");                
                location.reload();
            }else{                
                $("#serverresponseP").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponseP").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });
}
 
function enbdis(usercode,userstatus){    
    $.ajax({
        type: "POST",                    
        data: {'option':'10','usercode':usercode,'userstatus':userstatus},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data=="1" || data==1){ 
                if(userstatus=="Y"){
                    $("#serverresponse").html("User disabled successfully.");                    
                }else{
                    $("#serverresponse").html("User enabled successfully.");                    
                }
                    location.reload();
            }else{
                $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);            
            $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });    
}
   
