package kr.co.unithon.unithon13.model;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;

import lombok.ToString;

/**
 * Created by daehyun on 16. 2. 13..
 */
@ToString
public class Result {
    @Element(name="CODE")
    public String code;
    @Element(name="MESSAGE")
    public String message;

}
