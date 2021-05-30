package com.example.final_chatfunc.Models;

import com.stfalcon.chatkit.commons.models.IDialog;
import com.stfalcon.chatkit.commons.models.IUser;

import java.util.ArrayList;
import java.util.List;

public class DialogModel implements IDialog<MessageModel> {

   private String id;
   private String dialogPhoto;
   private String dialogName;
   private ArrayList<UserModel> users;
   private MessageModel lastMessage;
   private int unreadCount;

   public DialogModel(String id, String dialogName, String dialogPhoto, ArrayList<UserModel> users, MessageModel lastMessage, int unreadCount){
       this.id=id;
       this.dialogPhoto=dialogPhoto;
       this.dialogName=dialogName;
       this.users=users;
       this.lastMessage=lastMessage;
       this.unreadCount=unreadCount;
   }

   @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDialogPhoto() {
        return dialogPhoto;
    }

    @Override
    public String getDialogName() {
        return dialogName;
    }

    @Override
    public ArrayList<UserModel> getUsers() {
        return users;
    }

    @Override
    public MessageModel getLastMessage() {
        return lastMessage;
    }

    @Override
    public void setLastMessage(MessageModel lastMessage) {
        this.lastMessage=lastMessage;
    }

    @Override
    public int getUnreadCount() {
        return unreadCount;
    }
}
