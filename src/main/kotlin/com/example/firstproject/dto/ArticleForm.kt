package com.example.firstproject.dto

import com.example.firstproject.entity.Article
import lombok.AllArgsConstructor
import lombok.ToString


@AllArgsConstructor
@ToString
class ArticleForm ( val id :Long, val title: String, val content: String){

    fun toEntity():Article{
        return Article(id,title,content)
    }

    override fun toString(): String {
        return "ArticleForm(id=$id, title='$title', content='$content')"
    }


}