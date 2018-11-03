package edu.gatech.donatrix.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.donatrix.R;
import edu.gatech.donatrix.dao.UserDao;

public class LoginActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = (EditText) findViewById(R.id.loginEmailTextField);
        passwordField = (EditText) findViewById(R.id.loginPasswordTextField);
    }

    public void onCancelPressed() {
        finish();
    }

    public void onLoginPressed() {
        if (UserDao.checkRegisteredUser(emailField.toString(), passwordField.toString(), this)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
        } else {
            Toast toast = new Toast(this);
            toast.setText("Invalid Login");
            toast.show();
        }
    }
}
