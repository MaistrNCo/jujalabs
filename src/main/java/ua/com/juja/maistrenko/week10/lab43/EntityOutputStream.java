package ua.com.juja.maistrenko.week10.lab43;

import java.io.*;

public class EntityOutputStream implements EntityOutput {
    private final DataOutput out;
    public EntityOutputStream(OutputStream out) {
        this.out = new DataOutputStream(out);
    }

    @Override
    public void writePerson(Person person) throws IOException {
        out.writeInt(person.getAge());
        if (person.getName() == null) {
            out.writeBoolean(false);
        } else {
            out.writeBoolean(true);
            out.writeUTF(person.getName());
        }
    }

    @Override
    public void writePoint(Point point) throws IOException {
        int value = point.getX() << 4 | point.getY();
        out.writeByte(value);
    }
}

interface EntityInput {
    public Person readPerson() throws IOException;
    public Point readPoint() throws IOException;
}

interface EntityOutput {
    public void writePerson(Person person) throws IOException;
    public void writePoint(Point point) throws IOException;
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name=" + name  + ", age=" + age + "}";
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        if (x < 0 || 15 < x) {
            throw new IllegalArgumentException();
        }
        if (y < 0 || 15 < y) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" + x + ", " + y + "}";
    }
}

class EntityInputStream implements EntityInput {
    private DataInput in;

    public EntityInputStream(InputStream in) {
        this.in = new DataInputStream(in) ;
    }

    @Override
    public Person readPerson() throws IOException {
        String name = null;
        int age = in.readInt();
        boolean hasName = in.readBoolean();
        if (hasName) {
            name = in.readUTF();
        }
        return new Person(name, age);
    }

    @Override
    public Point readPoint() throws IOException {
        int value = in.readByte();
        int x = (value & 0b11110000)>>4;
        int y = value & 0b00001111;
        return new Point(x,y);
    }

}
