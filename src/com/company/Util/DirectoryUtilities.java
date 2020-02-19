package com.company.Util;

import java.io.File;

public class DirectoryUtilities {

    public static void deleteDirectory(String path) {
        File directory = new File(path);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        deleteDirectory(files[i].getPath());
                    } else {
                        files[i].delete();
                    }
                }
            }
        }
        directory.delete();
    }

}
