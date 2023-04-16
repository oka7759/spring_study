package com.example.firstproject.api

import com.example.firstproject.dto.ArticleForm
import com.example.firstproject.entity.Article
import com.example.firstproject.repository.ArticleRepository
import com.example.firstproject.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ArticleApiController(    @Autowired
                               val articleService : ArticleService  ){


    //get
    @GetMapping("/api/articles")
    fun index():List<Article> {
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    fun show(@PathVariable id:Long): Article {
        return articleService.show(id)
    }


    //post
    @PostMapping("/api/articles")
    fun create(@RequestBody dto :ArticleForm):ResponseEntity<Article> {

        var created:Article = articleService.create(dto)

        return if(created != null) { ResponseEntity.status(HttpStatus.CREATED).body(created)}
        else {ResponseEntity.status(HttpStatus.BAD_REQUEST).build()}
    }
    //patch
    @PatchMapping("/api/articles/{id}")
    fun update(@PathVariable id:Long, @RequestBody dto :ArticleForm):ResponseEntity<Article> {
     var updated:Article= articleService.update(id,dto)

        return if(updated != null) { ResponseEntity.status(HttpStatus.CREATED).body(updated)}
        else {ResponseEntity.status(HttpStatus.BAD_REQUEST).build()}
    }
    //delete
    @DeleteMapping("/api/articles/{id}")
    fun delete(@PathVariable id: Long):ResponseEntity<Article>{
        val deleted:Article =articleService.delete(id);

        return if(deleted != null) { ResponseEntity.status(HttpStatus.CREATED).body(deleted)}
        else {ResponseEntity.status(HttpStatus.BAD_REQUEST).build()}

    }

    @PostMapping("/api/transaction-test")
    fun transactionTest(@RequestBody dtos :List<ArticleForm>):ResponseEntity<List<Article>>{
        val createdList:List<Article> =articleService.createArticles(dtos)
        return if(createdList != null) { ResponseEntity.status(HttpStatus.OK).body(createdList)}
        else {ResponseEntity.status(HttpStatus.BAD_REQUEST).build()}

    }


}


