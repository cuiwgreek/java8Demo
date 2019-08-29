//[Listing One]
//PingPong

class PingPong extends Thread {
	String word;//what word to print
	int delay;//how long to pause

	PingPong(String whatToSay, int delayTime) {
		word = whatToSay;
		delay = delayTime;
	}

	public void run() {
		try {
			for (; ; ) {
				System.out.print(word + "");
				sleep(delay);//wait until next time
			}
		} catch (InterruptedException e) {
			return;//end this thread
		}
	}

	public static void main(String[] args) {
		new PingPong("ping", 33).start();//1/30 second
		new PingPong("PONG", 100).start();//1/10 second
	}

}
//[Listing Two]
class Account {

	private double balance;

	public Account(double initialDeposit) {
		balance = initialDeposit;
	}

	public synchronized void deposit(double amount) {
		balance += amount;
	}

};
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

//[Listing Four]
class Queue {
	//The first and last elements in the queue
	Element head, tail;

	public synchronized void append(Element p) {
		if (tail == null)
			head = p;
		else
			tail.next = p;
		p.next = null;
		tail = p;
		notiyf();//Let waiters know something arrived

	}

	public synchronized Element get() {
		try {
			while (head == null)
				wait();//Wait for an element
			return null;
		}
		Element p = head;//Remember first element
		head = head.next;//Remember it from the queue
		tail = null;
		return p;
	}

}
	//[Listing Five]
	Thread spinner;//the thread doing the processing

	public void userHitCancel() {
		spinner.suspend();//whoa!
		if (askYesNo("Really Cancel?"))
			spinner.stop();//stop it
		else
			spinner.resume();//giddyap!
	}

//[Listing Six]
class CalcThread extends Thread {
	private double Result;
	Result = calculate();

	public double result() {
		return Result;
	}

	public double calculate() {
		//...
	}
}