package com.example.firstproject.controller

import com.example.firstproject.dto.ArticleForm
import com.example.firstproject.entity.Article
import com.example.firstproject.repository.ArticleRepository
import lombok.extern.slf4j.Slf4j
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

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
        println("sdad")
        var article: Article = form.toEntity()

        var saved:Article= articleRepository.save(article)
        return "redirect:/article/"+ saved.getId()
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

    @GetMapping("/article/{id}/edit")
    fun  edit (@PathVariable id:Long, model: Model):String{
        //수정데이터 데려요기
        var articleEntity:Article=articleRepository.findById(id).orElse(null)
        model.addAttribute("article",articleEntity)

        return "article/edit"
    }
    @PostMapping("/article/update")
    fun update (form: ArticleForm):String {
        println(form.toString())
        //dto 엔티티로 변경
        var articleEntity:Article=form.toEntity()
        println(articleEntity.toString())
        //디비에서 기존데이터 가져온다
        var target: Article =articleRepository.findById(articleEntity.getId()).orElse(null)
        if(target != null){
            articleRepository.save(articleEntity)
        }

        //엔티티 저장소에 저장
        return "redirect:/article/"+articleEntity.getId()
    }
    @GetMapping("/article/{id}/delete")
    fun delete (@PathVariable id: Long,rttr:RedirectAttributes):String {
        println("삭제요청")
        //삭제 대상 가져오기
        var targert : Article = articleRepository.findById(id).orElse(null)
        if(targert != null){
            articleRepository.delete(targert);
            rttr.addFlashAttribute("msg","삭제완료입니다.")
        }
        return "redirect:/article"
    }
}


