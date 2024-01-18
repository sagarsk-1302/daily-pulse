package com.example.dailypulse.articles

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

class ArticlesUseCase(private val articlesService: ArticlesService) {

    suspend fun getArticles(): List<Article>{
        val articlesRaw = articlesService.fetchArticles()
        return mapArticle(articlesRaw = articlesRaw)
    }

    private fun mapArticle(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map {
        Article(
            title = it.title,
            desc = it.description?: "No Description",
            imageUrl = it.urlToImage ?: "https://s.yimg.com/ny/api/res/1.2/kfkeLteoVeLlTHTzCeNl4g--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA-/https://s.yimg.com/os/creatr-uploaded-images/2023-12/578482c0-aa7d-11ee-abf7-d86d16584d23",
            date = it.publishedAt.toInstant().toLocalDateTime(TimeZone.UTC).date.toString()
        )


    }
}