package com.example.Firstproject.repository;

import com.example.Firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

//CRUDRepositry는 생성,읽기,수정,삭제하는 기능을 확장받아서 사용
//JPA에서 가져오는 리포지토리로 두개의 파라미터를 받아야한다
//1. 관리대상 엔티티 2.대표값인 Id의 데이터타입을 넣어준다.
public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Override
    ArrayList<Article> findAll();
}
