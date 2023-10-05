import java.util.Arrays;

public class Watch implements Runnable{
    public Watch() {
    }
	public void run() {
		System.out.println("Reader is alive and well");
		
		long time;
		int mac;
		while(true) {
			byte[] bytes = TimeServer.theRF.receive();
			
			String allBytes = toBytes(bytes);
			System.out.println("Recieved "+allBytes);
			
			//Convert mac to int
        	//mac = (int) (bytes[0] << 8) + (int) bytes[1] << 0;
			mac = 0;
	    	for(int i=0; i < 2; i++) {
	    		mac +=  ((int) (bytes[i] & 0xff) << ((1-i)*8));
	    	}
			
	    	time = 0;
			//Convert time to long
	    	for(int i=2; i < 10; i++) {
	    		time +=  ((long) (bytes[i] & 0xff) << ((9-i)*8));
	    	}
	    	
	    	System.out.println("Host "+mac+" says time is "+time);
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
