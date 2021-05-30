package com.example.final_chatfunc.Holders;

import android.view.View;

import com.example.final_chatfunc.Models.MessageModel;
import com.stfalcon.chatkit.messages.MessageHolders;

public class OutcomingTextMessageHolder extends MessageHolders.OutcomingTextMessageViewHolder<MessageModel> {
    public OutcomingTextMessageHolder(View itemView, Object payload) {
        super(itemView, payload);
    }
    @Override
    public void onBind(MessageModel message){
        super.onBind(message);

        time.setText(message.getStatus()+""+time.getText());
    }
}
