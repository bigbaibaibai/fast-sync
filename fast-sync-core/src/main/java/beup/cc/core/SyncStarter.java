package beup.cc.core;

import beup.cc.core.job.DefaultSyncJob;
import beup.cc.core.receiver.TimeReceiver;
import beup.cc.core.transformer.SimpleTransformer;
import beup.cc.core.transformer.filter.FieldMappingFilter;
import beup.cc.core.writer.PrintWriter;
import beup.cc.core.writer.Writer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SyncStarter {

    public static void main(String[] args) {

        final TimeReceiver receiver = new TimeReceiver(() -> {
            Map<String, Object> data = new HashMap<>();
            data.put("a", "111");
            data.put("b", "111");
            data.put("c", "111");
            return data;
        }, 1);

        Map<String, String> mapping = new HashMap<>();
        mapping.put("a", "a1");
        mapping.put("b", "b1");
        mapping.put("c", "c1");
        final FieldMappingFilter fieldMappingFilter = new FieldMappingFilter(mapping);

        final SimpleTransformer transformer = new SimpleTransformer(Collections.singletonList(fieldMappingFilter));
        final Writer writer = new PrintWriter();

        final DefaultSyncJob syncJob = new DefaultSyncJob("test", receiver, transformer, writer);
        syncJob.start();

    }

}
