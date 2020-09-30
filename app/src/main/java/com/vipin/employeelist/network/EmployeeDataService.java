package com.vipin.employeelist.network;

import com.vipin.employeelist.model.EmployeeDBResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeDataService {
  @GET("api/v1/employees")
  Call<EmployeeDBResult> getEmployees();
}
