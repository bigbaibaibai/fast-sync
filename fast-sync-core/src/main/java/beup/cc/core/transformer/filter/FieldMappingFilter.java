package beup.cc.core.transformer.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 将param中的字段，fieldMap以重命名
 */
public class FieldMappingFilter extends AbstractFilter {

    protected final Map<String, String> fieldMap;

    public FieldMappingFilter(Map<String, String> fieldMap) {
        this.fieldMap = fieldMap;
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
