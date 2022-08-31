package fr.dawan.projet1.services.implement;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import fr.dawan.projet1.services.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender emailsender;

	public void sendMail(String recipient, String from, String subject, String contentHtml) {
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
				mimeMessage.setFrom(from);
				mimeMessage.setSubject(subject, "utf-8");
				mimeMessage.setContent(contentHtml, "text/html");
			}

		};
		emailsender.send(messagePreparator);
	}
}
