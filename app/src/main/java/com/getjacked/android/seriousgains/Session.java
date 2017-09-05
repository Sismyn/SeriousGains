package com.getjacked.android.seriousgains;

import java.util.Date;
import java.util.UUID;

/**
 * session object
 */

public class Session {

    private UUID mId;
    private int mSessionNum;
    private Date mDate;
    private boolean mPaidFor;
    private boolean mCompleted;

    public Session(){
        mId = UUID.randomUUID();
        mDate = new Date(); // placeholder until i get to the calendar selector code I was promised in the book?
    }

    //getters and setters

    public UUID getId() {
        return mId;
    }

    public int getSessionNum() {
        return mSessionNum;
    }

    public void setSessionNum(int sessionNum) {
        mSessionNum = sessionNum;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isPaidFor() {
        return mPaidFor;
    }

    public void setPaidFor(boolean paidFor) {
        mPaidFor = paidFor;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        mCompleted = completed;
    }
}
