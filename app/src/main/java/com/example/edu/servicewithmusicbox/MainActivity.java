package com.example.edu.servicewithmusicbox;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public BackgroundMusicBindService mServiceBinder;
    Button play, stop, pause;
    TextView music1, music2, music3;
    private boolean mBound;
    MusicBoxActivity mb=new MusicBoxActivity();
//    int[] music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMusic(View view) {
        Intent intent = new Intent(this, MusicBoxActivity.class);
        startActivity(intent);
    }




}
