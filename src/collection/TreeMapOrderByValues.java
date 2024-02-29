package collection;

import java.util.*;

public class TreeMapOrderByValues {
    public static void main(String[] args) {
        // Sample data (replace with your data)
        Map<String, Integer> data = new HashMap<>();
        data.put("account3", 4250);
        data.put("account2", 3000);
        data.put("account1", 5000);
        data.put("account4", 2000);

        // Create a list of entries
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(data.entrySet());

        // Sort the list based on values
        entries.sort(Map.Entry.comparingByValue());

        // Create a TreeMap with a custom Comparator to sort by values
        TreeMap<String, Integer> sortedData = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer value1 = data.get(o1);
                Integer value2 = data.get(o2);
                // Handle null values if needed
                return value2.compareTo(value1);
            }
        });

        // Populate the TreeMap with sorted entries
        for (Map.Entry<String, Integer> entry : entries) {
            sortedData.put(entry.getKey(), entry.getValue());
        }

        // Output the sorted TreeMap
        for (Map.Entry<String, Integer> entry : sortedData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
