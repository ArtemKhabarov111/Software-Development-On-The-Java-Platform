public class Main {
    public static void main(String[] args) {
        try {
            int rows = 3;
            int cols = 3;
            int zalikova = 3422;

            float C5 = zalikova % 5;
            float C7 = zalikova % 7;
            float C11 = zalikova % 11;

            float[][] matrix_A = new float[rows][cols];
            float[][] matrix_B = new float[rows][cols];

            System.out.println("Номер залікової = " + zalikova);
            System.out.printf("C5 = %s, C7 = %s, C11 = %s%n%n", C5, C7, C11);
            System.out.println("Матриця A:");
            MatrixOperations.fillMatrixRandom(matrix_A);
            MatrixOperations.printMatrix(matrix_A);

            System.out.println("Матриця B:");
            MatrixOperations.fillMatrixRandom(matrix_B);
            MatrixOperations.printMatrix(matrix_B);

            System.out.println("Матриця C = A + B:");
            float[][] matrix_C = MatrixOperations.addMatrix(matrix_A, matrix_B);
            MatrixOperations.printMatrix(matrix_C);

            float sum = MatrixOperations.sumOfMinElements(matrix_C);
            System.out.printf("Сума найменших елементів кожного рядка матриці = %.2f%n", sum);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Помилка. Індекс елементу матриці виходить за межі масиву.");

        } catch (NullPointerException e) {
            System.err.println("Помилка. Спроба використати неініціалізовану матрицю.");

        } catch (ArithmeticException e) {
            System.err.println("Помилка арифметичної операції. " + e.getMessage());

        } catch (Exception e) {
            System.err.println("Невідома помилка. " + e.getMessage());
        }
    }
}
