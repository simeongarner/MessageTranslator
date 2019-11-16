package com.example.nuntius;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> Conversation = new ArrayList<>();
    public LinearLayoutManager linearLayoutManager;
    public ConvoAdapter convoAdapter = new ConvoAdapter(Conversation);
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayConversation();
    }

    public void message(View view){
        TextView textView = findViewById(R.id.message_text);
        String message = textView.toString();

        Conversation.add(message);
        convoAdapter.notifyDataSetChanged();
    }

    public void displayConversation(){
        recyclerView = (RecyclerView) findViewById(R.id.Recycler_conversation);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(convoAdapter);
    }


}
