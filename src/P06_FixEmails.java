
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsMap = new HashMap<>();

        String name = scanner.nextLine();

        while(!name.equals("stop")) {

            String email = scanner.nextLine();

            String emailMainDomain = email.split("@")[1];

            String domain = emailMainDomain.split("\\.")[1];

            emailsMap.put(name, email);

            if(domain.equals("us") || domain.equals("uk") || domain.equals("com")) {
                  emailsMap.remove(name, email);
            } else {
                System.out.printf("%s -> %s%n", name, emailsMap.get(name));
            }

            name = scanner.nextLine();
        }

    }
}
