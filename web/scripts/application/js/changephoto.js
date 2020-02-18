var V =new Validate();
var U =new Upload();
$(function()
{   
    jQuery("#imageUpload").on('change', function()
    {
        var fileHolder = jQuery("#fileHolder");  
        U.uploadImage(this,fileHolder);
    });
    
    jQuery("#submit").on('click', function()
    {        
        if(validatePhotograph()){
            uploadPhotograph();
        }               
    });    
    
});

var userlogin= new Object();
function validatePhotograph(){
    if(dataFileList.length===0){
        $("#serverresponse").html("Browse an image file...!");
        return false;
    }
    userlogin.userphotograph=dataFileList[0];
    return true;
}

function uploadPhotograph(){
    $("#serverresponse").html("");
    $("#processing").show();
    $.ajax({
        type: "POST",                    
        data: {'option':'2','userphotograph':userlogin.userphotograph},
        url: "ControllerAdmin",
        success: function(data)
        {
            if(data==="1"){
                location.reload();
                //$("#processing").hide();
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
