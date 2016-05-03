package kr.co.unithon.unithon13.httpService;

import org.simpleframework.xml.Element;

import kr.co.unithon.unithon13.model.Result;

/**
 * Created by daehyun on 16. 2. 13..
 */
public class BaseResponse {
    @Element(name="RESULT")
    public Result result;
}
