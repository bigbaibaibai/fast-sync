package beup.cc.core;

import beup.cc.core.config.SyncConfig;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.receiver.ReceiverFactory;
import beup.cc.core.transmitter.Transmitter;
import beup.cc.core.writer.Writer;
import beup.cc.core.writer.WriterFactory;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleSyncContext implements SyncContext {

    private final List<Receiver> receiverList = new LinkedList<>();

    private final List<Transmitter> transmitterList = new LinkedList<>();

    private final List<Writer> writerList = new LinkedList<>();

    private final Map<String, Receiver> receiverMap = new HashMap<>();

    private final Map<String, Transmitter> transmitterMap = new HashMap<>();

    private final Map<String, Writer> writerMap = new HashMap<>();

    private boolean isRunning;

    @Override
    public void addTransmitter(Transmitter transmitter) {
        transmitterMap.put(transmitter.getId(), transmitter);
        this.transmitterList.add(transmitter);
    }

    @Override
    public void configuration(SyncConfig syncConfig) {
        for (JSONObject receiverConfig : syncConfig.getReceiverConfigList()) {
            final Receiver receiver = ReceiverFactory.getReceiver(receiverConfig, this);
            this.receiverList.add(receiver);
            this.receiverMap.put(receiver.getId(), receiver);
        }
        for (JSONObject writerConfig : syncConfig.getWriterConfigList()) {
            final Writer writer = WriterFactory.getWriter(writerConfig, this);
            this.writerList.add(writer);
            this.writerMap.put(writer.getId(), writer);
        }
        for (JSONObject transmitterConfig : syncConfig.getTransmitterConfigList()) {

        }
    }

    @Override
    public Transmitter getTransmitter(String id) {
        return this.transmitterMap.get(id);
    }

    @Override
    public Transmitter removeTransmitter(String id) {
        final Transmitter transmitter = this.transmitterMap.remove(id);
        this.transmitterList.remove(transmitter);
        return transmitter;
    }

    /**
     * 添加并开启接收器
     *
     * @author Bai Xinxiang
     * @since 2022/9/26 20:41
     */
    @Override
    public void addReceiverAndStart(Receiver receiver) {
        receiverMap.put(receiver.getId(), receiver);
        receiverList.add(receiver);
        receiver.start();
    }

    @Override
    public List<Transmitter> listMatchTransmitter(String rowKey) {
        final List<Transmitter> list = this.transmitterList.stream().filter(transmitter -> transmitter.isSupport(rowKey)).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<Transmitter> listTransmitter() {
        return this.transmitterList;
    }

    @Override
    public List<Receiver> listReceiver() {
        return this.receiverList;
    }

    @Override
    public Receiver getReceiver(String id) {
        return this.receiverMap.get(id);
    }

    @Override
    public Receiver removeAndStopReceiver(String id) {
        final Receiver receiver = this.receiverMap.remove(id);
        this.receiverList.remove(receiver);
        receiver.stop();
        return receiver;
    }

    @Override
    public void addAndStartWriter(Writer writer) {
        writerMap.put(writer.getId(), writer);
        writerList.add(writer);
        writer.start();
    }

    @Override
    public List<Writer> listWriter() {
        return this.writerList;
    }

    @Override
    public Writer getWriter(String id) {
        return this.writerMap.get(id);
    }

    @Override
    public Writer removeAndStopWriter(String id) {
        final Writer writer = this.writerMap.remove(id);
        this.writerList.remove(writer);
        writer.stop();
        return writer;
    }

    @Override
    public void start() {
        for (Writer writer : writerList) {
            writer.start();
        }
        for (Receiver receiver : receiverList) {
            receiver.start();
        }
        isRunning = true;
    }

    @Override
    public void stop() {
        isRunning = false;
        for (Receiver receiver : this.receiverList) {
            receiver.stop();
        }

        for (Writer writer : writerList) {
            writer.stop();
        }

    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

}
