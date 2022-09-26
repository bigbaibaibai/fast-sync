package beup.cc.core;

import beup.cc.core.config.SyncConfig;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.transmitter.Transmitter;
import beup.cc.core.writer.Writer;

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
    public void addReceiver(Receiver receiver) {
        receiverMap.put(receiver.getId(), receiver);
        receiverList.add(receiver);
    }

    @Override
    public void addWriter(Writer writer) {
        writerMap.put(writer.getId(), writer);
        writerList.add(writer);
    }

    @Override
    public void configuration(SyncConfig syncConfig) {

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

    @Override
    public List<Transmitter> listTransmitter(String rowKey) {
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
        this.writerMap.remove(writer);
        writer.stop();
        return writer;
    }

    @Override
    public void start() {
        startWriter();
        startReceiver();
        isRunning = true;
    }

    private void startWriter() {
        for (Writer writer : writerList) {
            writer.start();
        }
    }

    public void startReceiver() {
        for (Receiver receiver : receiverList) {
            new Thread(receiver::start).start();
        }
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

//        this.writerList.clear();
//        this.receiverList.clear();
//        this.transmitterList.clear();
//        this.receiverMap.clear();
//        this.transmitterMap.clear();
//        this.writerMap.clear();
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

}
