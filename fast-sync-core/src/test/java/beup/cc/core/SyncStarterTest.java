package beup.cc.core;

import beup.cc.core.transformer.filter.FieldMappingFilter;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.receiver.TimeReceiver;
import beup.cc.core.transformer.SimpleTransformer;
import beup.cc.core.job.DefaultSyncJob;
import beup.cc.core.job.SyncJob;
import beup.cc.core.writer.PrintWriter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SyncStarterTest {

    public static void main(String[] args) {
        final SyncStarterTest syncStarterTest = new SyncStarterTest();
        syncStarterTest.starter();
    }

    public void starter() {

        final SyncContext syncContext = new SimpleSyncContext();
        //注册接收器
        syncContext.addReceiver(buildTestTimeReceiver(syncContext));

        //注册写入器
        final PrintWriter printWriter = new PrintWriter("TestPrintWriter");
        syncContext.addWriter(printWriter);

        //注册一个传输流程
        syncContext.addTransmitter(buildSimpleTransmitter(printWriter));

        syncContext.start();

    }

    private SyncJob buildSimpleTransmitter(PrintWriter printWriter) {
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("name", "name");
        fieldMap.put("age", "age1");
        fieldMap.put("time", "time");

        FieldMappingFilter filter = new FieldMappingFilter(fieldMap);
        SimpleTransformer simpleTransformer = new SimpleTransformer(Collections.singletonList(filter));
        return new DefaultSyncJob("SimpleTransmitter", "test", simpleTransformer, printWriter);
    }

    private Receiver buildTestTimeReceiver(SyncContext syncContext) {
        final TimeReceiver testTimeReceiver = new TimeReceiver(, syncContext);
        testTimeReceiver.setTime(200);
        testTimeReceiver.setBatchSize(10);
        testTimeReceiver.setMaxSize(1000);
        testTimeReceiver.setRowKey("test");
        testTimeReceiver.setContentSupplier(() -> {
            final Map<String, Object> map = new HashMap<>();
            map.put("name", "bai");
            map.put("age", 24);
            map.put("time", LocalDateTime.now().toString());
            return map;
        });
        return testTimeReceiver;
    }

}