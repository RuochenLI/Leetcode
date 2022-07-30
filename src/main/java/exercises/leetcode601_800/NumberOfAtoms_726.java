package exercises.leetcode601_800;

import java.util.TreeMap;

/**
 * 726. Number of Atoms
 */
public class NumberOfAtoms_726 {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> atomMap = buildAtomMap(formula);
        StringBuilder resultBuilder = new StringBuilder();
        atomMap.forEach((key, value) -> {
            resultBuilder.append(key);
            if (value > 1) {
                resultBuilder.append(value);
            }
        });
        return resultBuilder.toString();
    }

    private TreeMap<String, Integer> buildAtomMap(String formula) {
        int pt = 0;
        TreeMap<String, Integer> atomMap = new TreeMap<>();
        while (pt < formula.length()) {
            if (formula.charAt(pt) <= 'Z' && formula.charAt(pt) >= 'A') {
                StringBuilder atomSB = new StringBuilder().append(formula.charAt(pt++));
                while (pt < formula.length() && formula.charAt(pt) <= 'z' && formula.charAt(pt) >= 'a') {
                    atomSB.append(formula.charAt(pt++));
                }
                String atom = atomSB.toString();
                StringBuilder numSB = new StringBuilder();
                while (pt < formula.length() && formula.charAt(pt) >= '0' && formula.charAt(pt) <= '9') {
                    numSB.append(formula.charAt(pt++));
                }
                int occ = numSB.toString().equals("") ? 1 : Integer.parseInt(numSB.toString());
                atomMap.put(atom, atomMap.getOrDefault(atom, 0) + occ);
            } else if (formula.charAt(pt) == '(') {
                int start = pt + 1;
                int nbParenthesis = 0;
                while (formula.charAt(pt) != ')' || nbParenthesis != 1) {
                    if (formula.charAt(pt) == '(') {
                        nbParenthesis++;
                    } else if (formula.charAt(pt) == ')') {
                        nbParenthesis--;
                    }
                    pt++;
                }
                TreeMap<String, Integer> subAtomMap = buildAtomMap(formula.substring(start, pt));
                pt++;
                StringBuilder numSB = new StringBuilder();
                while (pt < formula.length() && formula.charAt(pt) >= '0' && formula.charAt(pt) <= '9') {
                    numSB.append(formula.charAt(pt++));
                }
                int occ = numSB.toString().equals("") ? 1 : Integer.parseInt(numSB.toString());
                subAtomMap.forEach((atom, value) -> {
                    atomMap.put(atom, atomMap.getOrDefault(atom, 0) + value * occ);
                });
            }
        }
        return atomMap;
    }
}
