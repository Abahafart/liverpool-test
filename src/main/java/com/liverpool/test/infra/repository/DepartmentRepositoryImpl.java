package com.liverpool.test.infra.repository;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import com.liverpool.test.domain.model.DepartmentDO;
import com.liverpool.test.domain.repository.DepartmentRepository;
import com.liverpool.test.infra.exception.NotFoundException;
import com.liverpool.test.infra.repository.entity.DepartmentEntity;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

  private final DepartmentJPARepository jpaRepository;
  private  final DepartmentEntityMapper mapper;

  public DepartmentRepositoryImpl(DepartmentJPARepository jpaRepository,
      DepartmentEntityMapper mapper) {
    this.jpaRepository = jpaRepository;
    this.mapper = mapper;
  }

  @Override
  public DepartmentDO getById(String id) {
    UUID departmentId = UUID.fromString(id);
    DepartmentEntity entity = jpaRepository.findById(departmentId).orElseThrow(() -> new NotFoundException("department not found"));
    return mapper.fromEntity(entity);
  }

  @Override
  public List<DepartmentDO> saveDepartments(List<DepartmentDO> departmentDOList) {
    return jpaRepository.saveAll(departmentDOList.stream().map(mapper::fromDO).toList()).stream().map(mapper::fromEntity).toList();
  }

  @Override
  public List<DepartmentDO> getAll() {
    return jpaRepository.findAll().stream().map(mapper::fromEntity).toList();
  }

  @Mapper
  public interface DepartmentEntityMapper {
    DepartmentDO fromEntity(DepartmentEntity entity);
    DepartmentEntity fromDO(DepartmentDO departmentDO);
  }
}
