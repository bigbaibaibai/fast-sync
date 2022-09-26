package beup.cc.core.writer.config;

import beup.cc.core.SyncContext;

public class BaseWriterConfig {

    private String id;

    private String type;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

}
