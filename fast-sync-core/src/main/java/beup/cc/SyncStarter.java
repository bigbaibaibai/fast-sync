package beup.cc;

import beup.cc.config.SyncConfig;
import beup.cc.receiver.Receiver;

public class SyncStarter {

    public static SyncContext start(SyncConfig syncConfig){
        final SyncContext syncContext = new SimpleSyncContext();
        syncContext.configuration(syncConfig);
        syncContext.start();
        return syncContext;
    }

}
