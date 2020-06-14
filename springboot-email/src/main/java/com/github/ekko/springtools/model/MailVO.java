package com.github.ekko.springtools.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailVO {

    private String to;

    private String recipientName;

    private String subject;

    private String text;

    private String senderName;

    private String templateEngine;
}
