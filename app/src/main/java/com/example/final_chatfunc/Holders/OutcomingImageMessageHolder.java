package com.example.final_chatfunc.Holders;

import android.util.Pair;
import android.view.View;

import com.example.final_chatfunc.Models.MessageModel;
import com.stfalcon.chatkit.messages.MessageHolders;

public class OutcomingImageMessageHolder extends MessageHolders .OutcomingImageMessageViewHolder<MessageModel> {
    public OutcomingImageMessageHolder(View itemView, Object payload) {
        super(itemView,payload);
    }

    @Override
    public void onBind(MessageModel message){
        super.onBind(message);
        time.setText(message.getStatus()+""+time.getText());
    }

    @Override
    protected Object getPayloadForImageLoader(MessageModel message){
        return new Pair<>(100,100);
    }
}
