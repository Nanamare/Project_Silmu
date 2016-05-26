package kr.co.unithon.unithon13;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.unithon.unithon13.httpService.BaseResponse;
import kr.co.unithon.unithon13.httpService.PathClient;
import kr.co.unithon.unithon13.httpService.PathResponse;
import kr.co.unithon.unithon13.httpService.SeoulClient;

import kr.co.unithon.unithon13.httpService.ServiceGenerator;
import kr.co.unithon.unithon13.httpService.StationListResponse;
import kr.co.unithon.unithon13.model.SWline;
import kr.co.unithon.unithon13.model.Station;
import kr.co.unithon.unithon13.model.SwStation;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    PathClient pathClient;



    private SwStation srcStation;
    private SwStation dstStation;

    public Button start_btn, arrival_btn;
    public static boolean startState = false, arrivalState = false;
    public static String startName, arrivalName;
    public static InfoClass startInfo, arrivalInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "REsponse com");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.logo_icon);
        pathClient = ServiceGenerator.createPathService(PathClient.class);

        start_btn = (Button) findViewById(R.id.start_btn);
        arrival_btn = (Button) findViewById(R.id.arrival_btn);

        findViewById(R.id.start_btn).setOnClickListener(this);
        findViewById(R.id.arrival_btn).setOnClickListener(this);


        // setting default station src dst;


        Button findPathButton = (Button) findViewById(R.id.btn_find_path);
        findPathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srcStation = new SwStation("",startName,startInfo.getLineNum(),"");
                dstStation = new SwStation("", arrivalName, arrivalInfo.getLineNum(),"");
                pathClient.getShortestPath(0, 5, srcStation.getName(), dstStation.getName(), new Callback<PathResponse>() {
                    @Override
                    public void success(PathResponse pathResponse, Response response) {
                        Log.d("TAG", "Success");
                        Log.d("TAG", pathResponse.pathResult.toString());
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("src_stn", srcStation);
                        bundle.putParcelable("dst_stn", dstStation);
                        bundle.putParcelable("path_result", pathResponse.pathResult.get(0));
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("TAG", "Error : " + error.getMessage());
                    }
                });


            }
        });
        Intent intent = getIntent();
        }
    @Override
    protected void onResume() {
        super.onResume();
        int color_picture1 = R.drawable.startbtn;
        int color_picture = R.drawable.arrivalbtn;
        if(arrivalInfo!= null) {
            switch (arrivalInfo.getLineNum()) {
                case "1호선":
                    color_picture1 = R.drawable.one;
                    break;
                case "2호선":
                    color_picture1= R.drawable.two;
                    break;
                case "3호선":
                    color_picture1 = R.drawable.three;
                    break;
                case "4호선":
                    color_picture1 = R.drawable.four;
                    break;
                case "5호선":
                    color_picture1 = R.drawable.five;
                    break;
                case "6호선":
                    color_picture1 = R.drawable.six;
                    break;
                case "7호선":
                    color_picture1 = R.drawable.seven;
                    break;
                case "8호선":
                    color_picture1 = R.drawable.eight;
                    break;
                case "9호선":
                    color_picture1 = R.drawable.nine;
                    break;
                case "중앙선":
                    color_picture1 = R.drawable.kj;
                    break;
                case "분당선":
                    color_picture1 = R.drawable.bd;
                    break;
                case "경의선":
                    color_picture1 = R.drawable.kj;
                    break;
                case "에버라인":
                    color_picture1 = R.drawable.el;
                    break;
                case "경춘선":
                    color_picture1 = R.drawable.kc;
                    break;
                case "신분당선":
                    color_picture1 = R.drawable.sbd;
                    break;
                case "인천1호선":
                    color_picture1 = R.drawable.ic;
                    break;
            }
        }

        if(startInfo!= null) {
            switch (startInfo.getLineNum()) {
                case "1호선":
                    color_picture = R.drawable.oone;
                    break;
                case "2호선":
                    color_picture = R.drawable.ttwo;
                    break;
                case "3호선":
                    color_picture = R.drawable.tthree;
                    break;
                case "4호선":
                    color_picture = R.drawable.ffour;
                    break;
                case "5호선":
                    color_picture = R.drawable.ffive;
                    break;
                case "6호선":
                    color_picture = R.drawable.ssix;
                    break;
                case "7호선":
                    color_picture = R.drawable.sseven;
                    break;
                case "8호선":
                    color_picture = R.drawable.eeight;
                    break;
                case "9호선":
                    color_picture = R.drawable.nnine;
                    break;
                case "중앙선":
                    color_picture = R.drawable.kkc;
                    break;
                case "분당선":
                    color_picture = R.drawable.qqd;
                    break;
                case "경의선":
                    color_picture = R.drawable.kkc;
                    break;
                case "에버라인":
                    color_picture = R.drawable.eel;
                    break;
                case "경춘선":
                    color_picture = R.drawable.kckc;
                    break;
                case "신분당선":
                    color_picture = R.drawable.ssbd;
                    break;
                case "인천1호선":
                    color_picture = R.drawable.iic;
                    break;
            }
        }

        if (startName != null) {
            start_btn.setText(startName);
            start_btn.setBackgroundResource(color_picture);
            Log.d("arrival", startInfo.getLineNum());
        }
        if (arrivalName != null) {
            arrival_btn.setText(arrivalName);
            arrival_btn.setBackgroundResource(color_picture1);
            arrivalState = false;
            Log.d("arrival", arrivalInfo.getLineNum());

        }
    }

    @Override
    public void onClick(View v) { // Fuction of button click
        switch(v.getId()) {
            case R.id.start_btn: // When start button pressed, move SearchActivity
                Intent start_intent = new Intent(this, SearchActivity.class);
                startState = true;
                startActivity(start_intent);
                finish();
                break;
            case R.id.arrival_btn: // When arrival button pressed, move SearchActivity
                Intent arrival_intent = new Intent(this, SearchActivity.class);
                arrivalState = true;
                startActivity(arrival_intent);
                finish();
                break;
        }
    }

    public  void MapClick(View v){
        Toast.makeText(getApplicationContext(),"Map loading...",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SubwayMap.class);
        startActivity(intent);

        /*
        if (intent.getStringExtra("myactivity").equals("main")) {
            byte[] arr = getIntent().getByteArrayExtra("layout");
            Bitmap bitmap = BitmapFactory.decodeByteArray(arr, 0, arr.length);
            // Set the Drawable displayed
            Drawable bitmap2 = getDrawableFromBitmap(bitmap);
            mImageView.setImageDrawable(bitmap2);
            bmImage = (ImageView) findViewById(R.id.image2);
            bmImage.setImageBitmap(bitmap);


            Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
        LinearLayout image = (LinearLayout) findViewById(R.id.iv);
        Drawable ab = getDrawableFromBitmap(image_bitmap);
        image.setBackground(ab);
        */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }
}
