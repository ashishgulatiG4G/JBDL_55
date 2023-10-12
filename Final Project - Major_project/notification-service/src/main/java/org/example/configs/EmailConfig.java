package org.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    SimpleMailMessage getMailMessage(){
        return new SimpleMailMessage();
    }

    @Bean
    JavaMailSenderImpl getMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();


        javaMailSender.setHost("smtp.gmail.com");       // mailing server from which you want to send emails, smtp = mailing protocol
        javaMailSender.setPort(587);                    // Port of mailing server, we can search on the web
        javaMailSender.setUsername("ewallet.jbdl55@gmail.com");         // EmailID of the sender, this is a newly created account for this project
        javaMailSender.setPassword("mxvfmfmiwjbkbvkq");                 // Password generated using two-step verification

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.debug", true);

        properties.put("mail.smtp.starttls.enable", true);

        return javaMailSender;

    }
}
