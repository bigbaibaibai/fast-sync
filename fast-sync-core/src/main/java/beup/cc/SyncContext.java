package beup.cc;

import beup.cc.config.SyncConfig;
import beup.cc.receiver.Receiver;
import beup.cc.transformer.Transformer;
import beup.cc.writer.Writer;

import java.util.List;

public interface SyncContext {

    void addTransformer(Transformer transformer);

    void addReceiver(Receiver receiver);

    void addWriter(Writer writer);

    void configuration(SyncConfig syncConfig);

    void setMonitor(Monitor monitor);

    Transformer getTransformer(String key);

    List<Transformer> listMatchTransformer(String keyMatch);

    List<Transformer> listAllMatchTransformer();

    List<Receiver> listReceiver();

    List<Writer> listWriter();

    void start();

    void stop();

    boolean isRunning();

}
