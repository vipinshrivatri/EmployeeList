package com.vipin.employeelist;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vipin.employeelist.adapter.EmployeeDataAdapter;
import com.vipin.employeelist.databinding.ActivityMainBinding;
import com.vipin.employeelist.model.Employee;
import com.vipin.employeelist.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private EmployeeDataAdapter employeeDataAdapter;
    private ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        employeeDataAdapter = new EmployeeDataAdapter();
        recyclerView.setAdapter(employeeDataAdapter);
        pb = findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);

        getAllEmployee();
    }


    private void getAllEmployee() {
        mainViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {
                employeeDataAdapter.setEmployeeList((ArrayList<Employee>) employees);
                pb.setVisibility(View.GONE);

            }
        });
    }


}