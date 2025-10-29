package vegetables.orange;

import vegetables.Vegetables;

/**
 * Абстрактний клас для помаранчевих овочів.
 */
public abstract class OrangeVegetables extends Vegetables {
    /**
     * Конструктор помаранчевих овочів.
     *
     * @param calories калорійність
     * @param color колір
     */
    public OrangeVegetables(int calories, String color) {
        super(calories, color);
    }
}
