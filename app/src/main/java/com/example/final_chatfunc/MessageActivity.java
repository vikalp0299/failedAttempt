package com.example.final_chatfunc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.final_chatfunc.ActivityExtentions.MessageImplementationExtentionActivity;
import com.example.final_chatfunc.Extentions.MessageExtention;
import com.example.final_chatfunc.Holders.IncomingTextMessageHolder;
import com.example.final_chatfunc.Holders.OutcomingImageMessageHolder;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import static com.example.final_chatfunc.HelperFuntions.ToastMaker.cookToast;

public class MessageActivity extends MessageImplementationExtentionActivity implements MessagesListAdapter.OnMessageLongClickListener, MessageInput.InputListener,MessageInput.AttachmentsListener {

    public static void open(Context context){
        context.startActivity(new Intent(context, MessageActivity.class));
    }
    
    private MessagesList messagesList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        messagesList = findViewById(R.id.messegesList);
        launchAdapter();
        MessageInput  input = findViewById(R.id.input);
        input.setInputListener(this);
        input.setAttachmentsListener(this);
    }

    @Override
    public void onAddAttachments() {
        messageAdapter.addToStart(MessageExtention.getImageMessage(),true);
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        messageAdapter.addToStart(
                MessageExtention.getTextMessage(input.toString()), true);

        return true;
    }

    @Override
    public void onMessageLongClick(IMessage message) {

    }


    @Override
    public void onSelectionChanged(int count) {
        
    }
    private   void launchAdapter(){

        IncomingTextMessageHolder.Payload payload = new IncomingTextMessageHolder.Payload();
        payload.avatarClickListener = () -> cookToast(MessageActivity.this,"Avatar was clicked",false);

        MessageHolders holdersConfig = new MessageHolders()
                .setIncomingImageConfig(
                        IncomingTextMessageHolder.class,
                        R.layout.helper_text_incoming_message,
                        payload
                )
                .setOutcomingImageConfig(
                        OutcomingImageMessageHolder.class,
                        R.layout.helper_image_outcoming_message
                )
                .setOutcomingTextConfig(
                        OutcomingImageMessageHolder.class,
                        R.layout.helper_text_outcoming_message
                )
                .setIncomingTextConfig(
                        IncomingTextMessageHolder.class,
                        R.layout.helper_text_incoming_message
                );

        super.messageAdapter = new MessagesListAdapter<>(super.senderId, holdersConfig,super.imageLoader);
        super.messageAdapter.setOnMessageLongClickListener(this);
        super.messageAdapter.setLoadMoreListener(this);
        messagesList.setAdapter(super.messageAdapter);
    }
}