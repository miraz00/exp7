import java.util.*;

class thread1 extends Thread
{
	
	public void run()
	{
		System.out.println("Odd numbers b/w 1&100 are");
        for(int i=2;i<100;i++)
            if(i%2!=0)
                System.out.println(i);
	}
}

class thread2 extends Thread
{
    public void run()
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Even numbers b/w 1&100 are");
		for(int i=2;i<100;i++)
		    if(i%2==0)
			    System.out.println(i);
	}
}

class main
{
	public static void main(String args[])
	{
		thread1 t1=new thread1();
		thread2 t2=new thread2();
		t1.start();
		try
		{
			t1.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		t2.start();
	}
}
