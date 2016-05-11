package kr.co.unithon.unithon13;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
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

    //결과값을 출력할 EditText
    EditText editText;
    String xml; //다운로드된 xml문서
    XMLManager xManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_result);
        editText = (EditText)findViewById(R.id.editText);


    }
    //버튼을 눌렀을때 실행되는 메소드
    public void down(View v){
        xManager = new XMLManager();//Util 객체 생성
        //xml 문서 다운받기(다운이 완료되었을때 메시지를 받아중 handler객체, 다운받을 url주소)
        xManager.downLoadXML(handler, "http://www.kma.go.kr/weather/forecast/mid-term-xml.jsp?stnId=109");
        //http://ws.bus.go.kr/api/rest/buspos/getBusPosByRouteSt?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=100100411&startOrd=1&endOrd=999&numOfRows=999&pageSize=999&pageNo=1&startPage=1

    }

    //메세지를 전달 받을 핸들러 객체(문서 Thread 다운이 완료되면 이곳이 실행된다)
    Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg){
            //다운 받은 xml가져와서 xml에 담기
            xml = xManager.getXML();
            StringBuffer sBuff = new StringBuffer();
            //num, name, addr 요소를 String[]에 담아 파싱하기
            String[] tags = {"wf", "tmn", "tmx"};
            ArrayList<HashMap<String, String>> list = xManager.parseForList(tags, xml);
            for(HashMap<String, String> tmp : list){
                sBuff.append(tmp.get("wf")+"/"+tmp.get("tmn")+"/"+tmp.get("tmx")+"\n");
            }
            editText.setText(sBuff.toString());
        }
    };
}




