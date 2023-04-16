package com.example.firstproject.service

import com.example.firstproject.dto.ArticleForm
import com.example.firstproject.entity.Article
import com.example.firstproject.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ArticleService (@Autowired val articleRepository: ArticleRepository){
    fun index(): List<Article> {
       return articleRepository.findAll()

    }

    fun show(id: Long): Article {
       return articleRepository.findById(id).orElse(null)

    }

    fun create(dto: ArticleForm): Article {
        var article:Article =dto.toEntity()
        if(article.getId() !=null){
            return article
        }
        return articleRepository.save(article)


    }

    fun update(id: Long, dto: ArticleForm): Article {
        var article:Article =dto.toEntity()
       var target:Article =articleRepository.findById(id).orElse(null)
        if(target ==null || id != article.getId()){
            return target
        }
        target.patch(article)
        var updated :Article = articleRepository.save(target)
        return updated
    }

    fun delete(id: Long): Article {
        var target:Article= articleRepository.findById(id).orElse(null)
        if(target == null){

            return target
        }
        articleRepository.delete(target)
        return target

    }
@Transactional
    fun createArticles(dtos: List<ArticleForm>): List<Article> {
        
        ///dto묶음을 엔티티묶음으로

        var articleList :List<ArticleForm> = dtos.stream().map(dto-> dto.toEntity()).collect(collectors.toList())
        
        
        //엔티티 묶음을 디비로 저장
        
        //강제 예외 발셍
        
        //결과값 반환
        
        
        return 

    }


}