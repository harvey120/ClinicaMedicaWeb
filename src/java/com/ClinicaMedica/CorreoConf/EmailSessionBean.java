package com.ClinicaMedica.CorreoConf;

import java.util.Date;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author DanielG
 */
@Stateless
@LocalBean
public class EmailSessionBean {

    private int port = 465;
    private String host = "smtp.gmail.com";
    private String from = "deheck2017@gmail.com";
    private boolean auth = true;
    private String username = "deheck2017@gmail.com";
    private String password = "qlqybnfxnquosjhz";
    private Protocol protocol = Protocol.SMTPS;
    private boolean debug = true;

    //Nota: nameuser funciona como el subject
    
    public void sendEmail(String to, String nameuser, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        
        switch (protocol){
            case SMTPS:
                props.put("mail.smtp.ssl.enable", true);
                break;
            case TLS:
                props.put("mail.smtp.starttls.enable", true);
                break;
        } 
        
        Authenticator authenticator = null;
        if (auth) {
            props.put("mail.smtp.auth", true);
            authenticator = new Authenticator() {
                private PasswordAuthentication pa = new PasswordAuthentication(username, password);
                @Override
                public PasswordAuthentication getPasswordAuthentication(){
                    return pa;
                }
            };
        }
        
        Session session =   Session.getInstance(props, authenticator);
        session.setDebug(debug);
        
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress (from));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(nameuser);
            message.setSentDate(new Date());
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error en mimemessage: "+e);
        }
    }
}
