package com.vipin.employeelist.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.vipin.employeelist.model.Employee;
import com.vipin.employeelist.model.EmployeeRepo;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private EmployeeRepo employeeRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepo();
    }

    public LiveData<List<Employee>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }


}
