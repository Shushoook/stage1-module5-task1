package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> list.addAll(list.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList()));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .filter(s -> s.endsWith("."))
                .filter(s -> s.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> concatenatedList = new ArrayList<>(list1);
            concatenatedList.addAll(list2);
            return concatenatedList;
        };    }
}
