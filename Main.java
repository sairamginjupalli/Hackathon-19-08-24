import java.util.*;

class Main {

    private static Map<String, String> stateCapitalMap = new LinkedHashMap<>();
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Add states and capitals
    public static void addStateCapital(String state, String capital) {
        stateCapitalMap.put(state, capital);
    }

    // Generate a random quiz question
    public static String getRandomQuestion() {
        List<String> states = new ArrayList<>(stateCapitalMap.keySet());
        Random random = new Random();
        return states.get(random.nextInt(states.size()));
    }

    // Conduct the quiz for a student
    public static void conductQuiz(Student student, int numQuestions) {
        int score = 0;
        List<QuestionResult> results = new ArrayList<>();

        System.out.println("\nStarting Quiz for " + student.getName() + " (Roll No: " + student.getRollNo() + ")...");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < numQuestions; i++) {
            String state = getRandomQuestion();
            String correctCapital = stateCapitalMap.get(state);

            System.out.println((i + 1) + ". What is the capital of " + state + "?");
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            boolean isCorrect = userAnswer.equalsIgnoreCase(correctCapital);
            if (isCorrect) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect! The correct answer is " + correctCapital);
            }

            results.add(new QuestionResult(state, correctCapital, userAnswer, isCorrect));
            System.out.println("------------------------------------------------------");
        }

        student.setScore(score);
        student.setQuestionResults(results);
        students.add(student);

        System.out.println("\nQuiz over! " + student.getName() + ", your final score is: " + score + " out of " + numQuestions);
        System.out.println("------------------------------------------------------");
    }

    // Display results table
    public static void displayResultsTable() {
        System.out.println("\nFinal Scores:");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s\n", "Roll No", "Name", "Score");
        System.out.println("------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-10s %-20s %-10d\n", student.getRollNo(), student.getName(), student.getScore());
        }
        System.out.println("------------------------------------------------------");
    }

    // Display detailed exam results for each student
    public static void displayExamDetails() {
        for (Student student : students) {
            System.out.println("\nDetails for " + student.getName() + " (Roll No: " + student.getRollNo() + "):");
            System.out.println("------------------------------------------------------");
            for (QuestionResult result : student.getQuestionResults()) {
                System.out.printf("Q: What is the capital of %s?\n", result.getState());
                System.out.printf("Your answer: %-15s | Correct answer: %-15s | %s\n", result.getUserAnswer(), result.getCorrectAnswer(), (result.isCorrect() ? "✅ Correct" : "❌ Incorrect"));
                System.out.println("------------------------------------------------------");
            }
        }
    }

    // Display main menu
    public static void displayMainMenu() {
        System.out.println("\n=========================================");
        System.out.println(" Welcome to the State-Capital Quiz System ");
        System.out.println("=========================================");
        System.out.println("1. Start a new quiz");
        System.out.println("2. View all results");
        System.out.println("3. View detailed exam results");
        System.out.println("4. Exit");
        System.out.println("=========================================");
        System.out.print("Please select an option: ");
    }

    // Main method
    public static void main(String[] args) {
        // Populate the state-capital map (You can add more)
        // Populate the state-capital map (all Indian states and capitals)
        addStateCapital("Andhra Pradesh", "Amaravati");
        addStateCapital("Arunachal Pradesh", "Itanagar");
        addStateCapital("Assam", "Dispur");
        addStateCapital("Bihar", "Patna");
        addStateCapital("Chhattisgarh", "Raipur");
        addStateCapital("Goa", "Panaji");
        addStateCapital("Gujarat", "Gandhinagar");
        addStateCapital("Haryana", "Chandigarh");
        addStateCapital("Himachal Pradesh", "Shimla");
        addStateCapital("Jharkhand", "Ranchi");
        addStateCapital("Karnataka", "Bengaluru");
        addStateCapital("Kerala", "Thiruvananthapuram");
        addStateCapital("Madhya Pradesh", "Bhopal");
        addStateCapital("Maharashtra", "Mumbai");
        addStateCapital("Manipur", "Imphal");
        addStateCapital("Meghalaya", "Shillong");
        addStateCapital("Mizoram", "Aizawl");
        addStateCapital("Nagaland", "Kohima");
        addStateCapital("Odisha", "Bhubaneswar");
        addStateCapital("Punjab", "Chandigarh");
        addStateCapital("Rajasthan", "Jaipur");
        addStateCapital("Sikkim", "Gangtok");
        addStateCapital("Tamil Nadu", "Chennai");
        addStateCapital("Telangana", "Hyderabad");
        addStateCapital("Tripura", "Agartala");
        addStateCapital("Uttar Pradesh", "Lucknow");
        addStateCapital("Uttarakhand", "Dehradun");
        addStateCapital("West Bengal", "Kolkata");
        addStateCapital("Andaman and Nicobar Islands", "Port Blair");
        addStateCapital("Chandigarh", "Chandigarh");
        addStateCapital("Dadra and Nagar Haveli and Daman and Diu", "Daman");
        addStateCapital("Lakshadweep", "Kavaratti");
        addStateCapital("Delhi", "New Delhi");
        addStateCapital("Puducherry", "Puducherry");
        addStateCapital("Ladakh", "Leh");
        addStateCapital("Jammu and Kashmir", "Srinagar (summer), Jammu (winter)");


        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    System.out.print("\nEnter your Roll No: ");
                    String rollNo = scanner.nextLine().trim();

                    System.out.print("Enter your Name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter the number of questions you want to answer: ");
                    int numQuestions = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline

                    Student student = new Student(rollNo, name);
                    conductQuiz(student, numQuestions);
                    break;

                case "2":
                    displayResultsTable();
                    break;

                case "3":
                    displayExamDetails();
                    break;

                case "4":
                    exit = true;
                    System.out.println("Exiting the quiz system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        }
    }
}

// Class to hold student details
class Student {
    private String rollNo;
    private String name;
    private int score;
    private List<QuestionResult> questionResults;

    public Student(String rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.questionResults = new ArrayList<>();
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }
}

// Class to hold details of each question's result
class QuestionResult {
    private String state;
    private String correctAnswer;
    private String userAnswer;
    private boolean isCorrect;

    public QuestionResult(String state, String correctAnswer, String userAnswer, boolean isCorrect) {
        this.state = state;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
        this.isCorrect = isCorrect;
    }

    public String getState() {
        return state;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
