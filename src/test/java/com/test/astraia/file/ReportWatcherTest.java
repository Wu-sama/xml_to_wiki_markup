package com.test.astraia.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReportWatcherTest {
    //todo
    // 1. добавили не ксмл файл
    // 2. пустой файл с расширение ксмл
    // 3.добавили ксмл файл но не с репорт внутри

    @Test
    public void test() throws IOException, InterruptedException {
        File folder = new File("src/test/resources");
        final Map<String, String> map = new HashMap<>();
        ReportWatcher watcher = new ReportWatcher(folder);
        watcher.addListener(new FileAdapter() {
            public void onCreated(FileEvent event) {
                map.put("file.created", event.getFile().getName());
            }

            public void onModified(FileEvent event) {
                map.put("file.modified", event.getFile().getName());
            }

            public void onDeleted(FileEvent event) {
                map.put("file.deleted", event.getFile().getName());
            }
        }).watch();
        Assertions.assertEquals(1, watcher.getListeners().size());
        wait(2000);
        File file = new File(folder, "test.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Some String");
        }
        wait(2000);
//        file.delete();
        wait(2000);
        Assertions.assertEquals(file.getName(), map.get("file.created"));
        Assertions.assertEquals(file.getName(), map.get("file.modified"));
        Assertions.assertEquals(file.getName(), map.get("file.deleted"));
    }

    @Test
    public void createFile() throws IOException {
        File folder = new File("src/test/resources");
        File file = new File(folder, "test.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Some String");
        }
        Assertions.assertNotNull(file);
    }
    public void wait(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
