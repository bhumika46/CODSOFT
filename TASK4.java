import java.util.*;

public class Quiz {

    private static final int QUIZ_TIMER = 90;
    private static final int QUESTION_COUNT = 8;

    private int score;
    private int questionIndex;
    private Timer timer;

    private static final Question[] questions = {
            new Question("What is the smallest unit of digital information?", "Bit"),
            new Question("What is the process of converting analog signals into digital data?", "Modulation"),
            new Question("What is the primary purpose of firewall in network security?", "Access Control"),
            new Question("What does HTML stand for?", "Hyper Text Markup Language"),
            new Question("What is the main component of a solar panel that converts sunlight into electricity", "Photocell"),
            new Question("Who is the Prime Minister of India?", "Narendra Modi"),
            new Question("Which is the Tallest building in the World?", "Burj Khalifa"),
            new Question("Which is Highest Economy in the world?", "Kuwait Dinar")
    };
           

    public Quiz() {
        this.score = 0;
        this.questionIndex = 0;
        this.timer = new Timer();

        startQuiz();
    }

    private void startQuiz() {
        System.out.println("Welcome to the Quiz! You have " + QUIZ_TIMER + " seconds to answer " +
                QUESTION_COUNT + " questions.\n");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                endQuiz();
            }
        }, QUIZ_TIMER * 1000);

        askNextQuestion();
    }

    private void askNextQuestion() {
        if (questionIndex < QUESTION_COUNT) {
            Question currentQuestion = questions[questionIndex];

            System.out.println(currentQuestion.getQuestion());
            try (Scanner sc = new Scanner(System.in)) {
                System.out.print("Your answer: ");
                String userAnswer = sc.nextLine();

                if (currentQuestion.isCorrect(userAnswer)) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect! The correct answer is: " + currentQuestion.getAnswer() + "\n");
                }
            }
            questionIndex++;
            askNextQuestion();
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        timer.cancel();

        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + "/" + QUESTION_COUNT);
        System.exit(0);
    }

    public static void main(String[] args) {
        new Quiz();
    }
}

class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }
}