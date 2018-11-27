package com.example.edu.servicewithmusicbox;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class BackgroundMusicBindService extends Service {
    MediaPlayer mPlyaer;
    private int playbackPosition = 0;

    public BackgroundMusicBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        BackgroundMusicBindService getService() {
            return BackgroundMusicBindService.this;
        }
    }

    public void play() {
        mPlyaer = MediaPlayer.create(this, R.raw.fine);
//        mPlyaer.setLooping(true);
//        mPlyaer.setVolume(100, 100);
        if (mPlyaer != null && !mPlyaer.isPlaying()) {
            mPlyaer.seekTo(playbackPosition);
            mPlyaer.start();

        } else {
            mPlyaer.start();
        }

    }

    public void stop() {
        mPlyaer.stop();
//        mPlyaer.release();
//        playbackPosition = 0;
    }

    public void pause() {
        if (mPlyaer != null) {
            playbackPosition = mPlyaer.getCurrentPosition();
            mPlyaer.pause();
        }

    }

}
