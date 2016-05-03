package kr.co.unithon.unithon13.model;

import lombok.ToString;

/**
 * Created by daehyun on 16. 2. 13..
 */
@ToString
public class SwResult {

        //    <RESULT>
//    <code>INFO-000</code>
//    <developerMessage/>
//    <link/>
//    <message>정상 처리되었습니다.</message>
//    <status>200</status>
//    <total>1</total>
        public String code;
        public String developerMessage;
        public String link;
        public String message;
        public String status;
        public String total;
        //    </RESULT>

}
