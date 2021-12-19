package com.example.uts1.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.uts1.DAO.UserDao;
import com.example.uts1.Model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String dbname = "users";
    private static UserDatabase userDatabase;

    public static synchronized UserDatabase getUserDatabase(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, dbname)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDao userDao();
}
