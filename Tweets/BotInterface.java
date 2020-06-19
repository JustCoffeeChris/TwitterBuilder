package tweets;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import twitter4j.TwitterFactory;

public class BotInterface {

	JFrame frame = new JFrame();
	JButton startButton = new JButton();
	JButton selectFileButton = new JButton();
	JPanel panel = new JPanel(new FlowLayout());
	JLabel label = new JLabel();
	JFileChooser chooser = new JFileChooser();
	String path;

	public void createInterface() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		
		startButton.setText("Start Twitter Bot");
		selectFileButton.setText("Select File");
		label.setText("Remaining Tweets");

		frame.setSize(500, 75);
		frame.getContentPane().add(startButton);
		frame.getContentPane().add(selectFileButton);
		frame.getContentPane().add(label);
		frame.setVisible(true);

	}

	public void setLabelText(String text) {
		label.setText(text);
	}
	
	public void buttonEvent() {

		selectFileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				chooser.showOpenDialog(null);
				path = chooser.getSelectedFile().getAbsolutePath();

			}

		});

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed");
				TweetBuilder builder = new TweetBuilder(TwitterFactory.getSingleton());

				try {
					builder.addMultipleMessages(new FileLoader(path).seperator());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Thread test = new Thread(builder);
				test.start();

			}

		});

	}
}
