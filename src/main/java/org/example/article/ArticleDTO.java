package org.example.article;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ArticleDTO {
    private int id;
    private String title;
    private String content;
    private int memberId;
    private String userId;
    private String regDate;

    ArticleDTO (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
        this.memberId = (int)row.get("memberId");
        this.userId = (String)row.get("userId");
        this.regDate = row.get("regDate").toString();
    }
}
