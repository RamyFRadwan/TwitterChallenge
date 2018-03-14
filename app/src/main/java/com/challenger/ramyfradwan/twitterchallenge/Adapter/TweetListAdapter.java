package com.challenger.ramyfradwan.twitterchallenge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.challenger.ramyfradwan.twitterchallenge.R;

import java.util.ArrayList;

/**
 * Created by RamyFRadwan on 3/14/2018.
 */

public class TweetListAdapter  extends ArrayAdapter<String> {

    private ArrayList<String> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtTweet;

    }

    public TweetListAdapter(ArrayList<String> data, Context context) {
        super(context, R.layout.tweet_item , data);
        this.dataSet = data;
        this.mContext=context;

    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tweet_item, parent, false);
            viewHolder.txtTweet = (TextView) convertView.findViewById(R.id.tweet_item);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        viewHolder.txtTweet.setText(dataModel);

        // Return the completed view to render on screen
        return convertView;
    }
}