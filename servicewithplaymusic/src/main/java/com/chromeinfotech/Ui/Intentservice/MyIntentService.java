package com.chromeinfotech.Ui.Intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import com.chromeinfotech.utils.Utils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by user on 29/3/17.
 */

public class MyIntentService extends IntentService {
    private MediaPlayer mediaPlayer ;
    private String TAG = this.getClass().getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super(MyIntentService.class.getName());
    }

    /**
     * Called by the system to notify a Service that it is no longer used and is being removed
     */
    @Override
    public void onDestroy() {
        //super.onDestroy();
        Utils.showToast(this, "service done");
        /*if(mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();*/
    }

    /**
     * This method is invoked on the worker thread with a request to process. Only one Intent is processed at a time.
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {
       Utils.printLog(TAG , "onHandleIntent " + System.currentTimeMillis());


        if(true){
            downloadContent();
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ; i < 10 ; i ++ ){
                        try {
                            Log.e("TAG" , "Index " + i);
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();*/
            return ;
        }
//        mediaPlayer= MediaPlayer.create(this , R.raw.kaun_tujhe);
//        mediaPlayer.start();
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                MyIntentService.this.stopSelf();
//            }
//        });
//        SystemClock.sleep(1000);

    }

    /**
     * download data from url
     */
    private void downloadContent(){
        try {
            URL yahoo = new URL( "http://api.letsleapahead.com/LeapAheadMultiFreindzy/index.php?action=getLang&langCode=EN&langId=1&appId=6");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(yahoo.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                Log.e("TAG" , inputLine);
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
