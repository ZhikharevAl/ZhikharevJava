package org.example.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task3EvenNumberFilter {

  private static final int[] NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  public List<Integer> filterEvenNumbers() {
    List<Integer> evenNumbers = new ArrayList<>();
    for (int num : NUMBERS) {
      if (num % 2 == 0) {
        evenNumbers.add(num);
      }
    }
    return evenNumbers;
  }

  public void displayEvenNumbers() {
    System.out.println("\nЗадача 3: Чётные числа");
    System.out.println("Массив: " + java.util.Arrays.toString(NUMBERS));

    List<Integer> evenNumbers = filterEvenNumbers();

    System.out.print("Чётные числа: ");
    for (Integer num : evenNumbers) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
