package com.kingmang.tulang.std;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TuWriter {
    public static Object print(Object arg) {
        if (arg == null) {
            arg = TuNull.getInstance();
        }
        System.out.print(arg);
        return null;
    }

    public static Object println(Object arg) {
        if (arg == null) {
            arg = TuNull.getInstance();
        }
        System.out.println(arg);
        return null;
    }

    public static Object readln() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            return r.readLine();
        } catch (IOException ignore) {}
        return null;
    }
}
