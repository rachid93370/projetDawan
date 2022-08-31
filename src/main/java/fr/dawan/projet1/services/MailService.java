package fr.dawan.projet1.services;

public interface MailService {

	void sendMail(String recipient,String from,String subject, String contentHtml);
}
