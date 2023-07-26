package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(value -> value.matches("^[A-Z].*"));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValue = list.stream().filter(num -> num % 2 == 0).toList();
            list.addAll(evenValue);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> result = new ArrayList<>();
        return () -> {
            for (String item : values) {
                String[] s = item.split(" ");
                if (s.length > 3 && s[0].matches("^[A-Z].*") && s[s.length - 1].contains(".")) {
                    result.add(item);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {

        Map<String, Integer> result = new HashMap<>();
        return item -> {
            for (String word : item) {
                result.put(word, word.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (item1, item2) -> {
            item1.addAll(item2);
            return item1;
        };
    }
}
