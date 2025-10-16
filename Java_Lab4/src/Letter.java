/**
 * Клас, що представляє одну літеру тексту
 * Інкапсулює один символ та надає методи для роботи з ним
 */
public class Letter {
    /**
     * Символ, що представляє літеру
     */
    private final char symbol;

    /**
     * Конструктор для створення об'єкта літери
     *
     * @param symbol символ літери
     */
    public Letter(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Повертає символ літери
     *
     * @return символ літери
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Повертає рядкове представлення літери
     *
     * @return рядок, що містить один символ
     */
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}