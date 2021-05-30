package com.example.final_chatfunc.Extentions;

import com.example.final_chatfunc.Models.MessageModel;
import com.example.final_chatfunc.Models.UserModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MessageExtention extends StorageConnector{
    private MessageExtention(){throw new AssertionError();}

    public static MessageModel getImageMessage(){
        MessageModel message = new MessageModel(getRandomId(),null, getUser());
        message.setImg(new MessageModel.Image(getRandomImage()));
        return message;
    }

    public static MessageModel getTextMessage(){
        return getTextMessage(getRandomMessage());
    }

    public static MessageModel getTextMessage(String text){
        return new MessageModel(getRandomId(),text,getUser());
    }

    public static ArrayList<MessageModel> getMessages(Date startdate){
        ArrayList<MessageModel> messages = new ArrayList<>();
        for (int i=0; i<10 ; i++)
        {
            int countPerDay = rnd.nextInt(5)+1;       // right now using random change when backend
            for (int j=0; j<countPerDay;j++){
                MessageModel msg;
                if(i % 2  == 0 & j % 3 ==0){
                    msg =getImageMessage();
                }
                else{
                    msg= getTextMessage();
                }
                Calendar calendar = Calendar.getInstance();
                if (startdate != null)
                    calendar.setTime(startdate);
                    calendar.add(Calendar.DAY_OF_MONTH,-(2*i+1));

                    msg.setCreatedAt(calendar.getTime());
                    messages.add(msg);

            }
        }
        return messages;
    }

    private static UserModel getUser() {
        boolean even = rnd.nextBoolean();
        return new UserModel(
            even ? "0":"1",
            even ? names.get(0) : names.get(1),
            even ? avatars.get(0) : avatars.get(1),
                true
        );
    }

}
