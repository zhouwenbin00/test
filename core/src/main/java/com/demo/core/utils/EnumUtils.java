package com.demo.core.utils;

import java.util.Objects;

public class EnumUtils {

    public static <E extends Enum> E getEnumByName(Class<E> clazz, String name) {
        Objects.requireNonNull(name, "name不能为空");
        E[] enumConstants = clazz.getEnumConstants();
        for (E e : enumConstants) {
            if (e.toString().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }
}
