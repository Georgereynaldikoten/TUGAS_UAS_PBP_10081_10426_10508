package com.example.uts1.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo")
public class Todo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="sub")
    private String sub;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub=sub;
    }


}
