package main.java.com.bsu;

import com.sun.media.sound.InvalidFormatException;

import java.util.Scanner;

public class TailorSeriesCalculator {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter k: ");
      int k = scanner.nextInt();
      // add K check
      System.out.println("Enter x (-1, 1): ");
      double x = scanner.nextDouble();
      if (x <= -1 || x >= 1) {
        throw new InvalidFormatException("X should be in (-1, 1)");
      }

      double eps = Math.pow(10, -k);
      double actualValue = calculateActualValue(x);
      double calculatedValue = calculateTailorSeries(eps, x);

      System.out.println("Actual value: " + formattedNumericValue(actualValue));
      System.out.println("Calculated value: " + formattedNumericValue(calculatedValue));
    } catch (Exception ex) {
      System.out.println("Error while reading value: " + ex);
    }
  }

  public static double calculateActualValue(double x) {
    return 1 / Math.pow(1 + x, 3);
  }

  public static double calculateTailorSeries(double eps, double x) {
    double elem = 100;
    double calculatedValue = 0;
    int n = 1;
    while (Math.abs(elem) >= Math.abs(eps)) {
      elem = Math.pow(-1, n - 1) * n * (n + 1) / 2.0 * Math.pow(x, n - 1);
      calculatedValue += elem;
      n++;
    }
    return calculatedValue;
  }

  private static String formattedNumericValue(double value) {
    return String.format("%.3f", value);
  }
}
