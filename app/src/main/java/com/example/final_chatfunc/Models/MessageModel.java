package com.example.final_chatfunc.Models;

import androidx.annotation.Nullable;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.MessageContentType;
import java.util.Date;




public class MessageModel implements IMessage, MessageContentType.Image{

    private String id;
    private String text;
    private Date createdAt;
    private UserModel user;
    private Image img;

    public MessageModel(String id,UserModel user, String text){
        this(id,user,text,new Date());
    }
    public MessageModel(String id, UserModel user, String text, Date createdAt){
        this.id = id;
        this.text = text;
        this.user = user;
        this.createdAt = createdAt;

    }


    @Nullable
    @Override
    public String getImageUrl() {
        if(img == null)
            return null;
        return img.url;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public UserModel getUser() {
        return this.user;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt ;
    }


    public String getStatus() {

        return "Sent";
    }
    public void setImg(Image image){

        img = image;
    }
    public void setCreatedAt(Date createdAt) {

        this.createdAt = createdAt;
    }

    public static class Image{
        private String url;

        public  Image(String url){

            this.url =url;
        }
    }
}
