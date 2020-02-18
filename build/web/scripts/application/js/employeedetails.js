var V =new Validate();
$(function()
{   
     getDatePicker('dob'); 
    showReport();
    viewEmployee();
    onLoad();   
    $("#register").click(function(){
        if(validateEmployee()){
            employeeDetails();
        }
    });
    
    $("#addmorebtn").click(function(){
        add(); 
    });
    $("#sameaspre").click(function(){
        if($("#sameaspre:checked").length>0){
            $("#peraddress").val($.trim($("#preaddress").val()));
            $("#perpin").val($.trim($("#prepin").val()));
        }
    });
        $(".reset").click(function(){
        window.location="employeedetails.jsp";
    });
});
function onLoad(){
     $.ajax({
        type: "GET",                    
        data: "option=1",
        url: "UtilController",
        success: function(data)
        {
            var res="<option value='-1'>SELECT</option>";
            $.each(JSON.parse(data).listMCourses,function(index,data){
                res+="<option value='"+data.key+"'>"+data.value+"</option>"
            });
            $("#coursecode1").html(res);
            
            var res="<option value='-1'>SELECT</option>";
            $.each(JSON.parse(data).listMDesignations,function(index,data){
                res+="<option value='"+data.key+"'>"+data.value+"</option>"
            });
            $("#designation").html(res);
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse1").html("Sorry, some error occurred...");
        }
    });      
}


