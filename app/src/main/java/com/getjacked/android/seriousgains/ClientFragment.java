package com.getjacked.android.seriousgains;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.UUID;

public class ClientFragment extends Fragment {
    private static final String ARG_CLIENT_ID = "client_id";

    private Client mClient;
    private EditText mFirstName;
    private EditText mLastName;
    private Spinner mPronouns;
    private ImageButton mPicture;
    private EditText mWeight;
    private EditText mHeight;
    private EditText mStreetAddress;
    private EditText mCity;
    private EditText mState;
    private EditText mZipCode;
    private EditText mGoals;
    private EditText mCreditCardNum;
    private Spinner mCreditCardType;
    private EditText mCVC;

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

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_client, container, false);

        mFirstName = (EditText)v.findViewById(R.id.first_name_tb);
        mFirstName.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {
         }
         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             mClient.setFirstName(s.toString());
         }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mLastName = (EditText)v.findViewById(R.id.first_name_tb);
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mClient.setLastName(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mPronouns = (Spinner)v.findViewById(R.id.pronouns_spinner);
        mPronouns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mClient.setPronouns(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mPicture = (ImageButton)v.findViewById(R.id.client_picture);
        mPicture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // idk, send to camera somehow
            }
        });

        mWeight = (EditText)v.findViewById(R.id.weight_tb);
        mWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString();
                int weight = (Integer.parseInt(q));
                mClient.setWeight(weight);
            } // well that was overly complicated
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mHeight = (EditText)v.findViewById(R.id.height_tb);
        mHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mClient.setHeight(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mStreetAddress = (EditText)v.findViewById(R.id.street_add_tb);
        mStreetAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mClient.setStreetAddress(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mCity = (EditText)v.findViewById(R.id.city_tb);
        mCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mClient.setCity(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mState = (EditText)v.findViewById(R.id.state_tb);
        mState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mClient.setState(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mZipCode = (EditText)v.findViewById(R.id.zipcode_tb);
        mZipCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString();
                int zippo = (Integer.parseInt(q));
                mClient.setZipCode(zippo);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mGoals = (EditText)v.findViewById(R.id.goals_tb);
        mGoals.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // isn't set for now. would have to add another table. oh well.
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mCreditCardNum = (EditText)v.findViewById(R.id.creditcardnum_tb);
        mCreditCardNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mClient.setCreditCardNumber(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mCreditCardType = (Spinner)v.findViewById(R.id.creditcardtype_spinner);
        mCreditCardType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mClient.setCreditCardType(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mCVC = (EditText)v.findViewById(R.id.cvc_tb);
        mCVC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString();
                int cdc = (Integer.parseInt(q));
                mClient.setCVC(cdc);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        return v;
    }

    @Override
    public void onPause(){
        super.onPause();
        ClientStorage.get(getActivity()).updateClient(mClient);
    }

}