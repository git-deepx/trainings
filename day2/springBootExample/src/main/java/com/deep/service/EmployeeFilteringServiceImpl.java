package com.deep.service;

import com.deep.entity.Employee;
import com.deep.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class EmployeeFilteringServiceImpl implements EmployeeFilteringService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmp() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmpById(Long empId) {

        try {
            return repository.findById(empId);
        } catch (Exception e) {
        }

        return null;
    }

    @Override
    public Employee addEmp(Employee employee) {
        repository.save(employee);
        return employee;
    }

    @Override
    public void updateEmp(Employee employee) {
        repository.save(employee);
    }

    @Override
    public List<Employee> delEmp(Long empId) {

        try {
            repository.deleteById(empId);
            return repository.findAll();
        } catch (Exception e) {
        }

        return null;
    }
}
