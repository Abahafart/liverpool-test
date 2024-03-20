package com.liverpool.test.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liverpool.test.infra.repository.entity.EmployeeEntity;

public interface EmployeeJPARepository extends JpaRepository<EmployeeEntity, UUID> {

}
