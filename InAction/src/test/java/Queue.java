////[Listing Four]
//class Queue {
//	//The first and last elements in the queue
//	Element head, tail;
//
//	public synchronized void append(Element p) {
//		if (tail == null)
//			head = p;
//		else
//			tail.next = p;
//		p.next = null;
//		tail = p;
//		notiyf();//Let waiters know something arrived
//
//	}
//
//	public synchronized Element get() {
//		try {
//			while (head == null)
//				wait();//Wait for an element
//			return null;
//		}
//		Element p = head;//Remember first element
//		head = head.next;//Remember it from the queue
//		tail = null;
//		return p;
//	}
//
//}