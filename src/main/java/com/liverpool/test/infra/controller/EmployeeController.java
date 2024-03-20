package com.liverpool.test.infra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liverpool.test.domain.service.EmployeeService;
import com.liverpool.test.infra.controller.request.EmployeeRequest;
import com.liverpool.test.infra.controller.response.EmployeeResponse;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;
  private final EmployeeMapper mapper;

  public EmployeeController(EmployeeService employeeService, EmployeeMapper mapper) {
    this.employeeService = employeeService;
    this.mapper = mapper;
  }

  @PostMapping
  public EmployeeResponse create(@RequestBody EmployeeRequest request) {
    return mapper.fromDO(employeeService.save(mapper.fromRequest(request)));
  }

  @GetMapping("/{employeeId}")
  public EmployeeResponse getById(@PathVariable String employeeId) {
    return mapper.fromDO(employeeService.getById(employeeId));
  }

  @GetMapping
  public List<EmployeeResponse> getAll() {
    return employeeService.getAllEmployees().stream().map(mapper::fromDO).toList();
  }

}
