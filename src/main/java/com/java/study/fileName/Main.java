package com.java.study.fileName;

import com.google.common.io.Files;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String path = "C:/Users/USER/Desktop/사진_모음/dogs";
        String jpgPath = "C:/Users/USER/Desktop/사진_모음/dogs/jpg";
        String pngPath = "C:/Users/USER/Desktop/사진_모음/dogs/png";

//        File file = new File(jpgPath);


        File[] files = (new File(jpgPath)).listFiles();
        System.out.println("files.length = " + files.length);

//        int num = 143;
//        for (File f : files) {
//            System.out.println(f.getName());
//            if (f.getName().contains("jpg")) {
//                File toFile = new File(jpgPath + "/" + num + ".jpg");
//                boolean b = f.renameTo(toFile);
//            } else if (f.getName().contains("png")) {
//                File toFile = new File(pngPath + "/" + num + ".png");
//                boolean b = f.renameTo(toFile);
//            }
//            num++;
//        }

//        int num = 1;
//        for (File file : (new File(jpgPath)).listFiles()) {
//            file.renameTo(new File(jpgPath + "/" + num + ".jpg"));
//            num++;
//        }

        int num2 = 1;
        for (File file : (new File(pngPath)).listFiles()) {
            file.renameTo(new File(pngPath + "/" + num2 + ".png"));
            num2++;
        }


    }
}
