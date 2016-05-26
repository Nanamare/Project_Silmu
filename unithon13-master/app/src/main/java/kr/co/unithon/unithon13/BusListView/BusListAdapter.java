package kr.co.unithon.unithon13.BusListView;

/**
 * Created by nanamare on 2016-05-12.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.unithon.unithon13.BusResult;
import kr.co.unithon.unithon13.BusSearch;
import kr.co.unithon.unithon13.InfoClass;
import kr.co.unithon.unithon13.MainActivity;
import kr.co.unithon.unithon13.R;
import kr.co.unithon.unithon13.XMLManager;

public class   BusListAdapter extends ListActivity{
// ListActivity를 상속받습니다.
    String xml; //다운로드된 xml문서
    XMLManager xManager;
    private ArrayList<bus> mbuslist = null;
    private ListView busListView = null;
    bus a_bus= null;
    bus b_bus = null;
    ArrayList<bus> m_orders= new ArrayList<bus>();
    ArrayList<bus> m_orders2= new ArrayList<bus>();
    ArrayList<busLine> morders= new ArrayList<busLine>();
    busLine a_busline;
    TextWatcher textWatcherInput;
    EditText searchet;
    Button myButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buslistview);
        myButton = (Button)findViewById(R.id.myBtn);
        searchet = (EditText) findViewById(R.id.searchet);
            //삽입
        morders.add(new busLine("100100411",6000));
        morders.add(new busLine("100100412",6001));
        morders.add(new busLine("100100413",6002));
        morders.add(new busLine("100100414",6003));
        morders.add(new busLine("100100415",6004));
        morders.add(new busLine("100100416",6005));
        morders.add(new busLine("100100506",6006));
        morders.add(new busLine("100100417",6008));
        morders.add(new busLine("100100507",6009));
        morders.add(new busLine("100100584",6010));
        morders.add(new busLine("100100418",6011));
        morders.add(new busLine("100100419",6012));
        morders.add(new busLine("100100420",6013));
        morders.add(new busLine("100100421",6014));
        morders.add(new busLine("100100422",6015));
        morders.add(new busLine("100100423",6016));
        morders.add(new busLine("100100533",6017));
        morders.add(new busLine("100100538",6018));
        morders.add(new busLine("115000006",6019));
        morders.add(new busLine("100100509",6020));
        morders.add(new busLine("115000001",6021));
        morders.add(new busLine("100100517",6030));
        morders.add(new busLine("100100513",6100));
        morders.add(new busLine("100100373",6101));
        morders.add(new busLine("124000013",6103));
        morders.add(new busLine("124000012",6104));
        morders.add(new busLine("124000011",6105));
        morders.add(new busLine("124000006",6200));
        morders.add(new busLine("100100508",6300));
        morders.add(new busLine("124000009",6500));
        morders.add(new busLine("100100567",6701));
        morders.add(new busLine("100100573",6702));
        morders.add(new busLine("100100572",6703));
        morders.add(new busLine("100100571",6704));
        morders.add(new busLine("100100570",6705));
        morders.add(new busLine("100100569",6706));


        morders.add(new busLine("100100549",100));
        morders.add(new busLine("100100006",101));
        morders.add(new busLine("100100007",102));
        morders.add(new busLine("100100008",103));
        morders.add(new busLine("100100009",104));
        morders.add(new busLine("100100010",105));
        morders.add(new busLine("100100011",106));
        morders.add(new busLine("100100012",107));
        morders.add(new busLine("100100013",108));
        morders.add(new busLine("100100014",109));

        morders.add(new busLine("100100017",120));
        morders.add(new busLine("100100583",121));
        morders.add(new busLine("100100018",130));
        morders.add(new busLine("100100019",140));
        morders.add(new busLine("100100020",141));
        morders.add(new busLine("100100021",142));
        morders.add(new busLine("100100022",143));
        morders.add(new busLine("100100023",144));
        morders.add(new busLine("100100024",145));
        morders.add(new busLine("100100025",146));
        morders.add(new busLine("100100026",147));
        morders.add(new busLine("100100027",148));
        morders.add(new busLine("100100029",150));
        morders.add(new busLine("100100030",151));
        morders.add(new busLine("100100031",152));
        morders.add(new busLine("100100032",153));
        morders.add(new busLine("100100033",160));
        morders.add(new busLine("100100034",162));
        morders.add(new busLine("100100035",163));
        morders.add(new busLine("100100036",171));
        morders.add(new busLine("100100037",172));
        morders.add(new busLine("100100038",201));
        morders.add(new busLine("100100039",202));
        morders.add(new busLine("100100407",240));
        morders.add(new busLine("100100595",241));
        morders.add(new busLine("104000006",242));
        morders.add(new busLine("100100042",260));
        morders.add(new busLine("100100043",261));
        morders.add(new busLine("100100044",262));
        morders.add(new busLine("100100046",270));
        morders.add(new busLine("100100047",271));
        morders.add(new busLine("100100048",272));
        morders.add(new busLine("100100049",273));
        morders.add(new busLine("100100051",301));
        morders.add(new busLine("100100052",302));
        morders.add(new busLine("100100053",303));
        morders.add(new busLine("100100564",320));
        morders.add(new busLine("100100496",333));
        morders.add(new busLine("100100055",340));
        morders.add(new busLine("100100056",341));
        morders.add(new busLine("100100553",350));
        morders.add(new busLine("100100582",351));
        morders.add(new busLine("100100057",360));
        morders.add(new busLine("124000036",362));
        morders.add(new busLine("100100061",370));
        morders.add(new busLine("100100596",400));
        morders.add(new busLine("100100062",401));
        morders.add(new busLine("100100063",402));
        morders.add(new busLine("100100597",405));
        morders.add(new busLine("100100064",406));
        morders.add(new busLine("100100461",407));
        morders.add(new busLine("100100068",420));
        morders.add(new busLine("100100409",421));
        morders.add(new busLine("100100459",440));
        morders.add(new busLine("100100070",441));
        morders.add(new busLine("100100071",461));
        morders.add(new busLine("100100458",462));
        morders.add(new busLine("100100605",463));
        morders.add(new busLine("100100073",470));
        morders.add(new busLine("100100074",471));
        morders.add(new busLine("100100075",472));
        morders.add(new busLine("100100076",500));
        morders.add(new busLine("100100077",501));
        morders.add(new busLine("100100410",502));
        morders.add(new busLine("100100078",503));
        morders.add(new busLine("100100079",504));
        morders.add(new busLine("100100080",505));
        morders.add(new busLine("100100081",506));
        morders.add(new busLine("100100082",507));
        morders.add(new busLine("100100083",540));
        morders.add(new busLine("100100574",541));
        morders.add(new busLine("100100603",542));
        morders.add(new busLine("100100084",571));
        morders.add(new busLine("100100085",600));
        morders.add(new busLine("100100086",601));
        morders.add(new busLine("100100087",602));
        morders.add(new busLine("100100088",603));
        morders.add(new busLine("100100089",604));
        morders.add(new busLine("100100090",605));
        morders.add(new busLine("100100091",606));
        morders.add(new busLine("100100093",640));
        morders.add(new busLine("100100094",641));
        morders.add(new busLine("100100095",642));
        morders.add(new busLine("100100096",643));
        morders.add(new busLine("100100097",650));
        morders.add(new busLine("100100098",651));
        morders.add(new busLine("100100099",652));
        morders.add(new busLine("100100497",653));
        morders.add(new busLine("100100102",661));
        morders.add(new busLine("100100550",662));
        morders.add(new busLine("100100436",670));
        morders.add(new busLine("100100495",672));
        morders.add(new busLine("100100551",673));
        morders.add(new busLine("100100440",700));
        morders.add(new busLine("100100103",701));

        morders.add(new busLine("100100106",703));
        morders.add(new busLine("100100107",704));
        morders.add(new busLine("100100587",705));
        morders.add(new busLine("100100108",706));
        morders.add(new busLine("100100511",707));
        morders.add(new busLine("100100110",710));
        morders.add(new busLine("100100111",720));
        morders.add(new busLine("100100112",721));
        morders.add(new busLine("100100537",740));
        morders.add(new busLine("100100116",751));
        morders.add(new busLine("100100117",752));
        morders.add(new busLine("100100118",753));
        morders.add(new busLine("100100119",760));
        morders.add(new busLine("100100124",0017));
        morders.add(new busLine("100100129",1014));
        morders.add(new busLine("100100130",1017));
        morders.add(new busLine("100100131",1020));
        morders.add(new busLine("100100132",1111));
        morders.add(new busLine("100100133",1113));
        morders.add(new busLine("100100134",1114));
        morders.add(new busLine("100100566",1115));
        morders.add(new busLine("100100137",1119));
        morders.add(new busLine("100100138",1120));
        morders.add(new busLine("100100425",1122));
        morders.add(new busLine("100100139",1124));
        morders.add(new busLine("100100142",1126));
        morders.add(new busLine("100100143",1127));
        morders.add(new busLine("100100144",1128));
        morders.add(new busLine("100100145",1129));
        morders.add(new busLine("100100146",1130));
        morders.add(new busLine("100100147",1131));
        morders.add(new busLine("100100148",1132));
        morders.add(new busLine("100100149",1133));
        morders.add(new busLine("100100150",1135));
        morders.add(new busLine("100100151",1136));
        morders.add(new busLine("100100152",1137));
        morders.add(new busLine("100100153",1138));
        morders.add(new busLine("100100154",1139));
        morders.add(new busLine("100100155",1140));
        morders.add(new busLine("100100156",1141));
        morders.add(new busLine("100100157",1142));
        morders.add(new busLine("100100158",1143));
        morders.add(new busLine("100100159",1144));
        morders.add(new busLine("100100164",1154));
        morders.add(new busLine("100100165",1155));
        morders.add(new busLine("100100166",1156));
        morders.add(new busLine("100100170",1162));
        morders.add(new busLine("100100171",1164));
        morders.add(new busLine("100100172",1165));
        morders.add(new busLine("100100173",1166));
        morders.add(new busLine("100100175",1213));
        morders.add(new busLine("100100177",1218));
        morders.add(new busLine("100100178",1221));
        morders.add(new busLine("100100179",1222));
        morders.add(new busLine("100100181",1224));
        morders.add(new busLine("100100183",1226));
        morders.add(new busLine("100100184",1227));
        morders.add(new busLine("100100185",1711));
        morders.add(new busLine("100100186",2012));
        morders.add(new busLine("100100188",2013));
        morders.add(new busLine("100100189",2014));
        morders.add(new busLine("100100190",2015));
        morders.add(new busLine("100100522",2016));
        morders.add(new busLine("100100191",2112));
        morders.add(new busLine("100100192",2113));
        morders.add(new busLine("100100193",2114));
        morders.add(new busLine("100100598",2115));
        morders.add(new busLine("100100194",2211));
        morders.add(new busLine("100100198",2221));
        morders.add(new busLine("100100199",2222));
        morders.add(new busLine("100100201",2224));
        morders.add(new busLine("100100202",2227));
        morders.add(new busLine("100100203",2230));
        morders.add(new busLine("100100204",2233));
        morders.add(new busLine("100100205",2234));
        morders.add(new busLine("100100206",2235));
        morders.add(new busLine("100100599",2311));
        morders.add(new busLine("100100611",2312));
        morders.add(new busLine("100100209",2412));
        morders.add(new busLine("100100210",2413));
        morders.add(new busLine("100100211",2415));
        morders.add(new busLine("100100438",3011));
        morders.add(new busLine("100100579",3012));
        morders.add(new busLine("100100212",3212));
        morders.add(new busLine("100100213",3214));
        morders.add(new busLine("100100215",3216));
        morders.add(new busLine("100100216",3217));
        morders.add(new busLine("100100218",3220));
        morders.add(new busLine("100100219",3313));
        morders.add(new busLine("100100220",3314));
        morders.add(new busLine("100100221",3315));
        morders.add(new busLine("100100222",3316));
        morders.add(new busLine("100100478",3317));
        morders.add(new busLine("100100498",3318));
        morders.add(new busLine("100100501",3319));
        morders.add(new busLine("100100578",3321));
        morders.add(new busLine("100100613",3322));
        morders.add(new busLine("100100223",3411));
        morders.add(new busLine("100100224",3412));
        morders.add(new busLine("100100225",3413));
        morders.add(new busLine("100100226",3414));
        morders.add(new busLine("100100228",3416));
        morders.add(new busLine("100100229",3417));
        morders.add(new busLine("100100232",3422));
        morders.add(new busLine("100100609",3425));
        morders.add(new busLine("100100612",3426));
        morders.add(new busLine("100100604",4211));
        morders.add(new busLine("100100234",4212));
        morders.add(new busLine("100100237",4318));
        morders.add(new busLine("100100427",4319));
        morders.add(new busLine("100100500",4412));
        morders.add(new busLine("100100454",4419));
        morders.add(new busLine("100100246",4432));
        morders.add(new busLine("100100247",4433));
        morders.add(new busLine("122000001",4435));
        morders.add(new busLine("100100248",5012));
        morders.add(new busLine("100100249",5413));
        morders.add(new busLine("100100250",5511));
        morders.add(new busLine("100100251",5513));
        morders.add(new busLine("100100252",5515));
        morders.add(new busLine("100100253",5516));
        morders.add(new busLine("100100254",5517));
        morders.add(new busLine("100100255",5519));

        morders.add(new busLine("100100259",5523));
        morders.add(new busLine("100100260",5524));
        morders.add(new busLine("100100261",5525));
        morders.add(new busLine("100100263",5528));
        morders.add(new busLine("100100264",5530));
        morders.add(new busLine("100100265",5531));
        morders.add(new busLine("100100266",5534));
        morders.add(new busLine("100100267",5535));
        morders.add(new busLine("100100268",5536));
        morders.add(new busLine("100100269",5537));
        morders.add(new busLine("100100272",5615));
        morders.add(new busLine("100100273",5616));
        morders.add(new busLine("100100274",5617));
        morders.add(new busLine("100100275",5618));
        morders.add(new busLine("100100276",5619));
        morders.add(new busLine("100100277",5620));
        morders.add(new busLine("100100278",5621));
        morders.add(new busLine("100100279",5623));
        morders.add(new busLine("100100280",5624));
        morders.add(new busLine("100100281",5625));
        morders.add(new busLine("100100282",5626));
        morders.add(new busLine("100100283",5627));
        morders.add(new busLine("100100284",5630));
        morders.add(new busLine("100100285",5633));
        morders.add(new busLine("100100286",5712));
        morders.add(new busLine("100100287",5713));
        morders.add(new busLine("100100288",5714));
        morders.add(new busLine("100100289",6211));
        morders.add(new busLine("100100290",6411));
        morders.add(new busLine("100100291",6511));
        morders.add(new busLine("100100292",6512));
        morders.add(new busLine("100100293",6513));
        morders.add(new busLine("100100294",6514));
        morders.add(new busLine("100100521",6515));
        morders.add(new busLine("100100576",6516));
        morders.add(new busLine("100100295",6611));
        morders.add(new busLine("100100453",6613));
        morders.add(new busLine("100100297",6614));
        morders.add(new busLine("100100298",6616));
        morders.add(new busLine("100100299",6617));
        morders.add(new busLine("100100300",6620));
        morders.add(new busLine("100100301",6623));
        morders.add(new busLine("100100302",6624));
        morders.add(new busLine("100100303",6625));
        morders.add(new busLine("100100304",6627));
        morders.add(new busLine("100100305",6628));
        morders.add(new busLine("100100306",6629));
        morders.add(new busLine("100100307",6630));
        morders.add(new busLine("100100308",6631));
        morders.add(new busLine("100100309",6632));
        morders.add(new busLine("100100311",6635));
        morders.add(new busLine("100100312",6637));
        morders.add(new busLine("100100313",6638));

        morders.add(new busLine("100100316",6642));
        morders.add(new busLine("100100317",6643));
        morders.add(new busLine("100100318",6645));
        morders.add(new busLine("100100320",6647));
        morders.add(new busLine("115000005",6648));
        morders.add(new busLine("100100322",6649));
        morders.add(new busLine("100100323",6650));
        morders.add(new busLine("100100324",6651));
        morders.add(new busLine("100100329",6657));
        morders.add(new busLine("100100330",6712));
        morders.add(new busLine("100100331",6714));
        morders.add(new busLine("100100332",6715));
        morders.add(new busLine("100100451",6716));
        morders.add(new busLine("100100450",7011));
        morders.add(new busLine("100100447",7016));
        morders.add(new busLine("100100337",7017));
        morders.add(new busLine("100100338",7018));
        morders.add(new busLine("100100339",7019));
        morders.add(new busLine("100100340",7021));
        morders.add(new busLine("100100341",7022));
        morders.add(new busLine("100100342",7024));
        morders.add(new busLine("100100446",7025));
        morders.add(new busLine("100100344",7211));
        morders.add(new busLine("100100499",7212));
        morders.add(new busLine("100100345",7611));
        morders.add(new busLine("100100346",7612));
        morders.add(new busLine("100100347",7613));
        morders.add(new busLine("100100348",7711));
        morders.add(new busLine("100100349",7713));
        morders.add(new busLine("100100548",7714));
        morders.add(new busLine("100100462",7715));
        morders.add(new busLine("124000008",7719));
        morders.add(new busLine("100100352",7720));
        morders.add(new busLine("100100353",7722));
        morders.add(new busLine("100100354",7723));
        morders.add(new busLine("100100357",7726));
        morders.add(new busLine("100100358",7727));
        morders.add(new busLine("100100359",7728));
        morders.add(new busLine("100100360",7730));
        morders.add(new busLine("100100362",7733));
        morders.add(new busLine("100100363",7737));
        morders.add(new busLine("100100364",7738));
        morders.add(new busLine("100100552",7739));
        morders.add(new busLine("100000004",8001));
        morders.add(new busLine("100100370",8111));
        morders.add(new busLine("100100383",8541));
        morders.add(new busLine("100100525",8772));
        morders.add(new busLine("100100387",8774));
        morders.add(new busLine("100100001",02));
        morders.add(new busLine("100100002",03));
        morders.add(new busLine("100100003",05));
        morders.add(new busLine("124000007",8663));

        morders.add(new busLine("100100389",9401));
        morders.add(new busLine("100100390",9403));
        morders.add(new busLine("100100391",9404));
        morders.add(new busLine("100100392",9408));
        morders.add(new busLine("100100397",9701));
        morders.add(new busLine("100100398",9703));
        morders.add(new busLine("100100400",9707));
        morders.add(new busLine("100100402",9709));

        morders.add(new busLine("100100406",9714));


        morders.add(new busLine("241001320",1307));
        morders.add(new busLine("241000810",1310));

        morders.add(new busLine("241000830",1801));
        morders.add(new busLine("241004280",3000));


        morders.add(new busLine("241004220",3001));

        morders.add(new busLine("241004230",3002));
        morders.add(new busLine("241004250",3003));
        morders.add(new busLine("241003600",3300));
        morders.add(new busLine("241005910",5100));
        morders.add(new busLine("241006510",7002));
        morders.add(new busLine("241005960",7300));
        morders.add(new busLine("241000590",8101));
        morders.add(new busLine("241000740",8103));
        morders.add(new busLine("241002610",8105));
        morders.add(new busLine("241003770",8113));
        morders.add(new busLine("241006600",8115));
        morders.add(new busLine("241003340",8118));
        morders.add(new busLine("241003320",8131));
        morders.add(new busLine("241000460",8133));
        morders.add(new busLine("241000800",8142));
        morders.add(new busLine("241001340",8146));
        morders.add(new busLine("241000820",8147));
        morders.add(new busLine("241000840",8153));
        morders.add(new busLine("241003400",8154));
        morders.add(new busLine("241004890",8165));
        morders.add(new busLine("241004370",8455));



        Intent intent= getIntent();
        int name = Integer.valueOf(intent.getStringExtra(BusResult.EXTRA_MESSAGE));

        Intent intent2= getIntent();
        name = Integer.valueOf(intent2.getStringExtra(BusSearch.EXTRA_MESSAGE));


        String uri = "http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=";
        String routeid = findRouteId(morders,name);
        String furi = "&startOrd=1&endOrd=999&numOfRows=999&pageSize=999&pageNo=1&startPage=1";
        xManager = new XMLManager();//Util 객체 생성
        //xml 문서 다운받기(다운이 완료되었을때 메시지를 받아중 handler객체, 다운받을 url주소)
        xManager.downLoadXML(handler,uri+routeid+furi);



    }



    Handler handler = new Handler(){

        StringBuffer exam;
        int loop;
        public void handleMessage(android.os.Message msg){
            //다운 받은 xml가져와서 xml에 담기
            xml = xManager.getXML();
            StringBuffer sBuff = new StringBuffer();
            //num, name, addr 요소를 String[]에 담아 파싱하기
            //String[] tags = {"wf", "tmn", "tmx"};
            final String[] tags = {"rtNm","stNm","arrmsg1","arrmsg2"};
            final ArrayList<HashMap<String, String>> list = xManager.parseForList(tags, xml);

            mbuslist = new ArrayList<bus>();
            for(HashMap<String, String> tmp : list){

                String first = tmp.get("rtNm");
                String second = tmp.get("stNm");
                String third = tmp.get("arrmsg1");
                String forth = tmp.get("arrmsg2");
                a_bus = new bus(first,second,third,forth);
                m_orders.add(a_bus);
            }

            final PersonAdapter m_adapter = new PersonAdapter(getApplicationContext(), R.layout.busrow, m_orders);
            setListAdapter(m_adapter);


            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(HashMap<String, String> tmp : list){
                        if(tmp.get("stNm").equals(searchet.getText().toString())){
                            String first = tmp.get("rtNm");
                            String second = tmp.get("stNm");
                            String third = tmp.get("arrmsg1");
                            String forth = tmp.get("arrmsg2");
                            b_bus = new bus(first, second, third, forth);
                            m_orders2.add(b_bus);
                            PersonAdapter m_adapter2 = new PersonAdapter(getApplicationContext(), R.layout.busrow, m_orders2);
                            setListAdapter(m_adapter2);
                        }
                    }

                }
            });
            /*
            searchet = (EditText) findViewById(R.id.searchet);
            searchet.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(final CharSequence s, int start, int before, int count) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //m_adapter.notifyDataSetChanged();
                            //setListAdapter(m_adapter);
                            //m_adapter.getFilter().filter(s.toString());
                            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();

                            for(HashMap<String, String> tmp : list){
                                if(tmp.get("stNm").equals("마곡역")){
                                    String first = tmp.get("rtNm");
                                    String second = tmp.get("stNm");
                                    String third = tmp.get("arrmsg1");
                                    String forth = tmp.get("arrmsg2");
                                    b_bus = new bus(first, second, third, forth);
                                    m_orders2.add(b_bus);
                                    PersonAdapter m_adapter2 = new PersonAdapter(getApplicationContext(), R.layout.busrow, m_orders2);
                                    setListAdapter(m_adapter2);
                                }
                            }


                        }
                    });


                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            */


        }


    };





    public String findRouteId(ArrayList<busLine> morders,int num){
        String finish = "잘못 입력하였습니다";
        for(int i=0; i<morders.size(); i++) {
            if(morders.get(i).getBusRouteNm() == num ){
                Toast.makeText(getApplicationContext(),"파인드루트들어감",Toast.LENGTH_LONG).show();
                return morders.get(i).getBusRouteId();
            }
        }
        Toast.makeText(getApplicationContext(),"파인드루트탈출",Toast.LENGTH_LONG).show();
        return finish;
    }




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