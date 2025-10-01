import java.util.*;

// Виконавчий метод програми
public class Main {
    public static void main(String[] args) {
        int zalikova = 3422;
        int c3 = zalikova % 3;
        int c17 = zalikova % 17;
        System.out.println("Номер залікової = " + zalikova);
        System.out.printf("C3 = %s = Тип: StringBuffer %n", c3);
        System.out.printf("C17 = %s = Завдання: Надрукувати слова без повторень заданого тексту " +
                "в алфавітному порядку за першою літерою %n", c17);

        // Початковий текст
        StringBuffer text = new StringBuffer("фізика алгебра абетка абетка бегемот біологія вірш вірш вірші хімія бегемот");

        List<StringBuffer> wordsList = new ArrayList<>();
        StringBuffer currentWord = new StringBuffer();

        try {
            // Розділяємо текст на слова
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (ch == ' ') {
                    if (currentWord.length() > 0) {
                        wordsList.add(new StringBuffer(currentWord));
                        currentWord.setLength(0);
                    }
                } else {
                    currentWord.append(ch);
                }
            }
            // Додаємо останнє слово
            if (currentWord.length() > 0) {
                wordsList.add(currentWord);
            }

            // Видаляємо повторення
            List<StringBuffer> uniqueWords = new ArrayList<>();
            for (StringBuffer word : wordsList) {
                boolean isDuplicate = false;
                for (StringBuffer unique : uniqueWords) {
                    if (areEqual(word, unique)) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    uniqueWords.add(word);
                }
            }

            // Сортуємо за першою літерою
            uniqueWords.sort((sb1, sb2) -> {
                if (sb1.length() == 0 && sb2.length() == 0) return 0;
                if (sb1.length() == 0) return -1;
                if (sb2.length() == 0) return 1;
                return Character.compare(sb1.charAt(0), sb2.charAt(0));
            });

            // Вивід результатів
            System.out.println("\nПочатковий текст: \n" + text);
            System.out.println("\nУнікальні відсортовані слова:");
            for (StringBuffer sb : uniqueWords) {
                System.out.print(sb.toString() + " ");
            }

        } catch (NullPointerException npe) {
            System.err.println("Помилка: null у вхідних даних. " + npe.getMessage());

        } catch (IndexOutOfBoundsException ioobe) {
            System.err.println("Помилка індексації під час обробки рядка. " + ioobe.getMessage());

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }


    // Метод для порівняння двох об'єктів StringBuffer
    // Повертає true, якщо обидва містять однакові символи в тому ж порядку, інакше false
    private static boolean areEqual(StringBuffer sb1, StringBuffer sb2) {
        if (sb1.length() != sb2.length()) return false;
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) return false;
        }
        return true;
    }
}