package com.example.firstproject.controller

import com.example.firstproject.dto.ArticleForm
import com.example.firstproject.entity.Article
import com.example.firstproject.repository.ArticleRepository
import lombok.extern.slf4j.Slf4j
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
@Slf4j
class ArticleController (

    @Autowired
    val articleRepository: ArticleRepository
){

    @GetMapping("/article/new")
    fun newArticleForm ():String {
        return "article/new"
    }

    @PostMapping("/article/create")
    fun createArticle(form:ArticleForm): String {
        var article: Article = form.toEntity()
        var saved:Article= articleRepository.save(article)
        return ""
    }

    @GetMapping("/article/{id}")
    fun show(@PathVariable id:Long , model: Model):String {
        println(id)
        var articleEntity:Article =articleRepository.findById(id).orElse(null);
        model.addAttribute("article",articleEntity)
        println(model)
        return "article/show";
    }

    @GetMapping("/article")
    fun index(model: Model):String {
        var articleEntityList:List<Article> =articleRepository.findAll()

        model.addAttribute("articleList",articleEntityList)

        return "article/index"
    }
}


