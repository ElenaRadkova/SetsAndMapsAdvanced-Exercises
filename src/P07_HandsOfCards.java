
import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //S -> 4, H-> 3, D -> 2, C -> 1
        //2, 3, 4, 5, 6, 7, 8, 9, 10, J-11, Q-12, K-13, A-14

        Map<String, Set<String>> cardsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            String cardsInput = input.split(":")[1].trim();
            String[] cards = cardsInput.split(", ");

            Set<String> cardsSet = new HashSet<>();
            cardsSet.addAll(Arrays.asList(cards));

            if (!cardsMap.containsKey(name)) {
                cardsMap.put(name, cardsSet);
            } else {
                Set<String> currentCards = cardsMap.get(name);
                currentCards.addAll(cardsSet);
                cardsMap.put(name, currentCards);
            }

        input = scanner.nextLine();
    }
        cardsMap.entrySet().forEach(entry-> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });

    }
    private static int getCardsPoints(Set<String> cards) {
        int cardsSum = 0;

        for (String card : cards) {
            int power = 0;
            int type = 0;

            String powerCard = card.split("")[0].trim();
            switch (powerCard) {
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
                case "2":
                    power = 2;
                    break;
                case "3":
                    power = 3;
                    break;
                case "4":
                    power = 4;
                    break;
                case "5":
                    power = 5;
                    break;
                case "6":
                    power = 6;
                    break;
                case "7":
                    power = 7;
                    break;
                case "8":
                    power = 8;
                    break;
                case "9":
                    power = 9;
                    break;
                case "1":
                    power = 10;
                    break;
            }
            String typeCard="";
            if (!powerCard.equals("1")) {
                 typeCard = card.split("")[1];

            } else {
                typeCard = card.split("")[2];
            }
                switch (typeCard) {
                    case "S":
                        type = 4;
                        break;
                    case "H":
                        type = 3;
                        break;
                    case "D":
                        type = 2;
                        break;
                    case "C":
                        type = 1;
                        break;
                }

            cardsSum += (power * type);
        }
        return cardsSum;
    }
}
