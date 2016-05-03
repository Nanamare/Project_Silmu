package kr.co.unithon.unithon13.model;

import java.util.ArrayList;

/**
 * Created by ichung-gi on 2016. 2. 14..
 */
public class Station {
    public static ArrayList<Station> stationList = new ArrayList<Station>();

    public String[] item;

    String name;
    String line;
    String code;

    public Station(String name, String line, String code) {
        this.name = name;
        this.line = line;
        this.code = code;
    }

    public Station() {
        // 1호선
        stationList.add(new Station("소요산", "1호선", "100"));
        stationList.add(new Station("동두천", "1호선", "101"));
        stationList.add(new Station("보산", "1호선", "102"));
        stationList.add(new Station("동두천중앙", "1호선", "103"));
        stationList.add(new Station("지행", "1호선", "104"));
        stationList.add(new Station("덕정", "1호선", "105"));
        stationList.add(new Station("덕계", "1호선", "106"));
        stationList.add(new Station("양주", "1호선", "107"));
        stationList.add(new Station("녹양", "1호선", "108"));
        stationList.add(new Station("가능", "1호선", "110"));
        stationList.add(new Station("의정부", "1호선", "111"));
        stationList.add(new Station("회룡", "1호선", "112"));
        stationList.add(new Station("망월사", "1호선", "113"));
        stationList.add(new Station("도봉산", "1호선", "114"));
        stationList.add(new Station("도봉", "1호선", "115"));
        stationList.add(new Station("방학", "1호선", "116"));
        stationList.add(new Station("창동", "1호선", "117"));
        stationList.add(new Station("녹천", "1호선", "118"));
        stationList.add(new Station("월계", "1호선", "119"));
        stationList.add(new Station("광운대", "1호선", "120"));
        stationList.add(new Station("석계", "1호선", "121"));
        stationList.add(new Station("신이문", "1호선", "122"));
        stationList.add(new Station("외대앞", "1호선", "123"));
        stationList.add(new Station("회기", "1호선", "124"));
        stationList.add(new Station("청량리", "1호선", "125"));
        stationList.add(new Station("제기동", "1호선", "126"));
        stationList.add(new Station("신설동", "1호선", "127"));
        stationList.add(new Station("동대문", "1호선", "128"));
        stationList.add(new Station("종로5가", "1호선", "129"));
        stationList.add(new Station("종로3가", "1호선", "130"));
        stationList.add(new Station("종각", "1호선", "131"));
        stationList.add(new Station("시청", "1호선", "132"));
        stationList.add(new Station("서울역", "1호선", "133"));
        stationList.add(new Station("남영", "1호선", "134"));
        stationList.add(new Station("용산", "1호선", "135"));
        stationList.add(new Station("노량진", "1호선", "136"));
        stationList.add(new Station("대방", "1호선", "137"));
        stationList.add(new Station("신길", "1호선", "138"));
        stationList.add(new Station("영등포", "1호선", "139"));
        stationList.add(new Station("신도림", "1호선", "140"));
        stationList.add(new Station("구로", "1호선", "141"));
        stationList.add(new Station("구일", "1호선", "142"));
        stationList.add(new Station("개봉", "1호선", "143"));
        stationList.add(new Station("오류동", "1호선", "144"));
        stationList.add(new Station("온수", "1호선", "145"));
        stationList.add(new Station("역곡", "1호선", "146"));
        stationList.add(new Station("소사", "1호선", "147"));
        stationList.add(new Station("부천", "1호선", "148"));
        stationList.add(new Station("중동", "1호선", "149"));
        stationList.add(new Station("송내", "1호선", "150"));
        stationList.add(new Station("부개", "1호선", "151"));
        stationList.add(new Station("부평", "1호선", "152"));
        stationList.add(new Station("백운", "1호선", "153"));
        stationList.add(new Station("동암", "1호선", "154"));
        stationList.add(new Station("간석", "1호선", "155"));
        stationList.add(new Station("주안", "1호선", "156"));
        stationList.add(new Station("도화", "1호선", "157"));
        stationList.add(new Station("제물포", "1호선", "158"));
        stationList.add(new Station("도원", "1호선", "159"));
        stationList.add(new Station("동인천", "1호선", "160"));
        stationList.add(new Station("인천", "1호선", "161"));
        stationList.add(new Station("가산디지털단지", "1호선", "172"));
        stationList.add(new Station("독산", "1호선", "173"));
        stationList.add(new Station("금천구청", "1호선", "174"));
        stationList.add(new Station("석수", "1호선", "175"));
        stationList.add(new Station("관악", "1호선", "176"));
        stationList.add(new Station("안양", "1호선", "177"));
        stationList.add(new Station("명학", "1호선", "178"));
        stationList.add(new Station("금정", "1호선", "179"));
        stationList.add(new Station("군포", "1호선", "180"));
        stationList.add(new Station("의왕", "1호선", "181"));
        stationList.add(new Station("성균관대", "1호선", "182"));
        stationList.add(new Station("화서", "1호선", "183"));
        stationList.add(new Station("수원", "1호선", "184"));
        stationList.add(new Station("세류", "1호선", "185"));
        stationList.add(new Station("병점", "1호선", "186"));
        stationList.add(new Station("세마", "1호선", "187"));
        stationList.add(new Station("오산대", "1호선", "188"));
        stationList.add(new Station("오산", "1호선", "189"));
        stationList.add(new Station("진위", "1호선", "190"));
        stationList.add(new Station("동묘앞", "1호선", "199"));
        stationList.add(new Station("광명", "1호선", "1175"));
        stationList.add(new Station("당정", "1호선", "1181"));
        stationList.add(new Station("서동탄", "1호선", "1187"));
        stationList.add(new Station("송탄", "1호선", "1401"));
        stationList.add(new Station("서정리", "1호선", "1402"));
        stationList.add(new Station("지제", "1호선", "1403"));
        stationList.add(new Station("평택", "1호선", "1404"));
        stationList.add(new Station("성환", "1호선", "1405"));
        stationList.add(new Station("직산", "1호선", "1406"));
        stationList.add(new Station("두정", "1호선", "1407"));
        stationList.add(new Station("천안", "1호선", "1408"));
        stationList.add(new Station("봉명", "1호선", "1409"));
        stationList.add(new Station("쌍용(나사렛대)", "1호선", "1410"));
        stationList.add(new Station("아산", "1호선", "1411"));
        stationList.add(new Station("배방", "1호선", "1413"));
        stationList.add(new Station("온양온천", "1호선", "1415"));
        stationList.add(new Station("신창(순천향대)", "1호선", "1416"));

        // 2호선
        stationList.add(new Station("시청", "2호선", "201"));
        stationList.add(new Station("을지로입구", "2호선", "202"));
        stationList.add(new Station("을지로3가", "2호선", "203"));
        stationList.add(new Station("을지로4가", "2호선", "204"));
        stationList.add(new Station("동대문역사문화공원", "2호선", "205"));
        stationList.add(new Station("신당", "2호선", "206"));
        stationList.add(new Station("상왕십리", "2호선", "207"));
        stationList.add(new Station("왕십리", "2호선", "208"));
        stationList.add(new Station("한양대", "2호선", "209"));
        stationList.add(new Station("뚝섬", "2호선", "210"));
        stationList.add(new Station("성수", "2호선", "211"));
        stationList.add(new Station("건대입구", "2호선", "212"));
        stationList.add(new Station("구의", "2호선", "213"));
        stationList.add(new Station("강변", "2호선", "214"));
        stationList.add(new Station("잠실나루", "2호선", "215"));
        stationList.add(new Station("잠실", "2호선", "216"));
        stationList.add(new Station("신천", "2호선", "217"));
        stationList.add(new Station("종합운동장", "2호선", "218"));
        stationList.add(new Station("삼성", "2호선", "219"));
        stationList.add(new Station("선릉", "2호선", "220"));
        stationList.add(new Station("역삼", "2호선", "221"));
        stationList.add(new Station("강남", "2호선", "222"));
        stationList.add(new Station("교대", "2호선", "223"));
        stationList.add(new Station("서초", "2호선", "224"));
        stationList.add(new Station("방배", "2호선", "225"));
        stationList.add(new Station("사당", "2호선", "226"));
        stationList.add(new Station("낙성대", "2호선", "227"));
        stationList.add(new Station("서울대입구", "2호선", "228"));
        stationList.add(new Station("봉천", "2호선", "229"));
        stationList.add(new Station("신림", "2호선", "230"));
        stationList.add(new Station("신대방", "2호선", "231"));
        stationList.add(new Station("구로디지털단지", "2호선", "232"));
        stationList.add(new Station("대림", "2호선", "233"));
        stationList.add(new Station("신도림", "2호선", "234"));
        stationList.add(new Station("문래", "2호선", "235"));
        stationList.add(new Station("영등포구청", "2호선", "236"));
        stationList.add(new Station("당산", "2호선", "237"));
        stationList.add(new Station("합정", "2호선", "238"));
        stationList.add(new Station("홍대입구", "2호선", "239"));
        stationList.add(new Station("신촌", "2호선", "240"));
        stationList.add(new Station("이대", "2호선", "241"));
        stationList.add(new Station("아현", "2호선", "242"));
        stationList.add(new Station("충정로", "2호선", "243"));
        stationList.add(new Station("용답", "2호선", "251"));
        stationList.add(new Station("신답", "2호선", "252"));
        stationList.add(new Station("신설동", "2호선", "253"));
        stationList.add(new Station("용두", "2호선", "254"));
        stationList.add(new Station("도림천", "2호선", "261"));
        stationList.add(new Station("양천구청", "2호선", "262"));
        stationList.add(new Station("신정네거리", "2호선", "263"));
        stationList.add(new Station("까치산", "2호선", "264"));

        // 3호선
        stationList.add(new Station("대화", "3호선", "310"));
        stationList.add(new Station("주엽", "3호선", "311"));
        stationList.add(new Station("정발산", "3호선", "312"));
        stationList.add(new Station("마두", "3호선", "313"));
        stationList.add(new Station("백석", "3호선", "314"));
        stationList.add(new Station("대곡", "3호선", "315"));
        stationList.add(new Station("화정", "3호선", "316"));
        stationList.add(new Station("원당", "3호선", "317"));
        stationList.add(new Station("삼송", "3호선", "318"));
        stationList.add(new Station("지축", "3호선", "319"));
        stationList.add(new Station("구파발", "3호선", "320"));
        stationList.add(new Station("연신내", "3호선", "321"));
        stationList.add(new Station("불광", "3호선", "322"));
        stationList.add(new Station("녹번", "3호선", "323"));
        stationList.add(new Station("홍제", "3호선", "324"));
        stationList.add(new Station("무악재", "3호선", "325"));
        stationList.add(new Station("독립문", "3호선", "326"));
        stationList.add(new Station("경복궁", "3호선", "327"));
        stationList.add(new Station("안국", "3호선", "328"));
        stationList.add(new Station("종로3가", "3호선", "329"));
        stationList.add(new Station("을지로3가", "3호선", "330"));
        stationList.add(new Station("충무로", "3호선", "331"));
        stationList.add(new Station("동대입구", "3호선", "332"));
        stationList.add(new Station("약수", "3호선", "333"));
        stationList.add(new Station("금호", "3호선", "334"));
        stationList.add(new Station("옥수", "3호선", "335"));
        stationList.add(new Station("압구정", "3호선", "336"));
        stationList.add(new Station("신사", "3호선", "337"));
        stationList.add(new Station("잠원", "3호선", "338"));
        stationList.add(new Station("고속터미널", "3호선", "339"));
        stationList.add(new Station("교대", "3호선", "340"));
        stationList.add(new Station("남부터미널", "3호선", "341"));
        stationList.add(new Station("양재", "3호선", "342"));
        stationList.add(new Station("매봉", "3호선", "343"));
        stationList.add(new Station("도곡", "3호선", "344"));
        stationList.add(new Station("대치", "3호선", "345"));
        stationList.add(new Station("학여울", "3호선", "346"));
        stationList.add(new Station("대청", "3호선", "347"));
        stationList.add(new Station("일원", "3호선", "348"));
        stationList.add(new Station("수서", "3호선", "349"));
        stationList.add(new Station("가락시장", "3호선", "350"));
        stationList.add(new Station("경찰병원", "3호선", "351"));
        stationList.add(new Station("오금", "3호선", "352"));

        // 4호선
        stationList.add(new Station("당고개", "4호선", "409"));
        stationList.add(new Station("상계", "4호선", "410"));
        stationList.add(new Station("노원", "4호선", "411"));
        stationList.add(new Station("창동", "4호선", "412"));
        stationList.add(new Station("쌍문", "4호선", "413"));
        stationList.add(new Station("수유(강북구청)", "4호선", "414"));
        stationList.add(new Station("미아", "4호선", "415"));
        stationList.add(new Station("미아사거리", "4호선", "416"));
        stationList.add(new Station("길음", "4호선", "417"));
        stationList.add(new Station("성신여대입구", "4호선", "418"));
        stationList.add(new Station("한성대입구", "4호선", "419"));
        stationList.add(new Station("혜화", "4호선", "420"));
        stationList.add(new Station("동대문", "4호선", "421"));
        stationList.add(new Station("동대문역사문화공원", "4호선", "422"));
        stationList.add(new Station("충무로", "4호선", "423"));
        stationList.add(new Station("명동", "4호선", "424"));
        stationList.add(new Station("회현", "4호선", "425"));
        stationList.add(new Station("서울역", "4호선", "426"));
        stationList.add(new Station("숙대입구", "4호선", "427"));
        stationList.add(new Station("삼각지", "4호선", "428"));
        stationList.add(new Station("신용산", "4호선", "429"));
        stationList.add(new Station("이촌", "4호선", "430"));
        stationList.add(new Station("동작", "4호선", "431"));
        stationList.add(new Station("총신대입구(이수)", "4호선", "432"));
        stationList.add(new Station("사당", "4호선", "433"));
        stationList.add(new Station("남태령", "4호선", "434"));
        stationList.add(new Station("선바위", "4호선", "435"));
        stationList.add(new Station("경마공원", "4호선", "436"));
        stationList.add(new Station("대공원", "4호선", "437"));
        stationList.add(new Station("과천", "4호선", "438"));
        stationList.add(new Station("정부과천청사", "4호선", "439"));
        stationList.add(new Station("인덕원", "4호선", "440"));
        stationList.add(new Station("평촌", "4호선", "441"));
        stationList.add(new Station("범계", "4호선", "442"));
        stationList.add(new Station("금정", "4호선", "443"));
        stationList.add(new Station("산본", "4호선", "444"));
        stationList.add(new Station("수리산", "4호선", "445"));
        stationList.add(new Station("대야미", "4호선", "446"));
        stationList.add(new Station("반월", "4호선", "447"));
        stationList.add(new Station("상록수", "4호선", "448"));
        stationList.add(new Station("한대앞", "4호선", "449"));
        stationList.add(new Station("중앙", "4호선", "450"));
        stationList.add(new Station("고잔", "4호선", "451"));
        stationList.add(new Station("초지", "4호선", "452"));
        stationList.add(new Station("안산", "4호선", "453"));
        stationList.add(new Station("신길온천", "4호선", "454"));
        stationList.add(new Station("정왕", "4호선", "455"));
        stationList.add(new Station("오이도", "4호선", "456"));

        // 5호선
        stationList.add(new Station("방화", "5호선", "510"));
        stationList.add(new Station("개화산", "5호선", "511"));
        stationList.add(new Station("김포공항", "5호선", "512"));
        stationList.add(new Station("송정", "5호선", "513"));
        stationList.add(new Station("마곡", "5호선", "514"));
        stationList.add(new Station("발산", "5호선", "515"));
        stationList.add(new Station("우장산", "5호선", "516"));
        stationList.add(new Station("화곡", "5호선", "517"));
        stationList.add(new Station("까치산", "5호선", "518"));
        stationList.add(new Station("신정", "5호선", "519"));
        stationList.add(new Station("목동", "5호선", "520"));
        stationList.add(new Station("오목교", "5호선", "521"));
        stationList.add(new Station("양평", "5호선", "522"));
        stationList.add(new Station("영등포구청", "5호선", "523"));
        stationList.add(new Station("영등포시장", "5호선", "524"));
        stationList.add(new Station("신길", "5호선", "525"));
        stationList.add(new Station("여의도", "5호선", "526"));
        stationList.add(new Station("여의나루", "5호선", "527"));
        stationList.add(new Station("마포", "5호선", "528"));
        stationList.add(new Station("공덕", "5호선", "529"));
        stationList.add(new Station("애오개", "5호선", "530"));
        stationList.add(new Station("충정로", "5호선", "531"));
        stationList.add(new Station("서대문", "5호선", "532"));
        stationList.add(new Station("광화문", "5호선", "533"));
        stationList.add(new Station("종로3가", "5호선", "534"));
        stationList.add(new Station("을지로4가", "5호선", "535"));
        stationList.add(new Station("동대문역사문화공원", "5호선", "536"));
        stationList.add(new Station("청구", "5호선", "537"));
        stationList.add(new Station("신금호", "5호선", "538"));
        stationList.add(new Station("행당", "5호선", "539"));
        stationList.add(new Station("왕십리", "5호선", "540"));
        stationList.add(new Station("마장", "5호선", "541"));
        stationList.add(new Station("답십리", "5호선", "542"));
        stationList.add(new Station("장한평", "5호선", "543"));
        stationList.add(new Station("군자", "5호선", "544"));
        stationList.add(new Station("아차산", "5호선", "545"));
        stationList.add(new Station("광나루", "5호선", "546"));
        stationList.add(new Station("천호", "5호선", "547"));
        stationList.add(new Station("강동", "5호선", "548"));
        stationList.add(new Station("길동", "5호선", "549"));
        stationList.add(new Station("굽은다리", "5호선", "550"));
        stationList.add(new Station("명일", "5호선", "551"));
        stationList.add(new Station("고덕", "5호선", "552"));
        stationList.add(new Station("상일동", "5호선", "553"));
        stationList.add(new Station("둔촌동", "5호선", "569"));
        stationList.add(new Station("올림픽공원", "5호선", "570"));
        stationList.add(new Station("방이", "5호선", "571"));
        stationList.add(new Station("오금", "5호선", "572"));
        stationList.add(new Station("개롱", "5호선", "573"));
        stationList.add(new Station("거여", "5호선", "574"));
        stationList.add(new Station("마천", "5호선", "575"));

        // 6호선
        stationList.add(new Station("응암", "6호선", "610"));
        stationList.add(new Station("역촌", "6호선", "611"));
        stationList.add(new Station("불광", "6호선", "612"));
        stationList.add(new Station("독바위", "6호선", "613"));
        stationList.add(new Station("연신내", "6호선", "614"));
        stationList.add(new Station("구산", "6호선", "615"));
        stationList.add(new Station("새절", "6호선", "616"));
        stationList.add(new Station("증산", "6호선", "617"));
        stationList.add(new Station("디지털미디어시티", "6호선", "618"));
        stationList.add(new Station("월드컵경기장", "6호선", "619"));
        stationList.add(new Station("마포구청", "6호선", "620"));
        stationList.add(new Station("망원", "6호선", "621"));
        stationList.add(new Station("합정", "6호선", "622"));
        stationList.add(new Station("상수", "6호선", "623"));
        stationList.add(new Station("광흥창", "6호선", "624"));
        stationList.add(new Station("대흥", "6호선", "625"));
        stationList.add(new Station("공덕", "6호선", "626"));
        stationList.add(new Station("효창공원앞", "6호선", "627"));
        stationList.add(new Station("삼각지", "6호선", "628"));
        stationList.add(new Station("녹사평(용산구청)", "6호선", "629"));
        stationList.add(new Station("이태원", "6호선", "630"));
        stationList.add(new Station("한강진", "6호선", "631"));
        stationList.add(new Station("버티고개", "6호선", "632"));
        stationList.add(new Station("약수", "6호선", "633"));
        stationList.add(new Station("청구", "6호선", "634"));
        stationList.add(new Station("신당", "6호선", "635"));
        stationList.add(new Station("동묘앞", "6호선", "636"));
        stationList.add(new Station("창신", "6호선", "637"));
        stationList.add(new Station("보문", "6호선", "638"));
        stationList.add(new Station("안암", "6호선", "639"));
        stationList.add(new Station("고려대", "6호선", "640"));
        stationList.add(new Station("월곡", "6호선", "641"));
        stationList.add(new Station("상월곡", "6호선", "642"));
        stationList.add(new Station("돌곶이", "6호선", "643"));
        stationList.add(new Station("석계", "6호선", "644"));
        stationList.add(new Station("태릉입구", "6호선", "645"));
        stationList.add(new Station("화랑대", "6호선", "646"));
        stationList.add(new Station("봉화산(서울의료원)", "6호선", "647"));

        // 7호선
        stationList.add(new Station("장암", "7호선", "709"));
        stationList.add(new Station("도봉산", "7호선", "710"));
        stationList.add(new Station("수락산", "7호선", "711"));
        stationList.add(new Station("마들", "7호선", "712"));
        stationList.add(new Station("노원", "7호선", "713"));
        stationList.add(new Station("중계", "7호선", "714"));
        stationList.add(new Station("하계", "7호선", "715"));
        stationList.add(new Station("공릉", "7호선", "716"));
        stationList.add(new Station("태릉입구", "7호선", "717"));
        stationList.add(new Station("먹골", "7호선", "718"));
        stationList.add(new Station("중화", "7호선", "719"));
        stationList.add(new Station("상봉", "7호선", "720"));
        stationList.add(new Station("면목", "7호선", "721"));
        stationList.add(new Station("사가정", "7호선", "722"));
        stationList.add(new Station("용마산", "7호선", "723"));
        stationList.add(new Station("중곡", "7호선", "724"));
        stationList.add(new Station("군자", "7호선", "725"));
        stationList.add(new Station("어린이대공원", "7호선", "726"));
        stationList.add(new Station("건대입구", "7호선", "727"));
        stationList.add(new Station("뚝섬유원지", "7호선", "728"));
        stationList.add(new Station("청담", "7호선", "729"));
        stationList.add(new Station("강남구청", "7호선", "730"));
        stationList.add(new Station("학동", "7호선", "731"));
        stationList.add(new Station("논현", "7호선", "732"));
        stationList.add(new Station("반포", "7호선", "733"));
        stationList.add(new Station("고속터미널", "7호선", "734"));
        stationList.add(new Station("내방", "7호선", "735"));
        stationList.add(new Station("이수", "7호선", "736"));
        stationList.add(new Station("남성", "7호선", "737"));
        stationList.add(new Station("숭실대입구", "7호선", "738"));
        stationList.add(new Station("상도", "7호선", "739"));
        stationList.add(new Station("장승배기", "7호선", "740"));
        stationList.add(new Station("신대방삼거리", "7호선", "741"));
        stationList.add(new Station("보라매", "7호선", "742"));
        stationList.add(new Station("신풍", "7호선", "743"));
        stationList.add(new Station("대림", "7호선", "744"));
        stationList.add(new Station("남구로", "7호선", "745"));
        stationList.add(new Station("가산디지털단지", "7호선", "746"));
        stationList.add(new Station("철산", "7호선", "747"));
        stationList.add(new Station("광명사거리", "7호선", "748"));
        stationList.add(new Station("천왕", "7호선", "749"));
        stationList.add(new Station("온수", "7호선", "750"));
        stationList.add(new Station("까치울", "7호선", "751"));
        stationList.add(new Station("부천종합운동장", "7호선", "752"));
        stationList.add(new Station("춘의", "7호선", "753"));
        stationList.add(new Station("신중동", "7호선", "754"));
        stationList.add(new Station("부천시청", "7호선", "755"));
        stationList.add(new Station("상동", "7호선", "756"));
        stationList.add(new Station("삼산체육관", "7호선", "757"));
        stationList.add(new Station("굴포천", "7호선", "758"));
        stationList.add(new Station("부평구청", "7호선", "759"));

        // 8호선
        stationList.add(new Station("암사", "8호선", "810"));
        stationList.add(new Station("천호", "8호선", "811"));
        stationList.add(new Station("강동구청", "8호선", "812"));
        stationList.add(new Station("몽촌토성", "8호선", "813"));
        stationList.add(new Station("잠실", "8호선", "814"));
        stationList.add(new Station("석촌", "8호선", "815"));
        stationList.add(new Station("송파", "8호선", "816"));
        stationList.add(new Station("가락시장", "8호선", "817"));
        stationList.add(new Station("문정", "8호선", "818"));
        stationList.add(new Station("장지", "8호선", "819"));
        stationList.add(new Station("복정", "8호선", "820"));
        stationList.add(new Station("산성", "8호선", "821"));
        stationList.add(new Station("남한산성입구", "8호선", "822"));
        stationList.add(new Station("단대오거리", "8호선", "823"));
        stationList.add(new Station("신흥", "8호선", "824"));
        stationList.add(new Station("수진", "8호선", "825"));
        stationList.add(new Station("모란", "8호선", "826"));

        // 9호선
        stationList.add(new Station("개화", "9호선", "901"));
        stationList.add(new Station("김포공항", "9호선", "902"));
        stationList.add(new Station("공항시장", "9호선", "903"));
        stationList.add(new Station("신방화", "9호선", "904"));
        stationList.add(new Station("마곡나루", "9호선", "905"));
        stationList.add(new Station("양천향교", "9호선", "906"));
        stationList.add(new Station("가양", "9호선", "907"));
        stationList.add(new Station("증미", "9호선", "908"));
        stationList.add(new Station("등촌", "9호선", "909"));
        stationList.add(new Station("염창", "9호선", "910"));
        stationList.add(new Station("신목동", "9호선", "911"));
        stationList.add(new Station("선유도", "9호선", "912"));
        stationList.add(new Station("당산", "9호선", "913"));
        stationList.add(new Station("국회의사당", "9호선", "914"));
        stationList.add(new Station("여의도", "9호선", "915"));
        stationList.add(new Station("샛강", "9호선", "916"));
        stationList.add(new Station("노량진", "9호선", "917"));
        stationList.add(new Station("노들", "9호선", "918"));
        stationList.add(new Station("흑석", "9호선", "919"));
        stationList.add(new Station("동작", "9호선", "920"));
        stationList.add(new Station("구반포", "9호선", "921"));
        stationList.add(new Station("신반포", "9호선", "922"));
        stationList.add(new Station("고속터미널", "9호선", "923"));
        stationList.add(new Station("사평", "9호선", "924"));
        stationList.add(new Station("신논현", "9호선", "925"));

        // 중앙선
        stationList.add(new Station("청량리", "중앙선", "191"));
        stationList.add(new Station("왕십리", "중앙선", "192"));
        stationList.add(new Station("응봉", "중앙선", "193"));
        stationList.add(new Station("옥수", "중앙선", "195"));
        stationList.add(new Station("한남", "중앙선", "196"));
        stationList.add(new Station("서빙고", "중앙선", "197"));
        stationList.add(new Station("이촌", "중앙선", "198"));
        stationList.add(new Station("용문", "중앙선", "1300"));
        stationList.add(new Station("원덕", "중앙선", "1301"));
        stationList.add(new Station("양평", "중앙선", "1302"));
        stationList.add(new Station("아신", "중앙선", "1303"));
        stationList.add(new Station("국수", "중앙선", "1304"));
        stationList.add(new Station("신원", "중앙선", "1305"));
        stationList.add(new Station("양수", "중앙선", "1306"));
        stationList.add(new Station("운길산", "중앙선", "1307"));
        stationList.add(new Station("팔당", "중앙선", "1308"));
        stationList.add(new Station("도심", "중앙선", "1309"));
        stationList.add(new Station("덕소", "중앙선", "1310"));
        stationList.add(new Station("양정", "중앙선", "1311"));
        stationList.add(new Station("도농", "중앙선", "1312"));
        stationList.add(new Station("구리", "중앙선", "1313"));
        stationList.add(new Station("양원", "중앙선", "1314"));
        stationList.add(new Station("망우", "중앙선", "1315"));
        stationList.add(new Station("중랑", "중앙선", "1316"));
        stationList.add(new Station("회기", "중앙선", "1317"));
        stationList.add(new Station("용산", "중앙선", "1318"));
        stationList.add(new Station("상봉", "중앙선", "1390"));
        stationList.add(new Station("오빈", "중앙선", "1394"));

        // 분당선
        stationList.add(new Station("왕십리", "분당선", "1510"));
        stationList.add(new Station("서울숲", "분당선", "1511"));
        stationList.add(new Station("압구정로데오", "분당선", "1512"));
        stationList.add(new Station("강남구청", "분당선", "1513"));
        stationList.add(new Station("선정릉", "분당선", "1514"));
        stationList.add(new Station("선릉", "분당선", "1515"));
        stationList.add(new Station("한티", "분당선", "1516"));
        stationList.add(new Station("도곡", "분당선", "1517"));
        stationList.add(new Station("구룡", "분당선", "1518"));
        stationList.add(new Station("개포동", "분당선", "1519"));
        stationList.add(new Station("대모산입구", "분당선", "1520"));
        stationList.add(new Station("수서", "분당선", "1521"));
        stationList.add(new Station("복정", "분당선", "1522"));
        stationList.add(new Station("가천대", "분당선", "1523"));
        stationList.add(new Station("태평", "분당선", "1524"));
        stationList.add(new Station("모란", "분당선", "1525"));
        stationList.add(new Station("야탑", "분당선", "1526"));
        stationList.add(new Station("이매", "분당선", "1527"));
        stationList.add(new Station("서현", "분당선", "1528"));
        stationList.add(new Station("수내", "분당선", "1529"));
        stationList.add(new Station("정자", "분당선", "1530"));
        stationList.add(new Station("미금", "분당선", "1531"));
        stationList.add(new Station("오리", "분당선", "1532"));
        stationList.add(new Station("보정", "분당선", "1533"));
        stationList.add(new Station("죽전", "분당선", "1534"));
        stationList.add(new Station("구성", "분당선", "1535"));
        stationList.add(new Station("신갈", "분당선", "1536"));
        stationList.add(new Station("기흥", "분당선", "1537"));
        stationList.add(new Station("상갈", "분당선", "1538"));
        stationList.add(new Station("청명", "분당선", "1539"));
        stationList.add(new Station("영통", "분당선", "1540"));
        stationList.add(new Station("망포", "분당선", "1541"));
        stationList.add(new Station("매탄권선", "분당선", "1542"));
        stationList.add(new Station("수원시청", "분당선", "1543"));
        stationList.add(new Station("매교", "분당선", "1544"));
        stationList.add(new Station("수원", "분당선", "1545"));

        // 경의선
        stationList.add(new Station("공덕", "경의선", "1607"));
        stationList.add(new Station("서강대", "경의선", "1608"));
        stationList.add(new Station("홍대입구", "경의선", "1609"));
        stationList.add(new Station("서울역", "경의선", "1610"));
        stationList.add(new Station("신촌", "경의선", "1611"));
        stationList.add(new Station("가좌", "경의선", "1612"));
        stationList.add(new Station("디지털미디어시티", "경의선", "1613"));
        stationList.add(new Station("수색", "경의선", "1614"));
        stationList.add(new Station("화전", "경의선", "1615"));
        stationList.add(new Station("행신", "경의선", "1616"));
        stationList.add(new Station("능곡", "경의선", "1617"));
        stationList.add(new Station("대곡", "경의선", "1618"));
        stationList.add(new Station("곡산", "경의선", "1619"));
        stationList.add(new Station("백마", "경의선", "1620"));
        stationList.add(new Station("풍산", "경의선", "1621"));
        stationList.add(new Station("일산", "경의선", "1622"));
        stationList.add(new Station("탄현", "경의선", "1623"));
        stationList.add(new Station("운정", "경의선", "1624"));
        stationList.add(new Station("금릉", "경의선", "1625"));
        stationList.add(new Station("금촌", "경의선", "1626"));
        stationList.add(new Station("월롱", "경의선", "1627"));
        stationList.add(new Station("파주", "경의선", "1628"));
        stationList.add(new Station("문산", "경의선", "1629"));

        // 에버라인
        stationList.add(new Station("기흥", "에버라인", "1701"));
        stationList.add(new Station("강남대", "에버라인", "1702"));
        stationList.add(new Station("지석", "에버라인", "1703"));
        stationList.add(new Station("어정", "에버라인", "1704"));
        stationList.add(new Station("동백", "에버라인", "1705"));
        stationList.add(new Station("초당", "에버라인", "1706"));
        stationList.add(new Station("삼가", "에버라인", "1707"));
        stationList.add(new Station("시청.용인대", "에버라인", "1708"));
        stationList.add(new Station("명지대", "에버라인", "1709"));
        stationList.add(new Station("김량장", "에버라인", "1710"));
        stationList.add(new Station("운동장.송담대", "에버라인", "1711"));
        stationList.add(new Station("고진", "에버라인", "1712"));
        stationList.add(new Station("보평", "에버라인", "1713"));
        stationList.add(new Station("둔전", "에버라인", "1714"));
        stationList.add(new Station("전대.에버랜드", "에버라인", "1715"));

        // 경춘선
        stationList.add(new Station("광운대", "경춘선", "1809"));
        stationList.add(new Station("상봉", "경춘선", "1810"));
        stationList.add(new Station("망우", "경춘선", "1811"));
        stationList.add(new Station("신내", "경춘선", "1812"));
        stationList.add(new Station("갈매", "경춘선", "1813"));
        stationList.add(new Station("별내", "경춘선", "1814"));
        stationList.add(new Station("퇴계원", "경춘선", "1815"));
        stationList.add(new Station("사릉", "경춘선", "1816"));
        stationList.add(new Station("금곡", "경춘선", "1817"));
        stationList.add(new Station("평내호평", "경춘선", "1818"));
        stationList.add(new Station("천마산", "경춘선", "1819"));
        stationList.add(new Station("마석", "경춘선", "1820"));
        stationList.add(new Station("대성리", "경춘선", "1821"));
        stationList.add(new Station("청평", "경춘선", "1822"));
        stationList.add(new Station("상천", "경춘선", "1823"));
        stationList.add(new Station("가평", "경춘선", "1824"));
        stationList.add(new Station("굴봉산", "경춘선", "1825"));
        stationList.add(new Station("백양리", "경춘선", "1826"));
        stationList.add(new Station("강촌", "경춘선", "1827"));
        stationList.add(new Station("김유정", "경춘선", "1828"));
        stationList.add(new Station("남춘천", "경춘선", "1829"));
        stationList.add(new Station("춘천", "경춘선", "1830"));

        // 신분당선
        stationList.add(new Station("강남", "신분당선", "1910"));
        stationList.add(new Station("양재", "신분당선", "1911"));
        stationList.add(new Station("양재시민의숲", "신분당선", "1912"));
        stationList.add(new Station("청계산입구", "신분당선", "1913"));
        stationList.add(new Station("판교", "신분당선", "1914"));
        stationList.add(new Station("정자", "신분당선", "1915"));

        // 인천1호선
        stationList.add(new Station("계양", "인천1호선", "20110"));
        stationList.add(new Station("귤현", "인천1호선", "20111"));
        stationList.add(new Station("박촌", "인천1호선", "20112"));
        stationList.add(new Station("임학", "인천1호선", "20113"));
        stationList.add(new Station("계산", "인천1호선", "20114"));
        stationList.add(new Station("경인교대입구", "인천1호선", "20115"));
        stationList.add(new Station("작전", "인천1호선", "20116"));
        stationList.add(new Station("갈산", "인천1호선", "20117"));
        stationList.add(new Station("부평구청", "인천1호선", "20118"));
        stationList.add(new Station("부평시장", "인천1호선", "20119"));
        stationList.add(new Station("부평", "인천1호선", "20120"));
        stationList.add(new Station("동수", "인천1호선", "20121"));
        stationList.add(new Station("부평삼거리", "인천1호선", "20122"));
        stationList.add(new Station("간석오거리", "인천1호선", "20123"));
        stationList.add(new Station("인천시청", "인천1호선", "20124"));
        stationList.add(new Station("예술회관", "인천1호선", "20125"));
        stationList.add(new Station("인천터미널", "인천1호선", "20126"));
        stationList.add(new Station("문학경기장", "인천1호선", "20127"));
        stationList.add(new Station("선학", "인천1호선", "20128"));
        stationList.add(new Station("신연수", "인천1호선", "20129"));
        stationList.add(new Station("원인재", "인천1호선", "20130"));
        stationList.add(new Station("동춘", "인천1호선", "20131"));
        stationList.add(new Station("동막", "인천1호선", "20132"));
        stationList.add(new Station("캠퍼스타운", "인천1호선", "20133"));
        stationList.add(new Station("테크노파크", "인천1호선", "20134"));
        stationList.add(new Station("지식정보단지", "인천1호선", "20135"));
        stationList.add(new Station("인천대입구", "인천1호선", "20136"));
        stationList.add(new Station("센트럴파크", "인천1호선", "20137"));
        stationList.add(new Station("국제업무지구", "인천1호선", "20138"));

    }

    public String[] getAllName() {

        item = new String[stationList.size()];

        for(int i = 0; i < stationList.size(); i++) {
            item[i] = stationList.get(i).getName();
        }
        return item;
    }

    public ArrayList<Station> getStation() {
        return stationList;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public String getLine() {
        return line;
    }

    /**
     * @return
     */
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Station [name=" + name + ", line=" + line + ", code="
                + code + "]";
    }
}
