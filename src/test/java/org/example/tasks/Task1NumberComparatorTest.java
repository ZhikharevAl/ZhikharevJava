package org.example.tasks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Задача 1: Операции с числами")
@Story("Сравнение и арифметические операции с двумя целыми числами")
@DisplayName("Задача 1: Тесты операций с числами")
class Task1NumberComparatorTest {

  private Task1NumberComparator task;

  @BeforeEach
  void setUp() {
    task = new Task1NumberComparator();
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @Description("Должен корректно сравнивать два числа, когда a > b")
  @DisplayName("Сравнение: a больше b")
  void testCompareWhenAGreaterThanB() {
    int a = givenNumber(10);
    int b = givenNumber(5);
    String result = whenCompare(a, b);
    thenResultShouldBe(result, "a > b");
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @Description("Должен корректно сравнивать два числа, когда a < b")
  @DisplayName("Сравнение: a меньше b")
  void testCompareWhenALessThanB() {
    int a = givenNumber(3);
    int b = givenNumber(7);
    String result = whenCompare(a, b);
    thenResultShouldBe(result, "a < b");
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @Description("Должен корректно сравнивать два числа, когда a = b")
  @DisplayName("Сравнение: a равно b")
  void testCompareWhenAEqualsB() {
    int a = givenNumber(5);
    int b = givenNumber(5);
    String result = whenCompare(a, b);
    thenResultShouldBe(result, "a = b");
  }

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @Description("Должен правильно складывать два числа")
  @DisplayName("Сложение чисел")
  void testAdd() {
    int a = givenNumber(10);
    int b = givenNumber(5);
    int result = whenAdd(a, b);
    thenResultShouldBe(result, 15);
  }

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @Description("Должен правильно вычитать два числа")
  @DisplayName("Вычитание чисел")
  void testSubtract() {
    int a = givenNumber(10);
    int b = givenNumber(5);
    int result = whenSubtract(a, b);
    thenResultShouldBe(result, 5);
  }

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @Description("Должен правильно умножать два числа")
  @DisplayName("Умножение чисел")
  void testMultiply() {
    int a = givenNumber(10);
    int b = givenNumber(5);
    int result = whenMultiply(a, b);
    thenResultShouldBe(result, 50);
  }

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @Description("Должен правильно делить два числа")
  @DisplayName("Деление чисел")
  void testDivide() {
    int a = givenNumber(10);
    int b = givenNumber(5);
    double result = whenDivide(a, b);
    thenResultShouldBe(result);
  }

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @Description("Должен правильно делить с остатком")
  @DisplayName("Деление с дробным результатом")
  void testDivideWithRemainder() {
    int a = givenNumber(10);
    int b = givenNumber(3);
    double result = whenDivide(a, b);
    thenResultShouldBeCloseTo(result);
  }

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @Description("Должен выбросить исключение при делении на ноль")
  @DisplayName("Деление на ноль")
  void testDivideByZero() {
    int a = givenNumber(10);
    int b = givenNumber(0);
    thenDivisionShouldThrowException(a, b);
  }

  @Step("Дано число: {number}")
  private int givenNumber(int number) {
    return number;
  }

  @Step("Когда сравниваем a={a} и b={b}")
  private String whenCompare(int a, int b) {
    return task.compare(a, b);
  }

  @Step("Когда складываем a={a} и b={b}")
  private int whenAdd(int a, int b) {
    return task.add(a, b);
  }

  @Step("Когда вычитаем b={b} из a={a}")
  private int whenSubtract(int a, int b) {
    return task.subtract(a, b);
  }

  @Step("Когда умножаем a={a} на b={b}")
  private int whenMultiply(int a, int b) {
    return task.multiply(a, b);
  }

  @Step("Когда делим a={a} на b={b}")
  private double whenDivide(int a, int b) {
    return task.divide(a, b);
  }

  @Step("Тогда результат должен быть: {expected}")
  private void thenResultShouldBe(String actual, String expected) {
    assertThat(actual).isEqualTo(expected);
  }

  @Step("Тогда результат должен быть: {expected}")
  private void thenResultShouldBe(int actual, int expected) {
    assertThat(actual).isEqualTo(expected);
  }

  @Step("Тогда результат должен быть: {expected}")
  private void thenResultShouldBe(double actual) {
    assertThat(actual).isEqualTo(2.0);
  }

  @Step("Тогда результат должен быть близок к {expected} с точностью {offset}")
  private void thenResultShouldBeCloseTo(double actual) {
    assertThat(actual).isCloseTo(3.333, org.assertj.core.data.Offset.offset(0.001));
  }

  @Step("Тогда деление a={a} на b={b} должно вызвать исключение")
  private void thenDivisionShouldThrowException(int a, int b) {
    assertThatThrownBy(() -> task.divide(a, b))
        .isInstanceOf(ArithmeticException.class)
        .hasMessage("Деление на ноль невозможно");
  }
}
