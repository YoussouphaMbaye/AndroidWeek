package com.example.asynctaskactivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsynctaskImageDownload extends AsyncTask<String,Integer, Bitmap> {
    private Activity activity;
    ProgressDialog p;
    InputStream is = null;
    URL ImageUrl = null;
    Bitmap bmImg = null;
    ImageView imageView;
    public AsynctaskImageDownload(Activity activity,ImageView imageView){
        this.activity=activity;
        this.imageView=imageView;
    }
    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            ImageUrl = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) ImageUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            is = conn.getInputStream();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            bmImg = BitmapFactory.decodeStream(is, null, options);
            Log.i("DoInbackground","Sucsses doInbackground");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("DoInbackground","Erreur doInbackground");
        }
        return bmImg;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(imageView!=null) {
            p.hide();
            this.imageView.setImageBitmap(bitmap);
            Log.i("onPost","OnPost=========");
        }else {
            p.show();
            Log.i("onPost","show=========");
        }

    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        p = new ProgressDialog(this.activity);
        p.setMessage("Please wait...It is downloading");
        p.setIndeterminate(false);
        p.setCancelable(false);
        p.show();
    }
}
