import java.security.KeyStore;
import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //S -> 4, H-> 3, D -> 2, C -> 1
        //2, 3, 4, 5, 6, 7, 8, 9, 10, J-11, Q-12, K-13, A-14

        Map<String, List<String>> cardsMapList = new HashMap<>();
        Map<String, Integer> cardsMap = new LinkedHashMap<>();

//        List<String> cardsList = new ArrayList<>();

        String input = scanner.nextLine();


        while(!input.equals("JOKER")) {
            String name = input.split(":")[0];
            String cardsInput = input.split(":")[1].trim();
            String[] cards = cardsInput.split(", ");

            int cardsSum = 0;

            for (String card : cards) {
                cardsMapList.putIfAbsent(name, new ArrayList<>());
                if (!cardsMapList.get(name).contains(card)) {
                    cardsMapList.get(name).add(card);
//                    cardsList.add(card);

                    int power = 0;
                    int type = 0;

                    String powerCard = card.split("")[0].trim();
                    switch (powerCard) {
                        case "J" -> power = 11;
                        case "Q" -> power = 12;
                        case "K" -> power = 13;
                        case "A" -> power = 14;
                        case "2" -> power = 2;
                        case "3" -> power = 3;
                        case "4" -> power = 4;
                        case "5" -> power = 5;
                        case "6" -> power = 6;
                        case "7" -> power = 7;
                        case "8" -> power = 8;
                        case "9" -> power = 9;
                        case "10" -> power = 10;
                    }
                    String typeCard = card.split("")[1];
                    switch (typeCard) {
                        case "S" -> type = 4;
                        case "H" -> type = 3;
                        case "D" -> type = 2;
                        case "C" -> type = 1;
                    }
                    cardsSum += (power * type);
                }
            }

            if (cardsMap.containsKey(name)) {
                cardsSum = cardsMap.get(name) + cardsSum;
            }
            cardsMap.put(name, cardsSum);

            input = scanner.nextLine();
            }

        for (Map.Entry mp: cardsMap.entrySet()) {
            System.out.println(mp.getKey() + ": " + mp.getValue());
        }
    }
}
