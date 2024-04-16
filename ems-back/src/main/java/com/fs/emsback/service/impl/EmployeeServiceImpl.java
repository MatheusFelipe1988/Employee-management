package com.fs.emsback.service.impl;

import com.fs.emsback.entity.Employee;
import com.fs.emsback.entity.dto.EmployeeDTO;
import com.fs.emsback.entity.dto.mapper.EmployeeMapper;
import com.fs.emsback.exception.ResourseNotFoundException;
import com.fs.emsback.repository.EmployeeRepository;
import com.fs.emsback.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        Employee avedEmployee = repository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(avedEmployee);
    }

    @Override
    public EmployeeDTO getEmployee(Long EmployeedId) {
        Employee employee = repository.findById(EmployeedId)
                .orElseThrow(() -> new ResourseNotFoundException("Employeed not found by Id: " + EmployeedId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = repository.findAll();
        return employeeList.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO upEmployee) {

        Employee employee = repository.findById(employeeId).orElseThrow(() -> new
                ResourseNotFoundException("Employee is not exist in ID" + employeeId));

        employee.setFirstName(upEmployee.getFirstName());
        employee.setLastName(upEmployee.getLastName());
        employee.setEmail(upEmployee.getEmail());

        Employee employeeObj = repository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(employeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = repository.findById(employeeId).orElseThrow(() -> new
                ResourseNotFoundException("Employee is not exist in ID" + employeeId));

        repository.deleteById(employeeId);
    }
}
