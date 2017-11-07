package com.example.joeanca.intentpractice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void onGetNameClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        final int RESULT = 100000000;
        intent.putExtra("callingActivity", "MainActivity");
        startActivityForResult(intent,RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView UsersNameMessage = (TextView) findViewById(R.id.users_name_message);

        String nameSentBack = data.getStringExtra("UsersName");

        UsersNameMessage.append(" " + nameSentBack);
    }

    public void goToWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jorgecastano.com"));
        startActivity(intent);
    }
}
