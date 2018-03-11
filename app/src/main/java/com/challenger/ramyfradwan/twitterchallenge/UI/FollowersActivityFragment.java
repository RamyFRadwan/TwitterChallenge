package com.challenger.ramyfradwan.twitterchallenge.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenger.ramyfradwan.twitterchallenge.Model.User;
import com.challenger.ramyfradwan.twitterchallenge.R;
import com.challenger.ramyfradwan.twitterchallenge.Utilities.FetchTwitterUsersList;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class FollowersActivityFragment extends Fragment  {
    public static final String PREFS_NAME = "MyPrefsFile";
    boolean hasLoggedIn;
    String user_id;
    Long user_Id;
    RecyclerView view;
    List<User> ITEMS;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FollowersActivityFragment() {
    }


    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FollowersActivityFragment newInstance(int columnCount) {
        FollowersActivityFragment fragment = new FollowersActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView =  inflater.inflate(R.layout.fragment_followers2, container, false);


        view = mView.findViewById(R.id.list);
        Log.e(getClass().getSimpleName(), "Adapter started from here");
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        view.setLayoutManager(llm);

        view.setAdapter(new MyFollowersRecyclerViewAdapter());

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = mView.getContext();
            RecyclerView recyclerView = (RecyclerView) mView;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            if (ITEMS!=null) {
                recyclerView.setAdapter(new MyFollowersRecyclerViewAdapter(ITEMS, getContext(), mListener));
                Log.e(getClass().getSimpleName() + "  " , "ITEMS here is empty null");
            }
        }




//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        user_id = settings.getString("username", "");
        user_Id = settings.getLong("user_id", 0);

        Log.i(this.getClass().getName(), "Login status is : " + hasLoggedIn + "");

        Log.i(this.getClass().getName(), "User Name is : " + user_id);

        Log.i(this.getClass().getName(), "User ID is : " + user_Id);
        FetchTwitterUsersList fetchTwitterUsersList = new FetchTwitterUsersList();
         if (hasLoggedIn && view!=null) {

            ITEMS = fetchTwitterUsersList.getUserList(user_Id, getContext(),view);

        }else if (hasLoggedIn && view == null){
             Log.e(getClass().getSimpleName() + "  RecyclerView is null", "view object is null from here");
         }



        return mView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FollowersActivityFragment.OnListFragmentInteractionListener) {
            mListener = (FollowersActivityFragment.OnListFragmentInteractionListener) context;
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
        void onListFragmentInteraction(User item);

    }
}
