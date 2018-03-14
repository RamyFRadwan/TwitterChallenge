package com.challenger.ramyfradwan.twitterchallenge.UI;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.challenger.ramyfradwan.twitterchallenge.R;
import com.challenger.ramyfradwan.twitterchallenge.Utilities.FetchTwitterProfile;
import com.challenger.ramyfradwan.twitterchallenge.Utilities.ZoomImage;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;
import java.util.Objects;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileActivityFragment extends Fragment {
    private ProfileActivityFragment.OnListFragmentInteractionListener mListener;
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 2;
    private Long userId;
    private String screenName ,userBio,profileImageUrl, backgroundImageUrl;
    public static final String PREFS_NAME = "MyPrefsFile";


    public ProfileActivityFragment() {
    }


    View view;
    ImageView background;
    CircularImageView circularImageView;
    TextView Name,Bio;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences settings = getContext().getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
        ListView listView = (ListView) view.findViewById(R.id.tweetlist);
        // UI components init
        circularImageView = (CircularImageView) view.findViewById(R.id.profileimage);
        Name = view.findViewById(R.id.UserName);
        Bio = view.findViewById(R.id.UserBio);
        background = view.findViewById(R.id.background);

        // getting data from sharedpreferences
        this.userId = settings.getLong("user_id",0);
        this.screenName = settings.getString("screenname"," ");
        this.userBio=settings.getString("description","No Bio for this userModel");
        this.profileImageUrl = settings.getString("profileImageUrl","");
        this.backgroundImageUrl = settings.getString("background_image_url","");
        this.screenName = settings.getString("screenname","");


        // Populating UI components
        Picasso.get().load(profileImageUrl).into(circularImageView);
        if(!Objects.equals(backgroundImageUrl, ""))
            Picasso.get().load(backgroundImageUrl).into(background);
        Name.setText(screenName);
        Bio.setText(userBio);
        Log.i(getClass().getSimpleName() , "Screen Name here is" + screenName);




        // Setting Zoom Actions
        circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = circularImageView.getDrawable();
                ZoomImage zom =new ZoomImage(v,drawable,view);
            }
        });
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = background.getDrawable();

                ZoomImage zom =new ZoomImage(v,drawable,view);
            }
        });
        // calling the class for dealing with tweets
        FetchTwitterProfile fetchTwitterProfile = new FetchTwitterProfile(getContext(), screenName,listView);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @SuppressWarnings("unused")
    public static FollowersActivityFragment newInstance(int columnCount) {
        FollowersActivityFragment fragment = new FollowersActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ProfileActivityFragment.OnListFragmentInteractionListener) {
            mListener = (ProfileActivityFragment.OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction();

    }


}
