package com.android.appmusic11.Service_Local;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;


import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ForegroundServiceControl extends Service {
    public static final int ACTION_PAUSE = 1;
    public static final int ACTION_RESUME = 2;
    public static final int ACTION_NEXT = 3;
    public static final int ACTION_PREVIOUS = 4;
    public static final int ACTION_DURATION = 5;
    public static final int ACTION_REPEAT = 6;
    public static final int ACTION_RANDOM = 7;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying, isRepeat, isRandom;
    private String urlImage;
    private ArrayList<BaiHatModel> mangbaihat = new ArrayList<>();
//    private ArrayList<BaiHatThuVienPlayListModel> mangbaihetthuvienplaylist = new ArrayList<>();
    private int positionPlayer = 0, duration = 0, seekToTime = 0, curentime = 0;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
            if (intent != null){
                if (intent.hasExtra("obj_song_baihat")){
                    clearArray();
                    mangbaihat = intent.getParcelableArrayListExtra("obj_song_baihat");
                }
//                else if (intent.hasExtra("obj_song_thuvien")){
//                    clearArray();
//                    mangbaihetthuvienplaylist = intent.getParcelableArrayListExtra("obj_song_thuvien");
//                }
            }
        assert intent != null;
        if (!intent.hasExtra("action_music_service")){
                CompleteAndStart();
            }
        int actionMusic = intent.getIntExtra("action_music_service", 0);
        seekToTime = intent.getIntExtra("duration", 0);
        isRepeat = intent.getBooleanExtra("repeat_music", false);
        isRandom = intent.getBooleanExtra("random_music", false);
        handleActionMusic(actionMusic);
        return START_NOT_STICKY;
    }
    private void clearArray() {
        positionPlayer = 0;
        mangbaihat.clear();
//        mangbaihetthuvienplaylist.clear();

    }
    private void handleActionMusic(int action){
        switch (action){
            case ACTION_PAUSE:
                if (mangbaihat != null && mangbaihat.size() > 0){
                    pauseMusic(mangbaihat.get(positionPlayer).getTenBaiHat(), mangbaihat.get(positionPlayer).getTenCaSi());
                }
//                else if (mangbaihetthuvienplaylist != null && mangbaihetthuvienplaylist.size() > 0){
//                    pauseMusic(mangbaihetthuvienplaylist.get(positionPlayer).getTenBaiHat(), mangbaihetthuvienplaylist.get(positionPlayer).getTenCaSi());
//                }
                break;
            case ACTION_RESUME:
                if (mangbaihat != null && mangbaihat.size() > 0){
                    resumeMusic(mangbaihat.get(positionPlayer).getTenBaiHat(), mangbaihat.get(positionPlayer).getTenCaSi());
                }
//                else if (mangbaihetthuvienplaylist != null && mangbaihetthuvienplaylist.size() > 0){
//                    resumeMusic(mangbaihetthuvienplaylist.get(positionPlayer).getTenBaiHat(), mangbaihetthuvienplaylist.get(positionPlayer).getTenCaSi());
//                }

                break;
            case ACTION_NEXT:
                if (mangbaihat != null && mangbaihat.size() > 0){
                    nextMusic(mangbaihat.size());
                }
//                else if (mangbaihetthuvienplaylist != null && mangbaihetthuvienplaylist.size() > 0){
//                    nextMusic(mangbaihetthuvienplaylist.size());
//                }
                CompleteAndStart();
                break;
            case ACTION_PREVIOUS:
                if (mangbaihat != null && mangbaihat.size() > 0){
                    previousMusic(mangbaihat.size());
                }
//                else if (mangbaihetthuvienplaylist != null && mangbaihetthuvienplaylist.size() > 0){
//                    previousMusic(mangbaihetthuvienplaylist.size());
//                }
                CompleteAndStart();
                break;
            case ACTION_DURATION:
                mediaPlayer.seekTo(seekToTime);
                break;
        }
    }
    private void startMusic(String linkBaiHat) {
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        new playMP3().onPostExecute(linkBaiHat);
        isPlaying = true;
        duration = mediaPlayer.getDuration();
        sendActonToPlayNhacActivity(ACTION_RESUME);
        sendTimeCurrent();
    }
    private void resumeMusic(String tenBaiHat, String tenCaSi) {
        if (mediaPlayer != null && !isPlaying){
            mediaPlayer.start();
            isPlaying = true;
            sendActonToPlayNhacActivity(ACTION_RESUME);
        }
    }
    private void pauseMusic(String tenBaiHat, String tenCaSi) {
        if (mediaPlayer != null && isPlaying){
            mediaPlayer.pause();
            isPlaying = false;
            sendActonToPlayNhacActivity(ACTION_PAUSE);
        }
    }
    private void nextMusic(int sizeArray){
        positionPlayer++;
        if (isRepeat){
            positionPlayer -= 1;
        }else if (isRandom){
            Random random = new Random();
            positionPlayer = random.nextInt(sizeArray);
        }
        if (positionPlayer >= sizeArray){
            positionPlayer = 0;
        }
        sendActonToPlayNhacActivity(ACTION_NEXT);
    }
    private void previousMusic(int sizeArray){
        positionPlayer--;
        if (isRepeat){
            positionPlayer += 1;
        }else if (isRandom){
            Random random = new Random();
            positionPlayer = random.nextInt(sizeArray);
        }
        if (positionPlayer < 0){
            positionPlayer = sizeArray-1;
        }
        sendActonToPlayNhacActivity(ACTION_PREVIOUS);
    }
    private void CompleteAndStart(){
        if (mangbaihat != null && mangbaihat.size() > 0){
            Log.d("ManhCuong","PosittionPlayer"+mangbaihat.get(positionPlayer).getLinkBaiHat());
            startMusic(mangbaihat.get(positionPlayer).getLinkBaiHat());
            urlImage = mangbaihat.get(positionPlayer).getHinhBaiHat();
        }
//        else if (mangbaihetthuvienplaylist != null && mangbaihetthuvienplaylist.size() > 0){
//            startMusic(mangbaihetthuvienplaylist.get(positionPlayer).getLinkBaiHat());
//            urlImage = mangbaihetthuvienplaylist.get(positionPlayer).getHinhBaiHat();
//            sendNotificationMedia(mangbaihetthuvienplaylist.get(positionPlayer).getTenBaiHat(), mangbaihetthuvienplaylist.get(positionPlayer).getTenCaSi());
       // }

    }
    private PendingIntent getPendingIntent(Context context, int action){
        Intent intent = new Intent(this, BroadcastReceiverAction.class);
        intent.putExtra("action_music", action);
        return  PendingIntent.getBroadcast(context.getApplicationContext(), action, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
    private void sendActonToPlayNhacActivity(int action){
        if (mangbaihat != null){
//                mangbaihetthuvienplaylist != null){
            Intent intent = new Intent("send_data_to_activity");
            intent.putExtra("status_player", isPlaying);
            intent.putExtra("action_music", action);
            intent.putExtra("position_music", positionPlayer);
            intent.putExtra("duration_music", duration);
            intent.putExtra("seektomusic", curentime);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }
    @SuppressWarnings("deprecation")
    private void sendTimeCurrent(){
        if (mediaPlayer != null){
            curentime = mediaPlayer.getCurrentPosition();
            sendActonToPlayNhacActivity(ACTION_DURATION);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer != null){
                        sendTimeCurrent();
                    }
                }
            }, 1000);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
    @SuppressWarnings("deprecation")
    @SuppressLint("StaticFieldLeak")
    class playMP3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (mangbaihat != null && mangbaihat.size() > 0){
                            nextMusic(mangbaihat.size());
                        }
//                        else if (mangbaihetthuvienplaylist != null && mangbaihetthuvienplaylist.size() > 0){
//                            nextMusic(mangbaihetthuvienplaylist.size());
//                        }
                        CompleteAndStart();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                mediaPlayer.setDataSource(baihat);
                  mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            duration = mediaPlayer.getDuration();
        }
    }
}