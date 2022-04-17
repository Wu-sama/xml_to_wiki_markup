package com.test.astraia.file;

import java.util.EventListener;

public interface FileListener extends EventListener {
    void onCreated(FileEvent event);
}
