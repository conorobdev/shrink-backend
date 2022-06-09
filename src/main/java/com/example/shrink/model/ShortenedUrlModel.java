package com.example.shrink.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder
@Builder
@Data
@Document(collection = "user_urls")
public class ShortenedUrlModel {
    @Id
    @Indexed(unique = true)
    private String _id = UUID.randomUUID().toString();
    private String userUrl;
}
