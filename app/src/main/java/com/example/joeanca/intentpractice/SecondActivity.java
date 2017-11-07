package com.example.joeanca.intentpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by joeanca on 2017-10-16.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        Intent intent = getIntent();
        String previousActivity = intent.getExtras().getString("callingActivity");
        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);

        callingActivityMessage.append(" " + previousActivity);

    }

    public void onSendUsersName(View view) {
        EditText usersNameET = (EditText) findViewById(R.id.users_name_edit_text);

        String usersName = String.valueOf(usersNameET.getText());

        Intent intent = new Intent();
        intent.putExtra("UsersName", usersName);
        setResult(RESULT_OK, intent);
        finish();
    }
}
