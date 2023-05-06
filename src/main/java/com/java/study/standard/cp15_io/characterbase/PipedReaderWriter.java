package com.java.study.standard.cp15_io.characterbase;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipedReaderWriter {
    public static void main(String[] args) {
        InputThread inputThread = new InputThread("InputThread");
        OutputThread outputThread = new OutputThread("OutputThread");

        // PipedReader 와 PipedWriter을 연결한다
        inputThread.connect(outputThread.getOutput());

        inputThread.start();
        outputThread.start();
    }

    static class InputThread extends Thread {

        PipedReader input = new PipedReader();
        StringWriter sw = new StringWriter();

        public InputThread(String name) {
            super(name);    // Thread(String name)
        }

        @Override
        public void run() {
            try {
                   int data = 0;

                while ((data = input.read()) != -1) {
                    sw.write(data);
                }
                System.out.println(getName() + " 받은 내용 : " + sw.toString());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        public PipedReader getInput() {
            return input;
        }

        public void connect(PipedWriter output) {
            try {
                input.connect(output);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class OutputThread extends Thread {
        PipedWriter output = new PipedWriter();

        public OutputThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                String msg = "안뇽";
                System.out.println(getName() + " 보냄 : " + msg);
                output.write(msg);
                output.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        public PipedWriter getOutput() {
            return output;
        }

        public void connect(PipedReader input) {
            try {
                output.connect(input);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
