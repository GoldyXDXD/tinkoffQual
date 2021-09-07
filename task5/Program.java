import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int degree = in.nextInt();
        double[] a = new double[degree + 1];
        double[] result = new double[degree];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextFloat();
        }
        switch (degree) {
            case 1:
                result = solveForFirstPower(a);
                break;
            case 3:
                result = solveForThirdPower(a);
                break;
            case 5:
                result = solveForFifthPower(a);
                break;
        }
        System.out.println(result);
    }
    public static double[] solveForFirstPower(double[] floats) {
        double[] result = new double[1];
        result[0] =  floats[0] / floats[1];
        return result;
    }
    public static double[] solveForThirdPower(double[] floats) { // Тригонометрическая формула Виета
        double[] result = new double[3];
        if (floats[3] != 1) {
            for(int i = 0; i < floats.length; i++) {
                floats[i] /= floats[3];
            }
        }
        double q = (floats[2] * floats[2] - 3 * floats[1]) / 9;
        double r = (2 * floats[2] * floats[2] * floats[2] - 9 * floats[1] * floats[2] + 27 * floats[0]) / 54;
        double fi = Math.acos(r / Math.sqrt(q * q * q));
        result[0] = -2 * Math.sqrt(q) * Math.cos(fi) - floats[2] / 3;
        result[1] = -2 * Math.sqrt(q) * Math.cos(fi + 2 * Math.PI / 3) - floats[2] / 3;
        result[1] = -2 * Math.sqrt(q) * Math.cos(fi - 2 * Math.PI / 3) - floats[2] / 3;
        return result;
    }
    public static double[] solveForFifthPower(double[] floats) { // неэффективное решение
        double[] result = new double[5];
        int counter = 0;
        for (double i = -10000; i <= 10000; i += 0.0001 ) {
            if ((floats[0] + floats[1] * i + floats[2] * i * i + floats[3] * i * i * i + floats[4] * i * i * i * i) == 0) {
                result[counter] = i;
                counter++;
            }
        }
        return result;
    }
}
