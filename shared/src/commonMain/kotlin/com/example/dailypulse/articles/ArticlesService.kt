package com.example.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class ArticlesService(private val httpClient: HttpClient) {
    private val country = "in"
    private val category = "technology"
    private val apiKey = "22388440afab4fb7b03b440ce2e400fe"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticleResponse = httpClient.get(urlString = """
            https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey
        """.trimIndent()).body()
        return response.articles
    }
}