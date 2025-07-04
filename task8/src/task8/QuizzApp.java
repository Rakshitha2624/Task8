package task8;

import java.util.*;

class Question {
    String questionText;
    String[] options;
    char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void display() {
        System.out.println("\n----------------------------------------");
        System.out.println("Q: " + questionText);
        char opt = 'A';
        for (String option : options) {
            System.out.println("  " + opt + ") " + option);
            opt++;
        }
    }

    public boolean checkAnswer(char answer) {
        return Character.toUpperCase(answer) == Character.toUpperCase(correctAnswer);
    }
}

public class QuizzApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which method is the entry point in a Java application?",
                new String[]{"start()", "main()", "init()", "run()"}, 'B'));

        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"inherits", "implement", "extends", "super"}, 'C'));

        questions.add(new Question("Which package contains the Scanner class?",
                new String[]{"java.io", "java.util", "java.lang", "java.net"}, 'B'));

        questions.add(new Question("Which of these is not a primitive data type?",
                new String[]{"float", "boolean", "String", "char"}, 'C'));

        questions.add(new Question("What is the size of an int variable in Java?",
                new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on system"}, 'B'));

        questions.add(new Question("Which collection allows unique elements only?",
                new String[]{"List", "ArrayList", "HashSet", "Vector"}, 'C'));

        int score = 0;
        System.out.println("========================================");
        System.out.println("         Java Console Quiz App          ");
        System.out.println("========================================");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + "/" + questions.size());
            questions.get(i).display();
            System.out.print("Enter your answer (A/B/C/D): ");
            char ans = sc.next().charAt(0);
            if (questions.get(i).checkAnswer(ans)) {
                System.out.println("Correct Answer!");
                score++;
            } else {
                System.out.println("Incorrect. Correct: " + questions.get(i).correctAnswer);
            }
        }

        System.out.println("\n========================================");
        System.out.println("              Quiz Summary              ");
        System.out.println("========================================");
        System.out.println("Total Questions : " + questions.size());
        System.out.println("Correct Answers : " + score);
        System.out.println("Final Score     : " + score + " / " + questions.size());

        if (score == 6)
            System.out.println("Excellent! Perfect Score.");
        else if (score >= 4)
            System.out.println("Good job! Keep it up.");
        else
            System.out.println("Needs Improvement. Review Java basics.");

        System.out.println("========================================");
        sc.close();
    }
}
