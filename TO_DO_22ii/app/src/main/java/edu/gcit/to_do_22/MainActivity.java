package edu.gcit.to_do_22;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);

        if(getSupportLoaderManager().getLoader(0)!=null)
        {
            getSupportLoaderManager().initLoader(0,null, this);
        }
    }

    public void searchBooks(View view)
    {
        String queryString = mBookInput.getText().toString();

        //new FetchBook(mTitleText, mAuthorText).execute(queryString);

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null;
        if(connectivityManager !=null)
        {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if(networkInfo !=null && networkInfo.isConnected() && queryString.length() !=0)
        {
            Bundle querybundle = new Bundle();
            querybundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, querybundle, this);


            //new FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText(" ");
            mTitleText.setText("Loading......");
        }
        else {
            if(queryString.length()==0)
            {
                mAuthorText.setText(" ");
                mTitleText.setText("Please enter a search them");
            }
            else {
                mAuthorText.setText("");
                mTitleText.setText("please check your network connection and run again");
            }
        }

    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        String queryString = "";

        if(args !=null)
        {
            queryString = args.getString("queryString");
        }
        return new BookLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i =0;
            String title = null;
            String authors = null;

            while (i<itemsArray.length()&&(authors == null && title == null))
            {
                //get a current item information
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                //try to get authors and title from current items
                //catch if either field is empty and move on
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                //move to next item.
                i++;
            }
            if (title !=null && authors !=null)
            {
                mTitleText.setText(title);
                mAuthorText.setText(authors);
            }
            else {
                mTitleText.setText("No Result found");
                mAuthorText.setText(" ");
            }
        }
        catch (JSONException e)
        {
            mTitleText.setText("No Reslut Found");
            mAuthorText.setText(" ");
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}