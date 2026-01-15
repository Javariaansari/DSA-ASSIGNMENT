public class Matrix {
        public static void main(String[] args) {

            int[][] mat = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            // 1️⃣ Print Matrix
            System.out.println("Matrix:");
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++)
                    System.out.print(mat[i][j] + " ");
                System.out.println();
            }

            // 2️⃣ Transpose
            System.out.println("\nTranspose:");
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++)
                    System.out.print(mat[j][i] + " ");
                System.out.println();
            }

            // 3️⃣ Sum
            int sum = 0;
            for (int i = 0; i < mat.length; i++)
                for (int j = 0; j < mat[i].length; j++)
                    sum += mat[i][j];

            System.out.println("\nSum = " + sum);

            // 4️⃣ Average
            int totalElements = mat.length * mat[0].length;
            double average = (double) sum / totalElements;
            System.out.println("Average = " + average);

            // 5️⃣ Main Diagonal
            System.out.print("Main Diagonal: ");
            for (int i = 0; i < mat.length; i++)
                System.out.print(mat[i][i] + " ");
        }
    }


