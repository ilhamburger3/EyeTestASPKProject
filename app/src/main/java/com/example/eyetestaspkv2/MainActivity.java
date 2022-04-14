package com.example.eyetestaspkv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnLogout;
    Button btnTestHistory;
    Button btnEmpList;
    Button btnEnterTestMode;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.btnLogout);
        btnTestHistory = findViewById(R.id.btnTestHistory);
        btnEmpList = findViewById(R.id.btnEmpList);
        btnEnterTestMode = findViewById(R.id.btnEnterTestMode);

        mAuth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
        btnTestHistory.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, TestHistoryActivity.class));
        });
        btnEmpList.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, EmployeeListActivity.class));
        });
        btnEnterTestMode.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, TestModeActivity.class));
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }


    public void btnSettings (View view){
        Intent intent = new Intent(MainActivity.this, TestSettingsActivity.class);
        startActivity(intent);
    }





}