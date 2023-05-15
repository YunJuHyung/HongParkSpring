package com.example.Firstproject.controller;

import com.example.Firstproject.dto.ArticleForm;
import com.example.Firstproject.entity.Article;
import com.example.Firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {


    //원래라면 객체를 직접 입력해줘야한다.하지만 스프링부트에서는 자체적으로 만들어주는 어노테이션이 있다.
    @Autowired   //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결하는 어노테이션
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";

    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {//dto에 넣어줄 파라매터를 받는다
        log.info(form.toString());
        //System.out.println(form.toString()); ->logging 기능으로 대체

        //1.Dto를 Entity로 변환
        //ArticleForm 의 변수명인 form에 Article의 객체를 toEntity를 통해 반환한다.
        Article article = form.toEntity();
        //System.out.println(article.toString()); ->logging으로 대체
        log.info(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 함!
        // articleRepository가 있다는 가정하에 생성 Private으로 객채를 임시로 만들어줌
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString()); ->logging으로 대체
        return "";
    }

    @GetMapping("/articles/{id}")       //클라이언트에게 받은 Url
    public String show(@PathVariable Long id, Model model) {
        //@PathVariable 어노테이션은 @GetMapping에서
        // 받아오는 Url 주소가 Path로 부터 입력이 된다는 것
        log.info("id = " + id);


        //1: id로 데이터를 가져옴!
        //찾는 id가 없으면 null을 반환하라는 뜻
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //2: 가져온 데이터를 모델에 등록!
        model.addAttribute("article", articleEntity);
        //3: 보여줄 페이지를 설정!
        return "articles/show"; //show.mustache에 부트스트랩으로 받아온 자료를 넣어줌
    }
}
