package com.example.chuodekuai;

import android.os.Message;

public class Timer extends Thread {
	
	int num=(int)(Math.random()*4000)+2000;

	public void run(){
		try {
			sleep(num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Message msg=Message.obtain();
		MainActivity.handler.sendMessage(msg);
	}
	
}