package com.example.android.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    EditText mBookInput;
    TextView mTitle;
    TextView mAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = findViewById(R.id.bookInput);
        mTitle = findViewById(R.id.titleText);
        mAuthor = findViewById(R.id.authorText);



    }

    public void searchBook(View view) {

        String queryString = mBookInput.getText().toString();

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null;

        if(connMgr != null) {

            networkInfo = connMgr.getActiveNetworkInfo();

        }

        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0) {

            new FetchBook(mTitle, mAuthor).execute(queryString);
            mAuthor.setText(" ");
            mTitle.setText("Loading......");

        }
        else {

            if (queryString.length() == 0) {

                mAuthor.setText(" ");
                mTitle.setText("Please enter a search term");

            }
            else {

                mAuthor.setText(" ");
                mTitle.setText("Please check your network connection and run again");

            }
        }

    }
}