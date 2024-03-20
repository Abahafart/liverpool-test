package com.liverpool.test.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liverpool.test.domain.model.DepartmentDO;
import com.liverpool.test.domain.model.EmployeeDO;
import com.liverpool.test.domain.repository.DepartmentRepository;
import com.liverpool.test.domain.repository.EmployeeRepository;
import com.liverpool.test.domain.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  private final DepartmentRepository departmentRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository,
      DepartmentRepository departmentRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public EmployeeDO save(EmployeeDO employeeDO) {
    EmployeeDO saved = employeeRepository.create(employeeDO);
    buildEmployee(saved);
    return saved;
  }

  @Override
  public EmployeeDO getById(String id) {
    EmployeeDO found = employeeRepository.getById(id);
    buildEmployee(found);
    return found;
  }

  @Override
  public List<EmployeeDO> getAllEmployees() {
    return employeeRepository.getAll().stream().peek(this::buildEmployee).toList();
  }

  private void buildEmployee(EmployeeDO found) {
    DepartmentDO departmentDO = departmentRepository.getById(found.getFlatId());
    found.setFlatName(departmentDO.getName());
    found.setFlatId(null);
  }
}
