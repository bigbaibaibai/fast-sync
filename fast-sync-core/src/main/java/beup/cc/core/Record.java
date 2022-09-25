package beup.cc.core;

import java.util.List;
import java.util.Map;

public class Record {

    private String rowKey;

    private List<Map<String,Object>> values;

    private Record() {
    }

    public String getRowKey() {
        return rowKey;
    }

    public List<Map<String,Object>> getValues() {
        return values;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Record record = new Record();

        public Builder rowKey(String rowKey) {
            record.rowKey = rowKey;
            return this;
        }

        public Builder values(List<Map<String,Object>> values) {
            record.values = values;
            return this;
        }

        public Record build() {
            return record;
        }

    }

}
