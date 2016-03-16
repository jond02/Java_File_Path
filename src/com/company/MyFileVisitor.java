package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by jondann on 3/15/16.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private static int i = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("about to visit " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (attrs.isRegularFile()){
            //System.out.print("Regular File: ");
        }

        //need both?
        Path source = Paths.get(file.toString());
        File f1 = new File(file.toString());

        i++;

        //need to build path minus last index which is filename
        File f2 = new File(source.getName(0) + "/" + source.getName(1) + "/WaName" + i + ".txt");

        //System.out.println("h " + f2);

        f1.renameTo(f2);

        //System.out.println(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {

        System.err.println(exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("just visited " + dir);
        return FileVisitResult.CONTINUE;
    }
}
