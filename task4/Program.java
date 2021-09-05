import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal[] balances = new BigDecimal[amount];
        for (int i = 0; i < amount; i++) {
            balances[i] = BigDecimal.valueOf(in.nextInt());
            sum = sum.add(balances[i]);
        }
        while (balances.length != 1) {
            balances = transaction(balances);
        }
        String result = new DecimalFormat("#0.00").format(sum.subtract(balances[0]));
        System.out.println(result);
    }
    public static BigDecimal[] transaction(BigDecimal[] balances) {
        Arrays.sort(balances);
        BigDecimal[] result = new BigDecimal[balances.length - 1];
        result[0] = (balances[1].add(balances[0])).multiply(BigDecimal.valueOf(0.95));
        for (int i = 1; i < result.length; i++) {
            result[i] = balances[i + 1];
        }
        return result;
    }
}
