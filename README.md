[![No Maintenance Intended](http://unmaintained.tech/badge.svg)](http://unmaintained.tech/)

## DEPRECATED
**This is no longer supported as Google now restricts access to SMS and Call Log Permissions**

An Android Broadcast Receiver Library For Capturing/Reading Incoming SMS.

### Download:

Download via Gradle:

```java
implementation 'com.github.KwabenBerko:smsbroadcastreceiverlib:0.0.1'
```

Or Maven:
```xml
<dependency>
    <groupId>com.github.KwabenBerko</groupId>
    <artifactId>smsbroadcastreceiverlib</artifactId>
    <version>0.0.1</version>
    <type>pom</type>
</dependency>
```

### Usage:
Create a custom class that inherits the `SmsBroadcastReceiver` class and override the onSmsReceived( ) method:

```java

public class MySmsReceiver extends SmsBroadcastReceiver {

    @Override
    protected void onSmsReceived(SmsMessage smsMessage) {
        Log.d(MainActivity.TAG, "ONSMSRECEIVED");
        Log.d(MainActivity.TAG, smsMessage.getDisplayOriginatingAddress());
        Log.d(MainActivity.TAG, smsMessage.getDisplayMessageBody());
    }
}

```


Add the following permissions to your `AndroidManifest.xml` file: 

```xml

<uses-permission android:name="android.permission.RECEIVE_SMS"/>
<uses-permission android:name="android.permission.READ_SMS"/>

```


Still in the `AndroidManifest.xml` file, register your newly created custom class as a receiver:

```xml

<receiver android:name=".MySmsReceiver">
    <intent-filter android:priority="9999">
        <action android:name="android.provider.Telephony.SMS_RECEIVED"/>
    </intent-filter>
</receiver>

```
Send an sms to the device's phone number and see it in action.


Happy Coding!
