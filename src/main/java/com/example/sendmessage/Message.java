package com.example.sendmessage;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
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
