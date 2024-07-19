package com.example.secondproject.dto;

import com.example.secondproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 생성자가 자동으로 만들어짐
@ToString // toString() 자동 생성
public class ArticleForm {
    private Long id;
    private String title; // 제목을 받을 필드
    private String content; // 내용을 받을 필드

    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가
   /* public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }*/

    /*@Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }*/

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
