package com.example.secondproject.api;

import com.example.secondproject.dto.ArticleForm;
import com.example.secondproject.entity.Article;
import com.example.secondproject.repository.ArticleRepository;
import com.example.secondproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.sqm.produce.function.StandardFunctionReturnTypeResolvers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // 로그를 찍을 수 있게 어노테이션 추가
@RestController // REST API용 컨트롤러 선언
public class ArticleApiController {
    @Autowired
    private ArticleService articleService; // 서비스 객체 주입


//    @Autowired
//    private ArticleRepository articleRepository;
    // GET
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }
    // GET
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);

    }
    // POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        Article updated = articleService.update(id,dto); // 서비스를 통해 게시글 수정
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
        List<Article> createdList = articleService.createArticles(dtos); // 서비스 호출
        return (createdList !=null)?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
