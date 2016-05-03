package kr.co.unithon.unithon13;

/**
 * Created by daehyun on 16. 2. 14..
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.unithon.unithon13.model.Station;


public class SearchActivity extends Activity {
    private EditText input_edt;
    private ArrayList<InfoClass> mCareList = null;
    private ListView mListView = null;
    public SideSelector sideSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Station station = new Station(); // Constructor of station DB

        /*
        autoComplete = (AutoCompleteTextView) findViewById(R.id.autocomplete); // Find id and set listener
        autoComplete.addTextChangedListener(this);
        autoComplete.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                station.getAllName())); // (Context context, int resource, List<T> objects)
        autoComplete.setTextColor(Color.RED);*/

        setLayout();

        mCareList = new ArrayList<InfoClass>();


        int picture = R.drawable.line2;
        for(int i = 0 ; i < station.getStation().size() ; i++){
            switch(station.getStation().get(i).getLine()) {
                case "1호선":
                    picture = R.drawable.line1;
                    break;
                case "2호선":
                    picture = R.drawable.line2;
                    break;
                case "3호선":
                    picture = R.drawable.line3;
                    break;
                case "4호선":
                    picture = R.drawable.line4;
                    break;
                case "5호선":
                    picture = R.drawable.line5;
                    break;
                case "6호선":
                    picture = R.drawable.line6;
                    break;
                case "7호선":
                    picture = R.drawable.line7;
                    break;
                case "8호선":
                    picture = R.drawable.line8;
                    break;
                case "9호선":
                    picture = R.drawable.line9;
                    break;
                case "중앙선":
                    picture = R.drawable.gyeonguijungang;
                    break;
                case "분당선":
                    picture = R.drawable.bundang;
                    break;
                case "경의선":
                    picture = R.drawable.gyeonguijungang;
                    break;
                case "에버라인":
                    picture = R.drawable.everline;
                    break;
                case "경춘선":
                    picture = R.drawable.gyeongchun;
                    break;
                case "신분당선":
                    picture = R.drawable.sinbundan;
                    break;
                case "인천1호선":
                    picture = R.drawable.incheon1;
                    break;
            }

            mCareList.add(new InfoClass
                    (
                            picture,
                            station.getStation().get(i).getName(),
                            station.getStation().get(i).getLine()
                    ));
        }

        // ArrayAdapter 연결
        final CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.list_item, mCareList);
        mListView.setAdapter(adapter);
        sideSelector = (SideSelector) findViewById(R.id.side_selector);
        sideSelector.setListView(mListView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View view, int position,
                                    long arg3) {

                /*Toast.makeText(
                        getApplicationContext(),
                        "ITEM CLICK = " + position,
                        Toast.LENGTH_SHORT
                ).show();*/

                TextView tv_view = (TextView)view.findViewById(R.id.station_txt);


                if (MainActivity.startState == true) {
                    MainActivity.startName = tv_view.getText().toString();
                    MainActivity.startInfo = (InfoClass)arg0.getItemAtPosition(position);
                    MainActivity.startState = false;
                }
                if (MainActivity.arrivalState == true) {
                    MainActivity.arrivalName = tv_view.getText().toString();
                    MainActivity.arrivalInfo = (InfoClass)arg0.getItemAtPosition(position);
                    MainActivity.arrivalState = false;
                }
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        input_edt = (EditText) findViewById(R.id.input_edt);
        input_edt.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable theWatchedText) {

            }

            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
            }

            @Override
            public void onTextChanged(CharSequence arg0, int start, int after, int count) {

//                Toast.makeText(
//                        getApplicationContext(),
//                        arg0.toString(),
//                        Toast.LENGTH_SHORT
//                ).show();
                adapter.getFilter().filter(arg0.toString());

            }
        }); // addTextChangedListener




    }



    private void setLayout(){
        mListView = (ListView) findViewById(R.id.lv_list);
    }
}

