var V =new Validate();
$(function()
{
      onLoad();
    
    $("#submitcoursesI").click(function(){
        insertCourses();
    });    
    $("#submitcoursesU").click(function(){
        updateCourses();
    });
    
   $("#submitdesignationsI").click(function(){
      insertDesignations();
   });
   $("#submitdesignationsU").click(function(){
      updateDesignations();
   });
   
     $("#submitenclosuresI").click(function(){
         insertEnclosures();
   });
    $("#submitenclosuresU").click(function(){
       updateEnclosures();
   });
   
    $("#submitleavecategoriesI").click(function(){
        insertLeavecategories();
    });
    $("#submitleavecategoriesU").click(function(){
        updateLeavecategories();
    });
    
    
     $("#submitpayscalesI").click(function(){
        insertPayscales();
    });
    $("#submitpayscalesU").click(function(){
        updatePayscales();
    });
    
    $("#submitpaysdesI").click(function(){
        insertDesPayscales();
    });
    $("#submitpaysdesU").click(function(){
        updatetDesPayscales();
    });
    
    $(".reset").click(function(){
        window.location="initialization.jsp";
    });
});
    
    
var initData = new Object();
function onLoad()
{
    var data = {'option':1};
    $.ajax({
        type: "POST",                    
        data: data,
        url: "UtilController",
        dataType: 'json',
        success: function(data)
        {
            initData=data;
            var res="";
            if(data.listCourses.length>0)
            {                
                $.each(data.listCourses, function(index, row) {
                    var edb = "<span id="+row.key+" class='badge pull-right' style='cursor:pointer;' onclick='editCourses(this.id)'>Edit</span>";
                    res+="<tr><td>"+row.value+edb+"</td></tr>";                
                });   
                $("#courses tbody").html(res);                     
            }
            
            
            res="";
            if(data.listDesignations.length>0)
            {                
                $.each(data.listDesignations, function(index, row) {
                    var edb = "<span id="+row.key+" class='badge pull-right' style='cursor:pointer;' onclick='editDesignations(this.id)'>Edit</span>";
                    res+="<tr><td>"+row.value+edb+"</td></tr>";              
                });   
                
                $("#designations tbody").html(res);                     
            }
            
           
            res="";
            if(data.listEnclosures.length>0)
            {                
                $.each(data.listEnclosures, function(index, row) {
                    var edb = "<span id="+row.key+" class='badge pull-right' style='cursor:pointer;' onclick='editEnclosures(this.id)'>Edit</span>";
                    res+="<tr><td>"+row.value+edb+"</td></tr>";              
                });   
                
                $("#enclosures tbody").html(res);                     
            }
            
            
            res="";
            if(data.listLeavecategories.length>0)
            {                
                $.each(data.listLeavecategories, function(index, row) {
                    var edb = "<span id="+row.key+" class='badge pull-right' style='cursor:pointer;' onclick='editLeavecategories(this.id)'>Edit</span>";
                    res+="<tr><td>"+row.value+edb+"</td></tr>";              
                });   
                
                $("#leavecategories tbody").html(res);                     
            }
            
           
            res="";
            if(data.listPayscales.length>0)
            {                
                $.each(data.listPayscales, function(index, row) {
                    var edb = "<span id="+row.key+" class='badge pull-right' style='cursor:pointer;' onclick='editPayscales(this.id)'>Edit</span>";
                    res+="<tr><td>"+row.value+edb+"</td></tr>";              
                });   
                
                $("#payscales tbody").html(res);                     
            }
           res="<option value=''>-</option>";
            if(data.listPayscales.length>0)
            {                
                $.each(data.listPayscales, function(index, row) {
                    res+="<option value="+row.key+" >"+row.value+"</option>";                  
                });   
                
                $("#payscale").html(res);                     
            }
            
            res="<option value=''>-</option>";
            if(data.listDesignations.length>0)
            {                
                $.each(data.listDesignations, function(index, row) {
                     res+="<option value="+row.key+" >"+row.value+"</option>";
                   
                });                   
                $("#designation").html(res);                   
                
            }
            
           
            res="";
            if(data.listDesPay.length>0)
            {                          
                $.each(data.listDesPay, function(index, row) {
                    var edb = "<span id="+row.despaycode+" class='badge pull-right' style='cursor:pointer;' onclick='editDesPay(this.id)'>Edit</span>";
                    res+="<tr>";              
                    res+="<td>"+row.designationname+"</td>";              
                    res+="<td>"+row.payscaledescription+edb+"</td>";              
                    res+="</tr>";              
                });                   
                $("#designationpayscale tbody").html(res);                     
            }
        },
        error: function(e) {
//            alert(e.status);
        }
    });           
}

function editCourses(id){
    var index = initData.listCourses.map(function(d) { return d["key"]; }).indexOf(Number(id));   
    var coursename = initData.listCourses[index].value;     
    $("#coursename").val(coursename); 
    $("#coursecode").val(id);
    $("#submitcoursesI").hide();    
    $("#submitcoursesU").show(); 
}


