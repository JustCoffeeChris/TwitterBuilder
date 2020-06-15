
import Tweets.BotInterface;

public class Main {

	public static void main(String[] args) {

		BotInterface botInterface = new BotInterface();
		botInterface.createInterface();
		botInterface.buttonEvent();

	}
}
