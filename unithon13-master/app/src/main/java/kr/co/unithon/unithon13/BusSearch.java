package kr.co.unithon.unithon13;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.unithon.unithon13.BusListView.BusListAdapter;
import kr.co.unithon.unithon13.BusListView.bus;
import kr.co.unithon.unithon13.DBManager.DBManager;

/**
 * Created by nanamare on 2016-04-28.
 */
public class BusSearch extends Activity  {
    EditText txt_main2;
    Button btn_intent;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.Message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bussearch);
        txt_main2 = (EditText)findViewById(R.id.editText2);
        btn_intent = (Button)findViewById(R.id.btn_intent);


        //여기서 버스 매칭을 처리한후
        //버스 리스트 어댑터로 전송

        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusSearch.this,BusListAdapter.class);
                String message = txt_main2.getText().toString();
                intent.putExtra(EXTRA_MESSAGE,message);
                startActivity(intent);;
            }
        });
        //DBManager dbManager = new DBManager(getApplicationContext(), "RecentRoute.db", null, 1);



    }
   /*
    public void onClicked(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(this, Bus_main.class);
        intent.putExtra("RouteId",txt_main.getText().toString());
        startActivity(intent);
    }
    */




}
