package beup.cc.receiver;

import beup.cc.SyncContext;

public interface Receiver extends Cloneable, Runnable{

    void setContext(SyncContext syncContext);

}
