package beup.cc;

import beup.cc.config.SyncConfig;
import beup.cc.receiver.Receiver;
import beup.cc.transformer.Transformer;
import beup.cc.writer.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SimpleSyncContext implements SyncContext {

    private final List<Receiver> receiverList = new ArrayList<Receiver>();

    private boolean isRunning;

    public void addTransformer(Transformer transformer) {

    }

    public void addReceiver(Receiver receiver) {
        receiverList.add(receiver);
    }

    public void addWriter(Writer writer) {

    }

    public void configuration(SyncConfig syncConfig) {
    }

    public void setMonitor(Monitor monitor) {

    }

    public Transformer getTransformer(String key) {
        return null;
    }

    public List<Transformer> listMatchTransformer(String keyMatch) {
        return null;
    }

    public List<Transformer> listAllMatchTransformer() {
        return null;
    }

    public List<Receiver> listReceiver() {
        return null;
    }

    public List<Writer> listWriter() {
        return null;
    }

    public void start() {
        startReceiver();

        isRunning = true;
    }

    public void startReceiver() {
        for (Receiver receiver : receiverList) {
            receiver.setContext(this);
            new Thread(receiver).start();
        }
    }

    public void stop() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

}
