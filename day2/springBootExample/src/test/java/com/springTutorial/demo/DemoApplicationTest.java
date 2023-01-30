package com.springTutorial.demo;

import com.deep.entity.Employee;
import com.deep.facade.EmployeeFilteringFacade;
import com.deep.facade.EmployeeFilteringFacadeImpl;
import com.deep.repository.EmployeeRepository;
import com.deep.service.EmployeeFilteringServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class) //initiates MockitoAnnotations.initMocks(this) static method
@SpringBootTest
public class DemoApplicationTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    @Autowired
    private EmployeeFilteringServiceImpl service;

    @Test
    public void getAllEmpTest() {
        //repo.findAll() returns a list
        Mockito.when(repository.findAll()).thenReturn(Stream.
                of(new Employee(1L, "dummy1", 1, "pahadi"),
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

        Employee employee = new Employee(4L, "dummy4", 4, "hubli");

        //repo.delete() returns nothing, so using verify method
        repository.delete(employee);
        Mockito.verify(repository, Mockito.times(1)).delete(employee);
    }

    @Test
    public void updateEmpTest() {

        Employee employee = new Employee(4L, "dummy4", 4, "hubli");

        repository.save(employee);
        Mockito.verify(repository, Mockito.times(1)).save(employee);
    }
}
