package kr.co.unithon.unithon13.httpService;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by daehyun on 16. 2. 13..
 */
public interface SeoulClient {

    //    서울시 노선별 지하철역 정보
//    http://openAPI.seoul.go.kr:8088/(인증키)/xml/SearchSTNBySubwayLineService/1/5/1/
//    KEY	String(필수)	인증키	OpenAPI 에서 발급된 인증키
//    TYPE	String(필수)	요청파일타입	xml : xml, xml파일 : xmlf,엑셀파일 : xls, json파일 : json
//    SERVICE	String(필수)	서비스명	SearchSTNBySubwayLineService
//    START_INDEX	INTEGER(필수)	요청시작위치	정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
//    END_INDEX	INTEGER(필수)	요청종료위치	정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
//    LINE_NUM	STRING(선택)	호선
    @GET("/xml/SearchSTNBySubwayLineService/{startIndex}/{endIndex}/{lineNum}")
    void getStationsByLinenubmer(
            @Path("startIndex") int startIndex,
            @Path("endIndex") int endIndex,
            @Path("lineNum") String lineNum,
            Callback<StationListResponse> cb
    );


}
