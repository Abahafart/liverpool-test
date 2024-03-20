package com.liverpool.test.infra.repository;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Repository;

import com.liverpool.test.domain.model.EmployeeDO;
import com.liverpool.test.domain.repository.EmployeeRepository;
import com.liverpool.test.infra.exception.NotFoundException;
import com.liverpool.test.infra.repository.entity.EmployeeEntity;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final EmployeeJPARepository jpaRepository;
  private final MapperEntity mapper;

  public EmployeeRepositoryImpl(EmployeeJPARepository jpaRepository, MapperEntity mapper) {
    this.jpaRepository = jpaRepository;
    this.mapper = mapper;
  }

  @Override
  public EmployeeDO create(EmployeeDO employeeDO) {
    EmployeeEntity entity = mapper.fromDO(employeeDO);
    return mapper.fromEntity(jpaRepository.save(entity));
  }

  @Override
  public EmployeeDO getById(String employeeId) {
    EmployeeEntity entity = jpaRepository.findById(UUID.fromString(employeeId)).orElseThrow(() -> new NotFoundException(String.format("Employee with id %s not found", employeeId)));
    return mapper.fromEntity(entity);
  }

  @Override
  public List<EmployeeDO> getAll() {
    return jpaRepository.findAll().stream().map(mapper::fromEntity).toList();
  }

  @Mapper
  public interface MapperEntity {
    EmployeeEntity fromDO(EmployeeDO employeeDO);
    @Mapping(source = "id", target = "employeeId")
    EmployeeDO fromEntity(EmployeeEntity entity);
  }
}
