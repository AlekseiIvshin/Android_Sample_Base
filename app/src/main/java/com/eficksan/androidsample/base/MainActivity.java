package com.eficksan.androidsample.base;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private String mNotificationTitle;
    private static final int NOTIFICATION_ID = 0;

    private Button mSubmitButton;
    private CheckBox mAcceptance;
    private EditText mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationTitle = getResources().getString(R.string.notification_title);

        mAcceptance = (CheckBox) findViewById(R.id.acceptance);
        mUserName = (EditText) findViewById(R.id.user_name);
        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle(mNotificationTitle);
                builder.setContentText(buildUserData());
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(NOTIFICATION_ID,builder.build());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String buildUserData(){
        StringBuilder data = new StringBuilder();
        data.append("You entered: ").append(mUserName.getText().toString());
        if(mAcceptance.isSelected()){
            data.append("You accepted");
        }else {
            data.append("You discord");
        }
        return data.toString();
    }
}
