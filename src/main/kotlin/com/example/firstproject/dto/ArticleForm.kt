package com.example.firstproject.dto

import com.example.firstproject.entity.Article
import lombok.AllArgsConstructor
import lombok.ToString

@AllArgsConstructor
@ToString
class ArticleForm (val title: String, val content: String){

    fun toEntity():Article{
        return Article(null,title,content)
    }

    override fun toString(): String {
        return "ArticleForm(title='$title', content='$content')"
    }


}