package com.bright.util.base.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class JwrapMethod implements InvocationHandler {

    private Object dele;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(dele, args);
        Object k = after(result);
        return k == null ? result : k;
    }

    public void set(Object obj) {
        this.dele = obj;
    }

    public abstract void before();

    public abstract Object after(Object result);
}
