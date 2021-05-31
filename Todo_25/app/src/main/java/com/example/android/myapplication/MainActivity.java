package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText eName, eSname, eMarks, eID;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        eName = findViewById(R.id.firstName);
        eSname = findViewById(R.id.lastName);
        eMarks = findViewById(R.id.itwmarks);
        eID = findViewById(R.id.ID);

        addBtn = findViewById(R.id.add);


    }

    public void addData(View view) {

        //addBtn.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
                boolean isInserted = myDb.insertData(eID.getText().toString(),
                        eName.getText().toString(),
                        eSname.getText().toString(),
                        eMarks.getText().toString());

                if (isInserted == true) {

                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }

            }
       // });

    //}
}