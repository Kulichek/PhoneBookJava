import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество записей в телефонной книге:");
            int n = scanner.nextInt();
            scanner.nextLine(); // очистка буфера
            for (int i = 0; i < n; i++) {
                System.out.println("Введите имя и телефон через пробел:");
                String[] input = scanner.nextLine().split(" ");
                String name = input[0];
                String phone = input[1];
                if (!phoneBook.containsKey(name)) {
                    phoneBook.put(name, new HashSet<>());
                }
                phoneBook.get(name).add(phone);
            }
        }
        List<Map.Entry<String, HashSet<String>>> list = new ArrayList<>(phoneBook.entrySet());
        list.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());
        System.out.println("Телефонная книга:");
        for (Map.Entry<String, HashSet<String>> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}