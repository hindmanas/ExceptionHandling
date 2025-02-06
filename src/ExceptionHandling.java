// Manas Pandya c-07
//Que. A method named average () has one argument that is an array of strings .it converts these to double values and returns their average. The method generates a NullPointerException if an array element is null.
//Write a program that illustrates how to declare and use this method. Include a throws clause in the method declaration to indicate that these problems can occur.
import java.util.Scanner;

public class ExceptionHandling {


    public static double average(String[] arr) throws NullPointerException, NumberFormatException {
        if (arr == null) {
            throw new NullPointerException("Input array is null");
        }

        double sum = 0;
        int count = 0;

        for (String s : arr) {
            if (s == null) {
                throw new NullPointerException("Array contains a null element");
            }

            sum += Double.parseDouble(s); // Converts string to double
            count++;
        }

        if (count == 0) {
            throw new ArithmeticException("Cannot divide by zero, array is empty");
        }

        return sum / count; // Returns the average
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] numbers = new String[n];
        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLine();
        }

        try {
            double avg = average(numbers);
            System.out.println("The average is: " + avg);
        } catch (NullPointerException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: Invalid number format in array.");
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}