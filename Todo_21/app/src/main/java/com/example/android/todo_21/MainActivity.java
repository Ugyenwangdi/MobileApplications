package com.example.android.todo_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtV = findViewById(R.id.textView1);
    }

    public void startTask(View view) {

        mTxtV.setText(R.string.sleeping);

        new SimpleAsyncTask(mTxtV).execute();

    }
}
