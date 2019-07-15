package com.howardshowered.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {

    private EditText m_txtUsername;
    private EditText m_txtPassword;
    private EditText m_txtRePassword;
    private EditText m_txtEmail;
    private EditText m_txtPhone;
    private Button m_btnSignMeUp = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //sets Username and password to R.ID connected to xml file
        m_txtUsername = (EditText) findViewById(R.id.txtUsername);
        m_txtPassword = (EditText) findViewById(R.id.txtPassword);
        m_txtRePassword = (EditText) findViewById(R.id.txtRetypePassword);
        m_btnSignMeUp = (Button) findViewById(R.id.btnSignMeUp);
        m_txtEmail = (EditText) findViewById(R.id.txtEmail);
        m_txtPhone = (EditText) findViewById(R.id.txtPhone);


        final HashMap<String,String> dataDictionary = MainActivity.getDataDictionary();
        Intent intent = getIntent();
        String username = intent.getStringExtra("Username");
        m_txtUsername.setText(username);

        m_btnSignMeUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String password = "";
                String rePassword = "";
                String username = "";
                String phone ="";
                String email = "";

                password = m_txtPassword.getText().toString();
                rePassword = m_txtRePassword.getText().toString();
                username = m_txtUsername.getText().toString();
                phone = m_txtPhone.getText().toString();
                email = m_txtEmail.getText().toString();

                if (dataDictionary.containsKey(username)) {
                    Toast.makeText(getApplicationContext(), "Username taken!", Toast.LENGTH_LONG).show();
                } else if (username.length() == 0){
                    Toast.makeText(getApplicationContext(), "UserName field is empty!", Toast.LENGTH_LONG).show();
                } else if(password.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password must be 8 or more characters", Toast.LENGTH_LONG).show();
                }  else if (!password.equals(rePassword)) {
                    Toast.makeText(getApplicationContext(), "Passwords Don't Match!", Toast.LENGTH_LONG).show();
                } else if (password.length() == 0){
                    Toast.makeText(getApplicationContext(), "Password field is empty!", Toast.LENGTH_LONG).show();
                } else if (rePassword.length() == 0){
                    Toast.makeText(getApplicationContext(), "Retype Password field is empty!", Toast.LENGTH_LONG).show();
                }  else if (email.length() == 0){
                    Toast.makeText(getApplicationContext(), "Email field is empty!", Toast.LENGTH_LONG).show();
                } else if (phone.length() == 0){
                    Toast.makeText(getApplicationContext(), "Phone field is empty!", Toast.LENGTH_LONG).show();
                } else{
                    dataDictionary.put(username, password);
                    MainActivity.setDataDictionary(dataDictionary);
                    Toast.makeText(getApplicationContext(), "You have sucessfully signed up!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }

            }

        });

    }
}
