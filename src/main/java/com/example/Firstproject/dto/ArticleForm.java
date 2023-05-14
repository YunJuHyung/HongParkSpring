package com.example.Firstproject.dto;

import com.example.Firstproject.entity.Article;

//form데이터를 받아오는 그릇
//DTO : 데이터베이스 레코드의 데이터를 매핑하기 위한 데이터 객채
public class ArticleForm {

    private String title;
    private String content;

    //커스텀 생성자 드디어 자바에서 배운거 써먹는다
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
