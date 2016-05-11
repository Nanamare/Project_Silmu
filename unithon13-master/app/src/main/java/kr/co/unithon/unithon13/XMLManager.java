package kr.co.unithon.unithon13;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.os.Handler;
import android.widget.Toast;

public class XMLManager {

    private String xml; //다운로드한 xml
    private String urlAddr; //다운로드할 url 주소
    private Handler handler;//메인 스레드의 핸들러
    //다운로드 성공 실패 여부에 대한 상수
    static final int DOWN_SUCCESS=0;
    static final int DOWN_FAIL=1;
    //파싱할 테그의 종류가 한가지 읽때 호출하는 메소드
    public ArrayList<String> parseForList(String tag,String xml){
        ArrayList<String> list=new ArrayList<String>();
        try{
            DocumentBuilderFactory factory=
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=
                    factory.newDocumentBuilder();
            //xml 정보를 담고있는 String 객체를 InputStream 으로 변환
            InputStream is=
                    new ByteArrayInputStream(xml.getBytes());
            //파싱해서 Document 형태로 변환
            Document doc=documentBuilder.parse(is);
            Element element=doc.getDocumentElement();

            //읽어올 테그명 정하기
            NodeList itemsK=element.getElementsByTagName(tag);

            //읽어온 자료의 갯수
            int n=itemsK.getLength();

            //반복문 돌면서 모든 데이터 읽어오기
            for(int i=0; i < n ; i++){
                //읽어온 자료에서 해당인덱스 번호를 이용해서 읽어온다.
                Node itemK=itemsK.item(i);
                Node textK=itemK.getFirstChild();
                //해당 노드에서 문자열 읽어오기
                String itemNameK=textK.getNodeValue();
                list.add(itemNameK);
            }
        }catch(Exception e){}
        return list;
    }
    //파싱할 태그의 종류가 여러가지 일때 호출하는 메소드
    public ArrayList<HashMap<String,String>>
    parseForList(String[] tags,String xml){
        ArrayList<HashMap<String, String>> list=
                new ArrayList<HashMap<String,String>>();
        try{
            DocumentBuilderFactory factory=
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=
                    factory.newDocumentBuilder();
            //xml 정보를 담고있는 String 객체를 InputStream 으로 변환
            InputStream is=
                    new ByteArrayInputStream(xml.getBytes());
            //파싱해서 Document 형태로 변환
            Document doc=documentBuilder.parse(is);
            Element element=doc.getDocumentElement();
            //읽어올 데이터의 갯수
            int tagSize=tags.length;
            NodeList[] nodeList=new NodeList[tagSize];

            for(int i=0; i < tagSize ; i++){
                nodeList[i]=element.getElementsByTagName(tags[i]);
            }
            //읽어온 자료의 수
            int dataSize=nodeList[0].getLength();
            Node[] nodeFirst=new Node[tagSize];
            Node[] nodeSecond=new Node[tagSize];
            String[] nodeValue=new String[tagSize];
            for(int i=0; i < dataSize ; i++){
                for(int j=0; j < tagSize ; j++){
                    nodeFirst[j]=nodeList[j].item(i);
                }
                for(int j=0; j < tagSize ; j++){
                    nodeSecond[j]=nodeFirst[j].getFirstChild();
                }
                for(int j=0; j < tagSize ; j++){
                    nodeValue[j]=nodeSecond[j].getNodeValue();
                }
                HashMap<String, String> map=new HashMap<String, String>();
                for(int j=0; j < tagSize; j++){
                    map.put(tags[j], nodeValue[j]);
                }
                list.add(map);
            }

        }catch(Exception e){

        }
        return list;
    }
    //다운로드 하는 메소드
    public void downLoadXML(Handler handler,String urlAddr){
        this.handler=handler;
        this.urlAddr=urlAddr;
        //다운로드하는 스레드 시작하기
        new DownThread().start();
    }
    //다운로드할 스레드를 생성할 InnerClass
    class DownThread extends Thread{
        public void run(){
            //웹서버에 접속해서 응답하는 xml 문서를 읽어온다.
            StringBuilder builder=new StringBuilder();
            try{
                URL url=new URL(urlAddr);
                HttpURLConnection conn=
                        (HttpURLConnection)url.openConnection();
                if(conn != null){//정상접속이 되었다면
                    conn.setConnectTimeout(10000);//최대 대기시간10초
                    conn.setUseCaches(false);//캐쉬사용안함
                    if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                        //InputStreamReader 객체 얻어오기
                        InputStreamReader isr=
                                new InputStreamReader(conn.getInputStream());
                        BufferedReader br=new BufferedReader(isr);
                        //반복문 돌면서 읽어오기
                        while(true){
                            String line=br.readLine();
                            if(line==null)break;
                            //읽어온 문자열을 객체에 저장
                            builder.append(line);
                        }
                        br.close();
                        //다운로드한 자료를 문자열로 반환
                        xml=builder.toString();
                        //다운로드 성공일때 Hanlder 에 알린다.
                        handler.sendEmptyMessage(DOWN_SUCCESS);
                    }//if
                    conn.disconnect();//연결해제
                }//if
            }catch(Exception e){
                //실패일때도 알린다.
                handler.sendEmptyMessage(DOWN_FAIL);
            }//try
        }
    }
    //다운로드한 xml 문서를 리턴하는 메소드
    public String getXML(){
        return xml;
    }
}













