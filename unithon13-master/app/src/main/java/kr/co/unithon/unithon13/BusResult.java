package kr.co.unithon.unithon13;

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
       //editText = (EditText)findViewById(R.id.editText);


    }
    //버튼을 눌렀을때 실행되는 메소드
    //100100416
    //100100506
    //100100412
    //100100411

    public void down(View v){
        String uri = "http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=";
        String routeid ="100100411";
        String furi = "&startOrd=1&endOrd=999&numOfRows=999&pageSize=999&pageNo=1&startPage=1";
        xManager = new XMLManager();//Util 객체 생성
        //xml 문서 다운받기(다운이 완료되었을때 메시지를 받아중 handler객체, 다운받을 url주소)
        xManager.downLoadXML(handler,uri+routeid+furi);
        //http://ws.bus.go.kr/api/rest/buspos/getBusPosByRouteSt?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=100100411&startOrd=1&endOrd=999&numOfRows=999&pageSize=999&pageNo=1&startPage=1
        //사용할것은 아래
        //http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=100100411&numOfRows=999&pageSize=999&pageNo=1&startPage=1
    }

    //메세지를 전달 받을 핸들러 객체(문서 Thread 다운이 완료되면 이곳이 실행된다)
    Handler handler = new Handler(){
        StringBuffer exam;
        int loop;
        public void handleMessage(android.os.Message msg){
            /*
            //다운 받은 xml가져와서 xml에 담기
            xml = xManager.getXML();
            StringBuffer sBuff = new StringBuffer();
            //num, name, addr 요소를 String[]에 담아 파싱하기
            //String[] tags = {"wf", "tmn", "tmx"};
            String[] tags = {"rtNm","stNm","arrmsg1","arrmsg2"};
            ArrayList<HashMap<String, String>> list = xManager.parseForList(tags, xml);
            Vector<bus> m_orders = new Vector<>();
            mbuslist = new ArrayList<bus>();
            for(HashMap<String, String> tmp : list){
                //sBuff.append(tmp.get("wf")+"/"+tmp.get("tmn")+"/"+tmp.get("tmx")+"\n");
                sBuff.append(tmp.get("rtNm")+"번 버스"+tmp.get("stNm")+"\n"+tmp.get("arrmsg1")+"\n"+tmp.get("arrmsg2")+"\n");
                //bus _bus = new bus(tmp.get("rtNm"),tmp.get("stNm"), tmp.get("arrmsg1"), tmp.get("arrmsg2"));
               // mbuslist.add(new bus(tmp.get("rtNm"),tmp.get("stNm"), tmp.get("arrmsg1"), tmp.get("arrmsg2")));
                //m_orders.add(_bus);
                //m_orders.addElement(_bus);
            }
            //mbuslist.add(new bus("abc","111","222","333"));
            //editText.setText(sBuff.toString());
            //editText.setText(mbuslist.get(0).getName());
           // PersonAdapter m_adapter = new PersonAdapter(getApplicationContext(), R.layout.busrow, mbuslist);
            //busListView.setAdapter(m_adapter);
            /*
            for(int i=0; i<mbuslist.size(); i++ ) {
                editText.setText(mbuslist.get(i).getName());
                editText.setText(mbuslist.get(i).getNumber());
                editText.setText(mbuslist.get(i).getArrmsg1());
                editText.setText(mbuslist.get(i).getArrmsg2());
            }
            */
            Intent intent = new Intent(getApplicationContext(),BusListAdapter.class);
            startActivity(intent);
        }
    };
    /*
    private class PersonAdapter extends ArrayAdapter<bus> {

        private ArrayList<bus> items;

        public PersonAdapter(Context context, int textViewResourceId, ArrayList<bus> items) {
            super(context, textViewResourceId, items);
            this.items = items;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.busrow, null);
            }
            bus p = items.get(position);
            if (p != null) {
                TextView tt = (TextView) v.findViewById(R.id.toptext);
                TextView tt2 = (TextView) v.findViewById(R.id.toptext2);
                TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                TextView bt2 = (TextView) v.findViewById(R.id.bottomtext2);
                if (tt != null){
                    tt.setText(p.getName());
                }
                if(tt2 != null){
                    bt.setText(p.getNumber());
                }
                if(bt != null){
                    bt.setText(p.getArrmsg1());
                }
                if(bt2 != null){
                    bt.setText(p.getArrmsg2());
                }
            }
            return v;
        }
    }

     */
}