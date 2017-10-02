package com.getjacked.android.seriousgains;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import java.util.List;

public class ClientListActivity extends SingleFragmentActivity {


    private ViewPager mViewPager;
    private List<Client> mClients;

    @Override
    protected Fragment createFragment(){
        return new ClientListFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_client_list);
     //   mViewPager = (ViewPager) findViewById(R.id.activity_client_list_view_pager);

     //   mClients = ClientStorage.get(this).getClientList();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, createFragment());
        UserLoggedInFragment fragment = new UserLoggedInFragment();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

     /*   mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
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

        */

    }
}
