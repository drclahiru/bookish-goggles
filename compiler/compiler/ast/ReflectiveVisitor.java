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
        var objectClass = new Object().getClass();
        var nodeClass = o.getClass();

        // Try the superclasses
        for (var c = nodeClass; c != objectClass && method == null; c = c.getSuperclass()) {
            try {
                method = getClass().getMethod("visit", new Class[] { c });
            } catch (NoSuchMethodException e) {
            }
        }

        // Try the interfaces
        var class_ = nodeClass;
        while (method == null && class_ != objectClass) {
            for (var interface_ : class_.getInterfaces()) {
                try {
                    method = getClass().getMethod("visit", new Class[] { interface_ });
                } catch (NoSuchMethodException e) {
                }
            }
            class_ = class_.getSuperclass();
        }

        // Otherwise use the defaultVisit method
        if (method == null) {
            try {
                method = getClass().getMethod("defaultVisit", new Class[] { objectClass });
            } catch (NoSuchMethodException e) {
                e.printStackTrace(System.err);
                System.exit(-1);
            }
        }
        try {
            method.invoke(this, new Object[] { o });
        } catch (IllegalAccessException ex) {
            ex.printStackTrace(System.err);
            throw new Error("Method " + method + " aborting, bad access: " + ex);
        } catch (InvocationTargetException ex) {
            ex.printStackTrace(System.err);
            throw new Error("Method " + method + " aborting: " + ex);
        }
    }
}