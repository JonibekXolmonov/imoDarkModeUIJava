package com.example.imodarkmodeuijava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_chats);
        refreshAdapter();
    }

    private void refreshAdapter() {
        ChatAdapter chatAdapter = new ChatAdapter(allChats());
        recyclerView.setAdapter(chatAdapter);
    }

    private ArrayList<Chat> allChats() {
        ArrayList<Chat> chats = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            chats.add(new Chat(R.drawable.profile_mine, "Jonibek Xolmonov", 0));
            chats.add(new Chat(R.drawable.profile_azizbek, "Azizbek", 2));
            chats.add(new Chat(R.drawable.profile_bogibek, "Bog'ibek Matyoqubov", 3));
            chats.add(new Chat(R.drawable.profile_nazirov, "Elmurod Nazirov", 4));
            chats.add(new Chat(R.drawable.profile_ogabek, "Og'abek Matyoqubov", 1));
            chats.add(new Chat(R.drawable.profile_samandar, "Samandar", 0));
            chats.add(new Chat(R.drawable.profile_yahyo, "Yahyo", 10));
        }

        return chats;
    }
}