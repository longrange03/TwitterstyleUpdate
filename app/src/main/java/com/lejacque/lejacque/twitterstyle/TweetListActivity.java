package com.lejacque.lejacque.twitterstyle;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.BaseAdapter;

public class TweetListActivity extends ListActivity {

    private ArrayAdapter tweetItemArrayAdapter;
    private ListView mArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        ListView listView1 = (ListView) findViewById(R.id.tweetBody);
        ListView listView2 = (ListView) findViewById(R.id.tweetTitle);

        int tweets;

        ArrayAdapter<Tweet> adapter = new ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets);

        viewLists.setAdapter(adapter);

        ArrayAdapter<Tweet> adapter1 = new ArrayAdapter<Tweet>(this, R.layout.row_tweet, );
        setListAdapter(tweetItemArrayAdapter);

        for (int i = 0; i < 20; i++) {
            Tweet tweet = new Tweet();
            tweet.setTitle("A nice header for Tweet # " + i);
            tweet.setBody("Some random body text for the tweet # " + i);
            tweets.add(tweet);
        }


        AdapterView list = null;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(this, TweetListActivity, );
                startActivity(intent);


            }
        });


    }
}


//tweetItemArrayAdapter = new TweetAdapter(this, TweetAdapter.class);
        //setListAdapter(tweetItemArrayAdapter);













