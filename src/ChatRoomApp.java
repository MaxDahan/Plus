
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class ChatRoomApp {
	private ArrayList<Profile> directory;
	public ChatRoomApp() {
		new File(System.getProperty("user.dir") + "/data/ChatApp/").mkdirs();
		directory = new ArrayList<Profile>();
		try {
			loadChat();
			welcomeScreen();
		} catch (FileNotFoundException e) {
			newChat();
		}
	}
	private void newChat() {
		directory.clear();
		Scanner console = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String myName = console.next();
		System.out.print("Enter your IPv4 Address: ");
		String ip = console.next();
		System.out.print("Enter your port: ");
		String port = console.next();
		directory.add(new Profile(myName, ip, port, true));
		System.out.println("You must add at least one contact to chat with.");
		boolean adding = true;
		while(adding) {
			System.out.print("Enter a name for your contact: ");
			String theirName = console.next();
			System.out.print("Enter their IPv4 Address: ");
			String theirIp = console.next();
			System.out.print("Enter their port: ");
			String theirPort = console.next();
			System.out.print("Would you like to add another contact? (y/n)");
			adding = console.next().toLowerCase().charAt(0) == 'y';
			directory.add(new Profile(theirName, theirIp, theirPort, false));
		}
		System.out.println("\n\nSaving directory...\n");
		try {
			PrintStream p = new PrintStream(new File(System.getProperty("user.dir") + "/data/ChatApp/data.txt"));
			for (Profile pr : directory) {
				if (pr.isMe()) {
					p.print("MYPROFILE");
				}
				else {
					p.print("FRPROFILE");
				}
				p.println("\t" + pr.getName() + "\t" + pr.getIP());
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR EXPORTING FILE FOR DIRECTORY!");
		}
		console.close();
		welcomeScreen();
	}
	private boolean loadChat() throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + "/src/mychatappp/Profiles.txt");
		Scanner fileScan = new Scanner(file);
		while(fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			boolean me = line.substring(0, 9).equals("MYPROFILE");
			Scanner scan = new Scanner(line);
			scan.next();
			String name = scan.next();
			String ip = scan.next();
			String port = scan.next();
			directory.add(new Profile(name, ip, port, me));
			scan.close();
		}
		fileScan.close();
		return directory.size() > 0;
	}
	private void welcomeScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n");
		Profile me = null;
		for (Profile p : directory) {
			if (p.isMe()) me = p;
		}
		if (me == null) newChat();
		System.out.println("Welcome to the Chat, " + me.getName() + "!");
		Scanner console = new Scanner(System.in);
		System.out.print("\nType 'n' to start a chat, 'a' to add to your directory, or 'e' to exit: ");
		String string = "";
		if (console.hasNextLine()) console.nextLine();
		while(!console.hasNext()) {
			string = console.next();
		}
		char c = string.charAt(0);
		if (c == 'n') {
			findChatMate(me);
		}
		else if (c == 'a') {
			addToDirectory();
		}
		console.close();
	}
	private void findChatMate(Profile me) {
		boolean found = false;
		Scanner console = new Scanner(System.in);
		while(!found) {
			System.out.print("Let's chat! Search for a name in the directory, or type 'a' to add to the directory or 'p' to print the directory: ");
			String name = console.next();
			if (name.equals("a")) {
				addToDirectory();
			}
			else if (name.equals("p")) {
				System.out.println("\n\nDIRECTORY:");
				for(Profile p : directory) {
					System.out.println(p.getName() + "\t" + p.getIP());
				}
			}
			else {
				for (Profile p : directory) {
					if (p.getName().equals(name)) {
						found = true;
						chatWith(me, p);
					}
				}
			}
		}
		console.close();
	}
	private void addToDirectory() {
		Scanner console = new Scanner(System.in);
		boolean adding = true;
		while(adding) {
			System.out.print("Enter a name for your contact: ");
			String theirName = console.next();
			System.out.print("Enter their IPv4 Address: ");
			String theirIp = console.next();
			System.out.print("Enter their port: ");
			String theirPort = console.next();
			System.out.print("Would you like to add another contact? (y/n)");
			adding = console.next().toLowerCase().charAt(0) == 'y';
			directory.add(new Profile(theirName, theirIp, theirPort, false));
		}
		System.out.println("\n\nSaving directory...\n");
		try {
			PrintStream p = new PrintStream(new File(System.getProperty("user.dir") + "/data/ChatApp/data.txt"));
			for (Profile pr : directory) {
				if (pr.isMe()) {
					p.print("MYPROFILE");
				}
				else {
					p.print("PRPROFILE");
				}
				p.println("\t" + pr.getName() + "\t" + pr.getIP() + "\t" + pr.getPort());
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR EXPORTING FILE FOR DIRECTORY!");
		}
		console.close();
	}
	private void chatWith(Profile me, Profile o) {
		MainScreen chat = new MainScreen(me, o);
	}
}
