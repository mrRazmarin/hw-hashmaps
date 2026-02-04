import code.Address;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Address kazan = new Address("Россия", "Казань");
        Address moscow = new Address("Россия", "Москва");
        Address rio = new Address("Аргентина", "Рио-Де-Жанейро");

        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(kazan, 500);
        costPerAddress.put(moscow, 1000);
        costPerAddress.put(rio, 4500);

        int totalSum = 0;

        while(true) {

            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String inputCountry = scanner.nextLine();

            if (inputCountry.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String inputCity = scanner.nextLine();

            System.out.print("Введите вес (кг): ");
            int inputWeight = Integer.parseInt(scanner.nextLine());

            Address currentAddress = new Address(inputCountry, inputCity);

            if (costPerAddress.containsKey(currentAddress)){
                int costPerKg = costPerAddress.get(currentAddress);
                int deliveryCost = costPerKg * inputWeight;

                totalSum += deliveryCost;

                System.out.printf("Стоимость доставки: %d%n", deliveryCost);
                System.out.printf("Общая сумма всех доставок: %d%n", totalSum);
                System.out.println();
            } else {
                System.out.println("Извините, такой адрес не обслуживается.");
                System.out.println();
            }
        }
    }
}
