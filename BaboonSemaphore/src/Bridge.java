import java.util.concurrent.*;

public class Bridge {
	private final Semaphore sema; //calls Semaphore and limits one thread at a time
	
	public Bridge(){
		sema = new Semaphore(1); //construct semaphore
	}
	
	public void crossBridge(Baboon baboon){ try 
	{
		System.out.printf("%s is waiting to cross the bridge.\n",baboon.getName()); //takes next arg and print string
		sema.acquire(); //acquires permit and blocks until release
		System.out.printf("%s is crossing the bridge. \n",baboon.getName());//takes next arg and print string
		long duration = (long)(Math.random()*10);
		TimeUnit.SECONDS.sleep(duration);
	}
	catch(InterruptedException iex)
	{ 
		iex.printStackTrace();//print stack trace 
	}
	finally
	{
		System.out.printf("%s has finished crossing the bridge.\n",baboon.getName());//takes next arg and print string
		sema.release();//permit release
		}
	}
}
