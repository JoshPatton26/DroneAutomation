package com.example.dronecs420;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Adapter extends Adaptee{
    
    Adaptee adp = new Adaptee();
    
    public Adapter() throws IOException {
		
	}

	public void launch() throws IOException, InterruptedException{
		
		// Get connection to the drone.
		adp.initialize();
		//Activate the Tello-SDK
		adp.activateSDK();
		// Get battery life before taking flight.
	    adp.getBattery();
	    
		try {
	    	adp.takeoff();
    	}catch (Exception e) {
	    	e.printStackTrace();
	    }
    }
	
	public void gotoXY(int x, int y, int speed) {
		try {
	    	adp.gotoXY(x, y, speed);
    	}catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

}
