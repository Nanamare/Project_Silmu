package kr.co.unithon.unithon13;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;

/**
 * Created by nanamare on 2016-04-28.
 */
public class AlarmReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent){
        try{

            intent = new Intent(context,BusTrain.class);
            PendingIntent pi = PendingIntent.getActivity(context,0,intent,
                    PendingIntent.FLAG_ONE_SHOT);

            pi.send();
        } catch (PendingIntent.CanceledException e){
            e.printStackTrace();
        }
    }
}
