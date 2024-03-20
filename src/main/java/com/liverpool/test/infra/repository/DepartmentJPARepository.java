package com.liverpool.test.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liverpool.test.infra.repository.entity.DepartmentEntity;

public interface DepartmentJPARepository extends JpaRepository<DepartmentEntity, UUID> {

}
