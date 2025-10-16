import java.util.*;

/**
 * Клас, що представляє текст як масив речень
 * Надає методи для роботи з текстом
 */
public class Text {
    /**
     * Масив речень
     */
    private final Sentence[] sentences;

    /**
     * Конструктор для створення тексту з StringBuffer
     * Виконує нормалізацію пробілів, табуляцій і розбиття на речення
     *
     * @param text об'єкт StringBuffer, що містить початковий текст
     */
    public Text(StringBuffer text) {
        // Заміна послідовності пробілів і табуляцій на один пробіл
        String normalized = text.toString().replaceAll("[\\t ]+", " ").trim();

        // Розбиття на речення за крапкою, знаком оклику або питання
        String[] rawSentences = normalized.split("(?<=[.!?])\\s+");

        List<Sentence> tempSentences = new ArrayList<>();
        for (String s : rawSentences) {
            if (!s.isEmpty()) {
                tempSentences.add(new Sentence(s));
            }
        }

        this.sentences = tempSentences.toArray(new Sentence[0]);
    }

    /**
     * Повертає всі речення тексту
     *
     * @return масив об'єктів Sentence
     */
    public Sentence[] getSentences() {
        return sentences;
    }

    /**
     * Повертає масив унікальних слів, відсортованих за першою літерою в алфавітному порядку
     * Дублікати видаляються, використовуючи LinkedHashSet
     *
     * @return масив унікальних об'єктів Word, відсортованих за першою літерою
     */
    public Word[] getUniqueSortedWords() {
        Set<Word> unique = new LinkedHashSet<>();

        // Збираємо всі слова з усіх речень
        for (Sentence sentence : sentences) {
            unique.addAll(Arrays.asList(sentence.getWords()));
        }

        // Перетворюємо Set у масив та сортуємо
        Word[] sorted = unique.toArray(new Word[0]);
        Arrays.sort(sorted, Comparator.comparing(Word::getFirstChar));

        return sorted;
    }

    /**
     * Повертає рядкове представлення тексту
     * Об'єднує всі речення з пробілами між ними
     *
     * @return рядок, що представляє весь текст
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            sb.append(sentences[i].toString());
            if (i < sentences.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
