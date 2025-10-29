import vegetables.*;
import vegetables.green.*;
import vegetables.orange.*;
import vegetables.red.*;

import java.util.Scanner;

/**
 * Головний клас програми для роботи з салатом з овочів.
 * Можливості:
 * 1) створення масиву овочів,
 * 2) підрахунок калорійності салату,
 * 3) сортування за калорійністю,
 * 4) пошук овочів у заданому діапазоні калорійності.
 */
public class Main {
    /**
     * Головний метод програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        int zalikova = 3422;     // номер залікової книжки
        int c13 = zalikova % 13; // обчислення варіанту завдання

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Номер залікової = " + zalikova);
            System.out.printf("C13 = %s = Завдання 3. Визначити ієрархію овочів. Зробити салат. " +
                    "\nПорахувати калорійність салату. Провести сортування овочів для салату на основі одного з параметрів. " +
                    "\nЗнайти овоч у салаті, що відповідає заданому діапазону калорійності.\n\n", c13);

            // Створення масиву овочів для салату
            Vegetables[] vegetablesArray = {
                    new Celery(),
                    new Carrot(),
                    new Corn(),
                    new Tomato()
            };

            // Створення салату
            Salad<Vegetables> salad = new Salad<>(vegetablesArray);

            // Вивід салату та калорійність
            System.out.println("Склад салату:");
            salad.printSalad();
            System.out.println("Калорійність салату: " + salad.calculateCalories());

            // Сортування за калорійністю
            salad.sortByCalories();
            System.out.println("\nСортування за калорійністю (зростання):");
            salad.printSalad();

            // Пошук овочів у діапазоні калорійності
            System.out.print("\nВведіть мінімальну калорійність: ");
            int min = scanner.nextInt();
            System.out.print("Введіть максимальну калорійність: ");
            int max = scanner.nextInt();

            System.out.println("\nОвочі у заданому діапазоні калорійності:");
            salad.findByCalories(min, max);

            // Обробники помилок
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}