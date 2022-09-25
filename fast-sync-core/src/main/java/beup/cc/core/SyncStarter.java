package beup.cc.core;

import beup.cc.core.config.SyncConfig;

public class SyncStarter {

    public static SyncContext start(SyncConfig syncConfig){
        final SyncContext syncContext = new SimpleSyncContext();
        syncContext.configuration(syncConfig);
        syncContext.start();
        return syncContext;
    }

}
