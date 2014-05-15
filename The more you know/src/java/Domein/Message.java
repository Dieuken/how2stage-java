/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domein;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Stef
 */
@Entity
@Table(name = "TBL_Message")
public class Message 
{
    @Id
    private int messageId;
    @ManyToOne(fetch = FetchType.EAGER)
    private User fromUser;
    @ManyToOne(fetch = FetchType.EAGER)
    private User toUser;
    private String message;

    public Message() {
    }

    public Message(int messageId, User vanUser, User naarUser, String message) {
        this.messageId = messageId;
        this.fromUser = vanUser;
        this.toUser = naarUser;
        this.message = message;
    }

    public int getMessageId() {
        return messageId;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setVanUser(User vanUser) {
        this.fromUser = vanUser;
    }

    public void setNaarUser(User naarUser) {
        this.toUser = naarUser;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
    
                    
}
