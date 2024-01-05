
import java.util.HashMap;
import java.util.Random;


/*реализовать Java приложение для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия)
 и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
Студенту необходимо:
Создать свой Java Maven/Gradle проект;
Реализовать прикладную задачу - приложение для демонстрации парадокса Монти Холла;
Можно добавить любые библиотеки которые считают необходимыми
Результаты должны быть сохранены в HashMap (шаг цикла -> результат)
Необходимо вывести статистику по результату - количество позитивных и
 негативных результатов, процент от общего количества шагов цикла.*/


public class Main {
    public static void main(String[] args) {
        int totalSteps = 1000; // Увеличьте количество повторений по вашему усмотрению
        HashMap<Integer, String> results = new HashMap<>();

        for (int step = 1; step <= totalSteps; step++) {
            HashMap<Integer, String> doors = new HashMap<>();
            doors.put(1, "Автомобиль");
            doors.put(2, "Коза");
            doors.put(3, "Коза");

            int initialChoice = new Random().nextInt(1, 4);

            // Открываем одну из дверей с козой (не выбранной игроком)
            int revealedDoor;
            do {
                revealedDoor = new Random().nextInt(1, 4);
            } while (revealedDoor == initialChoice || doors.get(revealedDoor).equals("Автомобиль"));

            // Принимаем решение: оставляем выбор или меняем
            boolean switchDoor = new Random().nextBoolean();
            int finalChoice = switchDoor ? getOtherDoor(initialChoice, revealedDoor) : initialChoice;

            // Записываем результат
            String result = doors.get(finalChoice);
            results.put(step, result);
        }

        // Выводим статистику
        int positiveResults = (int) results.values().stream().filter(result -> result.equals("Автомобиль")).count();
        int negativeResults = totalSteps - positiveResults;
        double positivePercentage = (double) positiveResults / totalSteps * 100;
        double negativePercentage = (double) negativeResults / totalSteps * 100;

        System.out.println("Позитивных результатов: " + positiveResults);
        System.out.println("Негативных результатов: " + negativeResults);
        System.out.println("Процент позитивных результатов: " + positivePercentage + "%");
        System.out.println("Процент негативных результатов: " + negativePercentage + "%");
    }

    private static int getOtherDoor(int initialChoice, int revealedDoor) {
        for (int door = 1; door <= 3; door++) {
            if (door != initialChoice && door != revealedDoor) {
                return door;
            }
        }
        return initialChoice;
    }
}