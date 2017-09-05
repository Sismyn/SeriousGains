package com.getjacked.android.seriousgains;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class ClientActivity extends SingleFragmentActivity {
    private static final String EXTRA_CLIENT_ID = "com.getjacked.android.seriousgains.client_id";


    public static Intent newIntent(Context packageContext, UUID clientId) {
        Intent intent = new Intent(packageContext, ClientActivity.class);
        intent.putExtra(EXTRA_CLIENT_ID,clientId);
        return intent;
    }


    @Override
    protected Fragment createFragment(){
        UUID clientId = (UUID) getIntent().getSerializableExtra(EXTRA_CLIENT_ID);
        return ClientFragment.newInstance(clientId);
    }

}
