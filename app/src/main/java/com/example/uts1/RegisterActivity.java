package com.example.uts1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts1.DAO.UserDao;
import com.example.uts1.Database.UserDatabase;
import com.example.uts1.Model.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText etUsername,etPassword,etAlamat,etName,etNoTelp,etJenisKelamin,etEmail;
    MaterialButton btnRegister,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etPassword = findViewById(R.id.et_password);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etAlamat = findViewById(R.id.et_alamat);
        etNoTelp = findViewById(R.id.et_noTelp);
        etJenisKelamin = findViewById(R.id.et_jenisKelamin);
        btnRegister = findViewById(R.id.btn_register);
        btnLogin = findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setEmail(etEmail.getText().toString());
                user.setPassword(etPassword.getText().toString());
                user.setName(etName.getText().toString());
                user.setAlamat(etAlamat.getText().toString());
                user.setJenisKelamin(etJenisKelamin.getText().toString());
                user.setNoTelp(etNoTelp.getText().toString());

                if (validateInput(user)) {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(user);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Berhasil Registrasi!",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                }
                            });
                        }
                    }).start();
                } else {
                    Toast.makeText(getApplicationContext(), "Tidak boleh ada kosong!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private boolean validateInput(User user) {
        if (user.getName().isEmpty() ||
                user.getEmail().isEmpty() ||
                user.getPassword().isEmpty() ||
                user.getAlamat().isEmpty() ||
                user.getNoTelp().isEmpty() ||
                user.getJenisKelamin().isEmpty()) {
            return false;
        }
        return true;
    }
}
