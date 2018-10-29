package com.ssekorea.sse.sseproject.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.SseApp;

public final class UIUtil {
    private UIUtil(){

    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static void showToast(String message){
        showToast(message,Toast.LENGTH_SHORT);
    }
    public static void showToast(String message,int length){
        Toast.makeText(SseApp.getAppContext(), message, length).show();
    }
}
