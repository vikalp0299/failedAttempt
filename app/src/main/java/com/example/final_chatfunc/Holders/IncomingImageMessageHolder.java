package com.example.final_chatfunc.Holders;

import android.view.View;

import com.example.final_chatfunc.Models.MessageModel;
import com.example.final_chatfunc.R;
import com.stfalcon.chatkit.messages.MessageHolders;



public class IncomingImageMessageHolder extends MessageHolders.IncomingImageMessageViewHolder<MessageModel> {

    private View onlineIndicator;
    public IncomingImageMessageHolder(View itemView , Object payload) {
        super(itemView, payload);
        onlineIndicator = itemView.findViewById(R.id.onlineIndicator);
    }

    @Override
    public void onBind(MessageModel message){
        super.onBind(message);
        boolean isOnline = message.getUser().isOnline();
        if(isOnline)
            onlineIndicator.setBackgroundResource(R.drawable.online);
        onlineIndicator.setBackgroundResource(R.drawable.offline);
    }
}
