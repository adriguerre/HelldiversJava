package com.example.helldivers.utils;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateUtils {

    public static <T> void updateIfPresent(Supplier<T> getter, Consumer<T> setter) {
        Optional.ofNullable(getter.get()).ifPresent(setter);
    }

    public static <T extends Enum<T>> T parseEnum(Class<T> enumClass, String value) {
        if (value == null) return null;
        try {
            return Enum.valueOf(enumClass, value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
