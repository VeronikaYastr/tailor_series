package test.com.bsu;

import main.java.com.bsu.TailorSeriesCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TailorSeriesCalculatorTest {

  @Test
  void testCalculateTailorSeries() {
    double x = 0;
    double eps = Math.pow(10, -10);
    double expected = TailorSeriesCalculator.calculateActualValue(x);
    double actual = TailorSeriesCalculator.calculateTailorSeries(eps, x);
    assertEquals(expected, actual);
  }
}