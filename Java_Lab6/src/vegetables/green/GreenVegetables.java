package vegetables.green;

import vegetables.Vegetables;

/**
 * Абстрактний клас для зелених овочів.
 */
public abstract class GreenVegetables extends Vegetables {
    /**
     * Конструктор зелених овочів.
     *
     * @param calories калорійність
     * @param color колір
     */
    public GreenVegetables(int calories, String color) {
        super(calories, color);
    }
}
