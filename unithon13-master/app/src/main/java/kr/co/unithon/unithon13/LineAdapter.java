package kr.co.unithon.unithon13;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import kr.co.unithon.unithon13.model.SWline;

/**
 * Created by daehyun on 16. 2. 13..
 */
public class LineAdapter extends ArrayAdapter<SWline> {

    public LineAdapter(Context context, int resource) {
        super(context, resource);
    }

    public LineAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public LineAdapter(Context context, int resource, SWline[] objects) {
        super(context, resource, objects);
    }

    public LineAdapter(Context context, int resource, int textViewResourceId, SWline[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public LineAdapter(Context context, int resource, List<SWline> objects) {
        super(context, resource, objects);
    }

    public LineAdapter(Context context, int resource, int textViewResourceId, List<SWline> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public SWline getItem(int position) {
        return super.getItem(position);
    }
}