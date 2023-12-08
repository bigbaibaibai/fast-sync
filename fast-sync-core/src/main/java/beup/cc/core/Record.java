package beup.cc.core;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public class Record {

    private Map<String,Object> value;

    public Record(Map<String,Object> value) {
        this.value = value;
    }

    public Map<String,Object> getValue() {
        return value;
    }

}
