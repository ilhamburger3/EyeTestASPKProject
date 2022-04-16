package com.example.eyetestaspkv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class EmployeeListActivity extends AppCompatActivity {

    private RecyclerView employeeRecView;
    private EmployeeRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_employee_list);

        adapter = new EmployeeRecViewAdapter(this);
        employeeRecView = findViewById(R.id.employeeRecView);

        employeeRecView.setAdapter(adapter);
        employeeRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setEmployees(Utils.getInstance().getAllEmployees());

    }
}