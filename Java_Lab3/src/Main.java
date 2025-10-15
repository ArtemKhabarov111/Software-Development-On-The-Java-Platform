import java.util.Arrays;
import java.util.Comparator;

/**
 * Головний клас програми для демонстрації роботи з масивом об'єктів Car.
 * Виконує сортування масиву за різними критеріями та пошук ідентичних об'єктів.
 */
public class Main {
    /**
     * Головний метод програми.
     * Створює масив автомобілів, виконує сортування та пошук.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        int zalikova = 3422;
        int c11 = zalikova % 11;
        System.out.println("Номер залікової = " + zalikova);
        System.out.printf("C11 = %s = Визначити клас автомобіль, який складається як мінімум з 5-и полів.%n", c11);

        // Ініціалізація масиву автомобілів
        Car[] cars = {
                new Car("Infiniti QX60", "White", "Nissan",
                        2012, 180, 1900, 4),

                new Car("Honda CR-V", "White", "Honda",
                        1995, 150, 1800, 4),

                new Car("Nobe GT100", "Red", "Nobe Cars",
                        2012, 130, 500, 3),

                new Car("Toyota Tacoma", "Blue", "Toyota",
                        2004, 170, 2000, 4),

                new Car("Tesla Model 3", "Silver", "Tesla, Inc.",
                        2012, 200, 1700, 4),
        };

        // Вивід початкового масиву
        System.out.println("\nПочатковий масив:");
        showResult(cars);

        // Сортування масиву: за роком (зростання) та швидкістю (спадання)
        Arrays.sort(cars, Comparator
                .comparingInt(Car::getYear)  // за роком (зростання)
                .thenComparing(Comparator.comparingInt(Car::getSpeed).reversed())  // за швидкістю (спадання)
        );

        // Вивід відсортованого масиву
        System.out.println("\nВідсортований масив: за роком (зростання) та швидкістю (спадання)");
        showResult(cars);

        // Сортування масиву: за швидкістю (зростання) та вагою (спадання)
        Arrays.sort(cars, Comparator
                .comparingInt(Car::getSpeed)  // за вагою (зростання)
                .thenComparing(Comparator.comparingInt(Car::getWeight).reversed())  // за к-тю коліс (спадання)
        );

        // Вивід відсортованого масиву
        System.out.println("\nВідсортований масив: за швидкістю (зростання) та вагою (спадання)");
        showResult(cars);

        // Автомобылі для пошуку
        Car searchCar1 = new Car("Infiniti QX60", "White", "Nissan",
                2012, 180, 1900, 4);

        Car searchCar2 = new Car("Lamborghini", "Gray", "Lamborghini",
                2013, 350, 950, 4);

        // Знайти в масиві об’єкт, який ідентичний заданому
        searchIdenticalCar(cars, searchCar1);
        searchIdenticalCar(cars, searchCar2);

    }

    /**
     * Виводить масив автомобілів у вигляді форматованої таблиці.
     * Таблиця містить заголовки стовпців та інформацію про кожен автомобіль.
     *
     * @param cars масив автомобілів для відображення
     */
    public static void showResult(Car[] cars){
        System.out.printf("%-2s %-17s %-9s %-14s %-8s %-17s %-10s %-8s%n",
                "№", "Назва", "Колір", "Виробник", "Рік", "Макс. швидкість", "Вага(кг)", "К-ть Коліс");
        for (int i = 0; i < cars.length; i++) {
            Car car = cars[i];
            System.out.printf("%-2d %-17s %-9s %-14s %-8d %-17d %-10d %-8d%n",
                    (i + 1), car.getName(), car.getColor(), car.getManufacturer(),
                    car.getYear(), car.getSpeed(), car.getWeight(), car.getWheels());
        }
    }

    /**
     * Шукає автомобіль у масиві, ідентичний заданому.
     * Виводить результат пошуку та інформацію про шуканий автомобіль.
     *
     * @param cars масив автомобілів для пошуку
     * @param searchCar автомобіль, який потрібно знайти
     */
    public static void searchIdenticalCar(Car[] cars, Car searchCar){
        int foundIndex = -1;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].equals(searchCar)) {
                foundIndex = i;
                break;
            }
        }

        // Виведення результату пошуку
        if (foundIndex != -1) {
            System.out.println();
            System.out.println("\nАвтомобіль знайдено на позиції " + (foundIndex + 1));
        } else {
            System.out.println("\nАвтомобіль не знайдено");
        }
        System.out.printf("%-2s %-17s %-9s %-14s %-8s %-17s %-10s %-8s%n",
                "№", "Назва", "Колір", "Виробник", "Рік", "Макс. швидкість", "Вага(кг)", "К-ть Коліс");

        System.out.printf("%-2d %-17s %-9s %-14s %-8d %-17d %-10d %-8d%n",
                foundIndex + 1, searchCar.getName(), searchCar.getColor(), searchCar.getManufacturer(),
                searchCar.getYear(), searchCar.getSpeed(), searchCar.getWeight(), searchCar.getWheels());
    }
}