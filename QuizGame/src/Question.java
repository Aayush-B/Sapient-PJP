public class Question extends Object {
	private String question;
	private String opt1, opt2, opt3, opt4;
	private String correctOpt;

	Question(String question, String opt1, String opt2, String opt3, String opt4, String correctOpt) {
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.correctOpt = correctOpt;
	}

	public void print() {
		System.out.println(question);
		System.out.println("A. " + opt1);
		System.out.println("B. " + opt2);
		System.out.println("C. " + opt3);
		System.out.println("D. " + opt4);
	}

	public String getCorrectOpt() {
		return correctOpt;
	}

}
