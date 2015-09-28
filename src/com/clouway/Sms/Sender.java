package com.clouway.Sms;

/**
 * Created by clouway on 15-9-25.
 */
public class Sender {
    public final Gateway gateway;
    public final Reciever reciever;

    public Sender(Reciever reciever, Gateway gateway) {
        this.reciever = reciever;
        this.gateway = gateway;
    }

    public void sendMessage(Message message) {
        if(message.text==null || message.header==null || reciever.getPhoneNumber()==null){
            return;
        }
        if(message.text.length()>=1 && message.text.length()<=120 && message.header.length()>1 && reciever.getPhoneNumber().length()>0){
            gateway.recieveMessage(message,reciever);
        }

    }
}