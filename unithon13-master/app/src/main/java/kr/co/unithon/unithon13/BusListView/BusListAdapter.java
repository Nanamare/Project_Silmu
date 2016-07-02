package kr.co.unithon.unithon13.BusListView;

/**
 * Created by nanamare on 2016-05-12.
 */


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
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
import kr.co.unithon.unithon13.DBManager.DBManager;
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
    static String db_busrouteid;
    static String name;
    static String db_Stnm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buslistview);
        myButton = (Button)findViewById(R.id.myBtn);
        searchet = (EditText) findViewById(R.id.searchet);
            //삽입
        morders.add(new busLine("100100411","6000"));
        morders.add(new busLine("100100412","6001"));
        morders.add(new busLine("100100413","6002"));
        morders.add(new busLine("100100414","6003"));
        morders.add(new busLine("100100415","6004"));
        morders.add(new busLine("100100416","6005"));
        morders.add(new busLine("100100506","6006"));
        morders.add(new busLine("100100417","6008"));
        morders.add(new busLine("100100507","6009"));
        morders.add(new busLine("100100584","6010"));
        morders.add(new busLine("100100418","6011"));
        morders.add(new busLine("100100419","6012"));
        morders.add(new busLine("100100420","6013"));
        morders.add(new busLine("100100421","6014"));
        morders.add(new busLine("100100422","6015"));
        morders.add(new busLine("100100423","6016"));
        morders.add(new busLine("100100533","6017"));
        morders.add(new busLine("100100538","6018"));
        morders.add(new busLine("115000006","6019"));
        morders.add(new busLine("100100509","6020"));
        morders.add(new busLine("115000001","6021"));
        morders.add(new busLine("100100517","6030"));
        morders.add(new busLine("100100513","6100"));
        morders.add(new busLine("100100373","6101"));
        morders.add(new busLine("124000013","6103"));
        morders.add(new busLine("124000012","6104"));
        morders.add(new busLine("124000011","6105"));
        morders.add(new busLine("124000006","6200"));
        morders.add(new busLine("100100508","6300"));
        morders.add(new busLine("124000009","6500"));
        morders.add(new busLine("100100567","6701"));
        morders.add(new busLine("100100573","6702"));
        morders.add(new busLine("100100572","6703"));
        morders.add(new busLine("100100571","6704"));
        morders.add(new busLine("100100570","6705"));
        morders.add(new busLine("100100569","6706"));
        morders.add(new busLine("100100568","6707A"));
        morders.add(new busLine("115000002","6707B"));
        morders.add(new busLine("122900003","강남01"));
        morders.add(new busLine("122900006","강남02"));
        morders.add(new busLine("122900004","강남03"));
        morders.add(new busLine("122900002","강남05"));
        morders.add(new busLine("122900005","강남06"));
        morders.add(new busLine("122900007","강남06-1"));
        morders.add(new busLine("122900001","강남07"));
        morders.add(new busLine("122900008","강남08"));
        morders.add(new busLine("122900009","강남10"));
        morders.add(new busLine("124900002","강동01"));
        morders.add(new busLine("124900003","강동02"));
        morders.add(new busLine("124900001","강동05"));
        morders.add(new busLine("108900006","강북01"));
        morders.add(new busLine("108900002","강북02"));
        morders.add(new busLine("108900003","강북03"));
        morders.add(new busLine("108900005","강북04"));
        morders.add(new busLine("108900008","강북05"));
        morders.add(new busLine("108900007","강북06"));
        morders.add(new busLine("108900013","강북08"));
        morders.add(new busLine("108900004","강북09"));
        morders.add(new busLine("108900009","강북10"));
        morders.add(new busLine("108900011","강북10-1"));
        morders.add(new busLine("108900001","강북11"));
        morders.add(new busLine("108900012","강북12"));
        morders.add(new busLine("115900006","강서01"));
        morders.add(new busLine("115900003","강서02"));
        morders.add(new busLine("115900004","강서03"));
        morders.add(new busLine("115900001","강서04"));
        morders.add(new busLine("115900005","강서05"));
        morders.add(new busLine("115900008","강서05-1"));
        morders.add(new busLine("115900002","강서06"));
        morders.add(new busLine("115900007","강서07"));
        morders.add(new busLine("241329008","과천06"));
        morders.add(new busLine("120900005","관악01"));
        morders.add(new busLine("120900008","관악02"));
        morders.add(new busLine("120900003","관악03"));
        morders.add(new busLine("120900009","관악04"));
        morders.add(new busLine("120900010","관악05"));
        morders.add(new busLine("120900004","관악06"));
        morders.add(new busLine("120900006","관악07"));
        morders.add(new busLine("120900007","관악08"));
        morders.add(new busLine("120900002","관악10"));
        morders.add(new busLine("114900004","관악11"));
        morders.add(new busLine("241274001","광명01"));
        morders.add(new busLine("241274005","광명02"));
        morders.add(new busLine("241274004","광명1-3"));
        morders.add(new busLine("104900005","광진01"));
        morders.add(new busLine("104900003","광진02"));
        morders.add(new busLine("104900002","광진03"));
        morders.add(new busLine("104900001","광진04"));
        morders.add(new busLine("104900004","광진05"));
        morders.add(new busLine("116900013","구로01"));
        morders.add(new busLine("116900014","구로02"));
        morders.add(new busLine("116900010","구로03"));
        morders.add(new busLine("116900011","구로04"));
        morders.add(new busLine("116900009","구로05"));
        morders.add(new busLine("116900012","구로06"));
        morders.add(new busLine("116900006","구로07"));
        morders.add(new busLine("116900015","구로08"));
        morders.add(new busLine("116900007","구로09"));
        morders.add(new busLine("116900003","구로10"));
        morders.add(new busLine("116900004","구로11"));
        morders.add(new busLine("116900002","구로12"));
        morders.add(new busLine("116900001","구로13"));
        morders.add(new busLine("116900005","구로14"));
        morders.add(new busLine("116900016","구로15"));
        morders.add(new busLine("117900008","금천01"));
        morders.add(new busLine("117900006","금천02"));
        morders.add(new busLine("117900003","금천03"));
        morders.add(new busLine("117900002","금천04"));
        morders.add(new busLine("117900001","금천05"));
        morders.add(new busLine("117900004","금천06"));
        morders.add(new busLine("117900007","금천07"));
        morders.add(new busLine("117900005","금천08"));
        morders.add(new busLine("117900009","금천09"));
        morders.add(new busLine("117900010","금천11"));
        morders.add(new busLine("117900012","금천11-1"));
        morders.add(new busLine("241350001","남양주33"));
        morders.add(new busLine("241350002","남양주33-1"));
        morders.add(new busLine("241347002","남양주80"));
        morders.add(new busLine("241347005","남양주82A"));
        morders.add(new busLine("241347006","남양주82B"));
        morders.add(new busLine("241350003","남양주85"));
        morders.add(new busLine("110900004","노원01"));
        morders.add(new busLine("207900001","노원02"));
        morders.add(new busLine("110900005","노원03"));
        morders.add(new busLine("110900001","노원04"));
        morders.add(new busLine("110900003","노원05"));
        morders.add(new busLine("110900007","노원08"));
        morders.add(new busLine("110900006","노원09"));
        morders.add(new busLine("110900002","노원11"));
        morders.add(new busLine("110900008","노원13"));
        morders.add(new busLine("109900011","노원14"));
        morders.add(new busLine("109900010","노원15"));
        morders.add(new busLine("109900001","도봉01"));
        morders.add(new busLine("108900010","도봉02"));
        morders.add(new busLine("109900007","도봉03"));
        morders.add(new busLine("109900008","도봉04"));
        morders.add(new busLine("109900004","도봉05"));
        morders.add(new busLine("109900003","도봉06"));
        morders.add(new busLine("109900002","도봉07"));
        morders.add(new busLine("109900006","도봉08"));
        morders.add(new busLine("109900005","도봉09"));
        morders.add(new busLine("105900003","동대문01"));
        morders.add(new busLine("105900002","동대문02"));
        morders.add(new busLine("105900006","동대문03"));
        morders.add(new busLine("105900001","동대문05"));
        morders.add(new busLine("119900007","동작01"));
        morders.add(new busLine("119900013","동작02"));
        morders.add(new busLine("119900020","동작03"));
        morders.add(new busLine("119900022","동작05"));
        morders.add(new busLine("119900023","동작05-1"));
        morders.add(new busLine("119900014","동작06"));
        morders.add(new busLine("119900018","동작07"));
        morders.add(new busLine("119900009","동작08"));
        morders.add(new busLine("119900019","동작09"));
        morders.add(new busLine("119900006","동작10"));
        morders.add(new busLine("119900011","동작11"));
        morders.add(new busLine("119900021","동작12"));
        morders.add(new busLine("120900001","동작13"));
        morders.add(new busLine("119900025","동작13-1"));
        morders.add(new busLine("119900012","동작14"));
        morders.add(new busLine("119900010","동작15"));
        morders.add(new busLine("119900017","동작16"));
        morders.add(new busLine("119900016","동작17"));
        morders.add(new busLine("119900015","동작18"));
        morders.add(new busLine("119900008","동작19"));
        morders.add(new busLine("119900001","동작20"));
        morders.add(new busLine("119900024","동작21"));
        morders.add(new busLine("102900001","마포01"));
        morders.add(new busLine("113900005","마포02"));
        morders.add(new busLine("113900002","마포03"));
        morders.add(new busLine("113900011","마포05"));
        morders.add(new busLine("113900012","마포06"));
        morders.add(new busLine("113900010","마포07"));
        morders.add(new busLine("113900013","마포08"));
        morders.add(new busLine("113900015","마포09"));
        morders.add(new busLine("113900008","마포10"));
        morders.add(new busLine("113900004","마포11"));
        morders.add(new busLine("113900003","마포12"));
        morders.add(new busLine("113900007","마포13"));
        morders.add(new busLine("113900006","마포14"));
        morders.add(new busLine("113900014","마포15"));
        morders.add(new busLine("113900009","마포16"));
        morders.add(new busLine("113900001","마포17"));
        morders.add(new busLine("113900016","마포18"));
        morders.add(new busLine("112900010","서대문01"));
        morders.add(new busLine("112900014","서대문02대"));
        morders.add(new busLine("112900015","서대문02소"));
        morders.add(new busLine("112900004","서대문03"));
        morders.add(new busLine("112900011","서대문04"));
        morders.add(new busLine("112900009","서대문05"));
        morders.add(new busLine("112900007","서대문06"));
        morders.add(new busLine("112900003","서대문07"));
        morders.add(new busLine("100900012","서대문08"));
        morders.add(new busLine("112900012","서대문09대"));
        morders.add(new busLine("112900013","서대문09소"));
        morders.add(new busLine("112900001","서대문10"));
        morders.add(new busLine("112900006","서대문11"));
        morders.add(new busLine("112900002","서대문12"));
        morders.add(new busLine("112900005","서대문13"));
        morders.add(new busLine("112900008","서대문14"));
        morders.add(new busLine("121900009","서초01"));
        morders.add(new busLine("121900008","서초02"));
        morders.add(new busLine("121900005","서초03"));
        morders.add(new busLine("119900003","서초05"));
        morders.add(new busLine("119900002","서초06"));
        morders.add(new busLine("121900011","서초07"));
        morders.add(new busLine("121900002","서초08"));
        morders.add(new busLine("121900007","서초09"));
        morders.add(new busLine("121900003","서초10"));
        morders.add(new busLine("121900006","서초11"));
        morders.add(new busLine("121900013","서초13"));
        morders.add(new busLine("121900010","서초14"));
        morders.add(new busLine("121900012","서초15"));
        morders.add(new busLine("119900005","서초16"));
        morders.add(new busLine("119900004","서초17"));
        morders.add(new busLine("220900001","서초18"));
        morders.add(new busLine("121900015","서초18-1"));
        morders.add(new busLine("121900004","서초20"));
        morders.add(new busLine("121900001","서초21"));
        morders.add(new busLine("121900014","서초22"));
        morders.add(new busLine("241216002","성남21"));
        morders.add(new busLine("103900003","성동01"));
        morders.add(new busLine("103900004","성동02"));
        morders.add(new busLine("103900006","성동03"));
        morders.add(new busLine("101900001","성동05"));
        morders.add(new busLine("103900007","성동06"));
        morders.add(new busLine("103900005","성동07"));
        morders.add(new busLine("103900002","성동08"));
        morders.add(new busLine("103900001","성동09"));
        morders.add(new busLine("103900008","성동10"));
        morders.add(new busLine("103900009","성동12"));
        morders.add(new busLine("107900008","성북01"));
        morders.add(new busLine("107900003","성북02"));
        morders.add(new busLine("107900002","성북03"));
        morders.add(new busLine("107900005","성북04"));
        morders.add(new busLine("107900011","성북05"));
        morders.add(new busLine("107900012","성북06"));
        morders.add(new busLine("107900013","성북07"));
        morders.add(new busLine("107900007","성북08"));
        morders.add(new busLine("107900006","성북09"));
        morders.add(new busLine("107900014","성북10"));
        morders.add(new busLine("107900004","성북12"));
        morders.add(new busLine("107900001","성북13"));
        morders.add(new busLine("107900010","성북14"));
        morders.add(new busLine("107900015","성북15"));
        morders.add(new busLine("105900004","성북20"));
        morders.add(new busLine("105900005","성북21"));
        morders.add(new busLine("107900009","성북22"));
        morders.add(new busLine("241252003","안양6-3"));
        morders.add(new busLine("241449011","양주15-1긴급"));
        morders.add(new busLine("241449007","양주15-1막차"));
        morders.add(new busLine("114900001","양천01"));
        morders.add(new busLine("114900002","양천02"));
        morders.add(new busLine("114900003","양천03"));
        morders.add(new busLine("116900018","양천04"));
        morders.add(new busLine("116900008","영등포01"));
        morders.add(new busLine("118900004","영등포02"));
        morders.add(new busLine("118900005","영등포03"));
        morders.add(new busLine("118900001","영등포04"));
        morders.add(new busLine("118900006","영등포05"));
        morders.add(new busLine("118900003","영등포06"));
        morders.add(new busLine("118900002","영등포07"));
        morders.add(new busLine("118900007","영등포08"));
        morders.add(new busLine("116900017","영등포09"));
        morders.add(new busLine("118900008","영등포10"));
        morders.add(new busLine("118900009","영등포11"));
        morders.add(new busLine("102900003","용산01"));
        morders.add(new busLine("102900002","용산02"));
        morders.add(new busLine("102900004","용산03"));
        morders.add(new busLine("101900002","용산04"));
        morders.add(new busLine("111900002","은평01"));
        morders.add(new busLine("111900003","은평02"));
        morders.add(new busLine("111900001","은평03"));
        morders.add(new busLine("111900004","은평04"));
        morders.add(new busLine("111900005","은평05"));
        morders.add(new busLine("111900007","은평06"));
        morders.add(new busLine("111900006","은평07"));
        morders.add(new busLine("111900008","은평08"));
        morders.add(new busLine("111900009","은평09"));
        morders.add(new busLine("111900010","은평10"));
        morders.add(new busLine("100900006","종로01"));
        morders.add(new busLine("100900008","종로02"));
        morders.add(new busLine("100900010","종로03"));
        morders.add(new busLine("100900011","종로05"));
        morders.add(new busLine("100900001","종로06"));
        morders.add(new busLine("100900004","종로07"));
        morders.add(new busLine("100900005","종로08"));
        morders.add(new busLine("100900003","종로09"));
        morders.add(new busLine("100900007","종로11"));
        morders.add(new busLine("100900009","종로12"));
        morders.add(new busLine("100900002","종로13"));
        morders.add(new busLine("106900001","중랑01"));
        morders.add(new busLine("106900002","중랑02"));
        morders.add(new busLine("241411001","하남01"));
        morders.add(new busLine("241412004","하남05"));
        morders.add(new busLine("241409005","하남07"));
        morders.add(new busLine("241409006","하남08"));
        morders.add(new busLine("241409004","하남6-1"));
        morders.add(new busLine("241412001","하남7-1"));
        morders.add(new busLine("100100549","100"));
        morders.add(new busLine("100100006","101"));
        morders.add(new busLine("100100007","102"));
        morders.add(new busLine("100100008","103"));
        morders.add(new busLine("100100009","104"));
        morders.add(new busLine("100100010","105"));
        morders.add(new busLine("100100011","106"));
        morders.add(new busLine("100100012","107"));
        morders.add(new busLine("100100013","108"));
        morders.add(new busLine("100100014","109"));
        morders.add(new busLine("100100016","110A고려대"));
        morders.add(new busLine("100100015","110B국민대"));
        morders.add(new busLine("100100017","120"));
        morders.add(new busLine("100100583","121"));
        morders.add(new busLine("100100018","130"));
        morders.add(new busLine("100100019","140"));
        morders.add(new busLine("100100020","141"));
        morders.add(new busLine("100100021","142"));
        morders.add(new busLine("100100022","143"));
        morders.add(new busLine("100100023","144"));
        morders.add(new busLine("100100024","145"));
        morders.add(new busLine("100100025","146"));
        morders.add(new busLine("100100026","147"));
        morders.add(new busLine("100100027","148"));
        morders.add(new busLine("100100029","150"));
        morders.add(new busLine("100100030","151"));
        morders.add(new busLine("100100031","152"));
        morders.add(new busLine("100100032","153"));
        morders.add(new busLine("100100033","160"));
        morders.add(new busLine("100100034","162"));
        morders.add(new busLine("100100035","163"));
        morders.add(new busLine("100100036","171"));
        morders.add(new busLine("100100037","172"));
        morders.add(new busLine("100100038","201"));
        morders.add(new busLine("100100039","202"));
        morders.add(new busLine("100100407","240"));
        morders.add(new busLine("100100595","241"));
        morders.add(new busLine("104000006","242"));
        morders.add(new busLine("100100042","260"));
        morders.add(new busLine("100100043","261"));
        morders.add(new busLine("100100044","262"));
        morders.add(new busLine("100100046","270"));
        morders.add(new busLine("100100047","271"));
        morders.add(new busLine("100100048","272"));
        morders.add(new busLine("100100049","273"));
        morders.add(new busLine("100100051","301"));
        morders.add(new busLine("100100052","302"));
        morders.add(new busLine("100100053","303"));
        morders.add(new busLine("100100564","320"));
        morders.add(new busLine("100100496","333"));
        morders.add(new busLine("100100055","340"));
        morders.add(new busLine("100100056","341"));
        morders.add(new busLine("100100553","350"));
        morders.add(new busLine("100100582","351"));
        morders.add(new busLine("100100057","360"));
        morders.add(new busLine("124000036","362"));
        morders.add(new busLine("100100061","370"));
        morders.add(new busLine("100100596","400"));
        morders.add(new busLine("100100062","401"));
        morders.add(new busLine("100100063","402"));
        morders.add(new busLine("100100597","405"));
        morders.add(new busLine("100100064","406"));
        morders.add(new busLine("100100461","407"));
        morders.add(new busLine("100100068","420"));
        morders.add(new busLine("100100409","421"));
        morders.add(new busLine("100100459","440"));
        morders.add(new busLine("100100070","441"));
        morders.add(new busLine("100100071","461"));
        morders.add(new busLine("100100458","462"));
        morders.add(new busLine("100100605","463"));
        morders.add(new busLine("100100073","470"));
        morders.add(new busLine("100100074","471"));
        morders.add(new busLine("100100075","472"));
        morders.add(new busLine("100100076","500"));
        morders.add(new busLine("100100077","501"));
        morders.add(new busLine("100100410","502"));
        morders.add(new busLine("100100078","503"));
        morders.add(new busLine("100100079","504"));
        morders.add(new busLine("100100080","505"));
        morders.add(new busLine("100100081","506"));
        morders.add(new busLine("100100082","507"));
        morders.add(new busLine("100100083","540"));
        morders.add(new busLine("100100574","541"));
        morders.add(new busLine("100100603","542"));
        morders.add(new busLine("100100084","571"));
        morders.add(new busLine("100100085","600"));
        morders.add(new busLine("100100086","601"));
        morders.add(new busLine("100100087","602"));
        morders.add(new busLine("100100088","603"));
        morders.add(new busLine("100100089","604"));
        morders.add(new busLine("100100090","605"));
        morders.add(new busLine("100100091","606"));
        morders.add(new busLine("100100093","640"));
        morders.add(new busLine("100100094","641"));
        morders.add(new busLine("100100095","642"));
        morders.add(new busLine("100100096","643"));
        morders.add(new busLine("100100097","650"));
        morders.add(new busLine("100100098","651"));
        morders.add(new busLine("100100099","652"));
        morders.add(new busLine("100100497","653"));
        morders.add(new busLine("100100102","661"));
        morders.add(new busLine("100100550","662"));
        morders.add(new busLine("100100436","670"));
        morders.add(new busLine("100100495","672"));
        morders.add(new busLine("100100551","673"));
        morders.add(new busLine("100100440","700"));
        morders.add(new busLine("100100103","701"));
        morders.add(new busLine("100100104","702A서오릉"));
        morders.add(new busLine("100100105","702B용두초교"));
        morders.add(new busLine("100100106","703"));
        morders.add(new busLine("100100107","704"));
        morders.add(new busLine("100100587","705"));
        morders.add(new busLine("100100108","706"));
        morders.add(new busLine("100100511","707"));
        morders.add(new busLine("100100110","710"));
        morders.add(new busLine("100100111","720"));
        morders.add(new busLine("100100112","721"));
        morders.add(new busLine("100100537","740"));
        morders.add(new busLine("100100114","750A"));
        morders.add(new busLine("100100565","750B"));
        morders.add(new busLine("100100116","751"));
        morders.add(new busLine("100100117","752"));
        morders.add(new busLine("100100118","753"));
        morders.add(new busLine("100100119","760"));
        morders.add(new busLine("100100437","771"));
        morders.add(new busLine("100100593","N13"));
        morders.add(new busLine("100100610","N15"));
        morders.add(new busLine("100100592","N16"));
        morders.add(new busLine("100100586","N26"));
        morders.add(new busLine("100100591","N30"));
        morders.add(new busLine("100100585","N37"));
        morders.add(new busLine("100100589","N61"));
        morders.add(new busLine("100100588","N62"));
        morders.add(new busLine("100100124","0017"));
        morders.add(new busLine("100100129","1014"));
        morders.add(new busLine("100100130","1017"));
        morders.add(new busLine("100100131","1020"));
        morders.add(new busLine("100100132","1111"));
        morders.add(new busLine("100100133","1113"));
        morders.add(new busLine("100100134","1114"));
        morders.add(new busLine("100100566","1115"));
        morders.add(new busLine("100100137","1119"));
        morders.add(new busLine("100100138","1120"));
        morders.add(new busLine("100100425","1122"));
        morders.add(new busLine("100100139","1124"));
        morders.add(new busLine("100100142","1126"));
        morders.add(new busLine("100100143","1127"));
        morders.add(new busLine("100100144","1128"));
        morders.add(new busLine("100100145","1129"));
        morders.add(new busLine("100100146","1130"));
        morders.add(new busLine("100100147","1131"));
        morders.add(new busLine("100100148","1132"));
        morders.add(new busLine("100100149","1133"));
        morders.add(new busLine("100100150","1135"));
        morders.add(new busLine("100100151","1136"));
        morders.add(new busLine("100100152","1137"));
        morders.add(new busLine("100100153","1138"));
        morders.add(new busLine("100100154","1139"));
        morders.add(new busLine("100100155","1140"));
        morders.add(new busLine("100100156","1141"));
        morders.add(new busLine("100100157","1142"));
        morders.add(new busLine("100100158","1143"));
        morders.add(new busLine("100100159","1144"));
        morders.add(new busLine("100100164","1154"));
        morders.add(new busLine("100100165","1155"));
        morders.add(new busLine("100100166","1156"));
        morders.add(new busLine("100100170","1162"));
        morders.add(new busLine("100100171","1164"));
        morders.add(new busLine("100100172","1165"));
        morders.add(new busLine("100100173","1166"));
        morders.add(new busLine("100100175","1213"));
        morders.add(new busLine("100100177","1218"));
        morders.add(new busLine("100100178","1221"));
        morders.add(new busLine("100100179","1222"));
        morders.add(new busLine("100100181","1224"));
        morders.add(new busLine("100100183","1226"));
        morders.add(new busLine("100100184","1227"));
        morders.add(new busLine("100100185","1711"));
        morders.add(new busLine("100100186","2012"));
        morders.add(new busLine("100100188","2013"));
        morders.add(new busLine("100100189","2014"));
        morders.add(new busLine("100100190","2015"));
        morders.add(new busLine("100100522","2016"));
        morders.add(new busLine("100100191","2112"));
        morders.add(new busLine("100100192","2113"));
        morders.add(new busLine("100100193","2114"));
        morders.add(new busLine("100100598","2115"));
        morders.add(new busLine("100100194","2211"));
        morders.add(new busLine("100100198","2221"));
        morders.add(new busLine("100100199","2222"));
        morders.add(new busLine("100100201","2224"));
        morders.add(new busLine("100100202","2227"));
        morders.add(new busLine("100100203","2230"));
        morders.add(new busLine("100100204","2233"));
        morders.add(new busLine("100100205","2234"));
        morders.add(new busLine("100100206","2235"));
        morders.add(new busLine("100100599","2311"));
        morders.add(new busLine("100100611","2312"));
        morders.add(new busLine("100100209","2412"));
        morders.add(new busLine("100100210","2413"));
        morders.add(new busLine("100100211","2415"));
        morders.add(new busLine("100100438","3011"));
        morders.add(new busLine("100100579","3012"));
        morders.add(new busLine("100100212","3212"));
        morders.add(new busLine("100100213","3214"));
        morders.add(new busLine("100100215","3216"));
        morders.add(new busLine("100100216","3217"));
        morders.add(new busLine("100100218","3220"));
        morders.add(new busLine("100100219","3313"));
        morders.add(new busLine("100100220","3314"));
        morders.add(new busLine("100100221","3315"));
        morders.add(new busLine("100100222","3316"));
        morders.add(new busLine("100100478","3317"));
        morders.add(new busLine("100100498","3318"));
        morders.add(new busLine("100100501","3319"));
        morders.add(new busLine("100100578","3321"));
        morders.add(new busLine("100100613","3322"));
        morders.add(new busLine("100100223","3411"));
        morders.add(new busLine("100100224","3412"));
        morders.add(new busLine("100100225","3413"));
        morders.add(new busLine("100100226","3414"));
        morders.add(new busLine("100100228","3416"));
        morders.add(new busLine("100100229","3417"));
        morders.add(new busLine("100100232","3422"));
        morders.add(new busLine("100100609","3425"));
        morders.add(new busLine("100100612","3426"));
        morders.add(new busLine("100100604","4211"));
        morders.add(new busLine("100100234","4212"));
        morders.add(new busLine("100100237","4318"));
        morders.add(new busLine("100100427","4319"));
        morders.add(new busLine("100100500","4412"));
        morders.add(new busLine("100100454","4419"));
        morders.add(new busLine("100100246","4432"));
        morders.add(new busLine("100100247","4433"));
        morders.add(new busLine("122000001","4435"));
        morders.add(new busLine("100100248","5012"));
        morders.add(new busLine("100100249","5413"));
        morders.add(new busLine("100100250","5511"));
        morders.add(new busLine("100100251","5513"));
        morders.add(new busLine("100100252","5515"));
        morders.add(new busLine("100100253","5516"));
        morders.add(new busLine("100100254","5517"));
        morders.add(new busLine("100100255","5519"));
        morders.add(new busLine("100100257","5522A난곡"));
        morders.add(new busLine("100100258","5522B호암"));
        morders.add(new busLine("100100259","5523"));
        morders.add(new busLine("100100260","5524"));
        morders.add(new busLine("100100261","5525"));
        morders.add(new busLine("100100263","5528"));
        morders.add(new busLine("100100264","5530"));
        morders.add(new busLine("100100265","5531"));
        morders.add(new busLine("100100266","5534"));
        morders.add(new busLine("100100267","5535"));
        morders.add(new busLine("100100268","5536"));
        morders.add(new busLine("100100269","5537"));
        morders.add(new busLine("100100272","5615"));
        morders.add(new busLine("100100273","5616"));
        morders.add(new busLine("100100274","5617"));
        morders.add(new busLine("100100275","5618"));
        morders.add(new busLine("100100276","5619"));
        morders.add(new busLine("100100277","5620"));
        morders.add(new busLine("100100278","5621"));
        morders.add(new busLine("100100279","5623"));
        morders.add(new busLine("100100280","5624"));
        morders.add(new busLine("100100281","5625"));
        morders.add(new busLine("100100282","5626"));
        morders.add(new busLine("100100283","5627"));
        morders.add(new busLine("100100284","5630"));
        morders.add(new busLine("100100285","5633"));
        morders.add(new busLine("100100286","5712"));
        morders.add(new busLine("100100287","5713"));
        morders.add(new busLine("100100288","5714"));
        morders.add(new busLine("100100289","6211"));
        morders.add(new busLine("100100290","6411"));
        morders.add(new busLine("100100291","6511"));
        morders.add(new busLine("100100292","6512"));
        morders.add(new busLine("100100293","6513"));
        morders.add(new busLine("100100294","6514"));
        morders.add(new busLine("100100521","6515"));
        morders.add(new busLine("100100576","6516"));
        morders.add(new busLine("100100295","6611"));
        morders.add(new busLine("100100453","6613"));
        morders.add(new busLine("100100297","6614"));
        morders.add(new busLine("100100298","6616"));
        morders.add(new busLine("100100299","6617"));
        morders.add(new busLine("100100300","6620"));
        morders.add(new busLine("100100301","6623"));
        morders.add(new busLine("100100302","6624"));
        morders.add(new busLine("100100303","6625"));
        morders.add(new busLine("100100304","6627"));
        morders.add(new busLine("100100305","6628"));
        morders.add(new busLine("100100306","6629"));
        morders.add(new busLine("100100307","6630"));
        morders.add(new busLine("100100308","6631"));
        morders.add(new busLine("100100309","6632"));
        morders.add(new busLine("100100311","6635"));
        morders.add(new busLine("100100312","6637"));
        morders.add(new busLine("100100313","6638"));
        morders.add(new busLine("100100601","6640A"));
        morders.add(new busLine("100100602","6640B"));
        morders.add(new busLine("100100316","6642"));
        morders.add(new busLine("100100317","6643"));
        morders.add(new busLine("100100318","6645"));
        morders.add(new busLine("100100320","6647"));
        morders.add(new busLine("115000005","6648"));
        morders.add(new busLine("100100322","6649"));
        morders.add(new busLine("100100323","6650"));
        morders.add(new busLine("100100324","6651"));
        morders.add(new busLine("100100329","6657"));
        morders.add(new busLine("100100330","6712"));
        morders.add(new busLine("100100331","6714"));
        morders.add(new busLine("100100332","6715"));
        morders.add(new busLine("100100451","6716"));
        morders.add(new busLine("100100450","7011"));
        morders.add(new busLine("100100449","7013A"));
        morders.add(new busLine("100100448","7013B"));
        morders.add(new busLine("100100447","7016"));
        morders.add(new busLine("100100337","7017"));
        morders.add(new busLine("100100338","7018"));
        morders.add(new busLine("100100339","7019"));
        morders.add(new busLine("100100340","7021"));
        morders.add(new busLine("100100341","7022"));
        morders.add(new busLine("100100342","7024"));
        morders.add(new busLine("100100446","7025"));
        morders.add(new busLine("100100344","7211"));
        morders.add(new busLine("100100499","7212"));
        morders.add(new busLine("100100345","7611"));
        morders.add(new busLine("100100346","7612"));
        morders.add(new busLine("100100347","7613"));
        morders.add(new busLine("100100348","7711"));
        morders.add(new busLine("100100349","7713"));
        morders.add(new busLine("100100548","7714"));
        morders.add(new busLine("100100462","7715"));
        morders.add(new busLine("124000008","7719"));
        morders.add(new busLine("100100352","7720"));
        morders.add(new busLine("100100353","7722"));
        morders.add(new busLine("100100354","7723"));
        morders.add(new busLine("100100357","7726"));
        morders.add(new busLine("100100358","7727"));
        morders.add(new busLine("100100359","7728"));
        morders.add(new busLine("100100360","7730"));
        morders.add(new busLine("100100362","7733"));
        morders.add(new busLine("100100363","7737"));
        morders.add(new busLine("100100364","7738"));
        morders.add(new busLine("100100552","7739"));
        morders.add(new busLine("100000004","8001"));
        morders.add(new busLine("100100370","8111"));
        morders.add(new busLine("100100383","8541"));
        morders.add(new busLine("100100525","8772"));
        morders.add(new busLine("100100387","8774"));
        morders.add(new busLine("100100001","02"));
        morders.add(new busLine("100100002","03"));
        morders.add(new busLine("100100003","05"));
        morders.add(new busLine("124000007","8663"));
        morders.add(new busLine("100100514","90S투어"));
        morders.add(new busLine("100100389","9401"));
        morders.add(new busLine("100100390","9403"));
        morders.add(new busLine("100100391","9404"));
        morders.add(new busLine("100100392","9408"));
        morders.add(new busLine("100100397","9701"));
        morders.add(new busLine("100100398","9703"));
        morders.add(new busLine("100100400","9707"));
        morders.add(new busLine("100100402","9709"));
        morders.add(new busLine("100100607","9711A"));
        morders.add(new busLine("100100606","9711B"));
        morders.add(new busLine("100100406","9714"));
        morders.add(new busLine("165000145","1000인천"));
        morders.add(new busLine("165000146","1100인천"));
        morders.add(new busLine("165000147","1101인천"));
        morders.add(new busLine("165000412","117인천"));
        morders.add(new busLine("165000148","1200인천"));
        morders.add(new busLine("165000149","1300인천"));
        morders.add(new busLine("165000150","1301인천"));
        morders.add(new busLine("165000421","1302인천"));
        morders.add(new busLine("165000151","1400인천"));
        morders.add(new busLine("165000152","1500인천"));
        morders.add(new busLine("165000154","1601인천"));
        morders.add(new busLine("165000158","2500인천"));
        morders.add(new busLine("165000064","300인천"));
        morders.add(new busLine("165000391","60-5인천"));
        morders.add(new busLine("165000335","6118인천"));
        morders.add(new busLine("165000215","6405인천"));
        morders.add(new busLine("165000409","6628인천"));
        morders.add(new busLine("165000240","66인천"));
        morders.add(new busLine("165000381","6724인천"));
        morders.add(new busLine("165000377","7700인천"));
        morders.add(new busLine("165000052","78인천"));
        morders.add(new busLine("165000160","9100인천"));
        morders.add(new busLine("165000161","9200인천"));
        morders.add(new busLine("165000245","9201인천"));
        morders.add(new busLine("165000162","9300인천"));
        morders.add(new busLine("165000163","9500인천"));
        morders.add(new busLine("165000164","9501인천"));
        morders.add(new busLine("165000303","9802인천"));
        morders.add(new busLine("208000024","1-1안양"));
        morders.add(new busLine("207000009","1-1의정부"));
        morders.add(new busLine("207000080","1-2의정부"));
        morders.add(new busLine("207000088","1-3의정부"));
        morders.add(new busLine("222000032","1-4남양주"));
        morders.add(new busLine("207000004","10-1의정부"));
        morders.add(new busLine("207000085","10-2의정부"));
        morders.add(new busLine("234000028","10-5광주"));
        morders.add(new busLine("234001511","1000-1광주"));
        morders.add(new busLine("219000013","1000고양"));
        morders.add(new busLine("221000003","1000구리"));
        morders.add(new busLine("218000007","1001고양"));
        morders.add(new busLine("222000107","1001남양주"));
        morders.add(new busLine("232000006","1002김포"));
        morders.add(new busLine("204000080","1002성남"));
        morders.add(new busLine("233000140","1002화성"));
        morders.add(new busLine("241000910","1004"));
        morders.add(new busLine("232000073","1004김포"));
        morders.add(new busLine("234000074","1005-1광주"));
        morders.add(new busLine("234000065","1005광주"));
        morders.add(new busLine("234000013","1007-1광주"));
        morders.add(new busLine("234000015","1007광주"));
        morders.add(new busLine("233000125","1008화성"));
        morders.add(new busLine("234000310","1009광주"));
        morders.add(new busLine("213000012","100광명"));
        morders.add(new busLine("234000873","100광주"));
        morders.add(new busLine("204000018","100성남"));
        morders.add(new busLine("204000083","100출성남"));
        morders.add(new busLine("229000030","100파주"));
        morders.add(new busLine("213000016","101광명"));
        morders.add(new busLine("228000179","101용인"));
        morders.add(new busLine("206000007","102성남"));
        morders.add(new busLine("204000060","103성남"));
        morders.add(new busLine("219000006","1082고양"));
        morders.add(new busLine("219000007","108고양"));
        morders.add(new busLine("222000082","10남양주"));
        morders.add(new busLine("212000003","10부천"));
        morders.add(new busLine("207000003","10의정부"));
        morders.add(new busLine("213000007","11-1광명"));
        morders.add(new busLine("208000003","11-1안양"));
        morders.add(new busLine("213000011","11-2광명"));
        morders.add(new busLine("208000004","11-2안양"));
        morders.add(new busLine("208000006","11-3안양"));
        morders.add(new busLine("208000005","11-5안양"));
        morders.add(new busLine("218000011","1100고양"));
        morders.add(new busLine("222000074","1100남양주"));
        morders.add(new busLine("234000016","1112광주"));
        morders.add(new busLine("234001203","1113-10광주"));
        morders.add(new busLine("234001204","1113-11광주"));
        morders.add(new busLine("234000011","1113-1광주"));
        morders.add(new busLine("234001516","1113-2광주"));
        morders.add(new busLine("234000042","1113광주"));
        morders.add(new busLine("234000031","1115-6광주"));
        morders.add(new busLine("234000069","1117광주"));
        morders.add(new busLine("207000012","111의정부"));
        morders.add(new busLine("222000045","112-1남양주"));
        morders.add(new busLine("227000005","112-5하남"));
        morders.add(new busLine("234000036","112광주"));
        morders.add(new busLine("234000882","1150광주"));
        morders.add(new busLine("204000081","1151성남"));
        morders.add(new busLine("234000037","116광주"));
        morders.add(new busLine("235000020","118양주"));
        morders.add(new busLine("234000040","119광주"));
        morders.add(new busLine("213000008","11광명"));
        morders.add(new busLine("236000050","11포천"));
        morders.add(new busLine("210000002","12-1부천"));
        morders.add(new busLine("207000048","12-3의정부"));
        morders.add(new busLine("222000137","1200-1남양주"));
        morders.add(new busLine("219000016","1200고양"));
        morders.add(new busLine("222000078","1200남양주"));
        morders.add(new busLine("228000181","1241용인"));
        morders.add(new busLine("204000035","1251성남"));
        morders.add(new busLine("210000027","12부천"));
        morders.add(new busLine("234000082","13-2광주"));
        morders.add(new busLine("241001320","1307"));
        morders.add(new busLine("241000810","1310"));
        morders.add(new busLine("234001251","1311광주"));
        morders.add(new busLine("239000110","1330-2가평"));
        morders.add(new busLine("239000024","1330-44가평"));
        morders.add(new busLine("239000111","1330-4가평"));
        morders.add(new busLine("241003280","1336"));
        morders.add(new busLine("207000026","133의정부"));
        morders.add(new busLine("234000072","13광주"));
        morders.add(new busLine("204000073","15-1성남"));
        morders.add(new busLine("234000313","1500-2광주"));
        morders.add(new busLine("218000010","1500고양"));
        morders.add(new busLine("229000041","150파주"));
        morders.add(new busLine("234000324","1550-1광주"));
        morders.add(new busLine("234000139","1550-3광주"));
        morders.add(new busLine("234000136","1550광주"));
        morders.add(new busLine("234001290","1551B광주"));
        morders.add(new busLine("234001138","1551광주"));
        morders.add(new busLine("234001160","1553광주"));
        morders.add(new busLine("234000314","1560광주"));
        morders.add(new busLine("234001271","1570광주"));
        morders.add(new busLine("234000035","15광주"));
        morders.add(new busLine("234000050","1650광주"));
        morders.add(new busLine("222000028","165남양주"));
        morders.add(new busLine("222000048","166-1남양주"));
        morders.add(new busLine("222000049","1660남양주"));
        morders.add(new busLine("222000046","1670남양주"));
        morders.add(new busLine("222000072","167남양주"));
        morders.add(new busLine("234000034","16광주"));
        morders.add(new busLine("222000073","1700남양주"));
        morders.add(new busLine("213000005","17광명"));
        morders.add(new busLine("229000013","17파주"));
        morders.add(new busLine("241000830","1801"));
        morders.add(new busLine("219000027","1900고양"));
        morders.add(new busLine("208000031","19안양"));
        morders.add(new busLine("213000006","1광명"));
        morders.add(new busLine("222000058","1남양주"));
        morders.add(new busLine("208000007","1안양"));
        morders.add(new busLine("222000122","2000-1남양주"));
        morders.add(new busLine("240000007","2000-1양평"));
        morders.add(new busLine("222000128","2000-2남양주"));
        morders.add(new busLine("240000008","2000-2양평"));
        morders.add(new busLine("240000079","2000-3양평"));
        morders.add(new busLine("240000105","2000-4양평"));
        morders.add(new busLine("222000075","2000남양주"));
        morders.add(new busLine("229000021","2000파주"));
        morders.add(new busLine("229000028","200파주"));
        morders.add(new busLine("222000004","202남양주"));
        morders.add(new busLine("232000074","20김포"));
        morders.add(new busLine("213000002","21광명"));
        morders.add(new busLine("229000061","2200파주"));
        morders.add(new busLine("210000028","220부천"));
        morders.add(new busLine("213000010","22광명"));
        morders.add(new busLine("232000070","22김포"));
        morders.add(new busLine("222000013","23남양주"));
        morders.add(new busLine("210000060","23부천"));
        morders.add(new busLine("213000003","27광명"));
        morders.add(new busLine("213000017","2광명"));
        morders.add(new busLine("232000028","2김포"));
        morders.add(new busLine("227000004","30-1하남"));
        morders.add(new busLine("227000006","30-3하남"));
        morders.add(new busLine("227000001","30-5하남"));
        morders.add(new busLine("241004280","3000"));
        morders.add(new busLine("232000061","3000김포"));
        morders.add(new busLine("200000104","3000수원"));
        morders.add(new busLine("241004220","3001"));
        morders.add(new busLine("213000015","3001광명"));
        morders.add(new busLine("241004230","3002"));
        morders.add(new busLine("213000019","3002광명"));
        morders.add(new busLine("200000145","3002수원"));
        morders.add(new busLine("241004250","3003"));
        morders.add(new busLine("200000108","3003수원"));
        morders.add(new busLine("200000110","3007수원"));
        morders.add(new busLine("216000021","301안산"));
        morders.add(new busLine("208000027","3030안양"));
        morders.add(new busLine("234000003","30광주"));
        morders.add(new busLine("229000010","30파주"));
        morders.add(new busLine("227000003","30하남"));
        morders.add(new busLine("236000178","3100-1포천"));
        morders.add(new busLine("216000026","3100안산"));
        morders.add(new busLine("207000070","3100의정부"));
        morders.add(new busLine("216000043","3101안산"));
        morders.add(new busLine("229000027","31파주"));
        morders.add(new busLine("227000017","31하남"));
        morders.add(new busLine("218000005","3200고양"));
        morders.add(new busLine("224000019","3200시흥"));
        morders.add(new busLine("236000149","3200포천"));
        morders.add(new busLine("217000013","320안산"));
        morders.add(new busLine("234000009","32광주"));
        morders.add(new busLine("234000041","330-1광주"));
        morders.add(new busLine("241003600","3300"));
        morders.add(new busLine("229000060","330파주"));
        morders.add(new busLine("229000035","333파주"));
        morders.add(new busLine("210000071","33부천"));
        morders.add(new busLine("229000032","34파주"));
        morders.add(new busLine("236000176","3500포천"));
        morders.add(new busLine("236000190","3600포천"));
        morders.add(new busLine("229000036","360파주"));
        morders.add(new busLine("207000027","36의정부"));
        morders.add(new busLine("207000073","36의정부"));
        morders.add(new busLine("241006020","3700시외"));
        morders.add(new busLine("232000067","388김포"));
        morders.add(new busLine("238000017","39-1연천"));
        morders.add(new busLine("238000020","39-4연천"));
        morders.add(new busLine("200000233","3900전수원"));
        morders.add(new busLine("213000009","39광명"));
        morders.add(new busLine("238000015","39연천"));
        morders.add(new busLine("222000051","3남양주"));
        morders.add(new busLine("210000013","3부천"));
        morders.add(new busLine("241004710","4300"));
        morders.add(new busLine("235000018","48양주"));
        morders.add(new busLine("210000003","50-1부천"));
        morders.add(new busLine("234000079","500-1광주"));
        morders.add(new busLine("234000075","500-2광주"));
        morders.add(new busLine("234000077","500-5광주"));
        morders.add(new busLine("228000174","5000용인"));
        morders.add(new busLine("228000177","5001-1용인"));
        morders.add(new busLine("228000176","5001용인"));
        morders.add(new busLine("228000183","5002용인"));
        morders.add(new busLine("228000182","5003용인"));
        morders.add(new busLine("228000175","5005용인"));
        morders.add(new busLine("228000262","5006용인"));
        morders.add(new busLine("228000263","5007용인"));
        morders.add(new busLine("210000001","50부천"));
        morders.add(new busLine("204000012","50성남"));
        morders.add(new busLine("241005910","5100"));
        morders.add(new busLine("200000115","5100수원"));
        morders.add(new busLine("224000008","510시흥"));
        morders.add(new busLine("222000050","51남양주"));
        morders.add(new busLine("208000017","51안양"));
        morders.add(new busLine("241005940","5200"));
        morders.add(new busLine("224000024","520시흥"));
        morders.add(new busLine("234000071","52광주"));
        morders.add(new busLine("210000009","52부천"));
        morders.add(new busLine("200000193","5300-1수원"));
        morders.add(new busLine("200000175","5300수원"));
        morders.add(new busLine("224000029","530시흥"));
        morders.add(new busLine("234000001","5500-1광주"));
        morders.add(new busLine("234000148","5500-2광주"));
        morders.add(new busLine("234000052","5500광주"));
        morders.add(new busLine("219000008","55고양"));
        morders.add(new busLine("228000184","5600용인"));
        morders.add(new busLine("217000011","5601안산"));
        morders.add(new busLine("216000047","5602안산"));
        morders.add(new busLine("229000039","567파주"));
        morders.add(new busLine("229000087","56파주"));
        morders.add(new busLine("210000052","57-1부천"));
        morders.add(new busLine("228000271","5700용인"));
        morders.add(new busLine("210000040","57부천"));
        morders.add(new busLine("204000005","57성남"));
        morders.add(new busLine("210000069","59-1부천"));
        morders.add(new busLine("210000042","59부천"));
        morders.add(new busLine("234000007","5광주"));
        morders.add(new busLine("208000016","5안양"));
        morders.add(new busLine("207000034","5의정부"));
        morders.add(new busLine("232000025","60-3김포"));
        morders.add(new busLine("233000131","6001화성"));
        morders.add(new busLine("233000142","6002-1화성"));
        morders.add(new busLine("233000136","6002화성"));
        morders.add(new busLine("232000017","60김포"));
        morders.add(new busLine("204000013","60성남"));
        morders.add(new busLine("232000081","6427김포"));
        morders.add(new busLine("222000030","65-1남양주"));
        morders.add(new busLine("234001163","6501광주"));
        morders.add(new busLine("222000031","65남양주"));
        morders.add(new busLine("229000018","66파주"));
        morders.add(new busLine("234000018","6800광주"));
        morders.add(new busLine("234000027","6900광주"));
        morders.add(new busLine("232000016","69김포"));
        morders.add(new busLine("220000012","6과천"));
        morders.add(new busLine("210000022","7-3부천"));
        morders.add(new busLine("210000023","7-4부천"));
        morders.add(new busLine("222000012","7-5남양주"));
        morders.add(new busLine("210000012","70-2부천"));
        morders.add(new busLine("210000036","70-3부천"));
        morders.add(new busLine("200000112","7000수원"));
        morders.add(new busLine("241005760","7000시외"));
        morders.add(new busLine("200000119","7001수원"));
        morders.add(new busLine("241006510","7002"));
        morders.add(new busLine("200000109","7002수원"));
        morders.add(new busLine("234000311","7007-1광주"));
        morders.add(new busLine("222000129","7007-2남양주"));
        morders.add(new busLine("222000076","7007남양주"));
        morders.add(new busLine("210000039","700부천"));
        morders.add(new busLine("241006370","700시외"));
        morders.add(new busLine("222000002","707남양주"));
        morders.add(new busLine("210000034","70부천"));
        morders.add(new busLine("205000001","70성남"));
        morders.add(new busLine("229000072","7111파주"));
        morders.add(new busLine("210000037","71부천"));
        morders.add(new busLine("207000002","72-1의정부"));
        morders.add(new busLine("236000052","72-3포천"));
        morders.add(new busLine("219000021","72고양"));
        morders.add(new busLine("236000048","72포천"));
        morders.add(new busLine("241005960","7300"));
        morders.add(new busLine("222000014","73남양주"));
        morders.add(new busLine("222000125","74남양주"));
        morders.add(new busLine("210000038","75부천"));
        morders.add(new busLine("219000014","770고양"));
        morders.add(new busLine("233000031","7770화성"));
        morders.add(new busLine("233000007","777화성"));
        morders.add(new busLine("233000032","7780화성"));
        morders.add(new busLine("200000149","7790수원"));
        morders.add(new busLine("200000150","7800수원"));
        morders.add(new busLine("200000191","7900수원"));
        morders.add(new busLine("207000021","7의정부"));
        morders.add(new busLine("232000007","8000김포"));
        morders.add(new busLine("222000088","8001남양주"));
        morders.add(new busLine("222000084","8002남양주"));
        morders.add(new busLine("239000104","8005가평"));
        morders.add(new busLine("219000005","800고양"));
        morders.add(new busLine("222000090","8012남양주"));
        morders.add(new busLine("234000878","8100광주"));
        morders.add(new busLine("241000590","8101"));
        morders.add(new busLine("234000879","8101광주"));
        morders.add(new busLine("241000740","8103"));
        morders.add(new busLine("241002610","8105"));
        morders.add(new busLine("204000082","8110성남"));
        morders.add(new busLine("241003770","8113"));
        morders.add(new busLine("241006600","8115"));
        morders.add(new busLine("241003340","8118"));
        morders.add(new busLine("241003320","8131"));
        morders.add(new busLine("241000460","8133"));
        morders.add(new busLine("241000800","8142"));
        morders.add(new busLine("241001340","8146"));
        morders.add(new busLine("241000820","8147"));
        morders.add(new busLine("241000840","8153"));
        morders.add(new busLine("241003400","8154"));
        morders.add(new busLine("233000139","8155화성"));
        morders.add(new busLine("241004890","8165"));
        morders.add(new busLine("227000002","81하남"));
        morders.add(new busLine("234000884","8201광주"));
        morders.add(new busLine("229000017","830파주"));
        morders.add(new busLine("212000002","83부천"));
        morders.add(new busLine("227000015","83하남"));
        morders.add(new busLine("241000300","8433시외"));
        morders.add(new busLine("241004370","8455"));
        morders.add(new busLine("218000002","85-1고양"));
        morders.add(new busLine("233000135","8501화성"));
        morders.add(new busLine("218000001","85고양"));
        morders.add(new busLine("232000047","8600김포"));
        morders.add(new busLine("232000084","8601(예약)김포"));
        morders.add(new busLine("232000072","8601김포"));
        morders.add(new busLine("219000023","870고양"));
        morders.add(new busLine("219000004","871고양"));
        morders.add(new busLine("232000030","88-1김포"));
        morders.add(new busLine("210000074","88-1부천"));
        morders.add(new busLine("200000205","8800수원"));
        morders.add(new busLine("241005980","8829"));
        morders.add(new busLine("241003970","8840"));
        morders.add(new busLine("241005870","8842"));
        morders.add(new busLine("241005880","8843"));
        morders.add(new busLine("241005890","8844"));
        morders.add(new busLine("241005840","8849"));
        morders.add(new busLine("232000029","88김포"));
        morders.add(new busLine("222000008","88남양주"));
        morders.add(new busLine("212000001","88부천"));
        morders.add(new busLine("222000111","9-1남양주"));
        morders.add(new busLine("208000020","9-3안양"));
        morders.add(new busLine("234001574","9000-1광주"));
        morders.add(new busLine("234000002","9000광주"));
        morders.add(new busLine("229000083","9000파주"));
        morders.add(new busLine("234000315","9001광주"));
        morders.add(new busLine("204000046","9003성남"));
        morders.add(new busLine("204000041","9004성남"));
        morders.add(new busLine("204000042","9005성남"));
        morders.add(new busLine("204000070","9007성남"));
        morders.add(new busLine("200000010","900수원"));
        morders.add(new busLine("229000097","9030파주"));
        morders.add(new busLine("241001330","9101"));
        morders.add(new busLine("208000026","917안양"));
        morders.add(new busLine("222000022","91남양주"));
        morders.add(new busLine("219000015","921고양"));
        morders.add(new busLine("234000058","92광주"));
        morders.add(new busLine("234000886","9300광주"));
        morders.add(new busLine("234000309","9301광주"));
        morders.add(new busLine("227000016","9302하남"));
        morders.add(new busLine("222000026","93남양주"));
        morders.add(new busLine("204000024","9407성남"));
        morders.add(new busLine("206000005","9414성남"));
        morders.add(new busLine("204000059","9507성남"));
        morders.add(new busLine("222000052","95남양주"));
        morders.add(new busLine("234001244","9600광주"));
        morders.add(new busLine("204000065","9607성남"));
        morders.add(new busLine("234000029","96광주"));
        morders.add(new busLine("219000026","9700고양"));
        morders.add(new busLine("229000023","9710파주"));
        morders.add(new busLine("222000027","97남양주"));
        morders.add(new busLine("210000075","98부천"));
        morders.add(new busLine("229000071","99파주"));
        morders.add(new busLine("222000009","9남양주"));
        morders.add(new busLine("208000019","9안양"));
        morders.add(new busLine("222000105","M2316남양주"));
        morders.add(new busLine("234001476","M2323광주"));
        morders.add(new busLine("234000875","M4101광주"));
        morders.add(new busLine("234001159","M4102광주"));
        morders.add(new busLine("234001245","M4108광주"));
        morders.add(new busLine("234000995","M4403광주"));
        morders.add(new busLine("234001243","M5107광주"));
        morders.add(new busLine("234001286","M5115광주"));
        morders.add(new busLine("234001317","M5121광주"));
        morders.add(new busLine("234001285","M5414광주"));
        morders.add(new busLine("234001318","M5422광주"));
        morders.add(new busLine("216000046","M5609안산"));
        morders.add(new busLine("232000071","M6117김포"));
        morders.add(new busLine("216000044","M6410안산"));
        morders.add(new busLine("232000075","M6427김포"));
        morders.add(new busLine("218000012","M7106고양"));
        morders.add(new busLine("229000102","M7111파주"));
        morders.add(new busLine("218000015","M7119고양"));
        morders.add(new busLine("218000020","M7129고양"));
        morders.add(new busLine("234001241","M7412광주"));
        morders.add(new busLine("229000111","M7426파주"));
        morders.add(new busLine("234001242","M7613광주"));



        Intent intent= getIntent();
        //int name = Integer.valueOf(intent.getStringExtra(BusResult.EXTRA_MESSAGE));

        Intent intent2= getIntent();
        //name = Integer.valueOf(intent2.getStringExtra(BusSearch.EXTRA_MESSAGE));
        name = intent.getStringExtra(BusResult.EXTRA_MESSAGE).toString();

        String uri = "http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?ServiceKey=vZBThqOw53T9bJAs97F9pXl7HVr7TM6yZCMW%2BSkhdsCu7m9hJROUYNrr9%2FqUzRL5kA5rHRjGTX9Utyz3l6Vk8w%3D%3D&busRouteId=";
        String routeid = findRouteId(morders,name);
        String furi = "&startOrd=1&endOrd=999&numOfRows=999&pageSize=999&pageNo=1&startPage=1";
        xManager = new XMLManager();//Util 객체 생성
        //xml 문서 다운받기(다운이 완료되었을때 메시지를 받아중 handler객체, 다운받을 url주소)
        xManager.downLoadXML(handler,uri+routeid+furi);
        final DBManager dbManager = new DBManager(getApplicationContext(), "RecentRoute.db", null, 1);
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String str = dayTime.format(new Date(time));
        if(db_busrouteid != null) {
            //dbManager.insert("insert or replace into RecentRoute values (null," + db_busrouteid + ',' + name + ',' + null + ',' + "null," + str + ")");
            if(isRealNumber(name)){
                dbManager.insert("insert or replace into RecentRoute values (null," + db_busrouteid + ',' + name + ',' + null + ',' + "null," + str + ")");
            }
            else{
                dbManager.insert("insert or replace into RecentRoute values (null," + db_busrouteid + ",'" + name + "', '" + null + "' ," + "null," + str + ")");
            }

        }
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
                            db_Stnm = tmp.get("stNm");
                            String first = tmp.get("rtNm");
                            String second = tmp.get("stNm");
                            String third = tmp.get("arrmsg1");
                            String forth = tmp.get("arrmsg2");
                            b_bus = new bus(first, second, third, forth);
                            m_orders2.add(b_bus);
                            PersonAdapter m_adapter2 = new PersonAdapter(getApplicationContext(), R.layout.busrow, m_orders2);
                            setListAdapter(m_adapter2);
                            //db연동
                            final DBManager dbManager = new DBManager(getApplicationContext(), "RecentRoute.db", null, 1);
                            long time = System.currentTimeMillis();
                            SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
                            String str = dayTime.format(new Date(time));
                            if(isRealNumber(name)){
                                dbManager.insert("insert or replace into RecentRoute values (null," + db_busrouteid + ',' + name + ", '" + db_Stnm + "' ," + "null," + str + ")");
                            }
                            else{
                                dbManager.insert("insert or replace into RecentRoute values (null," + db_busrouteid + ",'" + name + "', '" + db_Stnm + "' ," + "null," + str + ")");
                            }
                            //dbManager.update("update RecentRoute set StNm = '" +db_Stnm+ "' WHERE BusRouteId = '" +db_busrouteid+ "';");
                            Log.i("UPDATETEST",String.valueOf(db_Stnm)+"\n"+String.valueOf(db_busrouteid));
                        }
                    }
                }
            });

            //원래 주석 있던 곳

            searchet = (EditText) findViewById(R.id.searchet);
            searchet.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable theWatchedText) {

                }

                public void beforeTextChanged(CharSequence arg0, int arg1,
                                              int arg2, int arg3) {
                }

                @Override
                public void onTextChanged(CharSequence arg0, int start, int after, int count) {
                /*
                Toast.makeText(
                      getApplicationContext(),
                      arg0.toString(),
                      Toast.LENGTH_SHORT
                      ).show();
                 */
                    m_adapter.getFilter().filter(arg0.toString());

                }
            });

            //여기 위에가 내가 주석했던곳

        }




    };

    public static boolean isRealNumber(String s){
        try{
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }

    }

    public static boolean isNumeric(String s){
        return s.matches("[-+]?\\d*\\.?\\d+");
    }


    public String findRouteId(ArrayList<busLine> morders,String num){
        String finish = "잘못 입력하였습니다";
        for(int i=0; i<morders.size(); i++) {
            if(num.equals(morders.get(i).getBusRouteNm())){
                Toast.makeText(getApplicationContext(),"조회중",Toast.LENGTH_LONG).show();
                db_busrouteid = morders.get(i).getBusRouteId();
                return morders.get(i).getBusRouteId();
            }
        }
        Toast.makeText(getApplicationContext(),"없는버스입니다",Toast.LENGTH_LONG).show();
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