package beup.cc.core;

import beup.cc.core.config.SyncConfig;
import beup.cc.core.monitor.Monitor;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.transmitter.Transmitter;
import beup.cc.core.writer.Writer;

import java.util.List;

public interface SyncContext extends LifeCycle {

    void addTransmitter(Transmitter transmitter);

    void addReceiver(Receiver receiver);

    void addWriter(Writer writer);

    void configuration(SyncConfig syncConfig);

    Transmitter getTransmitter(String id);

    Transmitter removeTransmitter(String id);

    List<Transmitter> listTransmitter(String rowKey);

    List<Transmitter> listTransmitter();

    List<Receiver> listReceiver();

    Receiver getReceiver(String id);

    Receiver removeAndStopReceiver(String id);

    List<Writer> listWriter();

    Writer getWriter(String id);

    Writer removeAndStopWriter(String id);

}
