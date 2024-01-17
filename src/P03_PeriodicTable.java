import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicals = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();

            String[] chemicalElements = inputLine.split("\\s+");
            for (String element:chemicalElements) {
                chemicals.add(element);

            }
        }
        for (String element:chemicals) {
            System.out.print(element + " ");
        }

    }
}
