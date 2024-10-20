package com.kingmang.tulang.parser;

import com.kingmang.tulang.visitor.IVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ANode {

    public static final List<ANode> EMPTY_LIST = new ArrayList<>(0);

    public abstract <T> T accept(IVisitor<T> visitor);

    public abstract List<ANode> childNodes();

    protected static List<ANode> createList(ANode... nodes) {
        List<ANode> list = new ArrayList<>();

        Collections.addAll(list, nodes);

        return list;
    }

    public abstract NodeType getNodeType();

    public String getNodeName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        return toString(true, 0);
    }

    public String toString(boolean indent, int indentation) {
        StringBuilder sb = new StringBuilder();

        if (indent) {
            indent(indentation, sb);
        }
        sb.append("<");
        sb.append(getNodeName());
        sb.append(">");
        sb.append('\n');

        for (ANode node : childNodes()) {
            sb.append(node.toString(indent, indentation + 1));
        }
        return sb.toString();
    }

    private void indent(int indentation, StringBuilder sb) {
        sb.append("  ".repeat(Math.max(0, indentation)));
    }
}
