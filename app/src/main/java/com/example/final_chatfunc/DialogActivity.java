package com.example.final_chatfunc;

import android.os.Bundle;

import com.example.final_chatfunc.ActivityExtentions.DialogImplementExtentionActivity;
import com.example.final_chatfunc.Extentions.DialogExtention;
import com.example.final_chatfunc.Holders.DialogViewHolder;
import com.example.final_chatfunc.Models.DialogModel;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

public class DialogActivity extends DialogImplementExtentionActivity {

    private DialogsList dialogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog);
        dialogList = findViewById(R.id.dialogList);

        activateAdapter();
    }

    private void activateAdapter(){
        super.dialogsListAdapter = new DialogsListAdapter<>(
                R.layout.helper_dialog_view,
                DialogViewHolder.class,
                super.imgLoader);
        super.dialogsListAdapter.setItems(DialogExtention.getDialogs());
        super.dialogsListAdapter.setOnDialogClickListener(this);
        super.dialogsListAdapter.setOnDialogLongClickListener(this);

        dialogList.setAdapter(super.dialogsListAdapter);

    }

    @Override
    public void onDialogClick(DialogModel dialog) {
       MessageActivity.open(this);
    }
}