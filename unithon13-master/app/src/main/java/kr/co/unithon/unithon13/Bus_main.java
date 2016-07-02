package kr.co.unithon.unithon13;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.unithon.unithon13.DBManager.DBManager;

/**
 * Created by nanamare on 2016-04-28.
 */
public class Bus_main extends Activity {
    Button bus_find_path;
    Button bus_num;
    ImageButton recent_delete;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.bus_search);
            //bus_find_path = (Button) findViewById(R.id.bus_find_path);
            bus_num = (Button) findViewById(R.id.bus_num);
            recent_delete = (ImageButton)findViewById(R.id.recent_delete);
            ListView list = (ListView) findViewById(R.id.recentlv);

            DBManager dbManager = new DBManager(getApplicationContext(), "RecentRoute.db", null, 1);
            SQLiteDatabase DB;
            //DB = dbManager.getWritableDatabase();
            DB = dbManager.getReadableDatabase();
            Cursor cursor = DB.rawQuery("SELECT * FROM RecentRoute order by _id DESC;",null);
            if(cursor.getCount()>0) {
                startManagingCursor(cursor);
                final MyCursorAdapter adapter = new MyCursorAdapter(getApplicationContext(), cursor);
                list.setAdapter(adapter);
            }
/*
            bus_find_path.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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

            recent_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBManager dbManager = new DBManager(getApplicationContext(), "RecentRoute.db", null, 1);
                    SQLiteDatabase DB;
                    DB = dbManager.getReadableDatabase();
                    DB.execSQL("delete  FROM RecentRoute;");
                    Intent intent = new Intent(getApplicationContext(),Bus_main.class);
                    startActivity(intent);
                }
            });


        }

    /*
    public void onClick(View v) {

        back();

    }

    public void back(){

    }
    */

    private class MyCursorAdapter extends CursorAdapter {


        public MyCursorAdapter(Context context, Cursor c) {
            super(context,c);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            final TextView tv_bus_num = (TextView) view.findViewById(R.id.tv_bus_num);
            final TextView tv_bus_nm = (TextView) view.findViewById(R.id.tv_bus_nm);
            String bus_num = cursor.getString(cursor.getColumnIndex("BusRouteNm"));
            String bus_nm = cursor.getString(cursor.getColumnIndex("StNm"));
            tv_bus_num.setText(bus_num+"번 버스");
            tv_bus_nm.setText(bus_nm);
        }

        public View newView(Context context, Cursor cursor, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.recentrouterow,parent,false);
            return v;
        }
    }

}
