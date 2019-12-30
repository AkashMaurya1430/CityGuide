package com.example.cityguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    private Button ButtonLogin;
    private EditText LoginPass;
    private EditText LoginEmail,emailreset;
    FirebaseAuth firebaseAuth ;
    private CheckBox checkbox;
    private ProgressDialog progressDialog;
    private TextView reset_pass;
    private Dialog myDialog;
    private TextView textClose;
    private Button resetpassword;


    private FirebaseAuth.AuthStateListener authStateListener;
//    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButtonLogin =(Button) findViewById(R.id.ButtonLogin);
        LoginPass = (EditText) findViewById(R.id.LoginPass);
        LoginEmail = (EditText) findViewById(R.id.LoginEmail);
        checkbox=(CheckBox) findViewById(R.id.checkbox);
        reset_pass=(TextView)findViewById(R.id.password_reset);
        myDialog= new Dialog(this);
        progressDialog =new ProgressDialog(this);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    LoginPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{

                    LoginPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });



        firebaseAuth = firebaseAuth.getInstance();
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Lemail= LoginEmail.getText().toString().trim();
                String Lpassword= LoginPass.getText().toString().trim();

                progressDialog.setMessage("LOGGING IN ");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(Lemail,Lpassword).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(login.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                        else{
                            Intent ihome_page= new Intent(getApplicationContext() , home_page.class);
                            startActivity(ihome_page);
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        });


 reset_pass.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         myDialog.setContentView(R.layout.password_popup);
         textClose=(TextView) myDialog.findViewById(R.id.textClose);
         resetpassword = (Button) myDialog.findViewById(R.id.button_reset);
         emailreset= (EditText) myDialog.findViewById(R.id.reset_passtext);
         textClose.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 myDialog.dismiss();
             }
         });
         resetpassword.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 firebaseAuth = FirebaseAuth.getInstance();
                 String useremail = emailreset.getText().toString().trim();


                 if(useremail.equals("")){

                     Toast.makeText(login.this, "ENTER A EMAIL ID", Toast.LENGTH_SHORT).show();
                 }else{

                     firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                         @Override
                         public void onComplete(@NonNull Task<Void> task) {

                             if(task.isSuccessful()){
                                 Toast.makeText(login.this, "PASSWORD RESET EMAIL SENT", Toast.LENGTH_SHORT).show();
                                 myDialog.dismiss();
                             }
                             else{

                                 Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                             }
                         }
                     });
                 }
             }
         });
         myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
         myDialog.show();
     }
 });

    }


}

