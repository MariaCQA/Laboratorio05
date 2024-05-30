package com.example.laboratorio05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtFirstname = findViewById(R.id.editFirstname);
        EditText edtLastname = findViewById(R.id.editLastname);
        EditText edtEmail = findViewById(R.id.editEmailAddress);
        EditText edtPhone = findViewById(R.id.editPhone);
        EditText edtUsername = findViewById(R.id.editUsername);
        EditText edtPassword = findViewById(R.id.editPassword);
        Button btnRegister = findViewById(R.id.buttonRegister2);

        btnRegister.setOnClickListener(v -> {
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setFirstname(edtFirstname.getText().toString());
            accountEntity.setLastname(edtLastname.getText().toString());
            accountEntity.setEmail(edtEmail.getText().toString());
            accountEntity.setPhone(edtPhone.getText().toString());
            accountEntity.setUsername(edtUsername.getText().toString());
            accountEntity.setPassword(edtPassword.getText().toString());

            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            intent.putExtra("accountEntity", accountEntity);
            startActivity(intent);
        });
    }
}