package com.example.final_chatfunc.Holders;

import android.view.View;

import com.example.final_chatfunc.Models.DialogModel;
import com.example.final_chatfunc.R;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

public class DialogViewHolder extends DialogsListAdapter.DialogViewHolder<DialogModel> {

    private View onlineIndicator;

    public DialogViewHolder(View itemView) {
        super(itemView);
        onlineIndicator = itemView.findViewById(R.id.onlineIndicator);
    }

    @Override
    public void onBind(DialogModel dialog){
        super.onBind(dialog);

        if(dialog.getUsers().size()>1){
            onlineIndicator.setVisibility(View.GONE);
        }
        else{
            boolean isOnline = dialog.getUsers().get(0).isOnline();
            onlineIndicator.setVisibility(View.VISIBLE);
            if (isOnline){
                onlineIndicator.setBackgroundResource(R.drawable.online);
            }else{
                onlineIndicator.setBackgroundResource(R.drawable.offline);
            }
        }
    }
}