function editDesignations(id){
    var index = initData.listDesignations.map(function(d) { return d["key"]; }).indexOf(Number(id));  
    var designationname = initData.listDesignations[index].value;       
    $("#designationname").val(designationname);  
    $("#designationcode").val(id);
    $("#submitdesignationsI").hide();    
    $("#submitdesignationsU").show();        
}

function editEnclosures(id){
    var index = initData.listEnclosures.map(function(d) { return d["key"]; }).indexOf(Number(id));  
    var enclosurename = initData.listEnclosures[index].value;  
    $("#enclosurename").val(enclosurename);  
    $("#enclosurecode").val(id);
    $("#submitenclosuresI").hide();    
    $("#submitenclosuresU").show();        
}

function editLeavecategories(id){
    var index = initData.listLeavecategories.map(function(d) { return d["key"]; }).indexOf(Number(id));  
    var lcdescription = initData.listLeavecategories[index].value;       
    $("#lcdescription").val(lcdescription);  
    $("#lccode").val(id);
    $("#submitleavecategoriesI").hide();    
    $("#submitleavecategoriesU").show();        
}

function editPayscales(id){
    var index = initData.listPayscales.map(function(d) { return d["key"]; }).indexOf(Number(id));  
    var payscaledescription = initData.listPayscales[index].value;       
    $("#payscaledescription").val(payscaledescription);  
    $("#payscalecode").val(id);
    $("#submitpayscalesI").hide();    
    $("#submitpayscalesU").show();        
}
function editDesPay(id){
    var index = initData.listDesPay.map(function(d) { return d["despaycode"]; }).indexOf(Number(id));  
    var row = initData.listDesPay[index];       
    $("#despaycode").val(row.despaycode);  
    $("#designation").val(row.designationcode);
    $("#payscale").val(row.payscalecode);
     
    $("#submitpaysdesI").hide();    
    $("#submitpaysdesU").show();        
}



