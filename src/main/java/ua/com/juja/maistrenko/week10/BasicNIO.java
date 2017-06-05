package ua.com.juja.maistrenko.week10;

import java.io.IOException;
import java.io.RandomAccessFile;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

public class BasicNIO {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("input.txt","r");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(32);
        int res = channel.read(buffer);
        while (res != -1 ) {
            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            res = channel.read(buffer);
        }

        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        int wer = interestSet & SelectionKey.OP_ACCEPT;

    }
}
