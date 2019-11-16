package com.example.nuntius;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {  // main activity class

    public static List<String> Conversation = new ArrayList<>();  // list to hold the conversation data
    public LinearLayoutManager linearLayoutManager;
    public ConvoAdapter convoAdapter = new ConvoAdapter(Conversation);
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // The app is created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // The view of the main activity

        displayConversation();       // call the display function to display the conversation
    }

    public void message(View view) {                            // When the send button is pressed
        TextView textView = findViewById(R.id.message_text);    // send the message in the text view
        String message = textView.getText().toString();         // convert message to a string

        Translator translator = new Translator();

        if (message.length() > 120) {                                            // The recycler view textview box can only
            Conversation.add(translator.Translate(message.substring(0, 120)));   // hold 120 characters
        } else {                                                                 // else the whole message can be added
            Conversation.add(translator.Translate(message));                     // to the conversation
        }
        convoAdapter.notifyDataSetChanged();        // let the recycler view know it needs to be updated
    }

    public void displayConversation() {                                           // displayConversation
        recyclerView = (RecyclerView) findViewById(R.id.Recycler_conversation);   // uses a recyclerView to
        recyclerView.setHasFixedSize(true);                                       // show the conversation
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(convoAdapter);
    }

}
