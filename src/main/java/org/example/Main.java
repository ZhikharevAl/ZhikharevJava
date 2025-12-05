package org.example;

import org.example.tasks.Task1NumberComparator;
import org.example.tasks.Task2StringComparator;
import org.example.tasks.Task3EvenNumberFilter;

public class Main {

  public static void main(String[] args) {

    // Задача 1: Операции с числами
    Task1NumberComparator task1 = new Task1NumberComparator();
    task1.runInteractive();

    // Задача 2: Сравнение строк
    Task2StringComparator task2 = new Task2StringComparator();
    task2.runInteractive();

    // Задача 3: Фильтр чётных чисел
    Task3EvenNumberFilter task3 = new Task3EvenNumberFilter();
    task3.displayEvenNumbers();

    System.out.println("\n=================================");
    System.out.println("  Все задачи выполнены!");
    System.out.println("=================================");
  }
}
