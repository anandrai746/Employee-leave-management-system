$(function(){
    leaveProcess();
});

var listData = new Object();
function leaveProcess(){
   var data = "option=7";
     jQuery.ajax({
        type: "POST",
        dataType: "json",
        data: data,
        url: "UtilController",
        success: function(data) {
            if(data.leaveProcess.length>0)
            {   
                listData=data.leaveProcess;                
                var res="";
                jQuery.each(data.leaveProcess, function(index, row) {                    
                    var slno=index+1;
                    res+="<tr>";
                    res+="<td style='width:5%;'>"+slno+"</td>";
                    res+="<td style='width:15%;'>"+row.lcdescription+ "</td>"
                    res+="<td style='width:10%;'>"+row.fromdate+"</td>";                                
                    res+="<td style='width:10%;'>"+row.todate+"</td>";                                
                    res+="<td style='width:20%;'>"+row.description+"</td>";                                
                    res+="<td style='width:10%;'>"+row.entrydate+"</td>";                                
                    res+="<td style='width:10%;'>"+row.appstatus+ "</td>"; 
                    res+="<td style='width:25%;'>";
                    res+="<input type='button' id='"+row.slno+"' name='A' value='Approve' onclick='apprej(this)' style='width:100%;' class='button' />";
                    res+="<input type='button' id='"+row.slno+"' name='R' value='Reject' onclick='apprej(this)' style='width:100%;' class='button' />";   
                    res+="</td>";                                   
                    res+="</tr>";
                });   
                                
                jQuery("#leavedisplay tbody").html(res);               
                      
            }                          
        },
        error: function(e) { 
//            alert(e.status);
//            alert(e.getMessage());
        }
    });         
}

function apprej(obj)
{
    var slno = $(obj).attr("id");
    var status = $(obj).attr("name");
    var data = "option=3&slno="+slno+"&status="+status;
    jQuery.ajax({
        type: "POST",
        dataType: "json",
        data: data,
        url: "ControllerApplication",
        success: function(data) {
            if(data==="1" || data==1)
            {  
                $("#serverresponse").html("processed successfully.");
                leaveProcess();                  
            }                          
        },
       error: function(e) {
            //alert(e.status);
            $("#serverresponse").html("Sorry, unable to process the request...!<br>Please try again...");
        }
    });             
}



