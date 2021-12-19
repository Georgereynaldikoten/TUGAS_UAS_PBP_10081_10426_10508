package com.example.uts1.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.uts1.Model.User;

@Dao
public interface UserDao {
    @Insert
    void registerUser(User user);

    @Query("SELECT * FROM users WHERE email=(:email) AND password=(:password)")
    User login(String email, String password);

    @Query("UPDATE users SET name=(:name), password=(:password), alamat=(:alamat), jenisKelamin=(:jenisKelamin), noTelp=(:noTelp)  WHERE email=(:email)")
    void updateName(String name, String email, String password, String alamat, String jenisKelamin, String noTelp);
}
