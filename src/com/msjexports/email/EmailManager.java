package com.msjexports.email;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msjexports.prop.PropertyManager;



public class EmailManager {
	
	final static Logger logger = LoggerFactory.getLogger(EmailManager.class);
	
	private PropertyManager propManager = new PropertyManager();
	private String path;
	
	
	public EmailManager(String path)
	{
		this.path = path;
	}
	
	
	public void sendEmail(String enq_name,String enq_email,String enq_phone,String enq_country,String enq_products,String enq_message)
	{
		
		logger.info("----inside send email ----- ");
		
		logger.info(" User name value : "+enq_name);
		
		
		logger.info(" User email value : "+enq_email);
		
		
		logger.info(" User phone value : "+enq_phone);
		
		
		logger.info(" User country value : "+enq_country);
		
		
		logger.info(" User products value : "+enq_products);
		
		
		logger.info(" User message value : "+enq_message);
		
		logger.info("----inside send email ----- ");
		
		
		propManager.loadProps(path);
		// Recipient's email ID needs to be mentioned.
	      String to = propManager.readSpecProp("com.msjexports.toaddr");;//change accordingly
	      logger.info("to addr "+to);

	      // Sender's email ID needs to be mentioned
	      final String from = propManager.readSpecProp("com.msjexports.fromaddr");//change accordingly
	      logger.info("from addr "+from);
	      final String username = propManager.readSpecProp("com.msjexports.username");//change accordingly
	      logger.info("username "+username);
	      final String password = propManager.readSpecProp("com.msjexports.password");//change accordingly
	      logger.info("password "+password);

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = propManager.readSpecProp("com.msjexports.hostname");
	      logger.info("host "+host);
	      
	      String port = propManager.readSpecProp("com.msjexports.port");
	      logger.info("port "+port);
	      
	      
	      String ssl = propManager.readSpecProp("com.msjexports.ssl");
	      logger.info("ssl "+ssl);
	      
	      String tls = propManager.readSpecProp("com.msjexports.tls");
	      logger.info("tls "+tls);
	      
	      String auth = propManager.readSpecProp("com.msjexports.auth");
	      logger.info("auth "+auth);
	      
	      Properties props = new Properties();
//	      props.put("mail.smtp.auth", auth);
//	      props.put("mail.smtp.starttls.enable", tls);
//	      props.put("mail.smtp.socketFactory.class",ssl);   
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", port);

	      // Get the Session object.
	      Session emailSession = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(emailSession);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(enq_products);

	         // Now set the actual message
	         message.setText("Product Enquiry Details \n\n"+
	        		 " Name : "+enq_name+"\n\n"+
	        		 " Phone : "+enq_phone+"\n\n"+
	        		 " Email : "+enq_email+"\n\n"+
	        		 " Country : "+enq_country+"\n\n"+
	        		 " Message : "+enq_message+"\n\n");	

	         // Send message
	         Transport.send(message);

	         logger.info("Sent message successfully....");

	      } catch (MessagingException e) {
	    	  logger.error("email message failure....",e);
	      }
	}

}