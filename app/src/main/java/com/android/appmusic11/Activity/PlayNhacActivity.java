package com.android.appmusic11.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayNhacActivity extends AppCompatActivity {
//    TextView txtTitle, txtTimeSongLeft, txtTimeSongRight;
//    SeekBar skBarSong;
//    ImageButton btnPrev,btnPlay, btnLoop, btnNext;
//    MediaPlayer mediaPlayer;
//    Animation animation;
//    ImageView imageViewDVD;
//    ArrayList<BaiHatModel> arrayBaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
    }
//        Mapping();
//        Intent intent = getIntent();
//        if (intent != null) {
//            if (intent.hasExtra("cakhuc")) {
//                BaiHatModel baiHat = intent.getParcelableExtra("cakhuc");
//                arrayBaiHat.add(baiHat);
//            }
//        }
//        CreateMediaSong();
//        animation = AnimationUtils.loadAnimation(this,R.anim.dvd_rorate);
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.pause();
//                    imageViewDVD.clearAnimation();
//                    btnPlay.setImageResource(R.drawable.nutplay);
//                }else{
//                    mediaPlayer.start();
//                    imageViewDVD.startAnimation(animation);
//                    btnPlay.setImageResource(R.drawable.nutpause);
//                }
//
//                SetTimeRight();
//                SetTimeLeft();
//            }
//        });
//
//        btnLoop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mediaPlayer.isLooping()){
//                    mediaPlayer.setLooping(false);
//                    btnLoop.setImageResource(R.drawable.iconrepeat);
//                }else{
//                    mediaPlayer.setLooping(true);
//                    btnLoop.setImageResource(R.drawable.refresh);
//                }
//            }
//        });
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(position > arrayBaiHat.size()-1){
//                    position = 0;
//                }else{
//                    position++;
//                }
//
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.stop();
//                }else{
//                    btnPlay.setImageResource(R.drawable.nutpause);
//                }
//                CreateMediaSong();
//                mediaPlayer.start();
//                imageViewDVD.startAnimation(animation);
//                SetTimeRight();
//                SetTimeLeft();
//            }
//        });
//
//        btnPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(position < 0){
//                    position = MainActivity.arraySong.size()-1;
//                }else{
//                    position--;
//                }
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.stop();
//                }else{
//                    btnPlay.setImageResource(R.drawable.nutpause);
//                }
//                CreateMediaSong();
//                mediaPlayer.start();
//                imageViewDVD.startAnimation(animation);
//                SetTimeRight();
//                SetTimeLeft();
//            }
//        });
//
//
//        skBarSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                mediaPlayer.seekTo(seekBar.getProgress());
//            }
//        });
//    }
//    private void CreateMediaSong() {
////        mediaPlayer = MediaPlayer.create(PlayMusic.this,MainActivity.arraySong.get(position).getFileMp3());
////        txtTitle.setText(arraySong.get(position).getName() + " - " + arraySong.get(position).getSinger());
////        imageViewDVD.setImageResource(arraySong.get(position).getImg());
//        String url = MainActivity.arraySong.get(position).getLinkBaiHat();
//        mediaPlayer = new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        mediaPlayer.prepareAsync();
//        String urlImage = MainActivity.arraySong.get(position).getHinhBaiHat();
//        new LoadImageInternet().execute(urlImage);
//        txtTitle.setText(MainActivity.arraySong.get(position).getTenBaiHat()+" - "+MainActivity.arraySong.get(position).getTenCaSi());
//
//    }
//    private void Mapping(){
//        txtTimeSongLeft = (TextView) findViewById(R.id.TextViewTimeLeft);
//        txtTimeSongRight = (TextView) findViewById(R.id.TextViewTimeRight);
//        txtTitle = (TextView) findViewById(R.id.txtTitle);
//        skBarSong = (SeekBar) findViewById(R.id.seekbarTime);
//        btnNext = (ImageButton) findViewById(R.id.nextbtn);
//        btnPrev = (ImageButton) findViewById(R.id.prevbtn);
//        btnPlay = (ImageButton) findViewById(R.id.playbtn);
//        btnLoop = (ImageButton) findViewById(R.id.btnloop);
//        imageViewDVD = (ImageView) findViewById(R.id.imageViewDvd);
//    }
//    private void SetTimeRight(){
//        SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
//        txtTimeSongRight.setText(timeFormat.format(mediaPlayer.getDuration()));
//        skBarSong.setMax(mediaPlayer.getDuration());
//    }
//
//    private void SetTimeLeft(){
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
//                txtTimeSongLeft.setText(timeFormat.format(mediaPlayer.getCurrentPosition()));
//                skBarSong.setProgress(mediaPlayer.getCurrentPosition());
//
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        if(position > MainActivity.arraySong.size()-1){
//                            position = 0;
//                        }else{
//                            position++;
//                        }
//
//                        if(mediaPlayer.isPlaying()){
//                            mediaPlayer.stop();
//                        }else{
//                            btnPlay.setImageResource(R.drawable.nutpause);
//                        }
//                        CreateMediaSong();
//                        mediaPlayer.start();
//                        SetTimeRight();
//                        SetTimeLeft();
//                    }
//                });
//                handler.postDelayed(this,500);
//            }
//        },100);
//
//    }
//    private class LoadImageInternet extends AsyncTask<String, Void, Bitmap> {
//        Bitmap bitmapHinh = null;
//        @Override
//        protected Bitmap doInBackground(String... strings) {
//            try {
//                URL url = new URL(strings[0]);
//                InputStream inputStream = url.openConnection().getInputStream();
//                bitmapHinh = BitmapFactory.decodeStream(inputStream);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return bitmapHinh;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            super.onPostExecute(bitmap);
//            imageViewDVD.setImageBitmap(bitmap);
//        }
//    }
}