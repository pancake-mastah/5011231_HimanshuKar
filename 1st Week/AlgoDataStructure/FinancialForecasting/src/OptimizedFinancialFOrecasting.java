import java.util.HashMap;

public class OptimizedFinancialFOrecasting {

    private static HashMap<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }

        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }

        double futureValue = calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
        
        memo.put(periods, futureValue);

        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; 
        double growthRate = 0.05; 
        int periods = 10; 

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("The future value after " + periods + " periods is: " + futureValue);
    }
}
