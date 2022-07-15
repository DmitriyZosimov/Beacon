package com.beacon.model.tools;

import java.lang.reflect.Field;

/**
 * Tool is to output more readable data. It can be used as toString() method.
 * Constructor takes an object which will use this tool.
 * @param <T> class which will use this tool as toString()
 */
public class ToStringTool<T> {

    private Class className;
    private T object;

    public ToStringTool(T t) {
        this.className = t.getClass();
        this.object = t;
    }

    public String getString() {
        StringBuilder result = new StringBuilder(className.getName() + "{\n");
        result.append(String.format("%-12s%-15s%-12s%-15s%s%n%s%s%n", "\t|", "Fields", "|", "Values", "|", "\t", "=".repeat(54)));

        Class currentClass = className;
        while (!currentClass.equals(Object.class)) {
            Field[] fields = currentClass.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    result.append(String.format("%-2s%-25s%-2s%-25s%s%n", "\t|", field.getName(), "|", field.get(object), "|"));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        result.append("}");
        return result.toString();
    }
}
