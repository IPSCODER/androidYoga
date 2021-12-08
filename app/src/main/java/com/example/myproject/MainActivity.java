package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private Button login;

    EditText username,password,cpassword;
    Button signin,signup;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);

        signup = (Button) findViewById(R.id.signup);
        signin = (Button) findViewById(R.id.signin);

        myDB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String cpass = cpassword.getText().toString();

                if (user.equals("") || pass.equals("") || cpass.equals("")){
                    Toast.makeText(MainActivity.this, "Fill All The Fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(cpass)){
                       Boolean usercheckResult = myDB.checkusername(user);
                       if (usercheckResult == false){
                          Boolean regResult = myDB.insertdata(user,pass);
                          if (regResult == true){
                              Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                              startActivity(intent);
                          } else {
                              Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                          }
                       }else {
                           Toast.makeText(MainActivity.this, "User already Exists.\n please sign in ", Toast.LENGTH_SHORT).show();
                       }
                    }else {
                        Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent1);
            }
        });






















































//        Button reg = findViewById(R.id.reg);
//
//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,register.class);
//                startActivity(intent);
//            }
//        });

//        login = findViewById(R.id.login);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,login.class);
//                startActivity(intent);
//
//            }
//
//
//        });
    }
}