import java.lang.Thread;

class thread1 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
            
			if(i%2==0)
		    {
				thread2 t2=new thread2();
				t2.square(i);
				t2.start();
			}
			else
			{
				thread3 t3=new thread3();
				t3.cube(i);
				t3.start();
			}
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		
	}
}

class thread2 extends Thread
{
	int n;
	void square(int n)
	{
		this.n=n;
	}
	
	public void run()
	{
		System.out.println(n*n);
		System.out.println();
		System.out.println();
	}
	
}
	
class thread3 extends Thread
{
	int n;
	void cube(int n)
	{
		this.n=n;
	}

	public void run()
	{
		System.out.println(n*n*n);
		System.out.println();
		System.out.println();
	}

}


 class main
 {
	 public static void main(String args[])
	 {
		 thread1 t1=new thread1();
		 t1.start();
	 }
 }
 
