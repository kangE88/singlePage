package onLoadTest;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class onLoadTest {
    //contents
    String test = "onLoad";


    public Map<String, Object> test() {
        Map<String, Object> rtnMap = new HashMap<>();
        List<Object> testLst = new ArrayList<>();

        testLst.add(0, "cast away!");
        rtnMap.put("fst", testLst);

        return rtnMap;
    }

    public Map<String, Object> test2() {
        Map<String, Object> rtnMap = new HashMap<>();
        System.out.println("커밋푸시잊지마!!!");
        rtnMap.put("fst", "커밋푸시잊지마!!!");
        return rtnMap;
    }
}



