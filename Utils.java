package com.*.*.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author f.olle
 */
public class Utils {
    private Utils(){}

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static <T> T createNewObjectAndAddToList(List<T> list, T object) {
        list.add(object);
        return object;
    }

    public static <T extends Enum<?>> T valueOfLabel(Class<T> genericEnum, String label) {
        for (T value : genericEnum.getEnumConstants()) {
            if (value.toString().equals(label)) {
                return value;
            }
        }
        return null;
    }

    public static <T> ArrayList<T> cloneToMutableList(List<T> list) {
        return new ArrayList<T>(list);
    }
}
