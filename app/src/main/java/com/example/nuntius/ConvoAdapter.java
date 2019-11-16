package com.example.nuntius;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ConvoAdapter extends Adapter<ConvoAdapter.ViewHolder> {

    private List<String> Conversation;

    public ConvoAdapter(List<String> Conversation)
    {this.Conversation = Conversation;}

    @NonNull
    @Override
    public ConvoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.conversation_layout,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConvoAdapter.ViewHolder viewHolder, int i){
        viewHolder.newMessage.setText(Conversation.get(i));
    }

    @Override
    public int getItemCount(){return Conversation.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  View view;
        public TextView newMessage;

        private ViewHolder(@NonNull View itemView){
            super(itemView);
            view = itemView;
            newMessage = view.findViewById(R.id.message_view);
        }
    }

}
