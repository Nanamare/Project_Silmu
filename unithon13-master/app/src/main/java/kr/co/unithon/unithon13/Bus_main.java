package kr.co.unithon.unithon13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by nanamare on 2016-04-28.
 */
public class Bus_main extends Activity {
    Button bus_find_path;
    Button bus_num;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.bus_search);
            bus_find_path = (Button) findViewById(R.id.bus_find_path);
            bus_num = (Button) findViewById(R.id.bus_num);

            bus_find_path.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Bus_main.this, "경로 검색.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Bus_main.this, BusResult.class);
                    startActivity(intent);
                }
            });


            bus_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Bus_main.this, "이용 가능 버스 검색", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Bus_main.this, BusSearch.class);
                    startActivity(intent);
                }
            });

        }
}
