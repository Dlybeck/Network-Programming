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
    	
    	//Convert time to byte array
    	for(int i=2; i < 10; i++){
    		bytes[i] = (byte) (time >> ((9-i)*8));
    	}
    	
    	//Convert byte array back to time
    	long newTime = 0;
    	for(int i=2; i < 10; i++) {
    		newTime +=  ((long) (bytes[i] & 0xff) << ((9-i)*8));
    	}
    	System.out.println("Newtime is: " + newTime);
    	
    	System.exit(0);
	}
}
