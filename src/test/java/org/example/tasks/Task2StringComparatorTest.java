package org.example.tasks;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Задача 2: Сравнение строк")
@Story("Сравнение двух строк на идентичность")
@DisplayName("Задача 2: Тесты сравнения строк")
class Task2StringComparatorTest {

  private Task2StringComparator task;

  @BeforeEach
  void setUp() {
    task = new Task2StringComparator();
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @Description("Должен определять идентичные строки")
  @DisplayName("Сравнение идентичных строк")
  void testIdenticalStrings() {
    String a = givenString("Hello");
    String b = givenString("Hello");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки идентичны");
  }

  @Test
  @Severity(SeverityLevel.BLOCKER)
  @Description("Должен определять неидентичные строки")
  @DisplayName("Сравнение неидентичных строк")
  void testDifferentStrings() {
    String a = givenString("Hello");
    String b = givenString("World");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки неидентичны");
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен различать строки с разным регистром")
  @DisplayName("Сравнение строк с разным регистром")
  void testCaseSensitiveComparison() {
    String a = givenString("Hello");
    String b = givenString("hello");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки неидентичны");
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен определять идентичность пустых строк")
  @DisplayName("Сравнение пустых строк")
  void testEmptyStrings() {
    String a = givenString("");
    String b = givenString("");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки идентичны");
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен определять неидентичность пустой и непустой строки")
  @DisplayName("Сравнение пустой и непустой строки")
  void testEmptyAndNonEmptyStrings() {
    String a = givenString("");
    String b = givenString("Hello");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки неидентичны");
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен корректно обрабатывать null значения")
  @DisplayName("Сравнение null строк")
  void testNullStrings() {
    String a = givenNullString();
    String b = givenNullString();
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки идентичны");
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен определять неидентичность null и обычной строки")
  @DisplayName("Сравнение null и обычной строки")
  void testNullAndNonNullStrings() {
    String a = givenNullString();
    String b = givenString("Hello");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки неидентичны");
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен игнорировать пробелы как различие")
  @DisplayName("Сравнение строк с пробелами")
  void testStringsWithSpaces() {
    String a = givenString("Hello World");
    String b = givenString("Hello World");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки идентичны");
  }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @Description("Должен различать строки с разным количеством пробелов")
  @DisplayName("Сравнение строк с разными пробелами")
  void testStringsWithDifferentSpaces() {
    String a = givenString("Hello World");
    String b = givenString("Hello  World");
    String result = whenCompareStrings(a, b);
    thenResultShouldBe(result, "Строки неидентичны");
  }

  @Step("Дана строка: \"{string}\"")
  private String givenString(String string) {
    return string;
  }

  @Step("Дана null строка")
  private String givenNullString() {
    return null;
  }

  @Step("Когда сравниваем строки a=\"{a}\" и b=\"{b}\"")
  private String whenCompareStrings(String a, String b) {
    return task.compare(a, b);
  }

  @Step("Тогда результат должен быть: \"{expected}\"")
  private void thenResultShouldBe(String actual, String expected) {
    assertThat(actual).isEqualTo(expected);
  }
}
