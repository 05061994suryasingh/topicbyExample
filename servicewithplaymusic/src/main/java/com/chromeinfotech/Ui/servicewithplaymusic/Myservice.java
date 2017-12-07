package com.chromeinfotech.Ui.servicewithplaymusic;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import com.chromeinfotech.servicewithplaymusic.R;
import com.chromeinfotech.utils.Utils;
import java.util.concurrent.TimeUnit;
import static com.chromeinfotech.Ui.servicewithplaymusic.MainServiceActivity.seekBar;
import static com.chromeinfotech.Ui.servicewithplaymusic.MainServiceActivity.songDuration;


/**
 *
 */

public class Myservice extends Service implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener{

    private  MediaPlayer mediaPlayer ;
    private double timeElapsed = 0, finalTime = 0;
    private Handler durationHandler = new Handler();
    private String TAG = this.getClass().getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        Utils.printLog(TAG ,"inside onCreate");

        mediaPlayer= MediaPlayer.create(this ,R.raw.aaj_jane_ki);
        mediaPlayer.setOnCompletionListener(this);
        seekBar.setOnSeekBarChangeListener(this);

        Utils.printLog(TAG ,"outside onCreate");
    }

    /**
     * Called by the system every time a client explicitly starts the service by calling Context.startService,
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Utils.printLog(TAG ,"inside onStartCommand");
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            this.setSeekbar();

        }else {
            mediaPlayer.pause();
            MainServiceActivity.btnplay.setText("play");
        }
        Utils.printLog(TAG ,"outside onStartCommand");
        return START_STICKY;
    }

    /**
     * set the seekbar
     */
    private void setSeekbar() {
        Utils.printLog(TAG ,"inside setSeekbar");
        finalTime = mediaPlayer.getDuration();
        songDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime) , TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
        seekBar.setMax((int) finalTime);
        timeElapsed = mediaPlayer.getCurrentPosition();
        seekBar.setProgress((int) timeElapsed);
        durationHandler.postDelayed(updateSeekBarTime, 0);
        Utils.printLog(TAG ,"outside setSeekbar");
    }

    /**
     * Called by the system to notify a Service that it is no longer used and is being removed
     */
    @Override
    public void onDestroy() {
        Utils.printLog(TAG ,"inside onDestroy");
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            seekBar.setProgress(0);
            songDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime) , TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
        }
        mediaPlayer.release();
        durationHandler.removeCallbacksAndMessages(null);
        Utils.printLog(TAG ,"outside onDestroy");
    }

    /**
     * Called when the end of a media source is reached during playback.
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        Utils.printLog(TAG ,"inside onCreate");
        stopSelf();
        songDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime) , TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
        seekBar.setProgress(0);
        Utils.printLog(TAG ,"outside onCreate");
    }

    /**
     * update the seekbar
     */
    private Runnable updateSeekBarTime = new Runnable() {
        public void run() {
            timeElapsed = mediaPlayer.getCurrentPosition();
            seekBar.setProgress((int) timeElapsed);
            double timeRemaining = finalTime - timeElapsed;
            songDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining), TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));
            if (mediaPlayer.getCurrentPosition() == finalTime){
                mediaPlayer.stop();
                seekBar.setProgress(0);
            }
            //repeat yourself that again in 100 miliseconds
            durationHandler.postDelayed(this, 100);
        }
    };

    /**
     * Notification that the progress level has changed.
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(fromUser)
            mediaPlayer.seekTo(progress);
    }

    /**
     * Notification that the progress level has changed.

     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * Notification that the user has finished a touch gesture
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
