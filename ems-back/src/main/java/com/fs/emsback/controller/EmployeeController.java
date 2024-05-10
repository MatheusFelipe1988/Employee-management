package com.fs.emsback.controller;

import com.fs.emsback.entity.dto.EmployeeDTO;
import com.fs.emsback.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "publicando novo empregado", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dado inserido com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro de cadastro")
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = service.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(summary = "Buscando unico funcionario", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "quando o funcionario selecionado for OK"),
            @ApiResponse(responseCode = "500", description = "Erro por selecionar Id correto")
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long EmployeeId){
        EmployeeDTO employeeDTO = service.getEmployee(EmployeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @Operation(summary = "Listando todos funcionarios", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "quando a listagem dos funcionarios for OK"),
            @ApiResponse(responseCode = "500", description = "quando der erro na hora de listar funcionarios")
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployess(){
        List<EmployeeDTO> employeeDTO = service.getAllEmployees();
        return ResponseEntity.ok(employeeDTO);
    }

    @Operation(summary = "Atualizando funcionario", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dado atualizado for OK"),
            @ApiResponse(responseCode = "500", description = "Erro na escrita")
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDTO upEmployee){
        EmployeeDTO employeeDTO = service.updateEmployee(employeeId, upEmployee);

        return ResponseEntity.ok(employeeDTO);
    }

    @Operation(summary = "Deletando funcionarios", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletando um dado"),
            @ApiResponse(responseCode = "500", description = "Error")
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long employeeId){
        service.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted sucessfully!.");
    }
}
