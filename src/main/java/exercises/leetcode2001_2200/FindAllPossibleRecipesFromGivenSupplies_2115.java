package exercises.leetcode2001_2200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindAllPossibleRecipesFromGivenSupplies_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Construct directed graph and count in-degrees.
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            for (String ing : ingredients.get(i)) {
                ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }
        // Toplogical Sort.
        List<String> ans = new ArrayList<>();
        Queue<String> available = Stream.of(supplies).collect(Collectors.toCollection(ArrayDeque::new));
        while (!available.isEmpty()) {
            String ing = available.poll();
            if (ingredientToRecipes.containsKey(ing)) {
                for (String rcp : ingredientToRecipes.remove(ing)) {
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        available.offer(rcp);
                        ans.add(rcp);
                    }
                }
            }
        }
        return ans;
    }

    public List<String> findAllRecipes1(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Set<String> suppSet = Arrays.stream(supplies).collect(Collectors.toSet());
        Map<String, List<String>> recipesMap = IntStream.range(0, recipes.length)
                                                        .boxed()
                                                        .collect(Collectors.toMap(i -> recipes[i], ingredients::get));
        for (final String recipe : recipes) {
            if (suppSet.contains(recipe)) {
                result.add(recipe);
            } else {
                if (lookForIngredients(recipe, suppSet, recipesMap, new HashSet<>())) {
                    suppSet.add(recipe);
                    result.add(recipe);
                }
            }
        }
        return result;
    }

    public boolean lookForIngredients(String recipe,
                                      Set<String> suppSet,
                                      Map<String, List<String>> recipesMap,
                                      Set<String> visited) {
        visited.add(recipe);
        for (String ingredient : recipesMap.get(recipe)) {
            if (suppSet.contains(ingredient)) {
                continue;
            }

            if (recipesMap.containsKey(ingredient) && !visited.contains(ingredient)) {
                boolean feasible = lookForIngredients(ingredient, suppSet, recipesMap, visited);
                if (feasible) {
                    suppSet.add(ingredient);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
