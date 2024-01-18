package com.example.dailypulse.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dailypulse.articles.Article
import com.example.dailypulse.articles.ArticlesViewModel

@Composable
fun ArticleScreen(
    articlesViewModel: ArticlesViewModel
) {
    val articleState = articlesViewModel.articlesState.collectAsState()
    Column {
        Appbar()
        if (articleState.value.loading) {
            Loading()
        } else if (articleState.value.error != null) {
            ErrorMessage(error = articleState.value.error!!)
        } else if (articleState.value.articles.isNotEmpty()) {
            ArticlesListView(articles = articleState.value.articles)
        }
    }

}

@Composable
fun ArticlesListView(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) {
            ArticleRowView(article = it)
        }
    }
}

@Composable
fun ArticleRowView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc,
            style = TextStyle(
                color = Color.Gray,
            ),
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = article.date, modifier = Modifier.align(Alignment.End))
        Divider()
    }
}

@Composable
fun ErrorMessage(error: String) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Text(text = "Error : $error", textAlign = TextAlign.Center)
    }
}

@Composable
fun Loading() {
    Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.width(64.dp),
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Appbar() {
    TopAppBar(title = { Text(text = "Articles") })
}
