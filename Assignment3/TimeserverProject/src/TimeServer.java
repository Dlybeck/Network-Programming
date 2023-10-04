import java.math.BigInteger;
import java.util.Arrays;

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
    	
    	String macString = args[0];
    	short mac = Short.parseShort(macString);
    	System.out.println(mac);
    	macString = Integer.toBinaryString(mac);
    	System.out.println(macString);
    	
    	byte[] bval = new BigInteger(macString, 2).toByteArray();
    	System.out.println(Arrays.toString(bval));
    	
    	//System.out.println(10001100 & 0xFF);
    	
    	
    	
    	//SHOULD I BE USING SHIFTING AND MASKING TO MAKE BYTE ARRAY?
    	
    	
    	// Create an instance of the RF layer. See documentation for
    	// info on parameters, but they're null here since we don't need
    	// to override any of its default settings.
        //RF theRF = new RF(null, null);  
        
        // Put together an array of bytes to do a test send
        //byte[] buf = new byte[3];
        //buf[0] = 10;
        //buf[1] = 20;
        //buf[2] = 5;
        
        // Try to send it and see if it went out.
        //int bytesSent = theRF.transmit(buf);
        //if (bytesSent != buf.length) {
          //  System.err.println("Only sent "+bytesSent+" bytes of data!");
        //} 
        //else {
          //  System.out.println("Yay!  We sent the entire packet!");
        //}
            
        //System.exit(0);  // Make sure all threads die
    }
}





