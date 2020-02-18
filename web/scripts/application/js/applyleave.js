var V = new Validate();
$(function()
{
    getDatePicker('fromdate');
    getDatePicker('todate');
    onLoad();
    loadLeaves();
    $("#submitleave").click(function() {
        if (validateDetails()) {
            applyLeave();
        }
    });
    $(".reset").click(function() {
        window.location = "applyleave.jsp";
    });
});

var initData = new Object();
var employee = new Object();
function validateDetails() {
    var leavecatagories = $.trim($("#leavecatagories").val());
    var fromdate = $.trim($("#fromdate").val());
    var todate = $.trim($("#todate").val());
    var description = $.trim($("#description").val());
    if (leavecatagories == "") {
        showMsg("leavecatagories", "Select leave categories");
        return false;
    } else {
        hideMsg("leavecatagories");
        employee.leavecatagories = leavecatagories;
    }
    if (fromdate == "") {
        showMsg("fromdate", "Enter the from date");
        return false;
    } else if (!checkDateFutureOrEqual(fromdate)) {
        showMsg("fromdate", "from date cannot be in the past");
        return false;
    } else {
        hideMsg("fromdate");
        employee.fromdate = fromdate;
    }
    if (todate == "") {
        showMsg("todate", "Enter the to date");
        return false;
    } else if (!checkDateFutureOrEqual(todate)) {
        showMsg("todate", "to date cannot be in the past");
        return false;
    }else if(compareDates(fromdate,todate)==1){
        showMsg("todate", "to date cannot be before from date");
        return false;
    } else {
        hideMsg("todate");
        employee.todate = todate;
    }
    if (description == "") {
        showMsg("description", "Type a description");
        return false;
    } else {
        hideMsg("description");
        employee.description = description;
    }
    return true;
}

function onLoad() {
    var data = {'option': 5};
    $.ajax({
        type: "POST",
        data: data,
        url: "UtilController",
        dataType: 'json',
        success: function(data)
        {

            initData = data;
            var res = "";
            if (data.listLeave.length > 0)
            {
                res += "<option value=''>-</option>";
                $.each(data.listLeave, function(index, row) {
                    res += "<option value='" + row.key + "'>" + row.value + "</option>";
                });
                $("#leavecatagories").html(res);
            }
        },
        error: function(e) {
            // alert(e.status);
        }
    });
}

function applyLeave() {
    $.ajax({
        type: "POST",
        data: {'option': '2', 'employee': JSON.stringify(employee)},
        url: "ControllerApplication",
        success: function(data)
        {
            if (data === "1" || data == 1) {
                $("#serverresponse").html("Leave request send successfully.");
                window.location = "applyleave.jsp";
            } else {
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

function loadLeaves() {
    var data = "option=6";
    jQuery.ajax({
        type: "POST",
        dataType: "json",
        data: data,
        url: "UtilController",
        success: function(data) {
            if (data.loadLeaves.length > 0)
            {
                listData = data.loadLeaves;
                var res = ""
                jQuery.each(data.loadLeaves, function(index, row) {
                    var slno = index + 1;
                    res += "<tr>"
                    res += "<td style='width:5%;'>" + slno + "</td>"
                    res += "<td style='width:15%;'>" + row.lcdescription + "</td>"
                    res += "<td style='width:15%;'>" + row.fromdate + "</td>";
                    res += "<td style='width:15%;'>" + row.todate + "</td>";
                    res += "<td style='width:30%;'>" + row.description + "</td>";
                    res += "<td style='width:10%;'>" + row.entrydate + "</td>";
                    res += "<td style='width:10%;'>" + row.appstatus + "</td>";
                    res += "</tr>";
                });

                jQuery("#leavedisplay tbody").html(res);

            }
        },
        error: function(e) {
//            alert(e.status);
//            alert(e.getMessage())
        }
    });
}