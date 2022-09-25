package beup.cc.core;

import beup.cc.core.filter.FieldFilter;
import beup.cc.core.receiver.Receiver;
import beup.cc.core.receiver.TestTimeReceiver;
import beup.cc.core.transformer.SimpleTransformer;
import beup.cc.core.transmitter.SimpleTransmitter;
import beup.cc.core.transmitter.Transmitter;
import beup.cc.core.writer.TestPrintWriter;

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
        final TestPrintWriter printWriter = new TestPrintWriter("TestPrintWriter");
        syncContext.addWriter(printWriter);

        //注册一个传输流程
        syncContext.addTransmitter(buildSimpleTransmitter(printWriter));

        syncContext.start();

    }

    private Transmitter buildSimpleTransmitter(TestPrintWriter printWriter) {
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("name", "name");
        fieldMap.put("age", "age");
        fieldMap.put("time", "time");

        FieldFilter filter = new FieldFilter(fieldMap);
        SimpleTransformer simpleTransformer = new SimpleTransformer(Collections.singletonList(filter));
        return new SimpleTransmitter("SimpleTransmitter", "test", simpleTransformer, printWriter);
    }

    private Receiver buildTestTimeReceiver(SyncContext syncContext) {
        final TestTimeReceiver testTimeReceiver = new TestTimeReceiver("TestTimeReceiver", syncContext);
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