package kr.co.unithon.unithon13;

/**
 * Created by daehyun on 16. 2. 14..
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;

;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.unithon.unithon13.model.Station;

import static kr.co.unithon.unithon13.R.drawable.line1;

/**
 * Created by ichung-gi on 2016. 2. 14..
 */
public class CustomArrayAdapter extends ArrayAdapter<InfoClass> implements Filterable, SectionIndexer {

    private static final String TAG = "CustomArrayAdapter";
    private ViewHolder viewHolder = null;
    private LayoutInflater inflater = null;
    ArrayList<InfoClass> infoList = new ArrayList<InfoClass>();
    private ArrayList<InfoClass> originalList;
    private Context mContext = null;
    private NameFilter filter;

    public CustomArrayAdapter(Context c, int textViewResourceId,
                              ArrayList<InfoClass> infoList) {
        super(c, textViewResourceId, infoList);
        this.inflater = LayoutInflater.from(c);
        this.mContext = c;
        this.infoList = infoList;

        this.originalList = new ArrayList<InfoClass>();
        this.originalList.addAll(infoList);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public InfoClass getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        View v = convertview;

        if(v == null){
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.list_item, null);
            viewHolder.iv_image = (ImageView)v.findViewById(R.id.line_image);
            viewHolder.textView = (TextView)v.findViewById(R.id.station_txt);

            v.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder)v.getTag();
        }


        final InfoClass infoClass = (InfoClass) infoList.get(position);
        viewHolder.iv_image.setImageResource(infoClass.getImage());

        //viewHolder.iv_image.setImageBitmap();
        viewHolder.iv_image.setTag(position);

        viewHolder.textView.setText(getItem(position).str);
        viewHolder.textView.setTag(position);

        return v;
    }

    public void setArrayList(ArrayList<InfoClass> arrays){
        this.infoList  = arrays;
    }

    public ArrayList<InfoClass> getArrayList(){
        return infoList;
    }


    /*
     * ViewHolder
     */
    class ViewHolder{
        public ImageView iv_image = null;
        public TextView textView = null;

    }


    @Override
    protected void finalize() throws Throwable {
        free();
        super.finalize();
    }

    private void free(){
        inflater = null;
        infoList = null;
        viewHolder = null;
        mContext = null;
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter  = new NameFilter();
        }
        return filter;
    }
    private class NameFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString();
            FilterResults result = new FilterResults();
            if(constraint != null && constraint.toString().length() > 0)
            {
                ArrayList<InfoClass> filteredItems = new ArrayList<InfoClass>();
                for(int i = 0, l = originalList.size(); i < l; i++)
                {
                    InfoClass nameList = originalList.get(i);
                    if(nameList.str.toString().contains(constraint))
                        filteredItems.add(nameList);

                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                synchronized(this)
                {
                    result.values = originalList;
                    result.count = originalList.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            infoList = (ArrayList<InfoClass>)results.values;
            notifyDataSetChanged();
            clear();
            for(int i = 0, l = infoList.size(); i < l; i++) {
                add(infoList.get(i));
                //Log.d("infoList.get(i)", infoList.get(i).str);
            }
            notifyDataSetInvalidated();
        }
    }

    public int findImage() {
        Station station = new Station();
        int picture = R.drawable.line2;
        for (int i = 0; i < station.getStation().size(); i++) {
            switch (station.getStation().get(i).getLine()) {
                case "1호선":
                    picture = line1;
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
        }
        return picture;
    }

    public Object[] getSections() {
        String[] chars = new String[SideSelector.Line.length];
        for (int i = 0; i < SideSelector.Line.length; i++) {
            chars[i] = String.valueOf(SideSelector.Line[i]);
        }

        return chars;
    }

    public int getPositionForSection(int i) {

        Log.d(TAG, "getPositionForSection " + i);
        return (int) (getCount() * ((float)i/(float)getSections().length));
    }

    public int getSectionForPosition(int i) {
        return 0;
    }
}
