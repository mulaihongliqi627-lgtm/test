package demo;

import java.util.Scanner;

public class testDemo {
    private static String convert(int n, int base) {
        if (n == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (n > 0) {
            int r = n % base;
            res.append(digits.charAt(r));
            n /= base;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int P = scanner.nextInt();
        scanner.close();

        for (int i = 1; i < P; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                int product = i * j;
                String s_i = convert(i, P);
                String s_j = convert(j, P);
                String s_product = convert(product, P);

                if (j > 1) {
                    line.append(" ");
                }
                line.append(s_i).append("*").append(s_j).append("=").append(s_product);
            }
            System.out.println(line.toString());
        }
    }

}
