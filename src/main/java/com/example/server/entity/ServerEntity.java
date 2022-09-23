package com.example.server.entity;

import com.example.server.enumiration.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ServerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String memory;

    @Column(unique = true)
    @NotEmpty(message = "IpAddress cannot be empty!")
    private String ipAddress;
    private String type;
    private String imageUrl;
    private Status status;

}
