package com.example.Mezzi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Mezzi.Classes.Validation;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendNotification(Validation validation) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("mohamed.mezzi@ensi-uma.tn");
        mailMessage.setTo(validation.getUser().getEmail());
        mailMessage.setSubject("Validation de votre compte");
        mailMessage.setText("Votre code de validation est : " + validation.getCode());

        // Envoi du mail
        javaMailSender.send(mailMessage);
    }
}
