package beup.cc;

import beup.cc.config.SyncConfig;

public class Main {

    public static void main(String[] args) {
        SyncStarter.start(new SyncConfig());
    }

}
