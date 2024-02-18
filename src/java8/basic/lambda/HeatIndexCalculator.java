package java8.basic.lambda;

import java.util.function.BiFunction;

public class HeatIndexCalculator {
    public static void main(String[] args) {
        // Simulated sensor data
        double temperature = 30.0; // in Celsius
        double humidity = 0.60;    // relative humidity (60%)

        // Define a BiFunction to calculate the heat index based on temperature and humidity
        BiFunction<Double, Double, Double> calculateHeatIndex = (temp, hum) -> {
            // Calculate heat index using the formula (simplified version)
            double heatIndex = -8.78469475556
                    + 1.61139411 * temp
                    + 2.33854883889 * hum
                    - 0.14611605 * temp * hum
                    - 0.012308094 * temp * temp
                    - 0.0164248277778 * hum * hum
                    + 0.002211732 * temp * temp * hum
                    + 0.00072546 * temp * hum * hum
                    - 0.000003582 * temp * temp * hum * hum;

            return heatIndex;
        };

        // Calculate the heat index using the BiFunction
        double heatIndex = calculateHeatIndex.apply(temperature, humidity);

        // Print the calculated heat index
        System.out.println("Heat Index: " + heatIndex);
    }
}
