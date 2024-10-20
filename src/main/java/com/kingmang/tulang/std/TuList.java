package com.kingmang.tulang.std;

import java.util.ArrayList;

public class TuList {

    public static Object list() {
        return new ArrayList<>();
    }

    public static Object list_append(Object list, Object elem) {
        ((ArrayList)list).add(elem);
        return null;
    }

    public static Object list_get(Object list, Object index) {
        return ((ArrayList)list).get((int)index);
    }

    public static Object list_set(Object list, Object index, Object value) {
        return ((ArrayList)list).set((int)index, value);
    }

    public static Object list_remove(Object list, Object index) {
        return ((ArrayList)list).remove(index);
    }

    public static Object list_empty(Object list) {
        return ((ArrayList)list).isEmpty();
    }

    public static Object list_size(Object list) {
        return ((ArrayList)list).size();
    }

}
