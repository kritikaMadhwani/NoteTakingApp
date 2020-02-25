package com.example.notepadapplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.EditText;

import com.example.kritika_m.notetaking.R;
import com.example.kritika_m.notetaking.notedb.NoteDatabase;


public class DisplayNote extends AppCompatActivity {

    EditText name;
    EditText content;
    private CoordinatorLayout coordinatorLayout;
    int id_To_Update = 0;
    Snackbar snackbar;
    NoteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = Room.databaseBuilder(getApplicationContext(),
                NoteDatabase.class, "database-name").build();


        setContentView(R.layout.create_notes);
        name = (EditText) findViewById(R.id.txtname);
        content = (EditText) findViewById(R.id.txtcontent);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                snackbar = Snackbar.make(coordinatorLayout, "Note Id : " + String.valueOf(Value), Snackbar.LENGTH_LONG);
                snackbar.show();
                id_To_Update = Value;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");
            getMenuInflater().inflate(R.menu.display_menu, menu);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
        return;
    }
}
