package org.example.tasks;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task1NumberComparator {

  public String compare(int a, int b) {
    if (a > b) {
      return "a > b";
    } else if (a < b) {
      return "a < b";
    } else {
      return "a = b";
    }
  }

  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public double divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Деление на ноль невозможно");
    }
    return (double) a / b;
  }

  public void displayOperations(int a, int b) {
    System.out.println("Числа: a = " + a + ", b = " + b);
    System.out.println();

    System.out.println("Сравнение: " + compare(a, b));
    System.out.println();

    System.out.println("Операции:");
    System.out.println("a + b = " + add(a, b));
    System.out.println("a - b = " + subtract(a, b));
    System.out.println("a * b = " + multiply(a, b));

    try {
      System.out.println("a / b = " + divide(a, b));
    } catch (ArithmeticException e) {
      System.out.println("a / b = " + e.getMessage());
    }
  }

  public void runInteractive() {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    System.out.println("\n#### Задача 1: Операции с числами ");
    System.out.println("Программа принимает два целых числа, сравнивает их");
    System.out.println("и выполняет операции сложения, вычитания, умножения и деления.");
    System.out.println();

    try {
      System.out.print("Введите первое число (a): ");
      int a = scanner.nextInt();

      System.out.print("Введите второе число (b): ");
      int b = scanner.nextInt();
      scanner.nextLine();

      displayOperations(a, b);

    } catch (Exception e) {
      System.out.println("\nОшибка: Необходимо ввести целые числа!");
      scanner.nextLine();
    }
  }
}
