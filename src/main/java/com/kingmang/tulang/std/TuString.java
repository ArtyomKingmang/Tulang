package com.kingmang.tulang.std;

import java.util.ArrayList;
import java.util.Collections;

public class TuString {
    public static Object upper(Object str) {
        return ((String)str).toUpperCase();
    }

    public static Object lower(Object str) {
        return ((String)str).toLowerCase();
    }

    public static Object is_upper(Object str) {
        return str != null && ((String)str).toUpperCase().equals(str);
    }

    public static Object is_lower(Object str) {
        return str != null && ((String)str).toLowerCase().equals(str);
    }



    public static Object split(Object str, Object separator) {
        String[] aux = ((String)str).split((String)separator);
        ArrayList result = new ArrayList();
        Collections.addAll(result, aux);
        return result;
    }

    public static Object concat(Object s1, Object s2) {
        return s1.toString() + s2.toString();
    }
}
