
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
        HashMap<Integer, String> doors = new HashMap<>();
        doors.put(1, "Ааавтомобииль");
        doors.put(2, "Коза");
        doors.put(3, "Коза");
        int initialChoice = new Random().nextInt(1, 4);
        // Убираем первый выбор
        // Проходим по map, открываем два оставшихся выбора
        // Если попалась коза, выбираем оставшиеся варианты
        // Либо оставляем тот же выбор, либо меняем
        //
    }
}