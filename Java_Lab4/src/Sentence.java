import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє речення як масив слів та розділових знаків
 */
public class Sentence {
    /**
     * Масив слів та розділових знаків
     */
    private final Object[] elements;

    /**
     * Конструктор для створення речення з рядка
     * Розбиває рядок на слова та розділові знаки
     *
     * @param sentence рядок, що представляє речення
     */
    public Sentence(String sentence) {
        List<Object> tempElements = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (Character.isLetter(ch)) {
                currentWord.append(ch);
            } else {
                // Додаємо накопичене слово, якщо воно не порожнє
                if (currentWord.length() > 0) {
                    tempElements.add(new Word(currentWord.toString()));
                    currentWord.setLength(0);
                }

                // Додаємо розділовий знак, окрім пробілів
                if (ch != ' ') {
                    tempElements.add(new PunctuationMark(ch));
                }
            }
        }

        // Додаємо останнє слово, якщо воно є
        if (currentWord.length() > 0) {
            tempElements.add(new Word(currentWord.toString()));
        }

        this.elements = tempElements.toArray();
    }

    /**
     * Повертає слова та розділові знаки
     *
     * @return масив об'єктів
     */
    public Object[] getElements() {
        return elements;
    }

    /**
     * Повертає слова з речення (без розділових знаків)
     *
     * @return масив об'єктів Word
     */
    public Word[] getWords() {
        List<Word> words = new ArrayList<>();
        for (Object obj : elements) {
            if (obj instanceof Word) {
                words.add((Word) obj);
            }
        }
        return words.toArray(new Word[0]);
    }

    /**
     * Повертає рядкове представлення речення
     * Додає пробіли між словами, окрім розділових знаків
     *
     * @return рядок, що представляє речення
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i].toString());

            // Додаємо пробіл тільки між двома словами
            if (i < elements.length - 1
                    && elements[i] instanceof Word
                    && elements[i + 1] instanceof Word) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}