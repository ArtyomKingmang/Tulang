package com.kingmang.tulang.std;

public class StdLib {

    //Std
    public static Object print(Object o) {
        TuWriter.print(o);
        return null;
    }

    public static Object println(Object o) {
        TuWriter.println(o);
        return null;
    }

    public static Object readln() {
       return TuWriter.readln();
    }


    //List
    public static Object list() { return TuList.list(); }

    public static Object list_append(Object list, Object elem) {
        return TuList.list_append(list, elem);
    }

    public static Object list_get(Object list, Object index) {
        return TuList.list_get(list, index);
    }

    public static Object list_set(Object list, Object index, Object value) {
        return TuList.list_set(list, index, value);
    }
    public static Object list_remove(Object list, Object index) {
        return TuList.list_remove(list, index);
    }

    public static Object list_empty(Object list) {
        return TuList.list_empty(list);
    }

    public static Object list_size(Object list) {
        return TuList.list_size(list);
    }


    //String
    public static Object upper(Object str) {
        return TuString.upper(str);
    }

    public static Object lower(Object str) {
        return TuString.lower(str);
    }

    public static Object is_upper(Object str) {
        return TuString.is_upper(str);
    }

    public static Object is_lower(Object str) {
        return TuString.is_lower(str);
    }

    public static Object parse_int(Object str) {
        return TuNumber.parse_int(str);
    }
    public static Object parse_double(Object str) {
        return TuNumber.parse_double(str);
    }
    public static Object split(Object str, Object separator) {
        return TuString.split(str, separator);
    }

    public static Object concat(Object s1, Object s2) {
        return TuString.concat(s1, s2);
    }
}
