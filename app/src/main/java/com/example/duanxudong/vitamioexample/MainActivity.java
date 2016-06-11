package com.example.duanxudong.vitamioexample;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnInfoListener {


    private String path = "http://baobab.wdjcdn.com/145076769089714.mp4";
    private Uri uri;
    private ProgressBar pb;
    private TextView downloadRateView, loadRateView;
    private MediaController mediaController;
    private CustomMediaconller customMeidaCotroller;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN; //定义全屏参数
        Window windows = MainActivity.this.getWindow();
        windows.setFlags(flag, flag);
        Vitamio.initialize(this);
        //设置视频编码监听
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        setContentView(R.layout.activity_main);
        initview();
        initData();
        // TODO: 16/6/11


    }

    private void initview(){
        videoView = (VideoView)findViewById(R.id.buffer);
        mediaController = new MediaController(this);
        customMeidaCotroller = new CustomMediaconller(this,videoView,this);
    }
    private void initData(){}


    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }
}
