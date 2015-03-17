import java.util.Vector;

//class to test the fastest way algorithm
public class test {


public static void main(String[] args) {
	final int number=6;	
	
	//a1,a2 are the time of stations of the same line
	//t1,t2 are the times of switching stations to another line
	Vector <Integer>t1 = new Vector<Integer>(number);
	Vector <Integer>a1 = new Vector<Integer>(number);
	Vector <Integer>t2 = new Vector<Integer>(number);
	Vector <Integer>a2 = new Vector<Integer>(number);
	//e1 and e2 are time to enter assembly lines. x1 and x2 are times to exit
	int e1=2;int e2=4;int x1=3;int x2=3;  
	
	//adding the time it takes for stations on assembly line 1
	a1.add(7);
	a1.add(9);
	a1.add(3);
	a1.add(4);
	a1.add(8);
	a1.add(4);
	
	//adding the time it takes for stations on assembly line 2
	a2.add(8);
	a2.add(5);
	a2.add(6);
	a2.add(4);
	a2.add(5);
	a2.add(7);
	
	//adding the time it takes for switching stations on assembly line 1
	t1.add(2);
	t1.add(3);
	t1.add(1);
	t1.add(3);
	t1.add(4);
	
	//adding the time it takes for switching stations on assembly line 2
	
	t2.add(2);
	t2.add(1);
	t2.add(2);
	t2.add(2);
	t2.add(1);
	
	
	AL ob1 = new AL(number);
	//calling the fastest way algorithm
	ob1.fastestway(a1,a2,t1,t2,e1,e2,x1,x2);
	//printing result.
	ob1.printpath();
	
	}
}
