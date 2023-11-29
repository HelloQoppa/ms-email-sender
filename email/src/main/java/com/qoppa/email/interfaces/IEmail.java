package com.qoppa.email.interfaces;


import com.qoppa.email.models.Email;

public interface IEmail<T> {

    public T sendEmail(Email email);

}
