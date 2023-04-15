package com.example.firstproject.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@Entity
@AllArgsConstructor
@NoArgsConstructor
class Article(
    @Id @GeneratedValue var id: Long ?=null,
    @Column var title: String,
    @Column var content: String
) {
    fun Article(id: Long,title: String,content: String){
        this.id=id
        this.title=title
        this.content=content

    }

    override fun toString(): String {
        return "Article(id=$id, title='$title', content='$content')"
    }



}