function insertCourses(){
    var formData = new Object();
    var coursename = $.trim($("#coursename").val());
    var index = initData.listCourses.map(function(d) { return d["value"]; }).indexOf(coursename);  
    if(coursename===""){
        $("#serverresponse1").html("Enter courses.");
        $("#coursename").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse1").html("courses exists.");
        $("#coursename").focus();
        return false;
    }
    formData.coursename=coursename;
    $.ajax({
        type: "POST",                    
        data: {'option':'12','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){        
                $("#serverresponse1").html("Courses inserted successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse1").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse1").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}
function updateCourses(){  
    var formData = new Object();
    var coursename = $.trim($("#coursename").val());
    var coursecode = $.trim($("#coursecode").val());
    var index = initData.listCourses.map(function(d) { return d["value"]; }).indexOf(coursename);  
    if(coursename===""){
        $("#serverresponse1").html("Enter courses.");
        $("#coursename").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse1").html("Courses exists.");
        $("#coursename").focus();
        return false;
    }
    formData.coursename=coursename;    
    formData.coursecode=coursecode;  
    $.ajax({
        type: "POST",                    
        data: {'option':'13','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse1").html("Courses updated successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse1").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse1").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}


function insertDesignations(){
    var formData = new Object();
    var designationname = $.trim($("#designationname").val());
    var index = initData.listDesignations.map(function(d) { return d["value"]; }).indexOf(designationname);  
    if(designationname===""){
        $("#serverresponse2").html("Enter designations.");
        $("#designationname").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse2").html("designations exists.");
        $("#designationname").focus();
        return false;
    }
    formData.designationname=designationname;
    $.ajax({
        type: "POST",                    
        data: {'option':'14','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse2").html("Designations inserted successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse2").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse2").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}
function updateDesignations(){  
    var formData = new Object();
    var designationname = $.trim($("#designationname").val());
    var designationcode = $.trim($("#designationcode").val());
    var index = initData.listDesignations.map(function(d) { return d["value"]; }).indexOf(designationname);  
    if(designationname===""){
        $("#serverresponse2").html("Enter designations.");
        $("#designationname").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse2").html("Designations exists.");
        $("#designationname").focus();
        return false;
    }
    formData.designationname=designationname;    
    formData.designationcode=designationcode;  
    $.ajax({
        type: "POST",                    
        data: {'option':'15','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse2").html("Designations updated successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse2").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse2").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}


function insertEnclosures(){
    var formData = new Object();
    var enclosurename = $.trim($("#enclosurename").val());
    var index = initData.listEnclosures.map(function(d) { return d["value"]; }).indexOf(enclosurename);  
    if(enclosurename===""){
        $("#serverresponse3").html("Enter Enclosures.");
        $("#enclosurename").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse3").html("Enclosures exists.");
        $("#enclosurename").focus();
        return false;
    }
    formData.enclosurename=enclosurename;
    $.ajax({
        type: "POST",                    
        data: {'option':'16','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse3").html("Enclosures inserted successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse3").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse3").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}
function updateEnclosures(){    
    var formData = new Object();
    var enclosurename = $.trim($("#enclosurename").val());
    var enclosurecode = $.trim($("#enclosurecode").val());
    var index = initData.listEnclosures.map(function(d) { return d["value"]; }).indexOf(enclosurename);  
    if(enclosurename===""){
        $("#serverresponse3").html("Enter Enclosures.");
        $("#enclosurename").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse3").html("Enclosures exists.");
        $("#enclosurename").focus();
        return false;
    }
    formData.enclosurename=enclosurename;    
    formData.enclosurecode=enclosurecode;  
    $.ajax({
        type: "POST",                    
        data: {'option':'17','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse3").html("Enclosures updated successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse3").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse3").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });       
}

function insertLeavecategories(){
    var formData = new Object();
    var lcdescription = $.trim($("#lcdescription").val());
    var index = initData.listLeavecategories.map(function(d) { return d["value"]; }).indexOf(lcdescription);  
    if(lcdescription===""){
        $("#serverresponse4").html("Enter Leavecategories.");
        $("#lcdescription").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse4").html("Leavecategories exists.");
        $("#lcdescription").focus();
        return false;
    }
    formData.lcdescription=lcdescription;
    $.ajax({
        type: "POST",                    
        data: {'option':'18','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse4").html("Leavecategories inserted successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse4").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse4").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}
function updateLeavecategories(){    
    var formData = new Object();
    var lcdescription = $.trim($("#lcdescription").val());
    var lccode = $.trim($("#lccode").val());
    var index = initData.listLeavecategories.map(function(d) { return d["value"]; }).indexOf(lcdescription);  
    if(lcdescription===""){
        $("#serverresponse4").html("Enter Leavecategories.");
        $("#lcdescription").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse4").html("Leavecategories exists.");
        $("#lcdescription").focus();
        return false;
    }
    formData.lcdescription=lcdescription;    
    formData.lccode=lccode;  
    $.ajax({
        type: "POST",                    
        data: {'option':'19','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse4").html("Leavecategories updated successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse4").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse4").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });       
}

function insertPayscales(){
    var formData = new Object();
    var payscaledescription = $.trim($("#payscaledescription").val());
    var index = initData.listPayscales.map(function(d) { return d["value"]; }).indexOf(payscaledescription);  
    if(payscaledescription===""){
        $("#serverresponse5").html("Enter Payscales.");
        $("#payscaledescription").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse5").html("Payscales exists.");
        $("#payscaledescription").focus();
        return false;
    }
    formData.payscaledescription=payscaledescription;
    $.ajax({
        type: "POST",                    
        data: {'option':'20','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){        
                $("#serverresponse5").html("Payscales inserted successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse5").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse5").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}
function updatePayscales(){    
    var formData = new Object();
    var payscaledescription = $.trim($("#payscaledescription").val());
    var payscalecode = $.trim($("#payscalecode").val());
    var index = initData.listPayscales.map(function(d) { return d["value"]; }).indexOf(payscaledescription);  
    if(payscaledescription===""){
        $("#serverresponse5").html("Enter Payscales.");
        $("#payscaledescription").focus();
        return false;
    }else if(index!==-1){
        $("#serverresponse5").html("Payscales exists.");
        $("#payscaledescription").focus();
        return false;
    }
    formData.payscaledescription=payscaledescription;    
    formData.payscalecode=payscalecode;  
    $.ajax({
        type: "POST",                    
        data: {'option':'21','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){        
                $("#serverresponse5").html("Payscales updated successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse5").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse5").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });       
}

function insertDesPayscales(){
    var formData = new Object();
    var  payscale = $.trim($("#payscale").val());
    var  designation = $.trim($("#designation").val());
    if(payscale===""){
        $("#serverresponse7").html("Select Payscales.");
        $("#payscale").focus();
        return false;
    }
    if(designation===""){
        $("#serverresponse7").html("Select Designation.");
        $("#designation").focus();
        return false;
    }
    formData.payscalecode= payscale;
    formData.designationcode= designation;
    $.ajax({
        type: "POST",                    
        data: {'option':'22','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1" || data==1){        
                $("#serverresponse7").html("DesignationPayscales inserted successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse7").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse7").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });     
}
 
 function updatetDesPayscales(){    
    var formData = new Object();
    var despaycode = $.trim($("#despaycode").val());
    var payscale = $.trim($("#payscale").val());
    var designation = $.trim($("#designation").val());
    if(payscale===""){
        $("#serverresponse8").html("Select Payscales.");
        $("#payscale").focus();
        return false;
    }
    if(designation===""){
        $("#serverresponse8").html("Select Designation.");
        $("#designation").focus();
        return false;
    }
    formData.despaycode= despaycode;
    formData.payscalecode= payscale;  
    formData.designationcode= designation;  
    $.ajax({
        type: "POST",                    
        data: {'option':'23','data':JSON.stringify(formData)},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){        
                $("#serverresponse8").html("Designation-Payscale updated successfully.");
                window.location="initialization.jsp";
            }else{                
                $("#serverresponse8").html("Sorry, unable to process the request...!<br>Please try again...");
            }
        },
        error: function(e) {
            //alert(e.status);
            $("#serverresponse8").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });       
}    
