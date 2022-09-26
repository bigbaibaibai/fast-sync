package beup.cc.core.config;

import beup.cc.core.transformer.TransformerConfig;
import com.alibaba.fastjson.JSONObject;

public class TransmitterConfig {

    /**
     * id
     */
    private String id;

    /**
     * 匹配字符串
     */
    private String match;

    /**
     * 写入器id
     */
    private String writerId;

    /**
     * 写入配置
     */
    private JSONObject writeConfig;

    /**
     * 转换器配置
     */
    private TransformerConfig transformerConfig;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public JSONObject getWriteConfig() {
        return writeConfig;
    }

    public void setWriteConfig(JSONObject writeConfig) {
        this.writeConfig = writeConfig;
    }

    public TransformerConfig getTransformerConfig() {
        return transformerConfig;
    }

    public void setTransformerConfig(TransformerConfig transformerConfig) {
        this.transformerConfig = transformerConfig;
    }
}
