package com.example.edu.servicewithmusicbox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MusicBoxActivity extends AppCompatActivity implements View.OnClickListener {
    private BackgroundMusicBindService mServiceBinder;
    Button play, stop, pause;
    private boolean mBound;

//    TextView music1, music2, music3;
//    int[] music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_box);

//        music1=findViewById(R.id.music1);
//        music1.setOnClickListener(MusicBoxActivity.this);
//        music2=findViewById(R.id.music2);
//        music2.setOnClickListener(this);
//        music3=findViewById(R.id.music3);
//        music3.setOnClickListener(this);
        Button play = (Button) findViewById(R.id.buttonPlay);
        play.setOnClickListener(this);
        Button stop = (Button) findViewById(R.id.buttonStop);
        stop.setOnClickListener(this);
        Button pause = (Button) findViewById(R.id.buttonPause);
        pause.setOnClickListener(this);
//        music = new int[]{R.raw.fine,R.raw.spring, R.raw.ppippi};
        // BackgroundMusicBindService.mPlyaer = MediaPlayer.create(this,music[0]);

        Intent intent = new Intent(this, BackgroundMusicBindService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection myConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServiceBinder = ((BackgroundMusicBindService.MyBinder) binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBinder = null;
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay:
                mServiceBinder.play();
                break;
            case R.id.buttonStop:
                mServiceBinder.stop();
            case R.id.buttonPause:
                mServiceBinder.pause();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(myConnection);
            mBound = false;

        }
    }
}

