package com.example.rentzz;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;

public class Main2Activity extends AppCompatActivity {

    private EditText registration,userName,userPhonenumber,userEmail,userPassword;
    private Button btn3;
    private Button btn4;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn4=(Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
                setupiews();
                firebaseAuth=FirebaseAuth.getInstance();
                btn3=(Button)findViewById(R.id.button3);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(validate()){
                            String user_email=  userEmail.getText().toString().trim();
                            String user_password=userPassword.getText().toString().trim();

                            firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {

                                        Toast.makeText(Main2Activity.this,"Registration Successful",Toast.LENGTH_LONG).show();
                                      // Intent intom=new Intent(this,MainActivity.class);
                                       startActivity(new Intent(Main2Activity.this,MainActivity.class));
                                    }else{
                                        Toast.makeText(Main2Activity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                                    }

                                }

                            });


                        }
                        else{
                            Toast.makeText(Main2Activity.this,"hello there! its not working",Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });



    }

    public void openActivity1(){
        Intent inn=new Intent(this,MainActivity.class);
        startActivity(inn);

    }

    public void setupiews(){
        //registration=(TextView)findViewById(R.id.textView);
        userName=(EditText)findViewById(R.id.editText4);
        userPhonenumber=(EditText)findViewById(R.id.editText5);
        userEmail=(EditText)findViewById(R.id.editText6);
        userPassword=(EditText)findViewById(R.id.editText7);
        //btn3=(Button)findViewById(R.id.button3);
        // btn4=(Button)findViewById(R.id.button4);


    }
    private Boolean validate(){
        Boolean result=false;
        String name=userName.getText().toString();
        String Phonenumber=userPhonenumber.getText().toString();
        String email=userEmail.getText().toString();
        String password=userPassword.getText().toString();
        if(name.isEmpty()||Phonenumber.isEmpty()||email.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"please enter all the details", Toast.LENGTH_LONG).show();
        }else{
            result=true;

        }
        return result;


    }

}