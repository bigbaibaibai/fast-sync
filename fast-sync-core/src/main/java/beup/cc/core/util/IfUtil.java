package beup.cc.core.util;

import java.util.Objects;

public class IfUtil {

    public static String ifBlankDefault(String target, String defaultValue) {
        if (Objects.isNull(target) || target.length() == 0) {
            return defaultValue;
        } else {
            return target;
        }
    }

    public static <T> T ifNullDefault(T target, T defaultValue) {
        if (Objects.isNull(target)) {
            return defaultValue;
        } else {
            return target;
        }
    }

}
