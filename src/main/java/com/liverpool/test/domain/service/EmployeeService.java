package com.liverpool.test.domain.service;

import java.util.List;

import com.liverpool.test.domain.model.EmployeeDO;

public interface EmployeeService {

  EmployeeDO save(EmployeeDO employeeDO);
  EmployeeDO getById(String id);
  List<EmployeeDO> getAllEmployees();

}
