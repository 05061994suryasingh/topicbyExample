package com.chromeinfotech.Ui.Bindservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.chromeinfotech.servicewithplaymusic.R;
import com.chromeinfotech.utils.Utils;

/**
 * MyBindservice
 */
public class MyBindservice extends Service implements MediaPlayer.OnCompletionListener{

    private final MylocalBinder mBinder = new MylocalBinder();
    private  MediaPlayer mediaPlayer ;
    private String TAG = this.getClass().getSimpleName();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * start the music
     */
    public   void  startmusic(){
        Utils.printLog(TAG ,"inside startmusic");
        mediaPlayer= MediaPlayer.create(this , R.raw.kaun_tujhe);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(this);
        Utils.printLog(TAG ,"outside startmusic");

    }

    /**
     * stop the service
     */
    @Override
    public void onDestroy() {
        Utils.printLog(TAG ,"inside onDestroy");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Utils.printLog(TAG ,"outside onUnbind");
        return super.onUnbind(intent);
    }

    /**
     *Interface definition for a callback to be invoked when playback of a media source has completed.
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {

        Utils.printLog(TAG ,"inside onCompletion");
        stopSelf();
    }

    /**
     * stop the music
     */
    public void stopMusic() {
        mediaPlayer.stop();
    }

    /**
     * MylocalBinder class return the MyBindservice instance
     */
    public class MylocalBinder extends Binder{

        MyBindservice getService() {
            return MyBindservice.this;
        }

    }
}
