package com.example.duanxudong.vitamioexample;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by duanxudong on 16/6/11.
 * Version 1
 */

 public class CustomMediaconller extends MediaController {

    private static final int HIDEFRAM = 0;//控制提示窗口的显示
    private static final int SHOW_PROGRESS = 2;
    private GestureDetector mGestureDetector;
    private ImageButton img_back;//返回按钮
    private TextView mFileName;//文件名
    private VideoView videoView;
    private Activity activity;
    private Context context;
    private String videoname;//视频名称
    private int controllerWidth = 0;//设置mediaController高度为了使横屏时top显示在屏幕顶端
    private View mVolumeBrightnessLayout;//提示窗口
    private ImageView mOperationBg;//提示图片
    private TextView mOperationTv;//提示文字
    private AudioManager mAudioManager;
    private SeekBar progress;
    private boolean mDragging;
    private MediaPlayerControl player;    //最大声音
    private int mMaxVolume;    // 当前声音
    private int mVolume = -1;    //当前亮度
    private float mBrightness = -1f;    //返回监听
    public void onClick(View v) {
        if (activity != null) {
            activity.finish();
        }
    }
    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            long pos;
            switch (msg.what) {
                case HIDEFRAM://隐藏提示窗口
                    mVolumeBrightnessLayout.setVisibility(View.GONE);
                    mOperationTv.setVisibility(View.GONE);
                    break;            }        }    };


    public CustomMediaconller(Context context,VideoView videoView,Activity activity){
        super(context);
        this.context = context;
        this.videoView = videoView;
        this.activity = activity;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);        controllerWidth = wm.getDefaultDisplay().getWidth();
        mGestureDetector = new GestureDetector(context, new MyGestureListener());

    }


    public CustomMediaconller(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMediaconller(Context context) {
        super(context);
    }

    @Override
    protected View makeControllerView() {
        return super.makeControllerView();
    }
}
