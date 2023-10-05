import java.util.Random;
import rf.RF;

/**
 * A simple test class showing the creation of an RF instance and
 * the sending of three bytes of data.
 * 
 * @author Brad Richards
 */
public class TimeServer 
{   
	// Create RF layer
    public static RF theRF = new RF(null, null); 
    public static void main(String[] args)
    {

    	int mac;
    	Random rand = new Random();
    	
    	if (args.length > 0) {
    		String macString = args[0];
    		mac = Integer.parseInt(macString);
    		System.out.println("Using MAC address: "+mac);
    	} 
    	else {
    		mac = (int) rand.nextLong(65534);
    		System.out.println("Using random MAC address: "+mac);
    	}
    	
    	String hex = Integer.toHexString(mac);
    	System.out.println("(That's 0x"+hex+" in hex)");
    	
    	new Thread(new Sender(mac)).start(); 
    	new Thread(new Watch()).start();
    }
}





