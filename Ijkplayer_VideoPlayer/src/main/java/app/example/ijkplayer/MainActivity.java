package app.example.ijkplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

//使用  Ijkplayer 播放视频，可以暂停继续
public class MainActivity extends AppCompatActivity {
    PlayerView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //本地视频资源 url
        //  String url = Environment.getExternalStorageDirectory()
        //          .getAbsolutePath() + "/local/adc.mp4";

        //网络视频 url
        String url ="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
        play = new PlayerView(this)
                .setTitle("视频名称")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url);
        play.startPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        play.stopPlay();
    }
}
