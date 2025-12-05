package org.example.tasks;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task2StringComparator {

  public String compare(String a, String b) {
    if (a == null || b == null) {
      if (a == null && b == null) {
        return "Строки идентичны";
      }
      return "Строки неидентичны";
    }

    if (a.equals(b)) {
      return "Строки идентичны";
    } else {
      return "Строки неидентичны";
    }
  }

  public void displayComparison(String a, String b) {
    System.out.println("Строка a: \"" + a + "\"");
    System.out.println("Строка b: \"" + b + "\"");
    System.out.println("Результат: " + compare(a, b));
  }

  public void runInteractive() {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    System.out.println("\n### Задача 2: Сравнение строк ");
    System.out.println("Программа принимает две строки и сравнивает их на идентичность.");
    System.out.println();

    System.out.print("Введите первую строку (a): ");
    String a = scanner.nextLine();

    System.out.print("Введите вторую строку (b): ");
    String b = scanner.nextLine();

    displayComparison(a, b);
  }
}
