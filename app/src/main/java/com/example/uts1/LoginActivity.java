package com.example.uts1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts1.DAO.UserDao;
import com.example.uts1.Database.UserDatabase;
import com.example.uts1.Model.User;
import com.example.uts1.Preferences.UserPreferences;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    MaterialButton btnRegister, btnLogin, btnClear;
    TextInputLayout inputEmail, inputPassword;
    TextInputEditText etEmail, etPassword;
    UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userPreferences = new UserPreferences(LoginActivity.this);
        btnRegister = findViewById(R.id.btn_register);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnClear = findViewById(R.id.btn_clear);

        checkLogin();

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //  Mengkosongkan Input
                String username = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                etEmail.setText("");
                etPassword.setText("");

                //  Memunculkan SnackBar
                Snackbar.make(view, "Text Cleared Success", Snackbar.LENGTH_LONG)
                        .setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                etEmail.setText(username);
                                etPassword.setText(password);
                            }
                        }).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Masih Terdapat Kosong!",
                            Toast.LENGTH_SHORT)
                            .show();
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.login(email, password);
                            if (user == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Email Atau Password Salah!",
                                                Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                });
                            } else {
                                String name = user.getName();
                                String alamat = user.getAlamat();
                                String noTelp = user.getNoTelp();
                                String jenisKelamin = user.getJenisKelamin();
                                userPreferences.setLogin(email, password, name, alamat, noTelp, jenisKelamin);
                                checkLogin();
                            }
                        }
                    }).start();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void checkLogin() {
        if (userPreferences.checkLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }
}
