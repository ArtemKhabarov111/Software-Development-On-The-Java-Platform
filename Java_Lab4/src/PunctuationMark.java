/**
 * Клас, що представляє розділовий знак
 * Інкапсулює розділові знаки (. , ! ?) та надає методи для роботи з ними
 */
public class PunctuationMark {
    /**
     * Символ розділового знаку
     */
    private final char mark;

    /**
     * Конструктор для створення об'єкта розділового знаку
     *
     * @param mark символ розділового знаку
     */
    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    /**
     * Повертає символ розділового знаку
     *
     * @return символ розділового знаку
     */
    public char getMark() {
        return mark;
    }

    /**
     * Повертає рядкове представлення розділового знаку
     *
     * @return рядок, що містить один символ
     */
    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
