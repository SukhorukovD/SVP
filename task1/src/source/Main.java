package source;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import tests.*;

import java.util.*;

public class Main {

    private static int[] cupurs;
    private static int requiredSum;

    private static IllegalArgumentException notIntegerException
            = new IllegalArgumentException("Wrong Format. Must be strongly int.");
    private static IllegalArgumentException zeroOrLessInputException
            = new IllegalArgumentException("Wrong Format. Must be positive integer bigger than zero.");

    private static int[] prepareCupurs(int[] cupurs) {

        int correctItemsCount = 0;
        for (int i = 0; i < cupurs.length; ++i) {
            if (cupurs[i] > 0) {
                correctItemsCount++;
            }
        }

        int[] cupursFiltered = new int[correctItemsCount];

        for (int i = 0, j = 0; j < cupursFiltered.length && i < cupurs.length; ++i) {
            if (cupurs[i] > 0) {
                cupursFiltered[j] = cupurs[i];
                j++;
            }
        }

        Arrays.sort(cupursFiltered);
        for (int left = 0, right = cupursFiltered.length - 1; left < right; left++, right--) {
            int temp = cupursFiltered[left];
            cupursFiltered[left] = cupursFiltered[right];
            cupursFiltered[right] = temp;
        }

        int duplicatinoCount = 0;
        for (int i = 1; i < cupursFiltered.length; ++i) {
            if (cupursFiltered[i] == cupursFiltered[i - 1]) {
                ++duplicatinoCount;
            }
        }
        int[] filteredCupursWithoutDuplicates = new int[cupursFiltered.length - duplicatinoCount];

        int filteredArrayIterator = 0;
        for (int i = 1; i < cupursFiltered.length; ++i) {
            if (cupursFiltered[i] != cupursFiltered[i - 1]) {
                filteredCupursWithoutDuplicates[filteredArrayIterator] = cupursFiltered[i - 1];
                filteredArrayIterator++;
            }
        }
        filteredCupursWithoutDuplicates[filteredCupursWithoutDuplicates.length - 1]
                = cupursFiltered[cupursFiltered.length - 1];

        return filteredCupursWithoutDuplicates;
    }

    private static void readInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter required sum: ");
        if (in.hasNextInt()) {
            requiredSum = in.nextInt();
        } else {
            throw notIntegerException;
        }

        System.out.println();

        System.out.print("Enter possible parts count: ");

        int partsCount;

        if (in.hasNextInt()) {

            partsCount = in.nextInt();
        } else {
            throw notIntegerException;
        }
        if (partsCount < 0) {
            throw zeroOrLessInputException;
        } else if (partsCount == 0) {
            cupurs = new int[0];
            return;
        }
        cupurs = new int[partsCount];
        for (int i = 0; i < partsCount; ++i) {
            System.out.println("Enter next possible part:");
            if (in.hasNextInt()) {
                cupurs[i] = in.nextInt();
            } else {
                throw notIntegerException;
            }
            if (cupurs[i] <= 0) {
                throw zeroOrLessInputException;
            }
        }
        return;
    }

    private static void writeOutput(List<List<Integer>> combinations) {
        System.out.println("Total number of combinations: " + combinations.size());
        for (List<Integer> combination : combinations) {
            if (combination.size() <= 15) {
                for (int i = 0; i < combination.size() - 1; ++i) {
                    System.out.print(combination.get(i) + " + ");
                }
                System.out.print(combination.get(combination.size() - 1));
            } else {
                Map<Integer, Integer> dic = new HashMap<>();
                for (int i = 0; i < combination.size(); ++i) {
                    if (dic.containsKey(combination.get(i))) {
                        dic.put(combination.get(i), dic.get(combination.get(i)) + 1);
                    } else {
                        dic.put(combination.get(i), 1);
                    }
                }
                int partsCount = dic.entrySet().size();
                for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
                    partsCount--;
                    System.out.print(entry.getKey() + " * " + entry.getValue() + (partsCount == 0 ? "" : " + "));
                }
            }
            System.out.println(" = " + requiredSum);
        }
    }

    public static List<List<Integer>> generate(int requiredSum, int[] cupurs) {
        if (requiredSum == 0 || cupurs.length == 0) {
            return new ArrayList<>();
        }
        int[] cupursCleaned = prepareCupurs(cupurs);

        Map<ArrayList<Integer>, Integer> potentionalCombinations = new HashMap<>();
        potentionalCombinations.put(new ArrayList<>(), 0);

        List<List<Integer>> combinations = new ArrayList<>();

        while (!potentionalCombinations.isEmpty()) {

            Set<Map.Entry<ArrayList<Integer>, Integer>> set = new HashSet();
            set.addAll(potentionalCombinations.entrySet());

            for (Map.Entry<ArrayList<Integer>, Integer> entry : set) {
                for (int i = entry.getValue(); i < cupursCleaned.length; ++i) {
                    ArrayList<Integer> potentionalCombination = (ArrayList<Integer>) entry.getKey().clone();
                    potentionalCombination.add(cupursCleaned[i]);

                    int sum = potentionalCombination.stream().mapToInt(Integer::intValue).sum();

                    if (sum == requiredSum) {
                        combinations.add(potentionalCombination);
                    } else if (sum < requiredSum) {
                        potentionalCombinations.put(potentionalCombination, i);
                    }
                }
                potentionalCombinations.remove(entry.getKey());
            }
        }
        return combinations;
    }

    public static void main(String[] args) {

        try {
            JUnitCore runner = new JUnitCore();
            Result result = runner.run(GenerateTest.class);
            System.out.println("Run tests: " + result.getRunCount());
            System.out.println("Failed tests: " + result.getFailureCount());
            System.out.println("Correct tests: " + (result.getRunCount() - result.getFailureCount()));
            System.out.println("Ignored tests: " + result.getIgnoreCount());
            System.out.println("Success: " + result.wasSuccessful());

            readInput();
            writeOutput(generate(requiredSum, cupurs));
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return;
        }
    }
}
