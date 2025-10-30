package vegetables;

/**
 * Клас, що описує салат з масиву овочів.
 *
 * @param <T> тип овочів, що наслідують Vegetables
 */
public class Salad<T extends Vegetables> {

    private final T[] vegetables;

    /**
     * Конструктор салату.
     *
     * @param vegetables масив овочів
     */
    public Salad(T[] vegetables) {
        if (vegetables == null || vegetables.length == 0) {
            throw new IllegalArgumentException("Масив овочів не може бути порожнім");
        }
        this.vegetables = vegetables;
    }

    /**
     * Обчислює загальну калорійність салату.
     *
     * @return сума калорій
     */
    public int calculateCalories() {
        int total = 0;
        for (T veg : vegetables) {
            total += veg.getCalories();
        }
        return total;
    }

    /**
     * Виводить склад салату.
     */
    public void printSalad() {
        System.out.printf("%-15s %-15s %-10s%n", "Назва", "Колір", "Ккал/100г");
        for (T veg : vegetables) {
            System.out.printf("%-15s %-15s %-10d%n", veg.toString(), veg.getColor(), veg.getCalories());
        }
    }

    /**
     * Знаходить овочі в заданому діапазоні калорійності.
     *
     * @param min мінімальна калорійність
     * @param max максимальна калорійність
     */
    public void findByCalories(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Мінімальна калорійність не може бути більшою за максимальну");
        }
        boolean found = false;
        for (T veg : vegetables) {
            if (veg.getCalories() >= min && veg.getCalories() <= max) {
                System.out.printf("%-15s %-15s %-10d%n", veg.toString(), veg.getColor(), veg.getCalories());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Немає овочів у цьому діапазоні.");
        }
    }

    /**
     * Сортує овочі за калорійністю за зростанням.
     */
    public void sortByCalories() {
        java.util.Arrays.sort(vegetables, java.util.Comparator.comparingInt(Vegetables::getCalories));
    }

    /**
     * Повертає масив овочів.
     *
     * @return масив овочів
     */
    public T[] getVegetables() {
        return vegetables;
    }
}