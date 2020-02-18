package services;

import util.application.*;
import daos.DaoApplication;
import domains.DomainApplication;
import org.json.simple.JSONObject;

public class ServiceApplication {
    
    private final UtilService utilService = new UtilService();
    private final DaoApplication daoApplication = new DaoApplication();
    private final DomainApplication domainApplication = new DomainApplication();

    public boolean saveEmployeeDetails(final JSONObject employee){
        Integer empcode = utilService.getNextEmpcode();
        System.out.println("empcode : "+empcode);
        employee.put("empcode",empcode+"");
        return daoApplication.saveEmployeeDetails(employee);
    }

    public boolean leaveDetails(final JSONObject employee){
        Integer slno = utilService.getNextLeaveSlno();
        employee.put("slno",slno+"");
        return daoApplication.leaveDetails(employee);
    }
    
    public boolean apprej(final String slno,final String status){
        return daoApplication.apprej(slno, status);
    }
    
    public boolean salaryProcess(final JSONObject salary){
                Integer slno = utilService.getNextSalarySlno();
        salary.put("slno",slno+"");
        return daoApplication.salaryProcess(salary);
    }
    
}
