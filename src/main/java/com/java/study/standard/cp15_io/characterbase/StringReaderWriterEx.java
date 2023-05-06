package com.java.study.standard.cp15_io.characterbase;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterEx {
    public static void main(String[] args) throws IOException {

        String inputData = "개처럼 짖어";
        StringReader input = new StringReader(inputData);
        StringWriter output = new StringWriter();

        int data = 0;

        while ((data = input.read()) != -1) {
            output.write(data);
        }

        System.out.println("Input : " + inputData);
        System.out.println("Output : " + output);
        System.out.println("Output.toString() : " + output.toString());
        System.out.println("Output.getBuffer() : " + output.getBuffer());
        System.out.println("Output.getBuffer().toString() : " + output.getBuffer().toString());

    }
}
