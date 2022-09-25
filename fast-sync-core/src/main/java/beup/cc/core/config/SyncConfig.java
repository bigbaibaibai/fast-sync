package beup.cc.core.config;

import java.util.LinkedList;
import java.util.List;

public class SyncConfig {

    private final List<ReceiverConfig> receiverConfigList = new LinkedList<>();

    private final List<TransmitterConfig> transmitterConfigList = new LinkedList<>();

    private final List<WriterConfig> writerConfigList = new LinkedList<>();

    public List<ReceiverConfig> getReceiverConfigList() {
        return receiverConfigList;
    }

    public List<TransmitterConfig> getTransmitterConfigList() {
        return transmitterConfigList;
    }

    public List<WriterConfig> getWriterConfigList() {
        return writerConfigList;
    }

}
