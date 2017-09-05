package com.getjacked.android.seriousgains;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class ClientFragment extends Fragment {
    private static final String ARG_CLIENT_ID = "client_id";

    private Client mClient;
    //private EditText mTitleField;
    //private Button mDateButton;
    //private CheckBox mSolvedCheckBox;

    public static ClientFragment newInstance(UUID clientId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CLIENT_ID, clientId);

        ClientFragment fragment = new ClientFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID clientId = (UUID) getArguments().getSerializable(ARG_CLIENT_ID);

        mClient = ClientStorage.get(getActivity()).getClient(clientId);
    }
}