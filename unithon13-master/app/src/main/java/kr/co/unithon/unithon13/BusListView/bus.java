package kr.co.unithon.unithon13.BusListView;

import android.app.Activity;
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
public class bus {

    private String Name;
    private String Number;
    private String Arrmsg1;
    private String Arrmsg2;

    public bus(String _Number, String _Name, String arrmsg1 , String arrmsg2){
        this.Name = _Name;
        this.Number = _Number;
        this.Arrmsg1 = arrmsg1;
        this.Arrmsg2 = arrmsg2;
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }

    public String getArrmsg1() {
        return Arrmsg1;
    }

    public String getArrmsg2() {
        return Arrmsg2;
    }

    public String setName(String name){
        return this.Name = name;
    }



}
