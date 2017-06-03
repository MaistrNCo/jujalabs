package ua.com.juja.maistrenko.week10.lab44;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test {
    public static void main(String[] args) throws IOException {
        Person expectedPerson = new Person("John", 32);

        StringWriter outStringWriter = new StringWriter();
        EntityOutputWriter writer = new EntityOutputWriter(outStringWriter);

        writer.writePerson(expectedPerson);
        String rawString = outStringWriter.toString();


        //call
        StringReader inStringReader = new StringReader(rawString);

        EntityInputReader reader = new EntityInputReader(inStringReader);

        Person actualPerson = reader.readPerson();

        //check

        if (!actualPerson.getName().equals(expectedPerson.getName()))
            throw new AssertionError("Expected Person name equals " + expectedPerson.getName() + " but found " + actualPerson.getName());

        if (actualPerson.getAge() != expectedPerson.getAge())
            throw new AssertionError("Expected Person age equals " + expectedPerson.getAge() + " but found " + actualPerson.getAge());


        System.out.print("OK");
    }
}