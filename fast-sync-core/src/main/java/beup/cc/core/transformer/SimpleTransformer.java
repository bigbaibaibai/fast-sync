package beup.cc.core.transformer;

import beup.cc.core.Record;
import beup.cc.core.filter.Filter;

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
        if (Objects.isNull(filterList) || filterList.size() == 0) {
            return true;
        }
        final Iterator<Map<String, Object>> iterator = record.getValues().iterator();
        while (iterator.hasNext()) {
            final Map<String, Object> value = iterator.next();
            for (Filter filter : filterList) {
                if (!filter.filter(value)) {
                    iterator.remove();
                }
            }
        }
        return !record.getValues().isEmpty();
    }

}
