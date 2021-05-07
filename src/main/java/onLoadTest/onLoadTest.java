package onLoadTest;

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
}



