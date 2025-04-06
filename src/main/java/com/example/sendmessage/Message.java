package com.example.sendmessage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.net.InetAddress;
import java.util.Date;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Message {
    @Id
    private Long id;
    private Date date = new Date();
    private String text;
    private String author;
    private String receiver;
}
