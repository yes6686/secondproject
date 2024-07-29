package com.example.secondproject.repository;

import com.example.secondproject.entity.Article;
import com.example.secondproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.CommonWriterSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // 해당 클래스를 JPA와 연동해 테스팅
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 4L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 3. 예상 데이터
            Article article = new Article(4L,"당신의 인생 영화는?","댓글 고");
            Comment a = new Comment(1L, article,"Park","굿 윌 헌팅");
            Comment b = new Comment(2L, article,"Kim","아이 엠 샘");
            Comment c = new Comment(3L, article,"Choi","쇼생크 탈출");
            List<Comment> expected = Arrays.asList(a,b,c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(),"4번 글의 모든 댓글을 출력!");
        }
    }
    @Test
    void findByNickname() {
    }
}