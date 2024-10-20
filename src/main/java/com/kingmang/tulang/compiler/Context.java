package com.kingmang.tulang.compiler;

import com.kingmang.tulang.compiler.symbol.FunctionSymbol;
import com.kingmang.tulang.compiler.symbol.VariableSymbol;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import java.util.*;

public class Context {

    private final Context parentContext;

    private final Map<String, FunctionSymbol> functions = new HashMap<>();
    private final Map<String, VariableSymbol> variables = new HashMap<>();

    private int variableIndex = 0;

    private final Stack<Label> breakLabels = new Stack<>();
    private final Stack<Label> continueLabels = new Stack<>();

    static class ContextException extends RuntimeException {
        ContextException(String msg) {
            super(msg);
        }
    }

    private static class RootContext extends Context {

        private Map<String, Integer> functionNames = new HashMap<>();

        RootContext() {
            super(null);
        }

        String getRenamedFunction(String name) {
            if (!functionNames.containsKey(name)) {
                functionNames.put(name, 0);
            }
            int index = functionNames.get(name);
            functionNames.put(name, index + 1);

            if (index == 0) {
                return name;
            }
            return String.format("%s$%d", name, index);
        }

    }

    private Context(Context parentContext) {
        this.parentContext = parentContext;
    }

    public static Context rootContext() {
        return new RootContext();
    }

    public static Context childOf(Context parent) {
        return new Context(parent);
    }

    public Context parentContext() {
        if (parentContext == null) {
            throw new ContextException("root context has no parent");
        }
        return parentContext;
    }

    private RootContext getRoot() {
        Context context = this;
        while (context.parentContext != null) {
            context = context.parentContext;
        }
        return (RootContext)context;
    }

    public void setFunction(String name, Type type, String className) {
        String newName = getRoot().getRenamedFunction(name);
        functions.put(name, new FunctionSymbol(newName, type, className));
    }

    public int setVariable(String name) {
        int index = variableIndex++;
        variables.put(name, new VariableSymbol(name, index));
        return index;
    }

    public FunctionSymbol getFunction(String name) {
        if (parentContext == null || functions.containsKey(name)) {
            return functions.get(name);
        }
        return parentContext.getFunction(name);
    }

    public VariableSymbol getVariable(String name) {
        return variables.get(name);
    }

    public boolean hasFunctionName(String name) {
        if (parentContext == null) {
            return functions.containsKey(name);
        }
        if (functions.containsKey(name)) {
            return true;
        }
        return parentContext.hasFunctionName(name);
    }

    public boolean hasVariableName(String name) {
        return variables.containsKey(name);
    }

    public List<VariableSymbol> localVariables() {
        List<VariableSymbol> list = new ArrayList<>();

        for (Map.Entry<String, VariableSymbol> e : variables.entrySet()) {
            list.add(e.getValue());
        }

        Collections.sort(list, new Comparator<VariableSymbol>() {
            @Override
            public int compare(VariableSymbol o1, VariableSymbol o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });

        return list;
    }

    public boolean isLoop() {
        return !breakLabels.isEmpty();
    }

    public void pushLoop(Label start, Label end) {
        breakLabels.push(end);
        continueLabels.push(start);
    }

    public void popLoop() {
        breakLabels.pop();
        continueLabels.pop();
    }

    public Label breakLabel() {
        return breakLabels.peek();
    }

    public Label continueLabel() {
        return continueLabels.peek();
    }
}
