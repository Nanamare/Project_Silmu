package kr.co.unithon.unithon13.DBManager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nanamare on 2016-06-30.
 */
public class DBManager extends SQLiteOpenHelper{
    public DBManager(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    //테이블 생성
        String sql = "CREATE TABLE RecentRoute(_id INTEGER PRIMARY KEY AUTOINCREMENT,BusRouteId INTEGER UNIQUE, BusRouteNm TEXT UNIQUE, StNm TEXT, count INTEGER, DATE TEXT);";
        String sql2 = "CREATE UNIQUE INDEX RecentRoute_idx ON RecentRoute(BusRouteId,BusRouteNm)";
        db.execSQL(sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        String sql = "drop table if exists RecentRoute;";
        db.execSQL(sql);
        onCreate(db); // 다시 테이블 생성
        */
    }

    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public String PrintData() {
        SQLiteDatabase db = getReadableDatabase();
        String str = "";
        Cursor cursor = db.rawQuery("select * from RecentRoute", null);
        while(cursor.moveToNext()) {
            str += cursor.getInt(0) + cursor.getString(1) + cursor.getInt(2)+cursor.getInt(4)+cursor.getInt(5)+"\n";
        }
        return str;
    }

}
