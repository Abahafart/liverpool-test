package com.liverpool.test.domain.repository;

import java.util.List;

import com.liverpool.test.domain.model.EmployeeDO;

public interface EmployeeRepository {

  EmployeeDO create(EmployeeDO employeeDO);
  EmployeeDO getById(String employeeId);
  List<EmployeeDO> getAll();
}
