import java.util.Objects;

/**
 * Клас, що представляє слово як масив літер
 * Надає методи для порівняння, перетворення та роботи зі словом
 */
public class Word {
    /**
     * Масив літер, що складають слово
     */
    private final Letter[] letters;

    /**
     * Конструктор для створення слова з рядка
     * Кожен символ рядка перетворюється в об'єкт Letter
     *
     * @param value рядок, що представляє слово
     */
    public Word(String value) {
        this.letters = new Letter[value.length()];
        for (int i = 0; i < value.length(); i++) {
            letters[i] = new Letter(value.charAt(i));
        }
    }

    /**
     * Повертає масив літер, що складають слово
     *
     * @return масив об'єктів Letter
     */
    public Letter[] getLetters() {
        return letters;
    }

    /**
     * Повертає кількість літер
     *
     * @return кількість літер у слові
     */
    public int length() {
        return letters.length;
    }

    /**
     * Повертає першу літеру слова
     * Якщо слово порожнє, повертає нульовий символ '\0'
     *
     * @return перший символ слова або '\0' для порожнього слова
     */
    public char getFirstChar() {
        return letters.length > 0 ? letters[0].getSymbol() : '\0';
    }

    /**
     * Повертає рядкове представлення слова
     * Об'єднує всі літери в один рядок
     *
     * @return рядок, що представляє слово
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getSymbol());
        }
        return sb.toString();
    }

    /**
     * Порівнює слово з іншим об'єктом на рівність
     * Два слова - рівні, якщо вони містять однакові літери в тому ж порядку
     *
     * @param obj об'єкт для порівняння
     * @return true - об'єкти рівні; false - інакше
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Word)) {
            return false;
        }
        Word other = (Word) obj;
        return this.toString().equals(other.toString());
    }

    /**
     * Повертає хеш-код слова
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }
}
