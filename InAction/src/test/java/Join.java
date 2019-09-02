class Join {
	public static void main(String[] args) throws InterruptedException {
		CalcThread calc = new CalcThread();
		calc.start();

//		doSomethingElse();

		calc.join();
		System.out.println("result is" + calc.result());
		System.out.println("No answer: interrupted");
	}

}