package beup.cc.core.receiver;

import beup.cc.core.LifeCycle;
import com.alibaba.fastjson.JSONObject;

public interface Receiver extends LifeCycle {

    String getId();

    JSONObject getParam();

}
