package ua.com.juja.maistrenko.week10.lab45;

import java.io.*;

public class ByteFilter {
    public static void filter(InputStream src, OutputStream dst, int bufferSize, byte filterCriteria) throws IOException {

        byte[] buffer = new byte[bufferSize];

        while (src.read(buffer) > -1) {

            int begin = 0;
            int links = 0;

            for (int i = 0; i < bufferSize; i++) {
                if (buffer[i] == filterCriteria) {
                    if (links > 0) {
                        dst.write(buffer,begin,links);
                    }
                    links = 0;
                    begin = i + 1;
                } else {
                    links++;
                }
            }
            if (links > 0) {
                dst.write(buffer,begin,links);
            }
            buffer = new byte[bufferSize];
        }
    }

}