package com.kingmang.tulang.runner;

import com.kingmang.tulang.compiler.Compiler;
import com.kingmang.tulang.parser.ANode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestRunner {
    public static void main(String[] args) throws IOException {
        String fileName = "test/test";
        File file = new File(fileName.concat(".tu"));
        byte[] classBytes = Compiler.fromFile(file).compile();
        Files.write(Paths.get("Main.class"), classBytes, StandardOpenOption.CREATE);
        ANode root = Compiler.fromFile(file).parse();
        //System.out.println(root);
        Compiler.fromFile(file).exec(args);

    }
}
