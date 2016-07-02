package kr.co.unithon.unithon13.BusListView;

/**
 * Created by nanamare on 2016-05-18.
 */
public class busLine {
    private String busRouteId;
    private String busRouteNm;
    public busLine(String busRouteId, String busRouteNm){
        this.busRouteId = busRouteId;
        this.busRouteNm = busRouteNm;
    }

    public String getBusRouteId(){return busRouteId;};
    public String getBusRouteNm(){return busRouteNm;};
}
