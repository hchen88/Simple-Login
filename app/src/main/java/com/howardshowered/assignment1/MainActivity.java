package com.howardshowered.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button m_btnLogin = null; //Button object for btnLogin
    private Button m_btnSignup = null; //Button object for btnSignup
    private EditText m_txtUsername = null; //EditText object for Username
    private EditText m_txtPassword = null; //EditText object for Password
    private static HashMap<String, String> dataDictionary = new HashMap();

    public static HashMap<String, String> getDataDictionary() {
        return dataDictionary;
    }

    public static void setDataDictionary(HashMap<String, String> dataDictionary) {
        MainActivity.dataDictionary = dataDictionary;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //constructor of the parent class
        setContentView(R.layout.activity_main); //sets the content view to the xml file activity_main

        m_btnLogin = (Button) findViewById(R.id.btnLogin);
        m_btnSignup = (Button) findViewById(R.id.btnSignup);
        m_txtUsername = (EditText) findViewById(R.id.txtUsername);
        m_txtPassword = (EditText) findViewById(R.id.txtPassword);


        m_btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = "";
                String password = ""; //string of password

                username = m_txtUsername.getText().toString(); // gets string of username
                // from plain text field
                password = m_txtPassword.getText().toString(); // gets string of password  from plain
                // text text  field

                if (dataDictionary.containsKey(username)) { // user is in data Dictionary

                    if (dataDictionary.get(username).equals(password)) { //password entered is corrrect

                        Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                        intent.putExtra("Message", "Welcome " + username + "! ");
                        startActivity(intent);

                    } else { // password entered is incorrect
                        //clears password field
                        m_txtPassword.setText("");
                        Toast.makeText(getApplicationContext(), "Incorrect password!", Toast.LENGTH_LONG).show();
                    }
                } else { //Username is not a key in dataDictionary
                    //clears password field
                    m_txtPassword.setText("");
                    //sends Toast for incorrect password/username
                    Toast.makeText(getApplicationContext(), "Incorrect UserName/password!", Toast.LENGTH_LONG).show();
                }

            }
        });

        m_btnSignup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String username = "";
                String password = "";

                username = m_txtUsername.getText().toString(); // gets string of username
                // from plain text field
                password = m_txtPassword.getText().toString(); // gets string of password  from plain
                // text field

                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                intent.putExtra("Username", username);
                startActivity(intent);

            }

        });
    }
}
