package com.deep.facade;

import com.deep.DTO.EmployeeDetailWsDTO;
import com.deep.DTO.EmployeeResponseWsDTO;
import com.deep.entity.Employee;
import com.deep.service.EmployeeFilteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeFilteringFacadeImpl implements EmployeeFilteringFacade {

    @Autowired
    private EmployeeFilteringService efs;

    /**
     * Populates the employeeResponse
     */
    public void populateEmployeeResponse(List<Employee> employee,
                                         EmployeeResponseWsDTO response) {

        List<EmployeeDetailWsDTO> employeeDetailWsDTOList = new ArrayList<>();

        employee.forEach(emp -> {
            employeeDetailWsDTOList.add(new EmployeeDetailWsDTO(emp.getName(), emp.getId()));
        });
        response.setEmployees(employeeDetailWsDTOList);
    }

    @Override
    public List<Employee> getAllEmp() {
        return efs.getAllEmp();
    }

    @Override
    public Employee addEmp(Employee employee) {
        return efs.addEmp(employee);
    }

    @Override
    public void delEmp(Long empId) {
        efs.delEmp(empId);
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
