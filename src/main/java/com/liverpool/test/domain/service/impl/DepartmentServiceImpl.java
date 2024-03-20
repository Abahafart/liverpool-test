package com.liverpool.test.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liverpool.test.domain.client.DepartmentClient;
import com.liverpool.test.domain.model.DepartmentDO;
import com.liverpool.test.domain.repository.DepartmentRepository;
import com.liverpool.test.domain.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentClient departmentClient;
  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentClient departmentClient,
      DepartmentRepository departmentRepository) {
    this.departmentClient = departmentClient;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<DepartmentDO> getAll() {
    List<DepartmentDO> found = departmentRepository.getAll();
    if (!found.isEmpty()) {
      return found;
    }
    return departmentRepository.saveDepartments(departmentClient.getDepartments().stream().map(DepartmentDO::new).toList());
  }
}
