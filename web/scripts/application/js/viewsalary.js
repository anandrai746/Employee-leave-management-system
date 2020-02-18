$(function()
{
    onLoad();
});
function onLoad() {
    var data = {'option': 9};
    $.ajax({
        type: "POST",
        data: data,
        url: "UtilController",
        dataType: 'json',
        success: function(data)
        {

            initData = data;
            var res = "";
            jQuery.each(initData.vewSalary, function(index, row) {
                res += "<tr>";
                res += "<td style='width:10%;'>" + (index+1) + "</td>";
                res += "<td style='width:10%;'>" + row.foryear + "</td>";
                res += "<td style='width:10%;'>" + row.month + "</td>";
                res += "<td style='width:10%;'>" + row.basic + "</td>";
                res += "<td style='width:10%;'>" + row.ta + "</td>";
                res += "<td style='width:10%;'>" + row.da + "</td>";
                res += "<td style='width:10%;'>" + row.hra + "</td>";
                res += "<td style='width:10%;'>" + row.total + "</td>";
                res += "<td style='width:10%;'>" + row.entrydate + "</td>";
                res += "<td><input type='button' id="+row.empcode+" name='"+row.foryear+":"+row.formonth+"'  value='Print' onclick='printSalary(this)' style='width:100%;' class='button' /></td>";
                res += "</tr>";
            });            
            jQuery("#viewsalary tbody").html(res);
        },
        error: function(e) {
            // alert(e.status);
        }
    });
}

     function printSalary(obj){
        var empcode = $(obj).attr("id");
        var foryear = $(obj).attr("name").split(":")[0];
        var formonth = $(obj).attr("name").split(":")[1];
        var param="option=2&type=p"+"&empcode="+empcode+"&foryear="+foryear+"&formonth="+formonth;              
        window.open("ControllerReports?"+param,"_blank");
    
    }
    


