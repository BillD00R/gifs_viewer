package com.bill_d00r.gifsviewer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bill_d00r.gifsviewer.presentation.GifsFeedViewModel
import com.bill_d00r.gifsviewer.presentation.carousel.GifsCarouselScreen
import com.bill_d00r.gifsviewer.presentation.feed.GifsFeedScreen
import com.bill_d00r.gifsviewer.presentation.util.Routes
import com.bill_d00r.gifsviewer.theme.ComposePaging3CachingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePaging3CachingTheme {
                val viewModel = hiltViewModel<GifsFeedViewModel>()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.GIFS_FEED
                ) {
                    composable(Routes.GIFS_FEED) {
                        GifsFeedScreen(
                            onNavigate = {
                                navController.navigate(it.route)
                            },
                            viewModel = viewModel
                        )
                    }
                    composable(route = Routes.GIFS_CAROUSEL + "?gifId={gifId}",
                        arguments = listOf(
                            navArgument(name = "gifId") {
                                type = NavType.IntType
                                defaultValue = 1
                            }
                        ))
                    {
                        val gifId = it.arguments?.getInt("gifId")
                        Log.d("PAGER_CALL", "GifID: $gifId")
                        GifsCarouselScreen(
                            viewModel = viewModel,
                            onPopBackStack = {
                                navController.popBackStack()
                            },
                            initialId = gifId ?: 0
                        )
                    }


                }

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//
//                    val gifs = viewModel.gifsPagingFlow.collectAsLazyPagingItems()
//                    GifsFeedScreen(gifs = gifs)
            }
        }
    }
}
