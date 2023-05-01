package com.ToDoServer.ToDoServer.Model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDoData {
    private int id;
    private String email;
    private String body;
    private boolean done;

}
