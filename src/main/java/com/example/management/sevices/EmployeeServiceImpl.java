package com.example.management.sevices;

import com.example.management.models.Employee;
import com.example.management.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean saveEmployee(Employee employee) {

        Optional<Employee> emp = employeeRepository.findByEmail(employee.getEmail());
        if(emp.isEmpty()==false){
            return false;
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return false;
    }
}
