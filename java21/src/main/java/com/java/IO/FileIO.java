package com.java.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class FileIO {

    public static void main(String[] args) {

    }

    /**
     * Byte Stream Example.
     */
    public void copyByte() {
        try (FileInputStream in = new FileInputStream("in.dat");
                FileOutputStream out = new FileOutputStream("out.dat")) {
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Character Stream Example.
     */
    public void copyChar() {
        try (FileReader in = new FileReader("in.txt");
                FileWriter out = new FileWriter("out.txt")) {

            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Buffered Byte Stream Example.
     */
    public void bufferedCopyByte() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("in"));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"))) {

            int byteRead;

            while ((byteRead = in.read()) != 1) {
                out.write(byteRead);
            }
            out.flush();

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Buffered Character Stream Example.
     */
    public void bufferedCopyChar() {
        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pathsTest() throws IOException {
        Path p1 = Path.of("C:", "data", "file.txt");

        // Writing
        Files.writeString(p1, "Hello, Java 21!", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        // Appending
        Files.writeString(p1, "\nMore data.", StandardOpenOption.APPEND);

        // Reading all lines
        List<String> lines = Files.readAllLines(p1);
        lines.forEach(System.out::println);
    }

    public void fileTreeTraversal() {
        Path startDir = Path.of(".");

        try (Stream<Path> stream = Files.walk(startDir, 2) /* maxDepth of 2 */) {
            stream
                    .filter(p -> p.toString().endsWith(".java")) // Filter for Java files
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
