package com.java.study.standard.cp14_stream;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class StreamEx2_9 {

    public static void main(String[] args) {

//        Path path = Paths.get("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\standard\\cp14_stream");
//        Path path = Paths.get("");

        URL resource = StreamEx2_9.class.getResource(".");
//        System.out.println("resource = " + resource);

        String path = resource.getPath();
//        System.out.println("path = " + path);


//        String string = path.toUri().getPath();
//        File file = new File(string);

        File file = new File(path);


        List<File> fileList = Arrays.asList(file.listFiles());
        fileList.stream()
                .filter((f) -> f.getName().startsWith("Stream"))
                .filter((f) -> f.getName().indexOf("$") == -1)
                .peek(f -> System.out.println(f))
                .map((f) -> {
                    int i = f.getName().indexOf(".");
                    String substring = f.getName().substring(0,i);
                    return substring;
                })
                .peek(f -> System.out.println(f))
                .forEach((f) -> System.out.println(f));






    }
}
