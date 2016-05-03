package kr.co.unithon.unithon13.model;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.ToString;

/**
 * Created by daehyun on 16. 2. 13..
 *
 *
 //    <row>
 //    <rowNum>1</rowNum>
 //    <selectedCount>1</selectedCount>
 //    <totalCount>1</totalCount>
 //    <statnFid>1001000100</statnFid>
 //    <statnTid>1002000215</statnTid>
 //    <statnFnm>소요산</statnFnm>
 //    <statnTnm>잠실나루</statnTnm>
 //    <shtStatnId>...</shtStatnId>
 //    <shtStatnNm>...</shtStatnNm>
 //    <shtTransferMsg>1시간 20분 걸리고, 2번 환승합니다. (32개역 지나감)</shtTransferMsg>
 //    <shtTravelMsg>1시간 20분 걸리고, 2번 환승합니다. (32개역 지나감)</shtTravelMsg>
 //    <shtStatnCnt>32</shtStatnCnt>
 //    <shtTravelTm>80</shtTravelTm>
 //    <shtTransferCnt>2</shtTransferCnt>
 //    <minStatnId>...</minStatnId>
 //    <minStatnNm>...</minStatnNm>
 //    <minTransferMsg>1시간 22분 걸리고, 1번 환승합니다. (34개역 지나감)</minTransferMsg>
 //    <minTravelMsg>1시간 22분 걸리고, 1번 환승합니다. (34개역 지나감)</minTravelMsg>
 //    <minStatnCnt>34</minStatnCnt>
 //    <minTravelTm>82</minTravelTm>
 //    <minTransferCnt>1</minTransferCnt>
 //    <shtStatnXy>...</shtStatnXy>
 //    <minStatnXy>...</minStatnXy>
 //    </row>
 //    </shortestRoute>
 */


@ToString
public class PathResult implements Parcelable{

        public int rowNum;
        public int selectedCount;
        public int totalCount;
        public String statnFid;
        public String statnTid;
        public String statnFnm;
        public String statnTnm;
        public String shtStatnId;
        public String shtStatnNm;
        public String shtTransferMsg;
        public String shtTravelMsg;
        public int shtStatnCnt;
        public int shtTravelTm;
        public int shtTransferCnt;
        public String minStatnId;
        public String minStatnNm;
        public String minTransferMsg;
        public String minTravelMsg;
        public String minStatnCnt;
        public int minTravelTm;
        public int minTransferCnt;
        public String shtStatnXy;
        public String minStatnXy;

    protected PathResult(Parcel in) {
        rowNum = in.readInt();
        selectedCount = in.readInt();
        totalCount = in.readInt();
        statnFid = in.readString();
        statnTid = in.readString();
        statnFnm = in.readString();
        statnTnm = in.readString();
        shtStatnId = in.readString();
        shtStatnNm = in.readString();
        shtTransferMsg = in.readString();
        shtTravelMsg = in.readString();
        shtStatnCnt = in.readInt();
        shtTravelTm = in.readInt();
        shtTransferCnt = in.readInt();
        minStatnId = in.readString();
        minStatnNm = in.readString();
        minTransferMsg = in.readString();
        minTravelMsg = in.readString();
        minStatnCnt = in.readString();
        minTravelTm = in.readInt();
        minTransferCnt = in.readInt();
        shtStatnXy = in.readString();
        minStatnXy = in.readString();
    }

    public static final Creator<PathResult> CREATOR = new Creator<PathResult>() {
        @Override
        public PathResult createFromParcel(Parcel in) {
            return new PathResult(in);
        }

        @Override
        public PathResult[] newArray(int size) {
            return new PathResult[size];
        }
    };

    public PathResult() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rowNum);
        dest.writeInt(selectedCount);
        dest.writeInt(totalCount);
        dest.writeString(statnFid);
        dest.writeString(statnTid);
        dest.writeString(statnFnm);
        dest.writeString(statnTnm);
        dest.writeString(shtStatnId);
        dest.writeString(shtStatnNm);
        dest.writeString(shtTransferMsg);
        dest.writeString(shtTravelMsg);
        dest.writeInt(shtStatnCnt);
        dest.writeInt(shtTravelTm);
        dest.writeInt(shtTransferCnt);
        dest.writeString(minStatnId);
        dest.writeString(minStatnNm);
        dest.writeString(minTransferMsg);
        dest.writeString(minTravelMsg);
        dest.writeString(minStatnCnt);
        dest.writeInt(minTravelTm);
        dest.writeInt(minTransferCnt);
        dest.writeString(shtStatnXy);
        dest.writeString(minStatnXy);
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getSelectedCount() {
        return selectedCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public String getStatnFid() {
        return statnFid;
    }

    public String getStatnTid() {
        return statnTid;
    }

    public String getStatnFnm() {
        return statnFnm;
    }

    public String getStatnTnm() {
        return statnTnm;
    }

    public String getShtStatnId() {
        return shtStatnId;
    }

    public String getShtStatnNm() {
        return shtStatnNm;
    }

    public String getShtTransferMsg() {
        return shtTransferMsg;
    }

    public String getShtTravelMsg() {
        return shtTravelMsg;
    }

    public int getShtStatnCnt() {
        return shtStatnCnt;
    }

    public int getShtTravelTm() {
        return shtTravelTm;
    }

    public int getShtTransferCnt() {
        return shtTransferCnt;
    }

    public String getMinStatnId() {
        return minStatnId;
    }

    public String getMinStatnNm() {
        return minStatnNm;
    }

    public String getMinTransferMsg() {
        return minTransferMsg;
    }

    public String getMinTravelMsg() {
        return minTravelMsg;
    }

    public String getMinStatnCnt() {
        return minStatnCnt;
    }

    public int getMinTravelTm() {
        return minTravelTm;
    }

    public int getMinTransferCnt() {
        return minTransferCnt;
    }

    public String getShtStatnXy() {
        return shtStatnXy;
    }

    public String getMinStatnXy() {
        return minStatnXy;
    }
}
