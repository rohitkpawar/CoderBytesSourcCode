package com.coder.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout txtName, txtEmail, txtHomePhone, txtMobilePhone, txtAddress, txtZipCode;
    private EditText etName, etEmail, etHomePhone, etMobilePhone, etAddress, etZipCode;
    private FrameLayout frmSubmit;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtHomePhone = findViewById(R.id.txtHomePhone);
        txtMobilePhone = findViewById(R.id.txtMobilePhone);
        txtAddress = findViewById(R.id.txtAddress);
        txtZipCode = findViewById(R.id.txtZipCode);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etHomePhone = findViewById(R.id.etHomePhone);
        etMobilePhone = findViewById(R.id.etMobilePhone);
        etAddress = findViewById(R.id.etAddress);
        etZipCode = findViewById(R.id.etZipCode);
        frmSubmit = findViewById(R.id.frmSubmit);

        frmSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frmSubmit:
                getValidData();
                break;
            default:
                break;

        }
    }

    private void getValidData() {
        if (etName.getText().toString().isEmpty()) {
            txtName.setEnabled(true);
            txtName.setError("Please enter your name");
            return;
        } else
            txtName.setErrorEnabled(false);
        /**************************************************************/
        if (etEmail.getText().toString().isEmpty()) {
            txtEmail.setEnabled(true);
            txtEmail.setError("Please enter your email id");
            return;
        } else if (!etEmail.getText().toString().matches(emailPattern)) {
            txtEmail.setEnabled(true);
            txtEmail.setError("Please enter valid email address");
            return;
        } else
            txtEmail.setErrorEnabled(false);
        /**************************************************************/
        if (etHomePhone.getText().toString().isEmpty() && etMobilePhone.getText().toString().isEmpty()) {
            txtHomePhone.setEnabled(true);
            txtHomePhone.setError("Please enter your home phone no");

            txtMobilePhone.setEnabled(true);
            txtMobilePhone.setError("Please enter your home mobile no");
            return;
        } else {
            txtHomePhone.setErrorEnabled(false);
            txtMobilePhone.setErrorEnabled(false);
        }
        /**************************************************************/
        setData();
    }

    private void setData() {
        Intent intent = new Intent(this, ActivityShowdata.class);
        intent.putExtra("name", etName.getText().toString());
        intent.putExtra("email", etEmail.getText().toString());
        intent.putExtra("homePhone", etHomePhone.getText().toString());
        intent.putExtra("mobilePhone", etMobilePhone.getText().toString());
        intent.putExtra("address", etAddress.getText().toString());
        intent.putExtra("zipCode", etZipCode.getText().toString());
        startActivity(intent);
    }
}