package com.example.cityguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.cityguide.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private Button ButtonRegister;
    private EditText EdittextPassword;
    private EditText EdittextEmail;
    private EditText Editpersonname;
    private EditText Editphonenumber;
    private TextView TextViewSignIn;

    AwesomeValidation awesomeValidation;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog =new ProgressDialog(this);

        ButtonRegister =(Button) findViewById(R.id.ButtonRegister);
        EdittextEmail = (EditText) findViewById(R.id.EdittextEmail);
        EdittextPassword = (EditText) findViewById(R.id.EdittextPassword);
        Editpersonname = (EditText) findViewById(R.id.Editpersonname);
        Editphonenumber = (EditText) findViewById(R.id.Editphonenumber);
        EdittextPassword = (EditText) findViewById(R.id.EdittextPassword);
        TextViewSignIn  =(TextView) findViewById(R.id.TextViewSignIn);

        //ButtonRegister.setOnClickListener(this);
        //TextViewSignIn.setOnClickListener(this);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.Editpersonname, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.Editphonenumber,"[5-9]{1}[0-9]{9}$",R.string.invalid_number);
        awesomeValidation.addValidation(this,R.id.EdittextEmail, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.EdittextPassword,".{6,}",R.string.invalid_pass);

        TextViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });

    }



    public void registerUser(View view) {
        String email= EdittextEmail.getText().toString().trim();
        String password= EdittextPassword.getText().toString().trim();


        progressDialog.setMessage("REGISTERING USER");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(awesomeValidation.validate()){
                            Toast.makeText(getApplicationContext(),"FORM VALIDATE SUCCESFULLY!",Toast.LENGTH_SHORT).show();
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "REGISTERED SUCCESFULLY!", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Intent intent=new Intent(MainActivity.this,home_page.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "COULD NOT REGISTER! PLEASE TRY AGAIN!", Toast.LENGTH_SHORT).show();

                                progressDialog.dismiss();
                            }


                        }
                        else {
                            Toast.makeText(getApplicationContext(),"VALIDATION UNSUCCESFULL",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }



                    }
                });
    }



}

