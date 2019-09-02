//[Listing Six]
class CalcThread extends Thread {
	private double Result;
//	Result = calculate();

	public double result() {
		return Result;
	}

	public double calculate() {
		//...
		return 0f;
	}

	//[Listing Three]
//synchronized_abs /*make all elements in the array nonnegative*/

	public static void abs(int[]value){
		synchronized(value){
			for(int i=0;i<value.length;i++){
				if(value[i]<0)
					value[i]=-value[i];
			}
		}
	}
	//[Listing Five]
	Thread spinner;//the thread doing the processing

	public void userHitCancel() {
		spinner.suspend();//whoa!
//		if (askYesNo("Really Cancel?"))
//			spinner.stop();//stop it
//		else
//			spinner.resume();//giddyap!
	}
}