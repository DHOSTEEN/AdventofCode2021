/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author Daniel
 */
class CheatyMcCheatyTWO {
    static Cave end;
    static Map<Cave, Integer> visitedSmall;
    static Map<String, Cave> cavesByName = new HashMap<>();

    public static void main(String[] args) throws Exception {
        try (Stream<String> lines = Files.lines(Paths.get("E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput12_data.txt"))) {
            lines.forEach(line -> {
                String[] caveNames = line.split("-");
                System.out.println("INPUTS: " + Arrays.toString(caveNames));
                cavesByName.computeIfAbsent(caveNames[0], Cave::new).connectTo(caveNames[1]);
            });
        }
        Cave start = cavesByName.get("start");
        end = cavesByName.get("end");
        visitedSmall = new HashMap<>();
        visitedSmall.put(start, 1);
        System.out.println(pathsOut(start, 0));
    }

    static int pathsOut(Cave cave, int flags) {
        if (end == cave) {
            return 1;
        }
        int visits = visitedSmall.computeIfAbsent(cave, c -> 0);
        if (cave.small + visits + flags > 4) {
            return 0;
        }
        visitedSmall.put(cave, visits + cave.small);
        int sum = cave.connected.stream().mapToInt(next -> pathsOut(next, 2 | flags | visits & cave.small & flags >> 1)).sum();
        visitedSmall.put(cave, visits);
        return sum;
    }

    static class Cave {
        final String name;
        final int small;
        final Set<Cave> connected = new HashSet<>();

        public Cave(String name) {
            this.name = name;
            this.small = name.charAt(0) >> 5 & 1;
        }

        void connectTo(String other) {
            Cave otherCave = cavesByName.computeIfAbsent(other, Cave::new);
            connected.add(otherCave);
            otherCave.connected.add(this);
        }
    }
}

