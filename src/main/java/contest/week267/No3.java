package contest.week267;

public class No3 {
    public static String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = encodedText.charAt(i * cols + j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            int j = 0;
            while (i + j < cols && j < rows) {
                sb.append(matrix[j][i + j]);
                j++;
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(decodeCiphertext("ch   ie   pr", 3));
        System.out.println(decodeCiphertext("", 5));
    }
}
