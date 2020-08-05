package com.database.demo.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "find_all_Users",query = "SELECT user from User user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private  String location;
    private Date birthDate;
}
