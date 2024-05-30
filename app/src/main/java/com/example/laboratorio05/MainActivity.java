package com.example.laboratorio05;

import static android.content.ContentValues.TAG;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laboratorio05.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AccountEntity accountEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getIntent().hasExtra("accountEntity")) {
            accountEntity = getIntent().getParcelableExtra("accountEntity");
            if (accountEntity != null) {
                binding.editTextLogin.setText(accountEntity.getUsername());
                binding.editTextPassword.setText(accountEntity.getPassword());
            }
        }

        EditText edtUsername = binding.editTextLogin;
        EditText edtPassword = binding.editTextPassword;
        Button btnLogin = binding.buttonLogin;
        Button btnRegister = binding.buttonRegister1;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Bienvenido a mi app", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Bienvenido a mi App");
                    // Abrir HomeActivity y pasar el nombre de usuario
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username", edtUsername.getText().toString());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Error en la autenticacion", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Error en la autenticacion");
                }
            }
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            startActivity(intent);
        });
    }
}