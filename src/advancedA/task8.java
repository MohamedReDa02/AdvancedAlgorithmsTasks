package advancedA;

import java.util.*;

public class task8 {
    private Map<Character, Map<Character, Character>> routingTables;

    public task8(List<String> connectivityInfo) {
        routingTables = new HashMap<>();
        for (String connection : connectivityInfo) {
            char node = connection.charAt(0);
            char neighbor = connection.charAt(2);
            updateRoutingTable(node, neighbor, neighbor);
            updateRoutingTable(neighbor, node, node);
        }

        for (char node : routingTables.keySet()) {
            Map<Character, Character> table = routingTables.get(node);
            Queue<Character> queue = new LinkedList<>(table.keySet());

            while (!queue.isEmpty()) {
                char curr = queue.poll();
                char currNextHop = table.get(curr);
                Map<Character, Character> neighbors = routingTables.get(curr);
                for (char neighbor : neighbors.keySet()) {
                    if (!table.containsKey(neighbor)) {
                        char nextHop = neighbors.get(neighbor);
                        updateRoutingTable(node, neighbor, nextHop);
                        table.put(neighbor, currNextHop);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    public void printRoutingTables() {
        for (Character node : routingTables.keySet()) {
            System.out.println("Routing table for node " + node + ":");
            Map<Character, Character> table = routingTables.get(node);
            for (Character dest : table.keySet()) {
                System.out.println("  " + dest + " -> " + table.get(dest));
            }
        }
    }

public void updateRoutingTable(char node, char dest, char nextHop) {
    routingTables.computeIfAbsent(node, k -> new HashMap<>()).merge(dest, nextHop, (prevHop, newHop) -> prevHop < newHop ? prevHop : newHop);
}



    public static void main(String[] args) {
        List<String> connectivityInfo = List.of("A:B", "A:C", "A:D");
        task8 rtb = new task8(connectivityInfo);
        rtb.printRoutingTables();
    }
}