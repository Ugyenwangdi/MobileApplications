package com.android.todo_17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    private TextView mTextTeam1;
    private TextView mTextTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScore1 = 0;
        mScore2 = 0;

        mTextTeam1 = findViewById(R.id.score_1);
        mTextTeam2 = findViewById(R.id.score_2);

    }

    public void decreaseScore(View view) {

        int ViewID = view.getId();

        switch (ViewID){
            case R.id.decreaseTeam1:
                mScore1--;
                mTextTeam1.setText(String.valueOf(mScore1));
                return;

            case R.id.decreaseTeam2:
                mScore2--;
                mTextTeam2.setText(String.valueOf(mScore2));
                return;

            default:
                return;
        }

    }

    public void increaseScore(View view) {

        int ViewID = view.getId();

        switch (ViewID){
            case R.id.increaseTeam1:
                mScore1++;
                mTextTeam1.setText(String.valueOf(mScore1));
                return;

            case R.id.increaseTeam2:
                mScore2++;
                mTextTeam2.setText(String.valueOf(mScore2));
                return;

            default:
                return;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.night_mode) {

            int nightmode = AppCompatDelegate.getDefaultNightMode();

            if(nightmode == AppCompatDelegate.MODE_NIGHT_YES){

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            }else {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            }
        }

        return super.onOptionsItemSelected(item);
    }
}