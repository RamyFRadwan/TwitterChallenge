//package com.challenger.ramyfradwan.twitterchallenge.UI;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.app.Fragment;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.challenger.ramyfradwan.twitterchallenge.Model.User;
//import com.challenger.ramyfradwan.twitterchallenge.R;
//import com.challenger.ramyfradwan.twitterchallenge.Utilities.FetchTwitterUsersList;
//
//import java.util.List;
//
///**
// * A fragment representing a list of Items.
// * <p/>
// * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
// * interface.
// */
//public class FollowersFragment extends Fragment {
//    public static final String PREFS_NAME = "MyPrefsFile";
//    RecyclerView mView;
//    // TODO: Customize parameter argument names
//    private static final String ARG_COLUMN_COUNT = "column-count";
//    // TODO: Customize parameters
//    private int mColumnCount = 1;
//    private OnListFragmentInteractionListener mListener;
//
//    /**
//     * Mandatory empty constructor for the fragment manager to instantiate the
//     * fragment (e.g. upon screen orientation changes).
//     */
//    public FollowersFragment() {
//    }
//
//    // TODO: Customize parameter initialization
//    @SuppressWarnings("unused")
//    public static FollowersFragment newInstance(int columnCount) {
//        FollowersFragment fragment = new FollowersFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
//        }
//    }
//
//    List<User> ITEMS;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_followers_list, container, false);
//
//        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new MyFollowersRecyclerViewAdapter(ITEMS, mListener));
//        }
//
//
//        mView = view.findViewById(R.id.list);
//
//
////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
//        //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
//        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
//        String user_id = settings.getString("username", "");
//        Long user_Id = settings.getLong("user_id", 0);
//
//        Log.i(this.getClass().getName(), "Login status is : " + hasLoggedIn + "");
//
//        Log.i(this.getClass().getName(), "User Name is : " + user_id);
//
//        Log.i(this.getClass().getName(), "User ID is : " + user_Id);
//
//        FetchTwitterUsersList fetchTwitterUsersList = new FetchTwitterUsersList();
//        if(!hasLoggedIn)
//        {
//            //Go directly to main activity.
//            Intent intent = new Intent();
//            intent.setClass(getActivity(), LoginActivity.class);
//            startActivity(intent);
//        } else if (hasLoggedIn) {
//            fetchTwitterUsersList.getUserList(user_Id, getActivity(),mView);
//
//        }
//        return view;
//    }
//
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onListFragmentInteraction(User item);
//    }
//}
