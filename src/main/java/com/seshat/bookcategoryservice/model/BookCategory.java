package com.seshat.bookcategoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookCategory")
public class BookCategory {
    @Id
    private String id;
    private String userId;
    private String userName;
    private String categoryId;
    private String categoryName;
}
