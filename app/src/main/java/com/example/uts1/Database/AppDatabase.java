package com.example.uts1.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.uts1.DAO.TodoDao;
import com.example.uts1.Model.Todo;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
}