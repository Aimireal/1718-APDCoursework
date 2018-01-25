import java.util.concurrent.*;

public class BridgeTest
{
    public static void main(String[] args)
    {
        final Bridge bridge = new Bridge();  
        Thread West = new Thread(new Runnable()  //constructs West thread
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Baboon baboon = new Baboon(bridge);  //constructs new baboon
                    Thread a = new Thread(baboon);  //baboon object becomes thread object
                    baboon.setName("West Baboon: "+a.getId());  //sets baboon name to West Baboon and gets the thread ID
                    a.start();  
                    try  
                    {    
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));//performs a Thread sleep for a given time
                    }
                    catch(InterruptedException iex)
                    { 
                        iex.printStackTrace();//prints the stack trace
                    }
                }
            }
        });
        Thread East = new Thread(new Runnable()//constructs East thread
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Baboon baboon = new Baboon(bridge);  //constructs new baboon
                    Thread a = new Thread(baboon);  //baboon object becomes thread object
                    baboon.setName("East Baboon:  "+a.getId());  //sets baboon name to East Baboon and gets the thread ID
                    a.start(); 
                    try
                    {   
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));//performs a Thread sleep for a given time
                    }
                    catch(InterruptedException iex)
                    {  
                        iex.printStackTrace();//prints the stack trace      
                    }
                }
            }
        });
        West.start();  //starts west thread
        East.start();  //starts east thread
    }
}
