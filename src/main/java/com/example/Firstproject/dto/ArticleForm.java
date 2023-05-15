package com.example.Firstproject.dto;

import com.example.Firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;
    //form데이터를 받아오는 그릇
    //DTO : 데이터베이스 레코드의 데이터를 매핑하기 위한 데이터 객채
    //커스텀 생성자 드디어 자바에서 배운거 써먹는다
    @AllArgsConstructor
    @ToString
    public class ArticleForm {
        private String title;
        private String content;

        public Article toEntity(){
            return new Article(null, title, content);

        }

    }
