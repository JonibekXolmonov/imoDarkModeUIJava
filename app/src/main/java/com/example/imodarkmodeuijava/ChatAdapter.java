package com.example.imodarkmodeuijava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imodarkmodeuijava.Chat;
import com.example.imodarkmodeuijava.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Chat> chats;

    public ChatAdapter(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat chat = chats.get(position);

        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).iv_profile.setImageResource(chat.profile);
            ((ViewHolder) holder).tv_fullname.setText(chat.name);

            if (chat.unreadMessages == 0)
                ((ViewHolder) holder).tv_unread_messages.setVisibility(View.GONE);
            else ((ViewHolder) holder).tv_unread_messages.setVisibility(View.VISIBLE);

            if (chat.unreadMessages <= 9)
                ((ViewHolder) holder).tv_unread_messages.setText(String.valueOf(chat.unreadMessages));
            else
                ((ViewHolder) holder).tv_unread_messages.setText("9+");
        }
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ShapeableImageView iv_profile;
        TextView tv_fullname;
        TextView tv_unread_messages;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            iv_profile = view.findViewById(R.id.iv_profile);
            tv_fullname = view.findViewById(R.id.tv_fullname);
            tv_unread_messages = view.findViewById(R.id.tv_unread_messages);
        }
    }
}
