import java.util.Vector;


public class AL {
	
	Vector <Integer>f1 ;
	Vector <Integer>f2 ;
	Vector <Integer>l1 ;
	Vector <Integer>l2 ;
	int L,result,number;

AL(int no){
	
	//initializing other vectors accordingly
	number=no;
	f1 = new Vector<Integer>(number);
	f2 = new Vector<Integer>(number);
	l1 = new Vector<Integer>(number);
	l2 = new Vector<Integer>(number);
	result=0;
	L=0;
}

void fastestway(Vector <Integer> a1, Vector <Integer> a2, Vector <Integer> t1, Vector <Integer> t2, int e1,int e2,int x1,int x2){
		
//sol is the cost for assembly line 1, by adding entry cost and processing time at station 1
	    int sol=e1+a1.get(0);
		f1.add(0,sol);
		
//sol2 is the cost for assembly line 2, by adding entry cost and processing time at station 1
		int sol2=e2+a2.get(0);
		f2.add(0,sol2);
		
	//for loops run for all station times	
		for(int i=1;i<number;i++){
			
			//storing the time it takes to stay on line 1
			sol=f1.get(i-1)+a1.get(i);
			//storing the time it takes to switch to line 2
			sol2=f2.get(i-1)+a1.get(i)+t2.get(i-1);
			
			//comparing the costs
			if(sol<=sol2){
				 
				f1.add(i,sol);
				//saving the line number where car was processed
				l1.add(1);
			}
			else
			{
				
				f1.add(i,sol2);
				//saving the line number where car was processed
				l1.add(2);
				
			}
			
			//storing the time it takes to stay on line 2
			sol=f2.get(i-1)+a2.get(i);
			//storing the time it takes to switch to line 1
			sol2=f1.get(i-1)+a2.get(i)+t1.get(i-1);
			
			if(sol<=sol2){
				
				f2.add(i,sol);
				//saving the line number where car was processed
				l2.add(2);
			}
			else
			{
				
				f2.add(i,sol2);
				//saving the line number where car was processed
				l2.add(1);
				
			}
			
		}

//calculating the cost of exiting from a assembly line		
sol=f1.get(number-1)+x1;
sol2=f2.get(number-1)+x2;

//Comparing and selecting the path of least cost
if(sol<=sol2){
	
    result=sol;
     L=1;  
 }  
 else  
 {  
	result=sol2;
     L=2;  
 }
	

}

void printpath()  
{   

	//printing the cost, exit station and the shortest path, beginning from the end.
	System.out.println("The optimal time is:" + result + " with exit station: " + L);
    for(int j=number-2;j>=0;j--)  
    {  
        if(L==1)  
        {  
        	 System.out.println("Station: "+ (j+1)+" path is " + l1.get(j));
        }  
        else if(L==2) 
        {  
        	 System.out.println("Station: "+ (j+1)+" path is " + l2.get(j));
        }  
        
       
        
    }  
}  
}
