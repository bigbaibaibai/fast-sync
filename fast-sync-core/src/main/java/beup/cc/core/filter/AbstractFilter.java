package beup.cc.core.filter;

import java.util.Map;

public abstract class AbstractFilter implements Filter {

    protected final Map<String, String> fieldMap;

    public AbstractFilter(Map<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }

}
