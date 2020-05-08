import java.util.Scanner;

class TimerThread extends Thread {
	public void run() {
		try {
			Thread.sleep(10000);
			QuizRunner.timedOut = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class QuestionThread extends Thread {

	private Question question;

	QuestionThread(Question question) {
		this.question = question;
	}

	public void run() {
		question.print();
		Scanner s = new Scanner(System.in);

		String userOpt = s.next();

		if (userOpt.toUpperCase().contentEquals(question.getCorrectOpt())) {
			System.out.println("Correct Answer");
		} else {
			System.out.println("Sorry, wrong answer");
		}

		System.out.println();
	}
}

public class QuizRunner {

	public static boolean timedOut = false;
	
	private static void questionsFiller(Question[] questions) {
		questions[0] = new Question("Question 1 : The world's largest desert is ?", "A. Thar", "B. Kalahari", "C. Sahara", "D. Sonoran", "C");
		questions[1] = new Question("Question 2 : Country that has the highest in Barley Production ?", "A. China", "B. India", "C. Russia", "D. France", "C");
		questions[2] = new Question("Question 3 : Which is considered as the biggest port of India ?", "A. Kolkata", "B. Cochin", "C. Chennai", "D. Mumbai", "D");
		questions[3] = new Question("Question 4 : The gas used for making vegetables is ?", "A. Oxygen", "B. Carbon Dioxide", "C. Hydrogen", "D. Nitrogen", "C");
		questions[4] = new Question("Question 5 : The chief ore of Aluminium is ?", "A. Iron", "B. Cryolite", "C. Bauxite", "D. Haematite", "C");
		questions[5] = new Question("Question 6 : The state which has desert in India is ?", "A. Rajasthan", "B. Punjab", "C. Uttar Pradesh", "D. Madhya Pradesh", "A");
		questions[6] = new Question("Question 7 : The largest fresh water lake in India is ?", "A. Pulicat Lake", "B. Veeranam Lake", "C. Chilka Lake", "D. Kolleru Lake", "D");
		questions[7] = new Question("Question 8 : The largest river in India is ?", "A. Yamuna", "B. Kaveri", "C. Ganga", "D. Bramaputra", "C");
		questions[8] = new Question("Question 9 : Punjab is famous for ?", "A. Nylon textile", "B. Silk textile", "C. Woolen textile", "D. Cotton textile", "C");
		questions[9] = new Question("Question 10 : The hottest planet in the solar system is ?", "A. Earth", "B. Venus", "C. Mars", "D. Jupiter", "B");

	}

	public static void main(String[] args) {

		Question[] questions = new Question[10];

		questionsFiller(questions) ;

		for (int i = 0; i < 10; i++) {
			Thread questionThread = new QuestionThread(questions[i]);
			Thread timerThread = new TimerThread();

			timerThread.setDaemon(true);
			questionThread.setDaemon(true);

			questionThread.start();
			timerThread.start();

			while (true) {
				if ((!questionThread.isAlive()) || (!timerThread.isAlive())) {
					break;
				}
			}

			if (timerThread.isAlive() == false) {
				System.out.println();
				System.out.println("TIMEOUT !!!");
				break;
			}
		}

	}

}
