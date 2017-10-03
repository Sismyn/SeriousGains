package com.getjacked.android.seriousgains;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserLoggedInFragment extends Fragment {
    // this fragment will be used to display user's username at the top of the app while they are logged in

    private TextView mUserLoggedInView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);

        mUserLoggedInView = (TextView) view.findViewById(R.id.logged_in_view);

        return mUserLoggedInView;
    }


}
