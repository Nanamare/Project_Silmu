package kr.co.unithon.unithon13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by nanamare on 2016-04-28.
 */
public class Bus_main extends Activity {
    Button bus_find_path;
    Button bus_num;
    ImageView etcBtn;
    ImageView etcBtn2;
    int cnt =0;
   int data[] = new int[2];




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.bus_search);
            //bus_find_path = (Button) findViewById(R.id.bus_find_path);
            bus_num = (Button) findViewById(R.id.bus_num);
            etcBtn = (ImageView)findViewById(R.id.recently_iv);

            data[0] = R.drawable.recent_stn;
            data[1] = R.drawable.recent_stn2;

/*
            bus_find_path.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Bus_main.this, "경로 검색.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Bus_main.this, BusSearch.class);
                    startActivity(intent);
                }
            });
*/

            bus_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Bus_main.this, "이용 가능 버스 검색", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Bus_main.this, BusResult.class);
                    startActivity(intent);
                }
            });
/*
            etcBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Bus_main.this, "개발자 : Invisible_Ending", Toast.LENGTH_LONG).show();
                    etcBtn.setImageResource(data[cnt]);
                }
            });
*/



        }


    public void onClick(View v) {
        // TODO Auto-generated method stub
        back();

    }

    public void back(){
        cnt++;
        etcBtn.setImageResource(data[cnt]);
        cnt--;
    }
}
