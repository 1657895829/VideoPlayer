package app.example.jiecao_videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

//  使用Jiecao播放器 播放视频，可以暂停播放,SDK版本最小为 16
public class MainActivity extends AppCompatActivity {
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    String url="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("jiecaovideoplayer的使用");
        jcVideoPlayerStandard= findViewById(R.id.js);
        jcVideoPlayerStandard.setUp(url,jcVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"视频标题");
    }

    // 安卓中的 后退键 ，按下时 会销毁当前 Activity
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    //暂停 播放资源，就释放资源
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
