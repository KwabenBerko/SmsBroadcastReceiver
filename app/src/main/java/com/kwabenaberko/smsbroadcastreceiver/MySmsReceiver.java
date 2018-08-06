package com.kwabenaberko.smsbroadcastreceiver;

import android.telephony.SmsMessage;
import android.util.Log;

import com.kwabenaberko.smsbroadcastreceiverlib.SmsBroadcastReceiver;

/**
 * Created by Kwabena Berko on 8/2/2018.
 */

public class MySmsReceiver extends SmsBroadcastReceiver {

    @Override
    protected void onSmsReceived(SmsMessage smsMessage) {
        Log.d(MainActivity.TAG, "ONSMSRECEIVED");
        Log.d(MainActivity.TAG, smsMessage.getDisplayOriginatingAddress());
        Log.d(MainActivity.TAG, smsMessage.getDisplayMessageBody());
    }
}
