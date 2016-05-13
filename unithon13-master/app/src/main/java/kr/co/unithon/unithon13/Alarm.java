package kr.co.unithon.unithon13;

import android.app.Activity;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by nanamare on 2016-04-28.
 */
public class Alarm extends Activity {
    Button mdbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        mdbtn = (Button)findViewById(R.id.mediabtn);
        mdbtn.setBackgroundColor(Color.TRANSPARENT);
        final MediaPlayer mPlayer = new MediaPlayer();         // 객체생성

// TYPE_RINGTONE 을 하면 현재 설정되어 있는 밸소리를 가져온다.
// 만약 알람음을 가져오고 싶다면 TYPE_ALARM 을 이용하면 된다
        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

        try {
            // 이렇게 URI 객체를 그대로 삽입해줘야한다.
            //인터넷에서 url.toString() 으로 하는것이 보이는데 해보니까 안된다 -_-;
            mPlayer.setDataSource(this, alert);


            // 출력방식(재생시 사용할 방식)을 설정한다. STREAM_RING 은 외장 스피커로,
            // STREAM_VOICE_CALL 은 전화-수신 스피커를 사용한다.
            mPlayer.setAudioStreamType(AudioManager.STREAM_RING);

            mPlayer.setLooping(true);  // 반복여부 지정
            mPlayer.prepare();    // 실행전 준비
        } catch (IOException e) {
            e.printStackTrace();
        }
        mPlayer.start();   // 실행 시작
        mdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Alarm.this,"알람 종료 완료.",Toast.LENGTH_LONG).show();
                mPlayer.stop();
                mPlayer.release();
                finish();
            }
        });


    }


}
