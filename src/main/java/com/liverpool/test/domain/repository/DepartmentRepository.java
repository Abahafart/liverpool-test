package com.liverpool.test.domain.repository;

import java.util.List;

import com.liverpool.test.domain.model.DepartmentDO;

public interface DepartmentRepository {

  DepartmentDO getById(String id);
  List<DepartmentDO> saveDepartments(List<DepartmentDO> departmentDOList);
  List<DepartmentDO> getAll();
}
