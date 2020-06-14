package Tweets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import twitter4j.TwitterFactory;

public class BotInterface {

	JFrame frame = new JFrame();
	JButton startButton = new JButton();

	public void createInterface() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startButton.setText("Start Twitter Bot");

		frame.setSize(500, 250);
		frame.add(startButton);
		frame.setVisible(true);

	}

	public void buttonEvent() {
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed");
				TweetBuilder builder = new TweetBuilder(TwitterFactory.getSingleton());
				builder.addMultipleMessages(new Messages().getMessages());

				builder.tweetLoop();

			}

		});
	}

}
