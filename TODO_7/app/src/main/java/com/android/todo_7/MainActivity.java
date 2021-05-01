package com.android.todo_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView)findViewById(R.id.textView1);
    }

    public void onClick(View view) {
        textview.setText(String.valueOf(i));
        i++;
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle){
        bundle.putString("count",textview.getText().toString());
        super.onSaveInstanceState(bundle);
    }

    @Override
    protected  void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        textview.setText(savedInstanceState.getString("count"));
    }

}