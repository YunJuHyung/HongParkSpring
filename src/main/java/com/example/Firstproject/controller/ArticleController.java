package com.example.Firstproject.controller;

import com.example.Firstproject.dto.ArticleForm;
import com.example.Firstproject.entity.Article;
import com.example.Firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {


    //원래라면 객체를 직접 입력해줘야한다.하지만 스프링부트에서는 자체적으로 만들어주는 어노테이션이 있다.
    @Autowired   //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결하는 어노테이션
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";

    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){  //dto에 넣어줄 파라매터를 받는다
        System.out.println(form.toString());

        //1.Dto를 Entity로 변환
        //ArticleForm 의 변수명인 form에 Article의 객체를 toEntity를 통해 반환한다.
        Article article = form.toEntity();
        System.out.println(article.toString());


        //2. Repository에게 Entity를 DB안에 저장하게 함!
        // articleRepository가 있다는 가정하에 생성 Private으로 객채를 임시로 만들어줌
        Article saved= articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
