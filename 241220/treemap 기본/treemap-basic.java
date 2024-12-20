import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        sc.nextLine(); 

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); 

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" "); 

            switch (parts[0]) {
                case "add": {
                
                    int k = Integer.parseInt(parts[1]);
                    int v = Integer.parseInt(parts[2]);
                    treeMap.put(k, v); 
                    break;
                }
                case "remove": {
                   
                    int k = Integer.parseInt(parts[1]);
                    treeMap.remove(k); 
                    break;
                }
                case "find": {
                
                    int k = Integer.parseInt(parts[1]);
                    if (treeMap.containsKey(k)) {
                        System.out.println(treeMap.get(k)); 
                    } else {
                        System.out.println("None");
                    }
                    break;
                }
                case "print_list": {
                    
                    if (treeMap.isEmpty()) {
                        System.out.println("None");
                    } else {
                        List<Integer> values = new ArrayList<>(treeMap.values());
                        System.out.println(String.join(" ", values.stream().map(String::valueOf).toArray(String[]::new)));
                    }
                    break;
                }
            }
        }
    }
}
