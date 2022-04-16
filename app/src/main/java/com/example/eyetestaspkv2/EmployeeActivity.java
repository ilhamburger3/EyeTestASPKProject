package com.example.eyetestaspkv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class EmployeeActivity extends AppCompatActivity {
    public static final String EMPLOYEE_ID_KEY = "employeId";

    private TextView txtEmployeeName, txtDescription;
    private Button btnShowContact, btnShowMedRec, btnShowCV, btnDelete;
    private ImageView employeeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        initViews();

        //TODO: get the data from rec view here
//        Employee employee = new Employee(5, "Joseph Monsieur", "https://akcdn.detik.net.id/community/media/visual/2022/04/13/screenshot-youtube-paytren-official-6_43.jpeg?w=250&q=",
//                "SAYA BUTUH 200 TRILIUN, MAU ANDA PATUNGAN? MAU?", "this is long desc");


        Intent intent = getIntent();
        if (null != intent){
            int employeeId = intent.getIntExtra(EMPLOYEE_ID_KEY, -1);
            if (employeeId != -1){
                Employee incomingEmployee = Utils.getInstance().getEmployeeById(employeeId);
                if (null != incomingEmployee){
                    setData(incomingEmployee);
                }
            }
        }
    }

    private void setData(Employee employee){
        txtEmployeeName.setText(employee.getName());
        txtDescription.setText(employee.getLongDesc());
        Glide.with(this)
                .asBitmap().load(employee.getImageUrl())
                .into(employeeImage);
    }

    private void initViews(){
        txtEmployeeName = findViewById(R.id.txtEmployeeName);
        txtDescription = findViewById(R.id.txtDescription);

        btnShowContact = findViewById(R.id.btnShowContact);
        btnShowMedRec = findViewById(R.id.btnShowMedRec);
        btnShowCV = findViewById(R.id.btnShowCV);
        btnDelete = findViewById(R.id.btnDelete);

        employeeImage = findViewById(R.id.imgEmployee);

    }
}