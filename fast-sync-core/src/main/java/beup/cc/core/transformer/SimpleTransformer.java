package beup.cc.core.transformer;

import beup.cc.core.Record;
import beup.cc.core.transformer.filter.Filter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SimpleTransformer implements Transformer {

    private final List<Filter> filterList;

    public SimpleTransformer(List<Filter> filterList) {
        this.filterList = filterList;
    }

    @Override
    public boolean transform(Record record) {
        if (Objects.isNull(filterList) || filterList.isEmpty()) {
            return true;
        }
        final Map<String, Object> value = record.getValue();
        for (Filter filter : filterList) {
            if (!filter.filter(value)) {
                return false;
            }
        }
        return true;
    }

}
