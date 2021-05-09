package com.android.todo14_ii;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlert =
                new AlertDialog.Builder(MainActivity.this);

        // Set the dialog title and message.
        myAlert.setTitle(R.string.alert_title);
        myAlert.setMessage(R.string.alert_message);

        // Add the dialog buttons.
        myAlert.setPositiveButton(R.string.ok_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                        Toast.makeText(getApplicationContext(),
                                R.string.pressed_ok,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        myAlert.setNegativeButton(R.string.cancel_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(),
                                R.string.pressed_cancel,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        // Create and show the AlertDialog.
        myAlert.show();
    }
}

