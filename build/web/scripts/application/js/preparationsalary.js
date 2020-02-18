var V = new Validate();
jQuery(function()
{
    populateYear();
    populateMonth();

    //salaryPending()
});

function populateYear()
{
    var foryear = new Date().getFullYear();
    var res = "<option value=''>Select Year</option>";
    for (var i = 2015; i <= foryear; i++)
    {
        res += "<option value=" + i + " >" + i + "</option>";
    }

    $("#foryear").html(res);
}
function populateMonth()
{
    var months = [
        {key: 1, value: 'January'},
        {key: 2, value: 'February'},
        {key: 3, value: 'March'},
        {key: 4, value: 'April'},
        {key: 5, value: 'May'},
        {key: 6, value: 'June'},
        {key: 7, value: 'July'},
        {key: 8, value: 'August'},
        {key: 9, value: 'September'},
        {key: 10, value: 'October'},
        {key: 11, value: 'November'},
        {key: 12, value: 'December'},
    ];

    var res = "<option value=''>Select Month</option>";
    jQuery.each(months, function(index, row)
    {
        res += "<option value=" + row.key + " >" + row.value + "</option>";
    });
    $("#formonth").html(res);
}

function salaryPending() {
    var foryear = $("#foryear").val();
    var formonth = $("#formonth").val();
    if (foryear == "") {
        jQuery("#salarypending tbody").html("");
        jQuery("#salaryprocessed tbody").html("");
        $("#foryear").focus();
        $("#validate").text("Select year...!");
        return;
    }
    if (formonth == "") {
        jQuery("#salarypending tbody").html("");
        jQuery("#salaryprocessed tbody").html("");
        $("#formonth").focus();
        $("#validate").text("Select month...!");
        return;
    }
    $("#validate").text("");
    var data = "option=8&foryear=" + foryear + "&formonth=" + formonth;
    jQuery.ajax({
        type: "POST",
        dataType: "json",
        data: data,
        url: "UtilController",
        success: function(data) {
            if (data.salaryPending.length > 0)
            {
                listData = data;
                var res = "";
                jQuery.each(listData.salaryPending, function(index, row) {
                    res += "<tr>";
                    res += "<td style='width:15%;'>" + row.fullname + "</td>";
                    res += "<td style='width:15%;'>" + row.designationname + "</td>";
                    res += "<td style='width:15%;'>" + row.payscaledescription + "</td>";
                    res += "<td><input type='button' id=" + row.empcode + " value='Process' onclick='procesSalary(this.id)' style='width:100%;' class='button' /><td>";
                    res += "</tr>";
                });

                jQuery("#salarypending tbody").html(res);
                var res = "";
                jQuery.each(listData.salaryProcessed, function(index, row) {
                    res += "<tr>";
                    res += "<td style='width:15%;'>" + row.fullname + "</td>";
                    res += "<td style='width:15%;'>" + row.designationname + "</td>";
                    res += "<td style='width:15%;'>" + row.payscaledescription + "</td>";
                    res += "<td><input type='button' id=" + row.empcode + " value='Print' onclick='printSalary(this.id)' style='width:100%;' class='button' /><td>";
                    res += "</tr>";
                });

                jQuery("#salaryprocessed tbody").html(res);

            }
        },
        error: function(e) {
//            alert(e.status);
//            alert(e.getMessage())
        }
    });
}

var salary = new Object();
function procesSalary(empcode)
{
    var index = listData.salaryPending.map(function(d) {
        return d["empcode"];
    }).indexOf(Number(empcode));
    var fullname = listData.salaryPending[index].fullname;
    var designationname = listData.salaryPending[index].designationname;
    var payscaledescription = listData.salaryPending[index].payscaledescription;
    $("#fullname").text(fullname);
    $("#designationname").text(designationname);
    $("#payscaledescription").text(payscaledescription);
    salary.empcode = empcode;
}

function submitSalary()
{
    var foryear = $("#foryear").val();
    var formonth = $("#formonth").val();
    var basic = $("#basic").val();
    var ta = $("#ta").val();
    var da = $("#da").val();
    var hra = $("#hra").val();

    if (basic == "") {
         showMsg("basic","Enter basic pay");
         $("#basic").focus();
        return false;
    }else if(!V.isNumeric(basic)){
         showMsg("basic","Invalid basic pay");
         $("#basic").focus();
        return false;
    }else{
        hideMsg("basic");
    }
    if (ta == "") {
        showMsg("ta","Enter TA");
         $("#ta").focus();
        return false;
    }else if(!V.isNumeric(ta)){
         showMsg("ta","Invalid TA");
         $("#ta").focus();
        return false;
    }else{
        hideMsg("ta");
    }
    if (da == "") {
        showMsg("da","Enter DA");
         $("#da").focus();
        return false;
    }else if(!V.isNumeric(da)){
         showMsg("da","Invalid DA");
         $("#da").focus();
        return false;
    }else{
        hideMsg("da");
    }
    if (hra == "") {
        showMsg("hra","Enter HRA");
         $("#hra").focus();
        return false;
    }else if(!V.isNumeric(hra)){
         showMsg("hra","Invalid HRA");
         $("#hra").focus();
        return false;
    }else{
        hideMsg("hra");
    }

    salary.foryear = foryear;
    salary.formonth = formonth;
    salary.basic = basic;
    salary.ta = ta;
    salary.da = da;
    salary.hra = hra;
    $.ajax({
        type: "POST",
        data: {'option': '4', 'salary': JSON.stringify(salary)},
        url: "ControllerApplication",
        success: function(data)
        {
            if (data === "1" || data === 1) {
                $("#serverresponse").html("Process Salary successfully.");
                salaryPending();
                $("#basic").val("");
                $("#ta").val("");
                $("#da").val("");
                $("#hra").val("");
                $("#basic").val("");
                 $("#fullname").text("");
    $("#designationname").text("");
    $("#payscaledescription").text("");
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
function printSalary(empcode)
{
       var foryear = $("#foryear").val();
    var formonth = $("#formonth").val();
        var param="option=2&type=p"+"&empcode="+empcode+"&foryear="+foryear+"&formonth="+formonth;              
        window.open("ControllerReports?"+param,"_blank");
}
function printPending()
{
       var foryear = $("#foryear").val();
    var formonth = $("#formonth").val();
     if (foryear == "") {
        $("#foryear").focus();
        $("#validate").text("Select year...!");
        return;
    }
    if (formonth == "") {
        $("#formonth").focus();
        $("#validate").text("Select month...!");
        return;
    }
        var param="option=3&type=p&foryear="+foryear+"&formonth="+formonth;              
        window.open("ControllerReports?"+param,"_blank");
}

