package com.example.safinalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class AdmitActivity extends AppCompatActivity {

    private EditText etName, etEmail, etNumber, etAge;
    private RadioGroup rgRole;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admit);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etNumber = findViewById(R.id.et_number);
        etAge = findViewById(R.id.et_age);
        rgRole = findViewById(R.id.rg_role);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String number = etNumber.getText().toString().trim();
            String age = etAge.getText().toString().trim();

            int selectedRoleId = rgRole.getCheckedRadioButtonId();

            if (name.isEmpty() || email.isEmpty() || number.isEmpty() || age.isEmpty() || selectedRoleId == -1) {
                showCustomToast("Please fill all fields");
                return;
            }

            if (!isValidEmail(email)) {
                showCustomToast("Invalid email address");
                return;
            }

            if (!isValidNumber(number)) {
                showCustomToast("Invalid phone number");
                return;
            }

            RadioButton selectedRole = findViewById(selectedRoleId);
            String role = selectedRole.getText().toString();

            showCustomToast("Submitted Successfully.\nWe will inform you by Email or Phone");

            finish();

        });
    }

    private void showCustomToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.tv_root));

        TextView tvMessage = layout.findViewById(R.id.tv_custom_toast);
        tvMessage.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailPattern, email);
    }

    private boolean isValidNumber(String number) {
        String numberPattern = "^\\+?[0-9]{10,13}$";
        return Pattern.matches(numberPattern, number);
    }
}