function add() {
    var str="";
    var value=parseInt($("#addmorebtn").attr("name"));
    value=value+1;
    $("#addmorebtn").attr("name",value);
    str+="<tr id='qualrow"+value+"' class='clearit'> ";
    str+="<td style='width:15%;'>";
    str+="<select id='coursecode"+value+"' name='coursecode' class='select' style='width:100%;'>";
    str+="<option value='-1'>-</option>";
    str+="</select>"; 
    str+="<div id='coursecode"+value+"Msg' class='error'></div>";
    str+="</td>";
    str+="<td style='width:20%;'>";
    str+="<input type='text' id='institute"+value+"' name='institute' class='inputtext' maxlength='100' style='width:100%;'/>";
    str+="<div id='institute"+value+"Msg' class='error'></div>";
    str+="</td>";
    str+="<td style='width:15%;'>";
    str+="<input type='text' id='passingyear"+value+"' name='passingyear' class='inputtext' maxlength='4' style='width:100%;'/>";
    str+="<div id='passingyear"+value+"Msg' class='error'></div>";
    str+="</td>";
    str+="<td style='width:15%;'>";
    str+="<input type='text' id='percentage"+value+"' name='percentage' class='inputtext' maxlength='5' style='width:100%;'/>";
    str+="<div id='percentage"+value+"Msg' class='error'></div>";
    str+="</td>";
    str+="<td style='width:10%;'>";
    str+="<input type='text' id='division"+value+"' name='division' class='inputtext' maxlength='5' style='width:100%;'/>";
    str+="<div id='division"+value+"Msg' class='error'></div>";
    str+="</td>";
    str+="<td style='width:10%;'>"
    str+="<span class='button' style='z-index: 0;'>Brows</span>"
    str+="<input type='file' id='passcertificate"+value+"' name='passcertificate' style='display: none;z-index: 100;'/>"
    str+="</td>"
    str+="<td style='width:10%;'>"
    str+="<span class='button' size='10' style='z-index: 0;'>Brows</span>"
    str+="<input type='file' id='marksheet"+value+"' name='marksheet' class='inputtext' style='display: none;z-index: 100;'/>"
    str+="</td>";
    str+="<td style='width:5%;'>";
    str+=" <img src='scripts/application/css/images/close.png' valign='middle' class='qualdelete' alt='delete' width='15' height='15'  name='"+value+"' />";
    str+="</td>";
    str+="</tr>";
    $("#qualtable tr").last().before(str);
    $("#coursecode"+value).html($("#coursecode1").html());
    event();
    
}
function event() {
    $(".qualdelete").click(function() {
        var value = $(this).attr("name");
        $("#qualrow" + value).remove();
    });
    $("[name=coursecode]").change(function(){
        var coursecodes=document.getElementsByName("coursecode");
        var i,count=0;
        for(i=0;i<coursecodes.length;i++)
        {
            if($(this).val()===coursecodes[i].value)
            {
                count++;
            }
        }
        if(count===2)
        {
            showMsg($(this).attr("id"),"It is aleady selected");
            $(this).val("-1");
        }
    });
}
var employee = new Object();
function validateEmployee()
{
    var designation = $.trim($("#designation").val());
    var fname = $.trim($("#fname").val());
    var mname = $.trim($("#mname").val());
    var lname = $.trim($("#lname").val());
    var dob = $.trim($("#dob").val());	
    var genderL = $("input[name='gender']:checked").length;
    var gender=$("input[name='gender']:checked").val();
    var mobile = $.trim($("#mobile").val());
    var bloodgroup = $.trim($("#bloodgroup").val());
    var empemail = $.trim($("#empemail").val());
    var emppassword = $.trim($("#emppassword").val());
    var conemppassword = $("#conemppassword").val();	
    var fathersname = $.trim($("#fathersname").val());
    var preaddress = $.trim($("#preaddress").val());
    var prepin = $.trim($("#prepin").val());
    var peraddress = $.trim($("#peraddress").val());
    var perpin = $.trim($("#perpin").val());
    var panno = $.trim($("#panno").val());
    var epicid = $.trim($("#epicid").val());
    var adharno = $.trim($("#adharno").val());
    var drivinglicenceno = $.trim($("#drivinglicenceno").val());
    var passportno = $.trim($("#passportno").val());

    var coursecode=[];
    var institute=[];
    var passingyear=[];
    var percentage=[];
    var division=[];

    if(designation===""){
        showMsg("designation","Select  designation ");
        return false;
    }else{
        hideMsg("designation");
        employee.designationcode=designation;
    }
    if(fname===""){
        showMsg("fname","Enter  first name");
        return false;
    }else{
        hideMsg("fname");
        employee.fname=fname;
    }
    
    if(lname===""){
        showMsg("lname","Enter last name");
        return false;
    }else{
        hideMsg("lname");
        employee.lname=lname;
    }
    
    if(dob==""){
        showMsg("dob","Enter date of birth");
        return false;
        
    }else if(!V.isDate(dob)){
        showMsg("dob","Date of birth should be in'YYYY-MM-DD' format");
        return false;
    }else if(checkDateFutureOrEqual(dob)){
        showMsg("dob","Date of birth cannot be a future date");
        return false;
    }else{
        hideMsg("dob");
        employee.dob=dob;
    
    }
    
    
    if(genderL==0){
        showMsg("genderM","Select gender");
        return false;
   
    }else{
        hideMsg("genderM");
        employee.gender=gender;
    
    }
    
    if(mobile==""){
        showMsg("mobile","Enter mobile number");
        return false;
    }else if(!V.isMobile(mobile)){
        showMsg("mobile","Enter a valid mobile number");
        return false;
    }else{
        hideMsg("mobile");
        employee.mobile=mobile;
    }
    
    if(empemail==""){ 
        showMsg("empemail","Enter a user id");
        return false;
    }else if(!V.isEmail(empemail)){
        showMsg("empemail","Enter a valid email");
        return false;
    }else{
        hideMsg("empemail");
        employee.empemail=empemail;
    }
    
     if(emppassword==""){
        showMsg("emppassword","Enter password");
        return false;
    }else if(conemppassword==""){
        hideMsg("emppassword");
        showMsg("conemppassword","Enter confirm password");
        return false;
    }else if(emppassword!==conemppassword){
        showMsg("conemppassword","Enter confirm password is not matching");
        return false;
    }else{
        emppassword=sha256_digest(emppassword);
        employee.emppassword=emppassword;
        hideMsg("emppassword");
        hideMsg("conemppassword");
       
    }
    
    if (bloodgroup == "") {
        showMsg("bloodgroup", "Enter bloodgroup");
        return false;
    } else {
        hideMsg("bloodgroup");
        employee.bloodgroup=bloodgroup;
    }
    
    if (fathersname === "") {
        showMsg("fathersname", "Enter Your Father Name");
        return false;
    } else {
        hideMsg("fathersname");
        employee.fathersname=fathersname;
    } 
    if (preaddress === "") {
        showMsg("preaddress", "Enter Your Present Address");
        return false;
    } else {
        hideMsg("preaddress");
        employee.preaddress=preaddress;
    }
    if (prepin === "") {
        showMsg("prepin", "Enter Your Present Pincode");
        return false;
    }else if(!V.isNumeric(prepin)){
        showMsg("prepin","Present pincode must be numeric");
        return false;
    }else if(prepin.length!=6){
        showMsg("prepin","Present pincode must be 6 digits only");
        return false;
    } else {
        hideMsg("prepin");
        employee.prepin=prepin;
    }
    if (peraddress === "") {
        showMsg("peraddress", "Enter Your Permanent Address");
        return false;
    } else {
        hideMsg("peraddress");
        employee.peraddress=peraddress;
    }
    if (perpin === "") {
        showMsg("perpin", "Enter Your Permanent Pincode ");
        return false;
    }else if(!V.isNumeric(perpin)){
        showMsg("perpin","Permanent pincode must be numeric");
        return false;
    }else if(perpin.length!=6){
        showMsg("perpin","Permanent pincode must be 6 digits only");
        return false;
    } else {
        hideMsg("perpin");
        employee.perpin=perpin;
    }
    if (panno === "") {
        showMsg("panno", "Enter Your Pan number ");
        return false;
    } else {
        hideMsg("panno");
        employee.panno=panno;
    }
    if (epicid === "") {
        showMsg("epicid", "Enter Your Epic ID ");
        return false;
    } else {
        hideMsg("epicid");
        employee.epicid=epicid;
    }
      
    $("[name='coursecode']").each(function(){
        var id=$(this).attr("id");
        if($(this).val()=="-1" || $(this).val()==-1){
            showMsg(id, "Please select the course Name");
            return false;
        }else
        {
            hideMsg(id);
            coursecode.push($(this).val())
        }
    });
     
    $("[name='institute']").each(function(){
        var id=$(this).attr("id");
        if($(this).val()==""){
            showMsg(id, "Please enter institute");
            return false;
        }else
        {
            hideMsg(id);
            institute.push($(this).val())
        }
    });
    $("[name='passingyear']").each(function(){
        var id=$(this).attr("id");
        if($(this).val()==""){
            showMsg(id, "Please enter year");
            return false;
        }else
        {
            hideMsg(id);
            passingyear.push($(this).val())
        }
    });
    $("[name='percentage']").each(function(){
        var id=$(this).attr("id");
        if($(this).val()==""){
            showMsg(id, "Please enter percentage");
            return false;
        }else
        {
            hideMsg(id);
            percentage.push($(this).val())
        }
    });
    $("[name='division']").each(function(){
        var id=$(this).attr("id");
        if($(this).val()==""){
            showMsg(id, "Please enter division");
            return false;
        }else
        {
            hideMsg(id);
            division.push($(this).val())
        }
    });
    
    employee.coursecode = coursecode;
    employee.institute = institute;
    employee.passingyear = passingyear;
    employee.percentage = percentage;
    employee.division = division;

    return true;
}
function employeeDetails(){
    $.ajax({
        type: "POST",
        data: {
            'option':'1',
            'employees':JSON.stringify(employee)
        },
        url: "ControllerApplication",
        succcess: function(data)
        {
            if(data==="1" || data==1){                
                //$("#processing").hide();
                
                $("#serverresponse").html("Registration Done successfully."); 
                //location.reload();
                
            }else{
            //    $("#processing").hide();
                $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
            }
         
        },
        error: function(e){
          
            $("#serverresponse").html("Sorry, unable to process the request....!<br>Plese try again.....");
        }
    });   
}


