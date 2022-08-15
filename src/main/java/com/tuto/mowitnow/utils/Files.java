package com.tuto.mowitnow.utils;

import java.io.File;

public class Files {

    public static boolean isExist(File f) {
        return f.exists();
    }

    public static boolean isFile(File f) {
        return !f.isFile();
    }
}
