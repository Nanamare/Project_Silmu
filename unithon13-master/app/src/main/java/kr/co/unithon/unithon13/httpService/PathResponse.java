package kr.co.unithon.unithon13.httpService;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import kr.co.unithon.unithon13.model.PathResult;
import kr.co.unithon.unithon13.model.SwResult;

/**
 * Created by daehyun on 16. 2. 13..
 */
@Root(name="shortestRoute")
public class PathResponse {
    @Element(name="RESULT")
    public SwResult result;

    @ElementList(entry="row", inline=true)
    public List<PathResult> pathResult;
}
