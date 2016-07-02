package com.lejacque.lejacque.twitterstyle;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends ListActivity {

    private ArrayList<Tweet> m_lists = new ArrayList<Tweet>();
    private Runnable viewLists;
    private TweetAdapter m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //check if the current Activity needs to be skipped {
        //Intent intent = new Intent(this, TweetListActivity.class);
        //startActivity(intent);
        //finish();
        //}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_adapter = new TweetAdapter(this, R.layout.activity_tweet_list, m_lists);
        setListAdapter(m_adapter);

        viewLists = new Runnable(){
            public void run(){
                handler.sendEmptyMessage(0);
            }
        };

        _loginBtn = ( Button ) findViewById(R.id.btn_login);

        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = ( EditText ) findViewById(R.id.fld_username);
                String usernameValue = username.getText().toString();

                SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("name",usernameValue);
                editor.commit();


                EditText password = ( EditText ) findViewById(R.id.fld_pwd);
                String passwordValue = password.getText().toString();

                SharedPreferences prefs1 = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = prefs.edit();
                editor.putString("password",passwordValue);
                editor.commit();

                Log.d("Codelearn", "username caught - " + usernameValue);


                Intent intent = new Intent(MainActivity.this, TweetListActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
