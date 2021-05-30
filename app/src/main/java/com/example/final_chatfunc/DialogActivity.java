package com.example.final_chatfunc;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.final_chatfunc.ActivityExtentions.DialogImplementExtentionActivity;
import com.example.final_chatfunc.Holders.DialogViewHolder;
import com.example.final_chatfunc.Models.DialogModel;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import com.example.final_chatfunc.Extentions.DialogExtention;

public class DialogActivity extends DialogImplementExtentionActivity {

    public static void open(Context context){
        context.startActivity(new Intent(context,DialogActivity.class)) ;
    }

    private DialogsList dialogList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog);
        dialogList = findViewById(R.id.dialogList);

        activateAdapter();
    }

    private void activateAdapter(){
        super.dialogsListAdapter = new DialogsListAdapter<>(
                R.layout.dialog_view_holder,
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