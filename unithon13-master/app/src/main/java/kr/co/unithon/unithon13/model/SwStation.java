package kr.co.unithon.unithon13.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;

/**
 * Created by daehyun on 16. 2. 13..
 */

public class SwStation implements Parcelable{
    public SwStation() {
    }

    protected SwStation(Parcel in) {
        stationCode = in.readString();
        name = in.readString();
        lineNum = in.readString();
        frCode = in.readString();
    }

    public static final Creator<SwStation> CREATOR = new Creator<SwStation>() {
        @Override
        public SwStation createFromParcel(Parcel in) {
            return new SwStation(in);
        }

        @Override
        public SwStation[] newArray(int size) {
            return new SwStation[size];
        }
    };

    public SwStation(String stationCode, String name, String lineNum, String frCode) {
        this.stationCode = stationCode;
        this.name = name;
        this.lineNum = lineNum;
        this.frCode = frCode;
    }

    public String getStationCode() {
        return stationCode;
    }

    public String getName() {
        return name;
    }

    public String getLineNum() {
        return lineNum;
    }

    public String getFrCode() {
        return frCode;
    }

    //    <STATION_CD>0413</STATION_CD>
//    <STATION_NM>쌍문</STATION_NM>
//    <LINE_NUM>4</LINE_NUM>
//    <FR_CODE>413</FR_CODE>
    @Element(name="STATION_CD")
    private String stationCode;
    @Element(name="STATION_NM")
    private String name;
    @Element(name="LINE_NUM")
    private String lineNum;
    @Element(name="FR_CODE")
    private String frCode;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
//        builder.append("STATION_CODE:");
//        builder.append(stationCode);
//        builder.append("STATION_NAME:");
//        builder.append(name);
//        builder.append("LINE_NUM:");
//        builder.append(lineNum);
//        builder.append("fr CODE");
//        builder.append(frCode);

        return builder.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stationCode);
        dest.writeString(name);
        dest.writeString(lineNum);
        dest.writeString(frCode);
    }
}