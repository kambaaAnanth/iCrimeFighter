package com.loginPageTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
        List<String> input = Arrays.asList("Ananth", "Shiva", "Ananth", "Abhirami", "Santu");

        Map<String, Integer> countMap = new HashMap<>();

        for (String name : input) {
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }

        List<String> result = new ArrayList<>();

        for (String name : input) {
            if (countMap.get(name) ==1) {
                result.add(name);
            }
        }

        result = new ArrayList<>(new LinkedHashSet<>(result));

        System.out.println(result);
    }
}
