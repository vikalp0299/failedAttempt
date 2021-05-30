package com.example.final_chatfunc.Extentions;

import android.app.Dialog;

import com.example.final_chatfunc.Models.DialogModel;
import com.example.final_chatfunc.Models.MessageModel;
import com.example.final_chatfunc.Models.UserModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DialogExtention extends StorageConnector {

    private DialogExtention() {
        throw new AssertionError();
    }


    public static ArrayList<DialogModel> getDialogs() {
        ArrayList<DialogModel> chats = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -(i * i));
            calendar.add(Calendar.MINUTE, -(i * i));

            chats.add(getDialog(i,calendar.getTime()));
        }
        return chats;
    }
    private static DialogModel getDialog(int i, Date lastMessageCreatedAt){
        ArrayList<UserModel> users = getUsers();
        return new DialogModel(
                getRandomId(),
                users.size() > 1 ? groupChatTitles.get(users.size() - 2) : users.get(0).getName(),
                users.size() > 1 ? groupChatImages.get(users.size() - 2) : getRandomAvatar(),
                users,
                getMessage(lastMessageCreatedAt),
                i < 3 ? 3 - i : 0);
    }

    private static ArrayList<UserModel> getUsers(){
        ArrayList<UserModel> users = new ArrayList<>();
        int usersCount = 1 + rnd.nextInt(4);

        for (int i=0; i < usersCount ; i++){
            users.add(getUser());
        }
        return users;
    }

    private static UserModel getUser(){
       return new UserModel(
               getRandomId(),
               getRandomName(),
               getRandomAvatar(),
               getRandomBoolean()
       );
    }

    private static MessageModel getMessage(final Date date){
        return new MessageModel(
                getRandomId(),
                getRandomMessage(),
                getUser(),
                date
        );

    }

}