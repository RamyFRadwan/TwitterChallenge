package com.challenger.ramyfradwan.twitterchallenge.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.challenger.ramyfradwan.twitterchallenge.DB.FollowersDB;
import com.challenger.ramyfradwan.twitterchallenge.DB.FollowersMetaDB;
import com.challenger.ramyfradwan.twitterchallenge.Model.UserModel;
import com.challenger.ramyfradwan.twitterchallenge.R;
import com.challenger.ramyfradwan.twitterchallenge.UI.FollowersActivityFragment;
import com.challenger.ramyfradwan.twitterchallenge.UI.ProfileActivity;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link UserModel} and makes a call to the
 * specified {@link FollowersActivityFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyFollowersRecyclerViewAdapter extends RecyclerView.Adapter<MyFollowersRecyclerViewAdapter.ViewHolder> {
    public MyFollowersRecyclerViewAdapter() {
    }

    private String []  usersNameOffline ;
    private String [] usersBioOffline;

    private Context context;
    private static final String PREFS_NAME = "MyPrefsFile";

    private static final String TAG = MyFollowersRecyclerViewAdapter.class.getSimpleName();
    private List<UserModel> mValues = new ArrayList<>();
    private FollowersActivityFragment.OnListFragmentInteractionListener mListener = new FollowersActivityFragment.OnListFragmentInteractionListener() {
        @Override
        public void onListFragmentInteraction(UserModel item) {

            Intent intent = new Intent();
            intent.setClass(context, ProfileActivity.class);
            context.startActivity(intent);
        }
    };

//    private String userName, userBio, profileImageURL;

    public MyFollowersRecyclerViewAdapter(List<UserModel> items, Context context, FollowersActivityFragment.OnListFragmentInteractionListener listener) {
        Log.i(TAG, "RecyclerView Adapter initiated");
        Log.i(TAG + " Users", items.get(1).getName());
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    public MyFollowersRecyclerViewAdapter(Context context, FollowersActivityFragment.OnListFragmentInteractionListener listener) {
        Log.i(TAG, "RecyclerView Adapter initiated");
        mListener = listener;
        this.context = context;
        Log.i("Followers DB " , "  " + FollowersMetaDB.find(FollowersMetaDB.class,"USER_COUNT >= ?","0"));
        List<FollowersDB> followersDB = FollowersDB.listAll(FollowersDB.class);

        usersNameOffline = new String[followersDB.size()];
        usersBioOffline = new String[followersDB.size()];
        for (int i = 0; i < followersDB.size(); i++) {
            usersNameOffline [i] = followersDB.get(i).getScreenName();
            usersBioOffline [i] = followersDB.get(i).getBio();


        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_followers, parent, false);
        return new ViewHolder(view);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        if (isNetworkConnected()) {
            holder.mItem = mValues.get(position);
            if (holder.userName != null) {
                holder.userName.setText(mValues.get(position).getName());
                Log.e(TAG + "ViewHolder userName ", mValues.get(position).getScreenName());
            }
            if (holder.userBio != null) {
                holder.userBio.setText(mValues.get(position).getDescription());
            }
            if (holder.profileImage != null) {
                Picasso.get().load(mValues.get(position).getProfileImageUrl()).resize(500, 500).into(holder.profileImage);
            }

            SharedPreferences mSharedPref = context.getSharedPreferences(PREFS_NAME, 0);

            final SharedPreferences.Editor editor = mSharedPref.edit();


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        Log.i(TAG + "ViewHolder was celled ", "Online");

                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onListFragmentInteraction(holder.mItem);
                        Intent intent = new Intent();
                        intent.setClass(context, ProfileActivity.class);

                        editor.putString("screenname", holder.mItem.getScreenName());
                        editor.putLong("user_id", holder.mItem.getId());
                        editor.putString("description", holder.mItem.getDescription());
                        editor.putString("profileImageUrl", holder.mItem.getProfileImageUrl());
                        editor.putString("background_image_url", holder.mItem.getProfileBackgroundImageUrl());


                        // Commit the edits!
                        editor.commit();
                        context.startActivity(intent);
                    }
                }
            });
        } else if (!isNetworkConnected()) {
            Log.i(TAG + "ViewHolder was celled ", "Offline" + usersNameOffline[position]);


            if (holder.userName != null) {
                holder.userName.setText(usersNameOffline[position]);
                Log.e(TAG + "ViewHolder userName ", usersNameOffline[position]);
            }
            if (holder.userBio != null) {
                holder.userBio.setText(usersBioOffline[position]);
                Log.e(TAG + "ViewHolder userName ", usersBioOffline[position]);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Please check you internet connection", Toast.LENGTH_LONG).show();
                }
            });

        }
    }


    @Override
    public int getItemCount() {
        if (isNetworkConnected()&& mValues != null && mValues.size() != 0) {
            Log.e(TAG, "mValues is " + mValues.size());

            return mValues.size();
        } else if(!isNetworkConnected()){
            Log.i(getClass().getSimpleName() + " Counter ",
                    String.valueOf(FollowersMetaDB.find(FollowersMetaDB.class,"USER_COUNT >= ?","0" + "")));
            List<FollowersMetaDB> count = FollowersMetaDB.find(FollowersMetaDB.class,"USER_COUNT >= ?","0");

            return count.get(0).getUserCount();
        }
        else {
            Log.e(TAG, "mValues is Empty");
            return 0;
        }

    }


    class ViewHolder extends RecyclerView.ViewHolder {

        //        @BindView(R.id.UserName)
//        @Nullable
        TextView userName;
        //        @BindView(R.id.UserBio)
//        @Nullable
        TextView userBio;
        //        @BindView(R.id.profileimage)
//        @Nullable
        CircularImageView profileImage;


        //        public final TextView mIdView;
//        public final TextView mContentView;
        UserModel mItem;

        ViewHolder(View view) {
            super(view);
            Log.e(TAG, "View Binded by butter Knife");

//            ButterKnife.bind(this, view);
            userName = view.findViewById(R.id.UserName);
            userBio = view.findViewById(R.id.UserBio);
            profileImage = view.findViewById(R.id.profileimage);


        }


    }
}
