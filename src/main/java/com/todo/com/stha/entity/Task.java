package com.todo.com.stha.entity;

/*

@author pritam shrestha
@version 1.0
@date 2024-10-22

*/

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task_details")
public class Task {
    @Id
    private String id;
    private String title;


}
