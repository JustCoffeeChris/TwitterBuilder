package main;

import tweets.BotInterface;

public class Main {

	static BotInterface botInterface = new BotInterface();
	
	
	public static BotInterface getInterface() {
		return botInterface;
	}
	
	public static void main(String[] args) {

		
		botInterface.createInterface();
		
		botInterface.buttonEvent();

	}
}
