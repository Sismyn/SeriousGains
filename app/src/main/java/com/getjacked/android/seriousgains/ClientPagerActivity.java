package com.getjacked.android.seriousgains;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * hnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
 */

public class ClientPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CLIENT_ID = "com.getjacked.android.seriousgains.client_id";

    private ViewPager mViewPager;
    private List<Client> mClients;

    public static Intent newIntent(Context packageContext, UUID clientID){
        Intent intent = new Intent(packageContext, ClientPagerActivity.class);
        intent.putExtra(EXTRA_CLIENT_ID, clientID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_client_pager);

        UUID clientId = (UUID) getIntent().getSerializableExtra(EXTRA_CLIENT_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_client_pager_view_pager);

        mClients = ClientStorage.get(this).getClientList();

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Client client = mClients.get(position);
                return ClientFragment.newInstance(client.getId());
            }

            @Override
            public int getCount() {
                return mClients.size();
            }
        });

        for(int i = 0; i < mClients.size(); i++){
            if (mClients.get(i).getId().equals(clientId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}