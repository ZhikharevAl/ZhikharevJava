package org.example.tasks;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Задача 3: Фильтр чётных чисел")
@Story("Фильтрация чётных чисел из массива [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]")
@DisplayName("Задача 3: Тесты фильтра чётных чисел")
class Task3EvenNumberFilterTest {

  private Task3EvenNumberFilter task;

  @BeforeEach
  void setUp() {
    task = new Task3EvenNumberFilter();
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @Description("Должен фильтровать чётные числа из массива [1,2,3,4,5,6,7,8,9,10]")
  @DisplayName("Фильтрация чётных чисел из заданного массива")
  void testFilterEvenNumbers() {
    List<Integer> result = filterEvenNumbersStep();
    verifyResultNotEmptyStep(result);
    verifyResultSizeStep(result);
    verifyExactContentStep(result, 2, 4, 6, 8, 10);
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен возвращать только чётные числа")
  @DisplayName("Все возвращённые числа чётные")
  void testAllNumbersAreEven() {
    List<Integer> result = filterEvenNumbersStep();
    verifyAllNumbersAreEvenStep(result);
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен возвращать правильное количество чётных чисел")
  @DisplayName("Правильное количество чётных чисел")
  void testEvenNumbersCount() {
    List<Integer> result = filterEvenNumbersStep();
    verifyResultSizeStep(result);
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен сохранять порядок чётных чисел")
  @DisplayName("Сохранение порядка")
  void testMaintainOrder() {
    List<Integer> result = filterEvenNumbersStep();
    verifyExactContentStep(result, 2, 4, 6, 8, 10);
  }

  @Step("Фильтрация чётных чисел из массива")
  private List<Integer> filterEvenNumbersStep() {
    return task.filterEvenNumbers();
  }

  @Step("Проверка, что результат не пустой")
  private void verifyResultNotEmptyStep(List<Integer> result) {
    assertThat(result).isNotEmpty();
  }

  @Step("Проверка размера результата: ожидается {expectedSize}")
  private void verifyResultSizeStep(List<Integer> result) {
    assertThat(result).hasSize(5);
  }

  @Step("Проверка точного содержимого: {expected}")
  private void verifyExactContentStep(List<Integer> result, Integer... expected) {
    assertThat(result).containsExactly(expected);
  }

  @Step("Проверка, что все числа чётные")
  private void verifyAllNumbersAreEvenStep(List<Integer> result) {
    assertThat(result).allMatch(num -> num % 2 == 0, "все числа должны быть чётными");
  }
}
