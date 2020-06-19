package tweets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {

	File file = null;
	Scanner scan = null;
	String content = "";
	ArrayList<String> stringList = new ArrayList<String>();

	public FileLoader(String path) throws FileNotFoundException {
		file = new File(path);
		scan = new Scanner(file);

		while (scan.hasNextLine()) {
			content += scan.nextLine();
		}
	}

	public ArrayList<String> seperator() {

		String actualString = "";
		for (int i = 0; i < content.length(); i++) {

			if (content.charAt(i) == '$') {

				stringList.add(actualString);
				actualString = "";
			} else {

				actualString += content.charAt(i);
			}

		}

		return stringList;
	}

	public String getContent() {
		return content;
	}

	public void main() throws FileNotFoundException {

	}
}
