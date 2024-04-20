package com.fs.emsback.controller;

import com.fs.emsback.entity.dto.EmployeeDTO;
import com.fs.emsback.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = service.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long EmployeeId){
        EmployeeDTO employeeDTO = service.getEmployee(EmployeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployess(){
        List<EmployeeDTO> employeeDTO = service.getAllEmployees();
        return ResponseEntity.ok(employeeDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDTO upEmployee){
        EmployeeDTO employeeDTO = service.updateEmployee(employeeId, upEmployee);

        return ResponseEntity.ok(employeeDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long employeeId){
        service.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted sucessfully!.");
    }
}
