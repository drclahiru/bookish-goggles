package compiler.ast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectiveVisitor implements Visitor {
    public void visit(AbstractNode n) {
        dispatch(n);
    }

    void defaultVisit(AbstractNode n) {
        n.children().forEach((x) -> visit(x));
    }

    // Modified version of dispatch for the ReflectiveVisitor from SPO lab:
    // https://www.cse.wustl.edu/~cytron/cacweb/Tutorial/Visitor/
    final void dispatch(Object o) {
        Method method = null;
        var nodeClass = o.getClass();
        var c = nodeClass;
        
        // Try the superclasses
        while (c != Object.class && method == null) {
            try {
                method = getClass().getMethod("visit", new Class[] { c });
            } catch (NoSuchMethodException e) {
            }
            c = c.getSuperclass();
        }

        // Try the interfaces
        c = nodeClass;
        while (method == null && c != Object.class) {
            for (var interface_ : c.getInterfaces()) {
                try {
                    method = getClass().getMethod("visit", new Class[] { interface_ });
                } catch (NoSuchMethodException e) {
                }
            }
            c = c.getSuperclass();
        }

        // Otherwise use the defaultVisit method
        if (method == null) {
            System.out.println(getClass());
            System.out.println(getClass().getMethods());
            try {
                method = getClass().getMethod("defaultVisit", new Class[] { AbstractNode.class });
            } catch (NoSuchMethodException e) {
                e.printStackTrace(System.err);
                System.exit(-1);
            }
        }
        try {
            method.invoke(this, new Object[] { o });
        } catch (IllegalAccessException ex) {
            throw new Error("Method " + method + " aborting, bad access: " + ex);
        } catch (InvocationTargetException ex) {
            throw new Error("Method \"" + method + "\" aborting: " + ex);
        }
    }
}