package app.example.ijkmediaplayer_surface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

//使用 IjkMediaPlayer 结合 Surface 播放视频，自己写的播放和暂停按钮
public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    @BindView(R.id.viedo_surface)
    SurfaceView viedoSurface;
    @BindView(R.id.start)
    Button start;
    @BindView(R.id.pause)
    Button pause;
    private IjkMediaPlayer mPlayer;
    boolean isPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        isPlay = false;
        pause.setEnabled(false);
        viedoSurface.getHolder().addCallback(this);
        initPlayer();
    }

    private void initPlayer() {
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mPlayer = new IjkMediaPlayer();
      /*  try {
            //http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4
            mPlayer.setDataSource("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mPlayer.prepareAsync();
        mPlayer.start();*/
    }

    @OnClick({R.id.start, R.id.pause})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start:
                mPlayer.reset();
                try {
                    mPlayer.setDataSource("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4");//读取视频文件地址
                    mPlayer.prepareAsync();                             //预加载视频
                    mPlayer.setDisplay(viedoSurface.getHolder());  //将视频画面输出到surface上
                    mPlayer.start();                                //开始播放
                    pause.setText("暂停");                        //pause此时为暂停
                    pause.setEnabled(true);                       //pause按钮此时可用
                    isPlay = true;
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "发生错误", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.pause://点击暂停时候 如果正在播放 就显示继续按钮

                if (isPlay == true) {
                    pause.setText("继续");
                    mPlayer.pause();
                    isPlay = false;
                } else {
                    mPlayer.start();
                    pause.setText("暂停");
                    isPlay = true;
                }
                break;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
