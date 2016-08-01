package com.hfad.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveMessageActivity extends AppCompatActivity {

    private TextView messageView;

    public static final String EXTRA_MESSAGE = "message";
    private String messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        messageView = (TextView) findViewById(R.id.message);
        Intent intent = getIntent();
        messageText = intent.getStringExtra(EXTRA_MESSAGE);

        messageView.setText(messageText);


    }
}
