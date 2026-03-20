package com.example.helldivers.utils;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateUtils {

    public static <T> void updateIfPresent(Supplier<T> getter, Consumer<T> setter) {
        Optional.ofNullable(getter.get()).ifPresent(setter);
    }
}
