package com.kingmang.tulang.compiler.symbol;

import com.google.common.base.MoreObjects;
import org.objectweb.asm.Type;

public class FunctionSymbol extends Symbol {

    private final String name;
    private final Type type;
    private final String container;

    public FunctionSymbol(String name, Type type, String container) {
        this.name = name;
        this.type = type;
        this.container = container;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getContainer() {
        return container;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("type", type)
                .add("container", container)
                .toString();
    }
}
