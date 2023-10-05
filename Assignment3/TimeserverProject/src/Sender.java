import java.util.Arrays;

public class Sender implements Runnable{
	
	private long time;
	private int mac;
    public Sender(int mac, long time) {
         this.time = time;
         this.mac = mac;
    }
    
	public void run() {
		System.out.println("This is the mac address: " + mac);
		System.out.println("The time is: " + time);
		
		byte[] bytes = new byte[10];
    	
    	//convert mac to bytes
    	bytes[0] = (byte) (mac >> 8);
    	bytes[1] = (byte) (mac >> 0);
    	//System.out.println((bytes[0] & 0xff) + " and " + (bytes[1] & 0xff));
    	
    	//Convert time to byte array
    	for(int i=2; i < 10; i++){
    		bytes[i] = (byte) (time >> ((9-i)*8));
    		//System.out.println("bytes[" + i + "] is: " + (bytes[i] & 0xff));
    	}
    	
    	System.out.println("\n");
    	
    	//Convert byte array back to time
    	long newTime = 0;
    	long newTime2 = 0;
    	for(int i=2; i < 10; i++) {
    		newTime |=  ((long) bytes[i] << ((9-i)*8));
    		//System.out.println("Adding " + (bytes[i] & 0xff) + " to Btime");
    		//System.out.println((9-i)*8);
    	}
    	
    	newTime2 =(((long)bytes[2] << 56) + ((long)bytes[3] << 48) + ((long)bytes[4] << 40) + ((long)bytes[5] << 32) + ((long)bytes[6] << 24) + ((long)bytes[7] << 16) + ((long)bytes[8] << 8) + ((long)bytes[9]));
    	
    	System.out.println("Newtime is: " + newTime);
    	System.out.println("New2time2 is: " + newTime2);
    	
    	System.exit(0);
	}
}
