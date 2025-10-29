package vegetables;

/**
 * Клас, який описує загальні властивості овочів.
 */
public abstract class Vegetables {
    private final int calories;
    private final String color;

    /**
     * Конструктор класу овочів.
     *
     * @param calories калорійність овоча на 100 г
     * @param color колір овоча
     */
    public Vegetables(int calories, String color) {
        this.calories = calories;
        this.color = color;
    }

    /**
     * Повертає калорійність овоча.
     *
     * @return калорійність
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Повертає колір овоча.
     *
     * @return колір
     */
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
