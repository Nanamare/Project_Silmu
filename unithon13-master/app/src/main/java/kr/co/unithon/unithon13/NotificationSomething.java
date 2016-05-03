package kr.co.unithon.unithon13;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by daehyun on 16. 2. 14..
 */
public class NotificationSomething extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence s = "전달 받은 값은 ";
        int id=0;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            s = "error";
        }
        else {
            id = extras.getInt("notificationId");
        }
        TextView t = (TextView) findViewById(R.id.textView);
        s = s+" "+id;
        t.setText(s);
        NotificationManager nm =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(id);
    }
}
