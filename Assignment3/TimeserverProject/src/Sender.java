import java.util.Random;
import java.util.Arrays;
public class Sender implements Runnable{
	
	private int mac;
    public Sender(int mac) {
    	this.mac = mac;
    }
    
	public void run() {		
		System.out.println("Writer is alive and well");
		
		byte[] bytes = new byte[10];
		
    	while(true) {
    		long time = TimeServer.theRF.clock();
        	//convert mac to bytes
        	bytes[0] = (byte) (mac >> 8);
        	bytes[1] = (byte) (mac >> 0);
        	
        	//Convert time to byte array
        	for(int i=2; i < 10; i++){
        		bytes[i] = (byte) (time >> ((9-i)*8));
        	}
    		
    		
    		Random rand = new Random();
    		long sleep = rand.nextLong(7001);
    		
    		if(TimeServer.theRF.transmit(bytes) != 10) {
    			System.out.println("ERROR \n Sent incorrect number of bytes" );
    		};
    		
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
		  allBytes+=(bytes[i]&0xff)+" ";
		}
		allBytes += "]";
		return allBytes;
	}
	
}
