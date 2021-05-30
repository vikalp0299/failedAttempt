package com.example.final_chatfunc.Holders;

import android.view.View;

import com.example.final_chatfunc.Models.MessageModel;
import com.example.final_chatfunc.R;
import com.stfalcon.chatkit.messages.MessageHolders;

public class IncomingTextMessageHolder extends MessageHolders.IncomingTextMessageViewHolder<MessageModel> {

    private View onlineIndicator;
    public IncomingTextMessageHolder(View itemView, Object payload) {
        super(itemView, payload);
        onlineIndicator = itemView.findViewById(R.id.onlineIndicator);
    }
    @Override
    public void onBind(MessageModel message){
        super.onBind(message);
        boolean isOnline = message.getUser().isOnline();
        if(isOnline){
            onlineIndicator.setBackgroundResource(R.drawable.online);
        }
        else {
            onlineIndicator.setBackgroundResource(R.drawable.offline);
        }
        final Payload payload =(Payload) this.payload;
        userAvatar.setOnClickListener(view ->{
            if (payload != null && payload.avatarClickListener != null) {
                payload.avatarClickListener.onAvatarClick();
            }
        });

    }
    public static class Payload{
        public OnAvatarClickListener avatarClickListener;
    }
    public interface OnAvatarClickListener{
        void onAvatarClick();
    }
}
