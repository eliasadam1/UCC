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
			message.setSubject("�rtes�t�s! - Ne v�laszoljon erre az �zenetre!");
			message.setText("Automatikus �zenet: A programban hib�s adat ker�lt bevitelre vagy hiba t�rt�nt a programban.");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("�zenet elk�ldve sikeresen.");
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
			message.setSubject("�rtes�t�s! - Ne v�laszoljon erre az �zenetre!");
			message.setText("Automatikus �zenet:Egy felhaszn�l� adati m�dos�tva lettek.");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("�zenet elk�ldve sikeresen.");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	
}