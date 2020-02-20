package com.company.Util;

import java.io.File;
import java.util.Scanner;

public class DirectoryUtilities {

    public static void deleteDirectory(String path) {
        System.out.println("Are you sure you want to delete this folder: " + path + "? y/n");
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();
        if (answer.equals("y")) {
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

}
