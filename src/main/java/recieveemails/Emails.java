package recieveemails;

import java.security.NoSuchProviderException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Emails {
	static void check(String host, String storeType, String User, String password) throws NoSuchProviderException {
		try {
			// create properties field
			Properties prop = new Properties();
			prop.put("mail.pop3.host", host);
			prop.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(prop);

			// pop3 store object and connection with pop server
			Store store = emailSession.getStore("pop3s");
			store.connect(host, User, password);

			// folder object for open inbox
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// get the messages
			Message messages[] = emailFolder.getMessages();
			int i = ((messages.length) - 1);
			Message message = messages[i];
			System.out.println("Email Number" + (i + 1));
			System.out.println("Subject:" + message.getSubject());
			System.out.println("From:" + message.getFrom()[0]);

			// close the store and folder objects
			emailFolder.close(true);
			store.close();

		} catch (MessagingException e) {
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) throws Exception {
		String host = "pop.cit.ac.in";
		String mailStoreType = "pop3";
		String username = "b17cs050@cit.ac.in";
		String password = "sam-witz37";
		check(host, mailStoreType, username, password);
	}
}
