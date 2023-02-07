package com.deep.facade;

import com.deep.DTO.EmployeeDetailWsDTO;
import com.deep.DTO.EmployeeResponseWsDTO;
import com.deep.entity.Employee;
import com.deep.service.EmployeeFilteringServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class) //initiates MockitoAnnotations.initMocks(this) static method
@SpringBootTest
public class EmployeeFilteringFacadeImplTest {

    @InjectMocks
    EmployeeFilteringFacadeImpl employeeFilteringFacadeImpl;

    @Mock
    EmployeeFilteringServiceImpl employeeFilteringServiceImpl;

    @Mock
    EmployeeResponseWsDTO employeeResponseWsDTO;

    @Test
    public void populateEmployeeResponse() {
        List<EmployeeDetailWsDTO> employeeDetailWsDTOList = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
//        EmployeeDetailWsDTO employeeDetailWsDTO = new EmployeeDetailWsDTO();
//        employeeDetailWsDTOList.add(employeeDetailWsDTO);

        employeeFilteringFacadeImpl.populateEmployeeResponse(employees, employeeResponseWsDTO);
        Mockito.verify(employeeResponseWsDTO, Mockito.times(1))
                .setEmployees(employeeDetailWsDTOList);

//        Mockito.verify(employeeDetailWsDTOList, Mockito.times(employees.size()))
//                .add(employeeDetailWsDTO);
    }

    @Test
    public void getAllEmp() {
        List<Employee> employee = new ArrayList<>();
        Mockito.when(employeeFilteringServiceImpl.getAllEmp()).thenReturn(employee);
        Assert.assertEquals(0, employeeFilteringFacadeImpl.getAllEmp().size());
    }

    @Test
    public void addEmp() {
        Employee employee = new Employee();
        Mockito.when(employeeFilteringServiceImpl.addEmp(employee)).thenReturn(employee);
        Assert.assertEquals(employee, employeeFilteringFacadeImpl.addEmp(employee));
    }

    @Test
    public void delEmp() {
        Long id = 10L;

        employeeFilteringFacadeImpl.delEmp(id);
        Mockito.verify(employeeFilteringServiceImpl, Mockito.times(1)).delEmp(id);
    }

    @Test
    public void getEmpById() {

        Long id = 1L;
        Employee employee = new Employee();

        Mockito.when(employeeFilteringServiceImpl.getEmpById(id)).thenReturn(java.util.Optional.of(employee));
        Assert.assertEquals(java.util.Optional.of(employee), employeeFilteringFacadeImpl.getEmpById(id));
    }

    @Test
    public void updateEmp() {

        Employee employee = new Employee();

        employeeFilteringFacadeImpl.updateEmp(employee);
        Mockito.verify(employeeFilteringServiceImpl, Mockito.times(1)).updateEmp(employee);
    }
}