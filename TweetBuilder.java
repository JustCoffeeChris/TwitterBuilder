package Tweets;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TweetBuilder implements Runnable {
	ArrayList<String> differentMessages = new ArrayList<String>();
	Twitter twitter = null;
	Status status = null;

	public TweetBuilder(Twitter twitter) {
		this.twitter = twitter;
	}

	public void addMessage(String message) {
		differentMessages.add(message);
	}

	public void addMultipleMessages(String[] message) {
		for (int i = 0; i < message.length; i++) {
			differentMessages.add(message[i]);
		}
	}

	public int getRemainingTweetLength() {
		return differentMessages.size() - 1;
	}

	public void sendTweet(String message) {
		try {
			status = twitter.updateStatus(message);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getRandomTweet() {
		int tweetNumber = new Random().nextInt(differentMessages.size() - 1);
		String fixTweet = differentMessages.get(tweetNumber);
		differentMessages.remove(tweetNumber);
		return fixTweet;
	}

	private void tweetLoop() {

		boolean sent = false;

		while (differentMessages.size() > 1) {

			if (LocalTime.now().getMinute() == 0 && sent == false) {
				sendTweet(getRandomTweet());
				System.err.println("Remaining Tweets:" + (differentMessages.size() - 1));
				sent = true;
			} else if (sent == true && LocalTime.now().getMinute() == 1) {
				sent = false;
			}

		}

	}

	// I really dont know if this is the best solution but it works
	@Override
	public void run() {
		tweetLoop();

	}

}
