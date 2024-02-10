import java.util.*;
public class P08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while(!input.equals("end")) {
            String longIp = input.split(" ")[0];
            String longMessage = input.split(" ")[1];
            String longUser = input.split(" ")[2];

            String ip = longIp.split("=")[1];
            String message = longMessage.split("=")[1];
            String username = longUser.split("=")[1];

            if(!users.containsKey(username)) {
                users.put(username, new LinkedHashMap<>(){{
                    put(ip, 1);
                }});
            } else {
                Map<String, Integer> currentIps = users.get(username);
                if(currentIps.containsKey(ip)) {
                    int currentTimes = currentIps.get(ip);
                    currentIps.put(ip, currentTimes + 1);
                } else {
                    currentIps.put(ip, 1);
                }
            }
            input = scanner.nextLine();

        }
        users.keySet().forEach(username -> {
            System.out.println(username + ": ");
            Map<String, Integer> ips = users.get(username);
            // Get an iterator for the entries in the map
            Iterator<Map.Entry<String, Integer>> iterator = ips.entrySet().iterator();

            // Iterate through the entries and print each key-value pair
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                System.out.print(entry.getKey() + " => " + entry.getValue());

                // Check if it's the last entry
                if (iterator.hasNext()) {
                    System.out.print(", ");
                } else {
                    System.out.println(".");
                }
            }
        });

    }
}



