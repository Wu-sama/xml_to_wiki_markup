package com.test.astraia.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReportWatcherTest {
    //todo
    // 1. добавили не ксмл файл
    // 2. пустой файл с расширение ксмл
    // 3.добавили ксмл файл но не с репорт внутри

    private static ReportWatcher watcher;
    private static File folder = new File("src/test/resources");
    private final static Map<String, String> map = new HashMap<>();

    @BeforeAll
    private static void watch(){
        watcher = new ReportWatcher(folder);
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
    }

    @Test
    public void test() throws IOException, InterruptedException {
        File file = new File(folder, "test.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Some String");
        }
        wait(10000);
        file.delete();
        wait(2000);
        Assertions.assertEquals(file.getName(), map.get("file.created"));
    }

    public void wait(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
