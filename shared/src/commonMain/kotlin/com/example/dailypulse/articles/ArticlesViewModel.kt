package com.example.dailypulse.articles

import com.example.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articleState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articleState

    private val mockArticle = listOf(
        Article(
            title =  "ChargePoint Announces Reorganization, Still Has Challenges Ahead",
            desc ="A recent press release from ChargePoint shows that the company is going to have to roll with some more punches ... [continued]\nThe post ChargePoint Announces Reorganization, Still Has Challenges Ahead appeared first on CleanTechnica.",
            date = "2024-01-18",
            imageUrl = "https://cleantechnica.com/wp-content/uploads/2023/08/Broken-ChargePoint-Station-Petrified-Forest-2000x1000-1-800x400.png"
        ),
        Article(
            title =  "Stock market today: Asian shares trade mixed after Wall Street dips amid dimming rate cut hopes",
            desc ="Asian shares are trading mixed as pessimism spreads among investors about any imminent interest rate cut in the U.S. Japan’s benchmark Nikkei finished little changed Thursday, inching down less than 0.1%",
            date = "2024-01-20",
            imageUrl = "https://i.abcnewsfe.com/a/6afbf3a8-75c3-471b-a85f-8ad3a8fc8522/wirestory_46b70fbc1f5d1be1da44b9bc486756ee_16x9.jpg?w=1600"
        ),
        Article(
            title =  "im Cramer’s 2024 Market Themes",
            desc ="Introduction In yesterday’s episode of CNBC’s “Mad Money,” host Jim Cramer outlined his market themes for 2024, offering investors a roadmap for navigating a year he anticipates to be tumultuous yet potentially rewarding. This analysis explores Cramer’s insig…",
            date = "2024-01-20",
            imageUrl = "https://media.cryptoglobe.com/2020/12/Jim-Cramer-in-Jan-2011-768x426.png",
        )
    )

    init {
        getArticles()
    }

    private fun getArticles(){
        scope.launch {
            val fetchedArticles = fetchArticles()
            _articleState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    private suspend fun fetchArticles(): List<Article> = mockArticle


}