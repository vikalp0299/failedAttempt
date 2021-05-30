package com.example.final_chatfunc.ActivityExtentions;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.final_chatfunc.Extentions.MessageExtention;
import com.example.final_chatfunc.HelperFuntions.ToastMaker;
import com.example.final_chatfunc.Models.MessageModel;
import com.example.final_chatfunc.R;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public abstract class MessageImplementationExtentionActivity extends AppCompatActivity implements MessagesListAdapter.SelectionListener,MessagesListAdapter.OnLoadMoreListener {

    private static final int total_message_count = 100;

    protected final String senderId = "0";
    protected ImageLoader imageLoader;
    protected MessagesListAdapter<MessageModel> messageAdapter;

    private Menu menu;
    private int selectioncount;
    private Date lastLoadedDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageLoader = ((imageView, url, payload) -> Picasso.get().load(url).into(imageView));
    }

    @Override
    protected void onStart() {

        super.onStart();
        messageAdapter.addToStart(MessageExtention.getTextMessage(), true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.menu=menu;
        getMenuInflater().inflate(R.menu.menu_chat_action,menu);
        onSelectionChanged(0);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_delete:
                messageAdapter.deleteSelectedMessages();
                break;
            case R.id.action_copy:
                messageAdapter.copySelectedMessagesText(this,getMessageStringFormatter(),true);
                ToastMaker.cookToast(this,"message copied", true);
                break;
        }
        return true;

    }

    @Override
    public void onBackPressed() {
        if(selectioncount==0){
            super.onBackPressed();
        }
        messageAdapter.unselectAllItems();
}

    @Override
    public void onLoadMore(int page, int totalItemsCount) {
        Log.i("TAG", "onLoadMore: " + page + " " + totalItemsCount);
        if (totalItemsCount < total_message_count) {
            loadMessages();
        }
    }



    @Override
    public void onSelectionChanged(int count) {
        this.selectioncount = count;
        menu.findItem(R.id.action_delete).setVisible(count > 0);
        menu.findItem(R.id.action_copy).setVisible(count > 0);
    }

    public void loadMessages() {
        //imitation of internet connection backend storage
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<MessageModel> messages = MessageExtention.getMessages(lastLoadedDate);
                lastLoadedDate = messages.get(messages.size() - 1).getCreatedAt();
                messageAdapter.addToEnd(messages, false);
            }
        }, 1000);
    }
    private MessagesListAdapter.Formatter<MessageModel> getMessageStringFormatter(){
        return message -> {
            String createdAt = new SimpleDateFormat("MMM d, EEE 'at' h:mm a ", Locale.getDefault()).format(message.getCreatedAt());
            String text  = message.getText();
            if (text  == null) text = "[attachment]";

            return String.format(Locale.getDefault(),"%s: %s (%s)", message.getUser().getName(),text,createdAt);
        };
    }
}