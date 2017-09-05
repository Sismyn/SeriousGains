package com.getjacked.android.seriousgains;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by test1 on 9/4/17.
 */

public class SessionFragment extends Fragment {
    private static final String ARG_SESSION_ID = "session_id";

    private Session mSession;
    //private EditText mTitleField;
    //private Button mDateButton;
    //private CheckBox mSolvedCheckBox;

    public static SessionFragment newInstance(UUID sessionId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_SESSION_ID, sessionId);

        SessionFragment fragment = new SessionFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    // not sure what to do about the calendar schedule thingy?
     //   UUID clientId = (UUID) getArguments().getSerializable(ARG_CLIENT_ID);

     //   mClient = ClientStorage.get(getActivity()).getClient(clientId);
    }
}
