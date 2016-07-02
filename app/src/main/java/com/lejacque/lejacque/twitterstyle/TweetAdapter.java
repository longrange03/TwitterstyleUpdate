package com.lejacque.lejacque.twitterstyle;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TweetAdapter extends ArrayAdapter<Tweet> {
    private ArrayList<Tweet> objects;

    public TweetAdapter(Context context, int textViewResourceId, ArrayList<Tweet> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_tweet_detail, null);
        }

        Tweet i = objects.get(position);

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView tt = (TextView) v.findViewById(R.id.tweetTitle);
            TextView tb = (TextView) v.findViewById(R.id.tweetBody);

            if (tt != null) {
                tt.setText("Title: ");
            }
            if (tb != null) {
                tb.setText(i.getBody());
            }

        }
        return v;
    }
}




//User user = getItem(position);

// ViewHolder viewHolder;
// if (convertView == null) {
//convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);


//TextView tweetBody = (TextView) convertView.findViewById(R.id.tweetBody);
//TextView tweetTitle = (TextView) convertView.findViewById(R.id.tweetTitle);
//return convertView;



