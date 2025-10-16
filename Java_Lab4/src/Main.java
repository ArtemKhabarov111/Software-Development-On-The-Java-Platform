/**
 * Головний клас програми для демонстрації роботи з текстом
 * Друкує слова без повторень заданого тексту в алфавітному порядку за першою літерою
 */
public class Main {
    /**
     * Головний метод програми
     * Виконує обробку тексту та виведення результатів
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        int zalikova = 3422;
        int c3 = zalikova % 3;
        int c17 = zalikova % 17;

        System.out.println("Номер залікової = " + zalikova);
        System.out.printf("C3 = %s = Тип: StringBuffer%n", c3);
        System.out.printf("C17 = %s = Завдання: Надрукувати слова без повторень заданого тексту "
                + "в алфавітному порядку за першою літерою%n", c17);

        try {
            // Початковий текст з табуляціями та пробілами
            StringBuffer inputText = new StringBuffer(
                    "фізика   алгебра\t\tабетка абетка, бегемот  біологія\tвірш вірш   вірші хімія\t\tбегемот."
            );

            System.out.println("\nПочатковий текст:");
            System.out.println("\"" + inputText + "\"");

            Text text = new Text(inputText);

            System.out.println("\nУнікальні відсортовані слова:");
            Word[] uniqueWords = text.getUniqueSortedWords();
            for (Word w : uniqueWords) {
                System.out.print(w + " ");
            }
            System.out.println();

        } catch (NullPointerException npe) {
            System.err.println("Помилка: null у вхідних даних. " + npe.getMessage());
        } catch (IndexOutOfBoundsException ioobe) {
            System.err.println("Помилка індексації під час обробки рядка. " + ioobe.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}