package beup.cc.core;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public class Record {

    private List<Map<String,Object>> values;

    private Record() {
    }

    public List<Map<String,Object>> getValues() {
        return values;
    }

}
