package com.java.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class IoNotes {

  public static void main(String[] args) throws IOException {
    final File file1 = createAFile();
    final Path path1 = createAPath();
    fileApi(file1);
    pathApi(path1);

    final Path path2 = path1.toAbsolutePath().getParent().resolve("test/files/test.txt");
    System.out.println(path2);
    System.out.println(path2.getName(2));
    System.out.println(path2.getNameCount());

    System.out.println();

    getSubPath(path2);
    getPathElements(path2);
    relativizePath(path1, path2);

    createDirs();
    createFile();
  }

  public static File createAFile() {
    File file1 = new File("testFile1.txt");
    System.out.println(file1.exists());
    return file1;
  }

  public static Path createAPath() {
    Path path1 = Path.of("testFile1.txt");
    System.out.println(Files.exists(path1));
    return path1;
  }

  public static void fileApi(final File file1) {

    if (file1.exists()) {
      System.out.println(file1.getAbsolutePath());
      System.out.println(file1.isDirectory());
      System.out.println(file1.getParent());

      if (file1.isFile()) {
        System.out.println(file1.length());
      } else {
        for (File subfile : file1.listFiles()) {
          System.out.println(subfile.getName());
        }
      }
    }
  }

  public static void pathApi(final Path path1) throws IOException {

    if (Files.exists(path1)) {
      System.out.println(path1.toAbsolutePath());
      System.out.println(Files.isDirectory(path1));
      System.out.println(path1.getParent());

      if (Files.isRegularFile(path1)) {
        System.out.println(Files.size(path1));
      } else {
        try (Stream<Path> stream = Files.list(path1)) {
          stream.forEach(p -> System.out.println(p.getFileName()));
        }
      }
    }
  }

  public static void getSubPath(final Path path) throws IOException {
    System.out.println(path.subpath(0, 2));
    System.out.println(path.subpath(2, 4));
    System.out.println(path.subpath(1, 3));
  }

  public static void getPathElements(final Path path) throws IOException {
    System.out.println(path.getParent());
    System.out.println(path.getRoot());
  }

  public static void relativizePath(final Path path1, final Path path2) throws IOException {
    System.out.println(path1.toAbsolutePath());
    System.out.println(path2);
    System.out.println(path1.toAbsolutePath().relativize(path2));
  }

  public static void createDirs() throws IOException {
    final Path path = Path.of("test/dog");

    Files.createDirectories(path);
    // Files.createDirectory(path);
  }

  public static void createFile() throws IOException {
    final Path path = Path.of("test/dog/test.txt");
    Files.createFile(path);
  }
}
