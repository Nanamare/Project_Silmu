package kr.co.unithon.unithon13;

/**
 * Created by daehyun on 16. 2. 14..
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.unithon.unithon13.model.Station;
import uk.co.senab.photoview.PhotoViewAttacher;


public class BusTrain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_train);

    }

    public void SelectTrans(View v) { // Fuction of button click
        switch(v.getId()) {
            case R.id.button: // When start button pressed, move SearchActivity
                Intent start_train = new Intent(this, MainActivity.class);
                startActivity(start_train);
                break;
            case R.id.button2: // When arrival button pressed, move SearchActivity
                Intent arrival_intent = new Intent(this, Bus_main.class);
                startActivity(arrival_intent);
                break;
        }
    }

}


