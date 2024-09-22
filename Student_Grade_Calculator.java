import java.util.Scanner;

public class GradeCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] subjectNames = new String[numSubjects];
        int[] marksObtained = new int[numSubjects];
        int totalMarks = 0;
        int highestMarks = Integer.MIN_VALUE;
        int lowestMarks = Integer.MAX_VALUE;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.nextLine();

            int marks;
            do {
                System.out.print("Enter marks obtained in " + subjectNames[i] + " (0-100): ");
                marks = scanner.nextInt();
            } while (marks < 0 || marks > 100); // Input validation
            marksObtained[i] = marks;

            totalMarks += marks;

            // Update highest and lowest marks
            if (marks > highestMarks) {
                highestMarks = marks;
            }
            if (marks < lowestMarks) {
                lowestMarks = marks;
            }
        }

        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("----------------------------");
        System.out.println("Subject-wise Marks:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjectNames[i] + ": " + marksObtained[i]);
        }
        System.out.println("----------------------------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Highest Marks: " + highestMarks);
        System.out.println("Lowest Marks: " + lowestMarks);

        scanner.close();
    }
}
