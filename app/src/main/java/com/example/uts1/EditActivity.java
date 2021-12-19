package com.example.uts1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts1.DAO.UserDao;
import com.example.uts1.Database.UserDatabase;
import com.example.uts1.Model.User;
import com.example.uts1.Preferences.UserPreferences;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EditActivity extends AppCompatActivity {
    EditText etPassword, etAlamat, etName, etNoTelp, etJenisKelamin, etEmail;
    ImageView ivBack;
    Button btnUpdate;
    UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        userPreferences = new UserPreferences(EditActivity.this);

        etPassword = findViewById(R.id.et_password);
        etName = findViewById(R.id.et_nama);
        etEmail = findViewById(R.id.et_email);
        etAlamat = findViewById(R.id.et_alamat);
        etNoTelp = findViewById(R.id.et_noTelp);
        etJenisKelamin = findViewById(R.id.et_jenisKelamin);
        btnUpdate = findViewById(R.id.btn_update);
        ivBack = findViewById(R.id.iv_back);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditActivity.this, ProfilActivity.class));
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String noTelp = etNoTelp.getText().toString();
                String alamat = etAlamat.getText().toString();
                String jenisKelamin = etJenisKelamin.getText().toString();
                String email = userPreferences.getUserLogin().getEmail();
                String password = etPassword.getText().toString();

                if (name.isEmpty()) {
                    startActivity(new Intent(EditActivity.this, MainActivity.class));
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    userDao.updateName(name, email, password, alamat, jenisKelamin, noTelp);
                }
            }
        });
    }
}