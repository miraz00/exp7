import java.util.*;

class bank 

{

	int bal=10000;

    public synchronized void withdraw(int amt)

	{

		

		

		if(bal<amt)

		{

			System.out.println("Insufficient balance,waiting for deposit");

			

			try

			{

		        wait();

			} 

			catch(InterruptedException e){}

			

		    bal-=amt;

		    System.out.println("Withdraw completed");

			System.out.println("Balance:"+bal);

        }

	}

	public synchronized void deposit(int amt)

	{

		bal+=amt;

		System.out.println("Deposit completed");	

		notify();

    }

}

class thread1 extends Thread

{

	bank obj;

	

	thread1(bank obj)

	{

		this.obj=obj;

	}

	

	public void run()

	{

		obj.withdraw(15000);

	}

}

 

class thread2 extends Thread

{

	bank obj;

	

	

	thread2(bank obj)

	{

		this.obj=obj;

	}

	public void run()

	{

		obj.deposit(5000);

	}

}

class main

{

	public static void main(String args[])

	{

		bank obj=new bank();

		

		thread1 t1=new thread1(obj);

		thread2 t2=new thread2(obj);

		

		

		t1.start();

		t2.start();

	}

}
