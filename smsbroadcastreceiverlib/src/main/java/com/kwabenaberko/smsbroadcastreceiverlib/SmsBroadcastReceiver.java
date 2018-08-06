package com.kwabenaberko.smsbroadcastreceiverlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by Kwabena Berko on 8/2/2018.
 */

public abstract class SmsBroadcastReceiver extends BroadcastReceiver {

    protected abstract void onSmsReceived(SmsMessage smsMessage);


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            Object[] pduObjectList = (Object[]) bundle.get("pdus");
            if(pduObjectList != null){
                for (Object pduObject : pduObjectList) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pduObject);
                    onSmsReceived(smsMessage);
                }
            }
        }
    }
}
