package app.example.jiaozivideoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import cn.jzvd.JZVideoPlayerStandard;

//使用 JiaoZiVideoPlayer 播放网络视频,暂停继续，SDK版本最低为 16
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp
                ("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4"
                        , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "食神");
    }
}