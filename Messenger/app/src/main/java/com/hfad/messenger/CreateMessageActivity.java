package com.hfad.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMessageActivity extends AppCompatActivity {

    private static final String TAG = "HF_Messenger";
    private EditText messageView;
    private String messageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        Log.d(TAG, "onCreate");

    }

    public void onSendMessage(View view) throws InterruptedException {

        messageView = (EditText) findViewById(R.id.message_et);
        messageText = messageView.getText().toString();


//        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
//        startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Some subj");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent choosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(choosenIntent);
    }
}
