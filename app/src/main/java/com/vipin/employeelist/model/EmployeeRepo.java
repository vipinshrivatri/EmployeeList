package com.vipin.employeelist.model;

import androidx.lifecycle.MutableLiveData;

import com.vipin.employeelist.network.EmployeeDataService;
import com.vipin.employeelist.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EmployeeRepo {
    private static final String TAG = "EmployeeRepository";
    private ArrayList<Employee> employees = new ArrayList<>();
    private MutableLiveData<List<Employee>> mutableLiveData = new MutableLiveData<>();

    public EmployeeRepo() {
    }

    public MutableLiveData<List<Employee>> getMutableLiveData() {

        final EmployeeDataService userDataService = RetrofitClient.getService();

        Call<EmployeeDBResult> call = userDataService.getEmployees();
        call.enqueue(new Callback<EmployeeDBResult>() {
            @Override
            public void onResponse(Call<EmployeeDBResult> call, Response<EmployeeDBResult> response) {
                EmployeeDBResult employeeDBResponse = response.body();
                if (employeeDBResponse != null && employeeDBResponse.getEmployee() != null) {
                    employees = (ArrayList<Employee>) employeeDBResponse.getEmployee();
                    mutableLiveData.setValue(employees);
                }
            }

            @Override
            public void onFailure(Call<EmployeeDBResult> call, Throwable t) {
//        Toast.makeText(context, "Network Error", Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveData;
    }
}
