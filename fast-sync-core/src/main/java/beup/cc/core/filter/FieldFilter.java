package beup.cc.core.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FieldFilter extends AbstractFilter {

    public FieldFilter(Map<String, String> fieldMap) {
        super(fieldMap);
    }

    @Override
    public boolean filter(Map<String, Object> param) {
        final Map<String, Object> temp = new HashMap<>();
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            final String newField = fieldMap.get(entry.getKey());
            if (Objects.nonNull(newField)) {
                temp.put(newField, entry.getValue());
            }
        }
        param.clear();
        param.putAll(temp);
        return !param.isEmpty();
    }

}
