package com.succulent.lib.file.util;

import java.io.File;

public class FileUtil {

    public static boolean delete(String path) {
        if (path == null) { return true; }
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return true;
    }

}