var listData = new Object();

  function viewEmployee(){
      
   var data = "option=4";
     jQuery.ajax({
        type: "POST",
        dataType: "json",
        data: data,
        url: "UtilController",
        success: function(data) {
            
            if(data.viewEmployee.length>0)
            {   
                listData=data.viewEmployee;
                var res=""
                jQuery.each(data.viewEmployee, function(index, row) {
                    var slno=index+1;
                    res+="<tr>";
                    res+="<td>"+slno+"</td>";
                    res+="<td>"+row.fname+ " "+ row.lname+"</td>";
                    res+="<td>"+row.dob+"</td>";
                    res+="<td>"+row.designationname+"</td>";
                    res+="<td>"+row.empemail+"</td>";
                    res+="<td>"+row.mobile+"</td>";                                
                    res+="<td>";                              
                    res+="<input type='button' value='View PDF' id='"+row.empcode+"'   name='p' class='button' onclick='showReport(this.id,this.name)'>";                              
                    res+="<input type='button' value='View Excel' id='"+row.empcode+"' name='x' class='button' onclick='showReport(this.id,this.name)'>";                              
                    res+="</td>";                                
                    res+="</tr>";
                });   
                                
                jQuery("#employeeCont tbody").html(res);               
                      
            }                          
        },
        error: function(e) { 
            //alert(e.status);
            //alert(e.getMessage())
        }
    });         
  }



function showMsg(id, msg)
{
    $("#" + id + "Msg").text(msg + "...!");
    $("#" + id).focus();
}
function hideMsg(id)
{
    $("#" + id + "Msg").text("");
}
function showReport(id,type){
    window.open('ControllerReports?option=1&type='+type+'&empcode='+id,'_blank');
}

function onload(){
    
}