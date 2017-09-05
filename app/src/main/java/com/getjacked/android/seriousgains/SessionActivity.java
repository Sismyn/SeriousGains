package com.getjacked.android.seriousgains;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * TODO: add checkboxs for "paid for" and "completed"
 */

public class SessionActivity extends SingleFragmentActivity {

    private static final String EXTRA_SESSION_ID = "com.getjacked.android.seriousgains.session_id";


    public static Intent newIntent(Context packageContext, UUID sessionId) {
        Intent intent = new Intent(packageContext, SessionActivity.class);
        intent.putExtra(EXTRA_SESSION_ID, sessionId);
        return intent;
    }


    @Override
    protected Fragment createFragment(){
        UUID sessionId = (UUID) getIntent().getSerializableExtra(EXTRA_SESSION_ID);
        return SessionFragment.newInstance(sessionId);
    }


}
