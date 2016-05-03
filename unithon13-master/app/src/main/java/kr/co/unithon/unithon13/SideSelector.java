package kr.co.unithon.unithon13;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SectionIndexer;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SectionIndexer;

/**
 * Created by ichung-gi on 2016. 2. 14..
 */
public class SideSelector extends View {
    private static String TAG = SideSelector.class.getCanonicalName();

    public static String[] Line = new String[]{"1호선", "2호선", "3호선", "4호선", "5호선", "6호선", "7호선", "8호선", "9호선", "중앙", "분당선"
            , "경의선", "에버라인", "경춘선", "신분당선", "인천1호선"};
    public static final int BOTTOM_PADDING = 100;

    private SectionIndexer selectionIndexer = null;
    private ListView list;
    private Paint paint;
    private String[] sections;

    public SideSelector(Context context) {
        super(context);
        init();
    }

    public SideSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SideSelector(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setBackgroundColor(0x44FFFFFF);
        paint = new Paint();
        paint.setColor(0xFFA6A9AA);
        paint.setTextSize(20);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public void setListView(ListView _list) {
        list = _list;
        selectionIndexer = (SectionIndexer) _list.getAdapter();

        Object[] sectionsArr = selectionIndexer.getSections();
        sections = new String[sectionsArr.length];
        for (int i = 0; i < sectionsArr.length; i++) {
            sections[i] = sectionsArr[i].toString();
        }

    }

    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int y = (int) event.getY();
        float selectedIndex = ((float) y / (float) getPaddedHeight()) * Line.length;

        Log.d("y", y + "");
        Log.d("selectedIndex", selectedIndex + "");
        Log.d("getPaddedHeight()", getPaddedHeight() + "");
        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
            if (selectionIndexer == null) {
                selectionIndexer = (SectionIndexer) list.getAdapter();
            }
            int position = selectionIndexer.getPositionForSection((int) selectedIndex);
            if (position == -1) {
                return true;
            }
            Log.d("position", position + "");
            list.setSelection(position);
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {

        int viewHeight = getPaddedHeight();
        float charHeight = ((float) viewHeight) / (float) sections.length;

        float widthCenter = getMeasuredWidth() / 2;



        for (int i = 0; i < sections.length; i++) {
            canvas.drawText(String.valueOf(sections[i]), widthCenter, charHeight + (i * charHeight), paint);
        }
        super.onDraw(canvas);
    }

    private int getPaddedHeight() {
        return getHeight() - BOTTOM_PADDING;
    }
}
