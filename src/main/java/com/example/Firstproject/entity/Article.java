package com.example.Firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//실제 DataBase의 테이블과 1:1로 매핑되는 클래스
@Entity // DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자를 추가해주는 어노테이션
@ToString
@Getter
public class Article {

    @Id //대표값을 지정! like a 주민등록번호
    @GeneratedValue //1,2,3,...자동 생성 어노테이션
    //어노테이션이란? 메타 데이터의 일종!
    //메타 데이터란? 일반적으로 데이터에 관환 구조화된 데이터
    private Long id;  //Entity에는 대표값을 하나 만들어줘야한다
    @Column
    private String title;

    @Column
    private String content;


//롬복으로 대체
//    public Long getid() {
//        return id;
//    }
}
