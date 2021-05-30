package com.example.final_chatfunc.ActivityExtentions;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.final_chatfunc.HelperFuntions.ToastMaker;
import com.example.final_chatfunc.Models.DialogModel;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

public abstract class DialogImplementExtentionActivity extends AppCompatActivity implements DialogsListAdapter.OnDialogClickListener<DialogModel>,DialogsListAdapter.OnDialogLongClickListener<DialogModel> {

    protected ImageLoader imgLoader;
    protected DialogsListAdapter<DialogModel> dialogsListAdapter;

    @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imgLoader = (imageView, url, payload) -> Picasso.get().load(url).into(imageView);
    }

    @Override
    public void onDialogLongClick(DialogModel dialog) {

        ToastMaker.cookToast(this , dialog.getDialogName(), false );

    }
}
