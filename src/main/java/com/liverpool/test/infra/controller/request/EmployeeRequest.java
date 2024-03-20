package com.liverpool.test.infra.controller.request;

public class EmployeeRequest {

  private String fullName;
  private String flatId;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFlatId() {
    return flatId;
  }

  public void setFlatId(String flatId) {
    this.flatId = flatId;
  }
}
