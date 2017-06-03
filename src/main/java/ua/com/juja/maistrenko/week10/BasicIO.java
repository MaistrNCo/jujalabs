package ua.com.juja.maistrenko.week10;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

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

    static void streamReader(){
        byte[] chunk = new byte[32];

        try (ByteArrayInputStream inp = new ByteArrayInputStream(new byte[] {})) {
            while(inp.read(chunk)!= -1 ){
                System.out.print(chunk.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void URLstreamReaderWriter(){
        String chunk = "";
        BufferedReader inp = null;

        try (BufferedWriter outp = new BufferedWriter(new FileWriter("output.htm"))) {
            URL url = new URL("http://google.com.ua");
            url.openConnection();
            inp = new BufferedReader(new InputStreamReader(url.openStream()));
            while(( chunk = inp.readLine()) != null){
                System.out.println(chunk);
                outp.write(chunk);
                outp.newLine();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inp!=null){
                try {
                    inp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static void readerWriter(){
        String chunk;
        try (BufferedReader inp = new BufferedReader(new FileReader("input.txt"));
             FileWriter outp = new FileWriter("output.txt")) {
            while((chunk = inp.readLine()) != null){
                System.out.print(chunk);
                outp.write(chunk);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
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
}
