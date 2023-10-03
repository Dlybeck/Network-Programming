import rf.RF;

/**
 * A simple test class showing the creation of an RF instance and
 * the sending of three bytes of data.
 * 
 * @author Brad Richards
 */
public class TimeServer 
{
    public static void main(String[] args)
    {
    	// Create an instance of the RF layer. See documentation for
    	// info on parameters, but they're null here since we don't need
    	// to override any of its default settings.
        RF theRF = new RF(null, null);  
        
        // Put together an array of bytes to do a test send
        byte[] buf = new byte[3];
        buf[0] = 10;
        buf[1] = 20;
        buf[2] = 5;
        
        // Try to send it and see if it went out.
        int bytesSent = theRF.transmit(buf);
        if (bytesSent != buf.length) {
            System.err.println("Only sent "+bytesSent+" bytes of data!");
        } 
        else {
            System.out.println("Yay!  We sent the entire packet!");
        }
            
        System.exit(0);  // Make sure all threads die
    }
}
