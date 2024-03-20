package com.liverpool.test.infra.controller;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liverpool.test.domain.model.DepartmentDO;
import com.liverpool.test.domain.service.DepartmentService;
import com.liverpool.test.infra.controller.response.DepartmentResponse;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

  private final DepartmentService service;
  private final DepartmentControllerMapper mapper;

  public DepartmentsController(DepartmentService service, DepartmentControllerMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  public List<DepartmentResponse> getDepartments() {
    return service.getAll().stream().map(mapper::fromDO).toList();
  }

  @Mapper
  public interface DepartmentControllerMapper {
    DepartmentResponse fromDO(DepartmentDO departmentDO);
  }

}
