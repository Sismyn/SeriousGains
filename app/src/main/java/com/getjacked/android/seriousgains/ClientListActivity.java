package com.getjacked.android.seriousgains;

import android.support.v4.app.Fragment;

public class ClientListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new ClientListFragment();
    }

    // it's too late for me to figure out how to fix the userlogged fragment
    // so im just going to focus on making hte rest of it work. I assume it's
    // because of the "single fragment" part..............
}
