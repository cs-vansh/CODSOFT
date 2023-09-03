import java.util.Scanner;

class Task2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.print("Enter the number of subjects:");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter the marks of Subject " + i + ":");
            int marks = sc.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                sc.close();
                return;
            }
            total += marks;
        }

        System.out.println("Your Total Marks are " + total + " out of " + (n * 100));

        float averagePercentage = ((float) total / (n * 100)) * 100;

        System.out.println("Average of Your Marks is " + averagePercentage + "%");

        String grade = calculateGrade(averagePercentage);
        System.out.println("Your Grade is " + grade);

        sc.close();
    }

    private static String calculateGrade(float averagePercentage) {
        if (averagePercentage >= 90.0) {
            return "O+";
        } else if (averagePercentage >= 80.0) {
            return "A+";
        } else if (averagePercentage >= 70.0) {
            return "A";
        } else if (averagePercentage >= 60.0) {
            return "B";
        } else if (averagePercentage >= 50.0) {
            return "C";
        } else if (averagePercentage >= 40.0) {
            return "D";
        } else {
            return "F";
        }
    }
}
