package ua.com.juja.maistrenko.week10;

import java.io.*;

public class BasicIO {

    public static void main(String[] args) {
        readerWriter();
        System.out.println();
        streamReaderWriter();
        bufferedReaderWriter();
    }

    static void streamReaderWriter(){
        int chunk;
        try (FileInputStream inp = new FileInputStream("input.txt");
             FileOutputStream outp = new FileOutputStream("output2.txt")) {
            while((chunk = inp.read()) != -1){
                System.out.print((char)chunk);
                outp.write(chunk);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void readerWriter(){
        int chunk;
        try (FileReader inp = new FileReader("input.txt");
             FileWriter outp = new FileWriter("output.txt")) {
            while((chunk = inp.read()) != -1){
                System.out.print((char)chunk);
                outp.write(chunk);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void bufferedReaderWriter(){
        String chunk;
        try (BufferedReader inp = new BufferedReader(new FileReader("input.txt"));
             PrintWriter outp = new PrintWriter(new FileWriter("output3.txt"))) {
            while((chunk = inp.readLine()) != null){
                System.out.println(chunk);
                outp.println(chunk);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void quiz() {
        new DataOutputStream(new BufferedOutputStream(new ByteArrayOutputStream()));
        //new DataOutputStream(byte[]);
        DataOutput ref = null;



    }
}
