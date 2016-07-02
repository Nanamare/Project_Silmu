package kr.co.unithon.unithon13;

import kr.co.unithon.unithon13.DBManager.DBManager;
import kr.co.unithon.unithon13.R;
import kr.co.unithon.unithon13.BusListView.*;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.BufferedReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;



/**
 * Created by nanamare on 2016-05-11.
 */

public class BusResult extends Activity {
    EditText txt_main;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.Message";
    /** Called when the activity is first created. */
    String busid;
    private ListView busListView = null;
    private ArrayList<bus> mbuslist = null;
    private bus _bus = null;
    //결과값을 출력할 EditText
    //EditText editText;
    String xml; //다운로드된 xml문서
    XMLManager xManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_result);
    }

    public void down(View v){
        Intent intent = new Intent(getApplicationContext(),BusListAdapter.class);
        txt_main = (EditText) findViewById(R.id.txt_main);
        String message = txt_main.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }

    //메세지를 전달 받을 핸들러 객체(문서 Thread 다운이 완료되면 이곳이 실행된다)
    Handler handler = new Handler(){
        StringBuffer exam;
        int loop;
        public void handleMessage(android.os.Message msg){

        }
    };

}