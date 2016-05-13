package kr.co.unithon.unithon13.BusListView;

/**
 * Created by nanamare on 2016-05-12.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import kr.co.unithon.unithon13.R;
import kr.co.unithon.unithon13.XMLManager;

public class BusListAdapter extends ListActivity{
// ListActivity를 상속받습니다.
    String xml; //다운로드된 xml문서
    XMLManager xManager;
    private ArrayList<bus> mbuslist = null;
    private ListView busListView = null;
    bus a_bus= null;
    bus b_bus = null;
    ArrayList<bus> m_orders= new ArrayList<bus>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buslistview);

        String uri = "http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=";
        String routeid ="100100411";
        String furi = "&startOrd=1&endOrd=999&numOfRows=999&pageSize=999&pageNo=1&startPage=1";
        xManager = new XMLManager();//Util 객체 생성
        //xml 문서 다운받기(다운이 완료되었을때 메시지를 받아중 handler객체, 다운받을 url주소)
        xManager.downLoadXML(handler,uri+routeid+furi);

        //삽입
        //다운 받은 xml가져와서 xml에 담기

        /*
        xml = xManager.getXML();
        StringBuffer sBuff = new StringBuffer();
        //num, name, addr 요소를 String[]에 담아 파싱하기
        //String[] tags = {"wf", "tmn", "tmx"};
        String[] tags = {"rtNm","stNm","arrmsg1","arrmsg2"};
        ArrayList<HashMap<String, String>> list = xManager.parseForList(tags, xml);
        //m_orders = new ArrayList<>();
        mbuslist = new ArrayList<bus>();
        int i = 0;
        for(HashMap<String, String> tmp : list){
            //sBuff.append(tmp.get("wf")+"/"+tmp.get("tmn")+"/"+tmp.get("tmx")+"\n");
            //sBuff.append(tmp.get("rtNm")+"번 버스"+tmp.get("stNm")+"\n"+tmp.get("arrmsg1")+"\n"+tmp.get("arrmsg2")+"\n");
            //bus _bus = new bus(tmp.get("rtNm"),tmp.get("stNm"), tmp.get("arrmsg1"), tmp.get("arrmsg2"));
            //mbuslist.add(new bus(tmp.get("rtNm"),tmp.get("stNm"), tmp.get("arrmsg1"), tmp.get("arrmsg2")));
            //a_bus[i] = new bus(first,second,third,forth);
            //a_bus[i] = new bus("11111","22222","33333","44444");
            b_bus =  new bus("11111","22222","33333","44444");
            // a_bus[0] = new bus("1111","2222","3333","4444");
            //m_orders.add(a_bus[i]);
            m_orders.add(b_bus);
            // /m_orders.add(_bus);
            i++;
        }
        */


        //bus p1 = new bus("6000번","개화검문소","첫 번째 버스 출발대기", "두 번째 버스 출발대기");
        //bus p2 = new bus("6000번","김포공항국제선","곧 도착", "두 번째 버스 출발대기");

        //m_orders.add(p1);
// 리스트에 객체를 추가합니다.
       // m_orders.add(p2);
// 리스트에 객체를 추가합니다.

        //PersonAdapter m_adapter = new PersonAdapter(this, R.layout.busrow, m_orders);
// 어댑터를 생성합니다
        //setListAdapter(m_adapter);
//

    }
    /*
    public void down(View v){

        String uri = "http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=";
        String routeid ="100100411";
        String furi = "&startOrd=1&endOrd=999&numOfRows=999&pageSize=999&pageNo=1&startPage=1";
        xManager = new XMLManager();//Util 객체 생성
        //xml 문서 다운받기(다운이 완료되었을때 메시지를 받아중 handler객체, 다운받을 url주소)
        xManager.downLoadXML(handler,uri+routeid+furi);
    }
    */


    Handler handler = new Handler(){

        StringBuffer exam;
        int loop;
        public void handleMessage(android.os.Message msg){
            //다운 받은 xml가져와서 xml에 담기
            xml = xManager.getXML();
            StringBuffer sBuff = new StringBuffer();
            //num, name, addr 요소를 String[]에 담아 파싱하기
            //String[] tags = {"wf", "tmn", "tmx"};
            String[] tags = {"rtNm","stNm","arrmsg1","arrmsg2"};
            ArrayList<HashMap<String, String>> list = xManager.parseForList(tags, xml);
            //m_orders = new ArrayList<>();
            mbuslist = new ArrayList<bus>();
            int i = 0;
            for(HashMap<String, String> tmp : list){
                //sBuff.append(tmp.get("wf")+"/"+tmp.get("tmn")+"/"+tmp.get("tmx")+"\n");
               //sBuff.append(tmp.get("rtNm")+"번 버스"+tmp.get("stNm")+"\n"+tmp.get("arrmsg1")+"\n"+tmp.get("arrmsg2")+"\n");
                //bus _bus = new bus(tmp.get("rtNm"),tmp.get("stNm"), tmp.get("arrmsg1"), tmp.get("arrmsg2"));
                //mbuslist.add(new bus(tmp.get("rtNm"),tmp.get("stNm"), tmp.get("arrmsg1"), tmp.get("arrmsg2")));
                //m_orders.add(_bus);

                String first = tmp.get("rtNm");
                String second = tmp.get("stNm");
                String third = tmp.get("arrmsg1");
                String forth = tmp.get("arrmsg2");
                a_bus = new bus(first,second,third,forth);
                //a_bus[i] = new bus("11111","22222","33333","44444");
                //b_bus =  new bus("11111","22222","33333","44444");
                // a_bus[0] = new bus("1111","2222","3333","4444");
                //m_orders.add(a_bus[i]);
                m_orders.add(a_bus);
                // /m_orders.add(_bus);
                i++;
            }
            //mbuslist.add(new bus("abc","111","222","333"));
            //editText.setText(sBuff.toString());
            //editText.setText(mbuslist.get(0).getName());
            //mbuslist.add(new bus("1","2","3,","4"));
            //PersonAdapter m_adapter = new PersonAdapter(getApplicationContext(), R.layout.busrow, mbuslist);
            //setListAdapter(m_adapter);
            /*
            for(int i=0; i<mbuslist.size(); i++ ) {
                editText.setText(mbuslist.get(i).getName());
                editText.setText(mbuslist.get(i).getNumber());
                editText.setText(mbuslist.get(i).getArrmsg1());
                editText.setText(mbuslist.get(i).getArrmsg2());
            }
            */
            PersonAdapter m_adapter = new PersonAdapter(getApplicationContext(), R.layout.busrow, m_orders);
// 어댑터를 생성합니다
            setListAdapter(m_adapter);
        }

    };











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
                    tt2.setText(p.getNumber());
                }
                if(bt != null){
                    bt.setText(p.getArrmsg1());
                }
                if(bt2 != null){
                    bt2.setText(p.getArrmsg2());
                }
            }
            return v;
        }
    }

}