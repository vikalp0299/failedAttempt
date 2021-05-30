package com.example.final_chatfunc.HelperFuntions;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

public class ToastMaker {

    public static void cookToast(Context context,@StringRes int text, boolean isLong){
        cookToast(context, context.getString(text), isLong);
    }
    public static void cookToast(Context context,String text,boolean isLong){
        Toast.makeText(context, text ,isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }
}
