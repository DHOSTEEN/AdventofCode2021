/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day14;

/**
 *
 * @Natrium_Benzoat - username on reddit
* NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE ---
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
/**
*@Natrium_Benzoat - username on reddit ORGINAL AUTHOR
*NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE
**/
public class CheatyMcCheaty {
// NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE ---
    private static Map<String, String[]> insertions = new HashMap<>();
    private static Character first;

    public static void main(String[] args) {
        String path = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput14_testdata.txt";
        Map<String, Long> templateMap = loadInput(path);//the polymer
templateMap.keySet().forEach(arr -> {System.out.println(arr);});
        for (int i = 0; i < 40; i++) {//DAY
            templateMap = transform(templateMap);//logic - RECURSIVE!
        }

        print(countChars(templateMap));//count AFTER finished
    }

    private static void print(Map<Character, Long> countChars) {
        char maxChar = 0;
        char minChar = 0;
        Long max = Long.MIN_VALUE;
        Long min = Long.MAX_VALUE;

        for (Character c : countChars.keySet()) {
            if (countChars.get(c) > max) {
                max = countChars.get(c);
                maxChar = c;
            } else if (countChars.get(c) < min) {
                min = countChars.get(c);
                minChar = c;
            }
        }
System.out.print("OL?" + 0L);
        System.out.println("hmm" + 0D);
        System.out.println("MAX: " + max + " MIN: " + min);
        System.out.println("ANSWER: " + (max-min));
        System.out.println("");
        System.out.printf("The most common element is %c with %d occurance\n " +
                "and the leat common element is %c with %d occurance\n " +
                "the subtraction is %d", maxChar, max, minChar, min, max - min);
    }

    private static Map<String, Long> loadInput(String path) {
        String startTemplate = null;
        try (Scanner scanner = new Scanner(new File(path))) {
            startTemplate = scanner.nextLine();
            first = startTemplate.charAt(0);
            scanner.nextLine();
            while (scanner.hasNext()) {
                createInsertions(scanner.nextLine().split(" -> "));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + path);
        }
        return createStartingMap(startTemplate);
    }

    private static void createInsertions(String[] line) {

        String pattern = line[0];
        String plus = line[1];
        String[] replace = {pattern.charAt(0) + plus, plus  + pattern.charAt(1)};
        System.out.println("Line: " + Arrays.toString(line));
        System.out.println("Pattern: " + pattern);
        System.out.println("replace: " + Arrays.toString(replace));
        insertions.put(pattern, replace);
    }

    private static Map<String, Long> createStartingMap(String line) {
       // System.out.println("WHAT AM I?" + line);
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < line.length() - 1; i++) {//gets pairs on inital string
            String s = line.substring(i, i + 2);
            //System.out.println("string: " + s);
            Long n = map.getOrDefault(s, 0L);
            map.put(s, n + 1);
        }
//for(String str : map.keySet()){System.out.println("I R: " + str);}
        return map;
    }

    private static Map<String, Long> transform(Map<String, Long> record) {
        Map<String, Long> newRecord = new HashMap<>();
//polymer is a Map<> not a LinkedList
        for (String key : record.keySet()) {
            Long countKey = record.get(key);

            if (insertions.containsKey(key)) {
                String insert1 = insertions.get(key)[0];
                String insert2 = insertions.get(key)[1];
                Long count1 = newRecord.getOrDefault(insert1, 0L);//do this OR get the val
                Long count2 = newRecord.getOrDefault(insert2, 0L);
                newRecord.put(insert1, count1 + countKey);//??
                newRecord.put(insert2, count2 + countKey);
            } else {
                newRecord.put(key, countKey);//copy over the Pair with no change
            }
        }
        return newRecord;
    }

    private static Map<Character, Long> countChars(Map<String, Long> templateMap) {
        Map<Character, Long> charMap = new HashMap<>();
        Long firstN = charMap.getOrDefault(first, 0L);
        charMap.put(first, firstN + 1);
        for (String key : templateMap.keySet()) {
            char c = key.charAt(1);
            Long n = templateMap.get(key);

            Long charN = charMap.getOrDefault(c, 0L);
            charMap.put(c, charN + n);
        }
        return charMap;
    }

}