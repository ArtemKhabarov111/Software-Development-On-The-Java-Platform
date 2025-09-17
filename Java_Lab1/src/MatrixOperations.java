public class MatrixOperations {
    // Заповнити матрицю випадковими значеннями від 0 до 20
    public static void fillMatrixRandom(float[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матриця порожня або не ініціалізована.");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length == 0) {
                throw new IllegalArgumentException("Рядок матриці порожній.");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (float) Math.random() * 20;
            }
        }
    }


    // Вивести матрицю в консоль
    public static void printMatrix(float[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Матриця порожня.");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length == 0) continue;
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4.2f\t", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    // Додавання двох матриць
    public static float[][] addMatrix(float[][] matrix_A, float[][] matrix_B) {
        if (matrix_A == null || matrix_B == null)
            throw new IllegalArgumentException("Одна з матриць неініціалізована.");

        if (matrix_A.length != matrix_B.length || matrix_A[0].length != matrix_B[0].length)
            throw new IllegalArgumentException("Розміри матриць не співпадають.");

        float[][] result = new float[matrix_A.length][matrix_A[0].length];
        for (int i = 0; i < matrix_A.length; i++) {
            for (int j = 0; j < matrix_A[i].length; j++) {
                result[i][j] = matrix_A[i][j] + matrix_B[i][j];
            }
        }
        return result;
    }


    // Сума найменших елементів кожного рядка матриці
    public static float sumOfMinElements(float[][] matrix) {
        if (matrix == null || matrix.length == 0)
            throw new IllegalArgumentException("Матриця порожня.");

        float sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length == 0)
                throw new IllegalArgumentException("Рядок " + (i + 1) + " порожній.");
            float min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) min = matrix[i][j];
            }
            System.out.printf("Мінімальний елемент у рядку %d = %.2f%n", i + 1, min);
            sum += min;
        }
        return sum;
    }
}
