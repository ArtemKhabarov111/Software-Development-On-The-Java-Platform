import java.util.Objects;

/**
 * Клас Car представляє автомобіль з основними характеристиками.
 * Використовується для зберігання та порівняння інформації про автомобілі.
 */
public class Car {
    /** Назва моделі автомобіля */
    private final String name;

    /** Колір автомобіля */
    private final String color;

    /** Виробник автомобіля */
    private final String manufacturer;

    /** Рік випуску автомобіля */
    private final int year;

    /** Максимальна швидкість автомобіля (км/год) */
    private final int speed;

    /** Вага автомобіля (кг) */
    private final int weight;

    /** Кількість коліс */
    private final int wheels;


    /**
     * Конструктор для створення об'єкта автомобіля.
     *
     * @param name назва моделі автомобіля
     * @param color колір автомобіля
     * @param manufacturer виробник автомобіля
     * @param year рік випуску
     * @param speed максимальна швидкість (км/год)
     * @param weight вага автомобіля (кг)
     * @param wheels кількість коліс
     */
    public Car(String name, String color, String manufacturer, int year, int speed, int weight, int wheels) {
        this.name = name;
        this.color = color;
        this.manufacturer = manufacturer;
        this.year = year;
        this.speed = speed;
        this.weight = weight;
        this.wheels = wheels;
    }

    /**
     * Повертає назву моделі автомобіля.
     *
     * @return назва моделі
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає колір автомобіля.
     *
     * @return колір автомобіля
     */
    public String getColor() {
        return color;
    }

    /**
     * Повертає виробника автомобіля.
     *
     * @return виробник
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Повертає рік випуску автомобіля.
     *
     * @return рік випуску
     */
    public int getYear() {
        return year;
    }

    /**
     * Повертає максимальну швидкість автомобіля.
     *
     * @return максимальна швидкість (км/год)
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Повертає вагу автомобіля.
     *
     * @return вага (кг)
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Повертає кількість коліс автомобіля.
     *
     * @return кількість коліс
     */
    public int getWheels() {
        return wheels;
    }

    /**
     * Порівнює два об'єкти автомобілів на рівність.
     * Два автомобілі вважаються рівними, якщо всі їхні поля однакові.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо об'єкти рівні; false - інакше
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) && color.equals(car.color) && manufacturer.equals(car.manufacturer) &&
                year == car.year && speed == car.speed && weight == car.weight && wheels == car.wheels;
    }

    /**
     * Повертає хеш-код об'єкта автомобіля.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, color, manufacturer, year, speed, weight, wheels);
    }
}
