package com.kingmang.tulang.std;

import com.kingmang.tulang.exception.TuException;

public class TuNumber {
    public static Object parse_int(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf((String) str);
        } catch (NumberFormatException e) {
            throw new TuException("NumberFormatException");
        }
    }
    public static Object parse_double(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return Double.valueOf((String) str);
        } catch (NumberFormatException e) {
            throw new TuException("NumberFormatException");
        }
    }
}
