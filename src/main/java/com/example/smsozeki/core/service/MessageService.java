package com.example.smsozeki.core.service;

import com.example.smsozeki.core.config.MySMSOzekiConfig;
import com.example.smsozeki.core.config.OzekiConfig;
import com.example.smsozeki.core.entity.MessageEntity;
import com.example.smsozeki.core.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private OzekiConfig ozekiConfig;

    /**
     * To Send sms and Save the sms in database
     * @param message
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String sendSMS(MessageEntity message) throws IOException, InterruptedException {
        MySMSOzekiConfig smsozekiConfig = new MySMSOzekiConfig(this.ozekiConfig.host, this.ozekiConfig.port);
        try {
            smsozekiConfig.login(this.ozekiConfig.username, this.ozekiConfig.password);
            if (smsozekiConfig.isLoggedIn()) {
                smsozekiConfig.sendMessage(message.getReceiver(), message.getMessage());
                messageRepository.save(message);
                return "sent";
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }finally {
            if (smsozekiConfig != null) {
                try {
                    smsozekiConfig.logout();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Not sent";
    }

    /**
     * For Testing SMS reaching to GATEWAY
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String test() throws IOException, InterruptedException {
        MySMSOzekiConfig config = new MySMSOzekiConfig("localhost", 9500);
        try {
            config.login("test", "12345");
            System.out.println("CRENDECIAS INSERIDAS");

            if (config.isLoggedIn()) {
                System.out.println("MANDAR MESSAGE");
                config.sendMessage("+258879191241", "TEST");
                System.out.println("Ja Mandou");
                return "sent";
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nao mandou");
        } finally {
            if (config != null) {
                try {
                    config.logout();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Not Sent";
    }

}
