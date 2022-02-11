package com.example.smsozeki.core.config;

import hu.ozeki.OzSMSMessage;
import hu.ozeki.OzSmsClient;

import java.io.IOException;
import java.util.Date;

public class MySMSOzekiConfig extends OzSmsClient {

    public MySMSOzekiConfig(String host, int port) throws IOException, InterruptedException {
        super(host, port);
    }

    @Override
    public void doOnMessageReceived(OzSMSMessage sms) {

    }

    @Override
    public void doOnMessageDeliveredToHandset(OzSMSMessage sms) {

    }

    @Override
    public void doOnMessageDeliveredToNetwork(OzSMSMessage sms) {

    }

    @Override
    public void doOnMessageAcceptedForDelivery(OzSMSMessage sms) {

    }

    @Override
    public void doOnMessageDeliveryError(OzSMSMessage sms) {

    }

    @Override
    public void doOnClientConnectionError(int i, String s) {
    }
}
