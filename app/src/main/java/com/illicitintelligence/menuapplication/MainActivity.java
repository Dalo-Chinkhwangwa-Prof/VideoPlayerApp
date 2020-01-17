package com.illicitintelligence.menuapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.sprylab.android.widget.TextureVideoView;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView videoSelected;

    TextureVideoView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoSelected = findViewById(R.id.videoTextView);

        tvView = findViewById(R.id.tvView);
        String videoPath = "android.resource://"+getPackageName() + "/"+R.raw.mov_bbb;
        Log.d("TAG_X", videoPath);

        tvView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                tvView.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.video_player_menu, menu);
        return true;
    }

    public void showPopUp(View view){
        PopupMenu menu = new PopupMenu(this, view);
        MenuInflater menuInflater = menu.getMenuInflater();
        menuInflater.inflate(R.menu.video_player_menu, menu.getMenu());
        menu.setOnMenuItemClickListener(this);
        menu.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return false;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()){
            case R.id.video1a:
                videoSelected.setText("Video 1A selected.");
                tvView.setVideoPath("https://soniczone.net/Downloads/Video/Underground/E01.mp4");
                break;
            case R.id.video2:
                videoSelected.setText("Video 2 selected.");
                tvView.setVideoPath("https://soniczone.net/Downloads/Video/Underground/E02.mp4");
                break;
            case R.id.video3:
                videoSelected.setText("Video 3 selected.");
                tvView.setVideoPath("https://soniczone.net/Downloads/Video/Underground/E03.mp4");
                break;
            case R.id.video4:
                videoSelected.setText("Video 4 selected.");
                tvView.setVideoPath("https://soniczone.net/Downloads/Video/Underground/E04.mp4");
                break;

        }

        return true;
    }
}
