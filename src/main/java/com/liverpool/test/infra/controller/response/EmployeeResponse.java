package com.liverpool.test.infra.controller.response;

public class EmployeeResponse {

  private String fullName;
  private String flatName;
  private String employeeId;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFlatName() {
    return flatName;
  }

  public void setFlatName(String flatName) {
    this.flatName = flatName;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }
}
