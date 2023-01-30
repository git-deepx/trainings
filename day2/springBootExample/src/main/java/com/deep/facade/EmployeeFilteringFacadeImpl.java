package com.deep.facade;

import com.deep.entity.Employee;
import com.deep.service.EmployeeFilteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeFilteringFacadeImpl implements EmployeeFilteringFacade {

    @Autowired
    private EmployeeFilteringService efs;

    @Override
    public List<Employee> getAllEmp() {
        return efs.getAllEmp();
    }

    @Override
    public Employee addEmp(Employee employee) {
        return efs.addEmp(employee);
    }

    @Override
    public List<Employee> delEmp(Long empId) {
        return efs.delEmp(empId);
    }

    @Override
    public Optional<Employee> getEmpById(Long empId) {
        return efs.getEmpById(empId);
    }

    @Override
    public void updateEmp(Employee employee) {
        efs.updateEmp(employee);
    }
}
