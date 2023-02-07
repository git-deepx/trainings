package com.deep.service;

import com.deep.entity.Employee;
import com.deep.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class) //initiates MockitoAnnotations.initMocks(this) static method
@SpringBootTest
public class EmployeeFilteringServiceImplTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeFilteringServiceImpl service;

    @Test
    public void getAllEmpTest() {
        //repo.findAll() returns a list
        Mockito.when(repository.findAll()).thenReturn(Stream.of(new Employee(1L, "dummy1", 1, "pahadi"),
                new Employee(2L, "dummy2", 2, "assam")).toList());
        Assert.assertEquals(2, service.getAllEmp().size());
    }


    @Test
    public void getEmpByIdTest() {

        Long id = 1L;
        Employee employee = new Employee(3L, "dummy3", 3, "japan");
        //repo.findById() returns Optional
        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(employee));
        Assert.assertEquals(java.util.Optional.of(employee), service.getEmpById(id));
    }

    @Test
    public void addEmpTest() {

        Employee employee = new Employee(4L, "dummy4", 4, "hubli");
        //repo.save() returns entity
        Mockito.when(repository.save(employee)).thenReturn(employee);
        Assert.assertEquals(employee, service.addEmp(employee));
    }

    @Test
    public void delEmpTest() {

        Long id = 10L;
        service.delEmp(10L);
        Mockito.verify(repository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void updateEmpTest() {

        Employee employee = new Employee(4L, "dummy4", 4, "hubli");

        service.updateEmp(employee);
        Mockito.verify(repository, Mockito.times(1)).save(employee);
    }
}
