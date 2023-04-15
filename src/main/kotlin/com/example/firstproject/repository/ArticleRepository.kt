package com.example.firstproject.repository

import com.example.firstproject.entity.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository :CrudRepository<Article,Long>{
    override fun findAll(): ArrayList<Article>
}