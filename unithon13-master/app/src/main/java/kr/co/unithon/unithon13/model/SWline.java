package kr.co.unithon.unithon13.model;

import lombok.AllArgsConstructor;

/**
 * Created by daehyun on 16. 2. 13..
 */

public class SWline {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String code;
    private String name;

    public SWline(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
