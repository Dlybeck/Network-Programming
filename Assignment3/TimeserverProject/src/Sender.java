import java.util.Random;
import java.util.Arrays;
public class Sender implements Runnable{
	
	private int mac;
    public Sender(int mac) {
    	this.mac = mac;
    }
    
	public void run() {
		//System.out.println("This is the mac address: " + mac);
		//System.out.println("The time is: " + time);
		
		byte[] bytes = new byte[10];
    	
		System.out.println(mac);

    	
    	//Convert byte array back to time
    	//long newTime = 0;
    	//for(int i=2; i < 10; i++) {
    	//	newTime +=  ((long) (bytes[i] & 0xff) << ((9-i)*8));
    	//}
    	//System.out.println("Newtime is: " + newTime);
    	while(true) {
    		long time = TimeServer.theRF.clock();
        	//convert mac to bytes
        	bytes[0] = (byte) (mac >> 8);
        	bytes[1] = (byte) (mac >> 0);
        	
        	//Try to convert back
        	//int newMac = (int) (bytes[0] << 8) + bytes[1] << 0;
        	//System.out.println(newMac);*/
        	
        	//Convert time to byte array
        	for(int i=2; i < 10; i++){
        		bytes[i] = (byte) (time >> ((9-i)*8));
        	}
    		
    		
    		Random rand = new Random();
    		long sleep = rand.nextLong(7001);
    		
    		TimeServer.theRF.transmit(bytes);
    		
    		String allBytes = toBytes(bytes);
    		
    		System.out.println("Sent Packet: "+mac+" "+time+"  "+allBytes);
    		
    		try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
    	}
	}
	
	private String toBytes(byte[] bytes) {
		String allBytes = Arrays.toString(bytes);
		allBytes = "[ ";
		for (int i = 0; i < bytes.length; i++) {
		  allBytes+=bytes[i]+" ";
		}
		allBytes += "]";
		return allBytes;
	}
	
}
