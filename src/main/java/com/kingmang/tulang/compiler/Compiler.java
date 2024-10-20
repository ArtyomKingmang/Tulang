package com.kingmang.tulang.compiler;

import com.kingmang.tulang.asm.Visitor;
import com.kingmang.tulang.exception.TuException;
import com.kingmang.tulang.gen.TulangLexer;
import com.kingmang.tulang.gen.TulangParser;
import com.kingmang.tulang.optimization.ConstantFolding;
import com.kingmang.tulang.parser.ANode;
import lombok.SneakyThrows;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Compiler {

    public static boolean enableOptimizations = true;

    private final byte[] code;

    private final String fileName;

    private Compiler(byte[] code, String fileName) {
        this.code = code;
        this.fileName = fileName;
    }

    public static Compiler fromFile(File file) throws IOException {
        byte[] code = Files.readAllBytes(file.toPath());
        return new Compiler(code, file.getName());
    }

    public static Compiler fromString(String code) throws IOException {
        return new Compiler(code.getBytes("UTF-8"), "unnamed");
    }

    public List<String> tokenList() {
        CharStream cs = CharStreams.fromString(new String(code, StandardCharsets.UTF_8), fileName);

        TulangLexer lexer = new TulangLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        tokens.fill();

        return tokens.getTokens()
                .stream()
                .map(Token::getText)
                .collect(Collectors.toList());
    }

    public static class ByteClassLoader extends URLClassLoader {
        private final byte[] classBytes;

        public ByteClassLoader(URL[] urls, ClassLoader parent, byte[] bytes) {
            super(urls, parent);
            this.classBytes = bytes;
        }

        @Override
        protected Class<?> findClass(final String name) throws ClassNotFoundException {
            return defineClass(name, classBytes, 0, classBytes.length);
        }
    }

    public ANode parse() {
        CharStream cs = CharStreams.fromString(new String(code, StandardCharsets.UTF_8), fileName);

        TulangLexer lexer = new TulangLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TulangParser parser = new TulangParser(tokens);

        ANode root = Transformer.transform(parser.statementList());

        if (enableOptimizations) {
            root = root.accept(new ConstantFolding());
        }

        return root;
    }

    public String trace() {
        ANode root = parse();

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        new Visitor(new TraceClassVisitor(null, new Textifier(), pw), fileName).start(root);

        return sw.toString();
    }

    @SneakyThrows
    public void exec(String[] argv) {
        Class<?> klass = loadClass(compile());

        List args = new ArrayList();
        Collections.addAll(args, argv);

        try {
            Method m = klass.getMethod("main", ArrayList.class);
            m.invoke(null, args);
        } catch (NoSuchMethodException
                | InvocationTargetException
                | IllegalAccessException e) {

            if (e instanceof InvocationTargetException) {
                Throwable cause = e.getCause();
                if (cause.getMessage() == null) {
                    throw new java.lang.Exception(cause.toString());
                }
                throw new TuException(cause.getMessage().replace("java.lang.", ""));
            } else {
                throw new TuException(e);
            }
        }
    }

    public byte[] compile() {
        ANode root = parse();

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        return new Visitor(cw, fileName).start(root).getByteArray();
    }

    private Class<?> loadClass(byte[] classBytes) {
        URLClassLoader cl = new ByteClassLoader(new URL[0], ClassLoader.getSystemClassLoader(), classBytes);

        Class<?> klass = null;
        try {
            klass = cl.loadClass("Main");
        } catch (ClassNotFoundException ignored) {}

        return klass;
    }
}
