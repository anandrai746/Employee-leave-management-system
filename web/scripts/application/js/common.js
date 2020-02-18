function dateFormatCheck(dob) {
    var objDate,
            day,
            month,
            year;
    var db = dob;
    if (db.length != 10) {
        return false;
    }
    if (db.substring(4, 5) !== '-' || db.substring(7, 8) !== '-') {
        return false;
    }
    year = db.substring(0, 4) - 0;
    month = db.substring(5, 7) - 1;
    day = db.substring(8, 10) - 0;
    if (year < 1900 || year > 3000) {
        return false;
    }
    objDate = new Date(db);
    if (objDate.getFullYear() != year ||
            objDate.getMonth() != month ||
            objDate.getDate() != day) {
        return false;
    }

    return true;
}
function checkDoB(dob, leastagerequired)
{
    var currdate = new Date();
    var dob = new Date(dob);
    if (currdate.getMonth === 1 && currdate.getDate() === 29) {
        currdate = currdate.setFullYear(currdate.getFullYear() - 15, 1, 28);
    } else
    {
        currdate = currdate.setFullYear(currdate.getFullYear() - 15, currdate.getMonth(), currdate.getDate());
    }
    if (dob <= currdate)
    {
        return true;
    }
    return false;
}

function checkDatePast(dt)
{
    var date2 = new Date(dt).setHours(0,0,0,0);
    var currdate = new Date().setHours(0,0,0,0);

    if (date2 < currdate)
    {
        return true;
    }
    return false;
}
function checkDateFuture(dt)
{
     var date2 = new Date(dt).setHours(0,0,0,0);
    var currdate = new Date().setHours(0,0,0,0);
    
    if (date2 > currdate)
    {
        return true;
    }
    return false;
}
function checkDatePastOrEqual(dt)
{
     var date2 = new Date(dt).setHours(0,0,0,0);
    var currdate = new Date().setHours(0,0,0,0);
    
    if (date2 <= currdate)
    {
        return true;
    }
    return false;
}
function checkDateFutureOrEqual(dt)
{
     var date2 = new Date(dt).setHours(0,0,0,0);
    var currdate = new Date().setHours(0,0,0,0);
    
    if (date2 >= currdate)
    {
        return true;
    }
    return false;
}
function compareDates(dt1,dt2)
{
     var date1 = new Date(dt1).setHours(0,0,0,0);
    var date2 = new Date(dt2).setHours(0,0,0,0);
    
    if (date1 > date2)
    {
        return 1;
    }else if(date1<date2)
    {
        return -1;
    }else
    {
        return 0;
    }
}


function yojcheck(yoj, dob) {

    if (Number(yoj) < 1924 || Number(yoj) > 3000) {
        return false;
    }
    var year = dob.substring(6, 10) - 0;
    if (Number(year) >= Number(yoj) || (Number(year) + 10) > Number(yoj)) {

        return false;
    }
    return true;
}