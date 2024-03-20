package com.liverpool.test.infra.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.liverpool.test.domain.client.DepartmentClient;

@Component
public class DepartmentClientImpl implements DepartmentClient {

  private final RestTemplate restTemplate;
  private final String url;

  public DepartmentClientImpl(RestTemplateBuilder builder, @Value("${departments.url}") String url) {
    this.restTemplate = builder.build();
    this.url = url;
  }
  @Override
  public List<String> getDepartments() {
    Department departments = restTemplate.getForObject(url, Department.class);
    if (departments != null && !departments.departamentos.isEmpty()) {
      return departments.departamentos.stream().distinct().toList();
    }
    return Collections.emptyList();
  }

  public record Department(List<String> departamentos){}
}
