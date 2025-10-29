package vegetables.red;

import vegetables.Vegetables;

/**
 * Абстрактний клас для червоних овочів.
 */
public abstract class RedVegetables extends Vegetables {
    /**
     * Конструктор червоних овочів.
     *
     * @param calories калорійність
     * @param color колір
     */
    public RedVegetables(int calories, String color) {
        super(calories, color);
    }
}
