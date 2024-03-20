package com.liverpool.test.infra.controller;

import org.mapstruct.Mapper;

import com.liverpool.test.domain.model.EmployeeDO;
import com.liverpool.test.infra.controller.request.EmployeeRequest;
import com.liverpool.test.infra.controller.response.EmployeeResponse;

@Mapper
public interface EmployeeMapper {

  EmployeeDO fromRequest(EmployeeRequest request);
  EmployeeResponse fromDO(EmployeeDO employeeDO);
}
