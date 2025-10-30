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
        int zalikova = 3422;
        int c2 = zalikova % 2;
        int c3 = zalikova % 3;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.printf("%-20s %-10s %-10s%n", "Залікова = " + zalikova, "C2 = " + c2, "C3 = " + c3);
            System.out.println("Інтерфейс, який реалізує колекція: List");
            System.out.println("Внутрішня структура колекції: Двозв’язний список\n");

            // Створення овочів для салату
            Celery celery = new Celery();
            Carrot carrot = new Carrot();
            Corn corn = new Corn();
            Tomato tomato = new Tomato();

            // Створення салату
            DoublyLinkedList<Vegetables> list = new DoublyLinkedList<>();
            list.add(celery);
            list.add(carrot);
            list.add(corn);
            list.add(tomato);

            // Створення салату з масиву овочів
            Salad<Vegetables> salad = new Salad<>(list.toArray(new Vegetables[0]));

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