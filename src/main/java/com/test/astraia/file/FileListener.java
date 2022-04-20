package com.test.astraia.file;

import java.nio.file.Path;
import java.util.EventListener;

public interface FileListener extends EventListener {
    void onCreated(FileEvent event);
    void onCreated(Path file);
}
