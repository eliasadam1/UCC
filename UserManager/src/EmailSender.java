import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender  {
	
	public static void EmailSend() {
		String from = "tesztelek278@gmail.com";
		String pass = "Almafa2a";
		String to = "testforucc@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Értesítés! - Ne válaszoljon erre az üzenetre!");
			message.setText("Automatikus üzenet: A programban hibás adat került bevitelre vagy hiba történt a programban.");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Üzenet elküldve sikeresen.");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void EmailSendMod() {
		String from = "tesztelek278@gmail.com";
		String pass = "Almafa2a";
		String to = "testforucc@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Értesítés! - Ne válaszoljon erre az üzenetre!");
			message.setText("Automatikus üzenet:Egy felhasználó adati módosítva lettek.");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Üzenet elküldve sikeresen.");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	
}