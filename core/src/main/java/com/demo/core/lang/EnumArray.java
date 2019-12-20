package com.demo.core.lang;

/**
 * 枚举数组
 *
 * @author zwb
 */
public class EnumArray<E extends Enum, T> {

    private final Class<E> clazz;
    private final T[] array;

    public EnumArray(Class<E> clazz) {
        this.clazz = clazz;
        this.array = (T[]) new Object[clazz.getEnumConstants().length];
    }

    public void set(E e, T t) {

        this.set(e.ordinal(), t);
    }

    private void set(int ordinal, T t) {
        this.array[ordinal] = t;
    }

    public T get(int ordinal) {
        return this.array[ordinal];
    }

    public T get(E e) {
        return this.get(e.ordinal());
    }

    public T getOrDefault(E e, T defaultValue) {
        T t = this.get(e);
        if (t == null) {
            t = defaultValue;
            this.set(e, defaultValue);
        }
        return t;
    }

    public void makeSureNoNull() {
        for (int i = 0; i < array.length; i++) {
            T t = array[i];
            if (t == null) {
                throw new IllegalArgumentException(clazz.getName() + "的第" + (i + 1) + "个值为空");
            }
        }
    }
}
