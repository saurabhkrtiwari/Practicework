package collection;

import java.util.*;

public class Top3Elements {
    public static void main(String[] args) {
        // Sample data (replace with your data)
        TreeMap<String, Integer> data = new TreeMap<>();
        data.put("account3", 4250);
        data.put("account2", 4250);
        data.put("account1", 3000);
        data.put("account4", 2000);

        // Read the top 3 elements
        int count = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (count < 3) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
    }
}
