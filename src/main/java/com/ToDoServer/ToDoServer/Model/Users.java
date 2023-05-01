package com.ToDoServer.ToDoServer.Model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private String email;
    private String fname;
    private String lname;
    private  String password;
}
