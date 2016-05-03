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


public class SubwayMap extends Activity {
    ImageView mImageView;
    PhotoViewAttacher mAttacher;
    LinearLayout view;
    ImageView bmImage;
    ImageButton inputpc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subwaymap);
        // Any implementation of ImageView can be used!
        mImageView = (ImageView) findViewById(R.id.SubwayPicture);

        // Set the Drawable displayed
        Drawable bitmap = getResources().getDrawable(R.drawable.jihachul);
        mImageView.setImageDrawable(bitmap);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        mAttacher = new PhotoViewAttacher(mImageView);

    }


    public Drawable getDrawableFromBitmap(Bitmap bitmap) {
        Drawable d = new BitmapDrawable(bitmap);
        return d;
    }

}


