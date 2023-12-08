package beup.cc.core.transformer.filter;

import java.util.Map;

public interface Filter {

    boolean filter(Map<String, Object> param);

}
