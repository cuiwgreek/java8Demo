class Join {
	CalcThread calc = new CalcThread();
	calc.start();

	doSomethingElse();
 try

	{
		calc.join();
		System.out.println("result is" + calc.result());
		System.out.println("No answer: interrupted");
	}
}