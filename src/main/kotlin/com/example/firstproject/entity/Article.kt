package com.example.firstproject.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor


@Entity
@AllArgsConstructor
@NoArgsConstructor
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private var id: Long,
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

    fun getId():Long{
        return id
    }

    fun patch(artice: Article) {
        if (artice.title != null)
            this.title = artice.title
        if (artice.content != null)
            this.content = artice.content
    }



}
