package com.getjacked.android.seriousgains;

import android.support.v4.app.Fragment;

public class ClientListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new ClientListFragment();
    }
}
