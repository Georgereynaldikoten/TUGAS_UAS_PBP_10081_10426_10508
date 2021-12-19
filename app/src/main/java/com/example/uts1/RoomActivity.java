package com.example.uts1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts1.Adapter.TodoAdapter;
import com.example.uts1.Database.DatabaseTodo;
import com.example.uts1.Model.Todo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {
    private EditText edt_todo;
    private EditText edt_sub;
    private Button btnReset, btnAdd;
    private RecyclerView rv_todoList;

    private List<Todo> todoList;
    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.todo_recycler);

        edt_todo=findViewById(R.id.edt_todo);
        edt_sub=findViewById(R.id.edt_sub);
        btnReset=findViewById(R.id.btnReset);
        btnAdd=findViewById(R.id.btnAdd);
        rv_todoList=findViewById(R.id.rv_todoList);

        rv_todoList.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!edt_todo.getText().toString().isEmpty()) && (!edt_sub.getText().toString().isEmpty())) {
                    addTodo();
                }else {
                    Toast.makeText(RoomActivity.this, "Ada Kolom yang tidak diisi !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_todo.setText("");
                edt_sub.setText("");
            }
        });

        getTodos();

        todoList=new ArrayList<>();
    }

    private void addTodo() {
        final String title=edt_todo.getText().toString();
        final String sub=edt_sub.getText().toString();

        class AddTodo extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                Todo todo = new Todo();
                todo.setTitle(title);
                todo.setSub(sub);

                DatabaseTodo.getInstance(getApplicationContext())
                        .getDatabase()
                        .todoDao()
                        .insertTodo(todo);

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(RoomActivity.this, "Berhasil menambahkan data", Toast.LENGTH_SHORT).show();
                edt_todo.setText("");
                edt_sub.setText("");
                getTodos();
            }
        }
        AddTodo addTodo=new AddTodo(  );
        addTodo.execute();
    }

    private void getTodos() {
        class GetTodos extends AsyncTask<Void, Void, List<Todo>> {
            @Override
            protected List<Todo> doInBackground(Void... voids) {
                List<Todo> todoList=DatabaseTodo.getInstance(getApplicationContext())
                        .getDatabase()
                        .todoDao()
                        .getAll();
                return todoList;
            }

            @Override
            protected void onPostExecute(List<Todo> todos) {
                super.onPostExecute(todos);
                todoAdapter=new TodoAdapter(todos, RoomActivity.this);
                rv_todoList.setAdapter(todoAdapter);
            }
        }

        GetTodos getTodos=new GetTodos();
        getTodos.execute();
    }
}