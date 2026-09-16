package com.khaysolutions.artspace

import android.graphics.ImageDecoder
import android.os.Bundle
import androidx.compose.material3.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.khaysolutions.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) }
            )
        },
        containerColor = Color.White
    ) {innerPadding ->
        ArtSpaceLayout(modifier = modifier.padding(innerPadding))
    }
}

@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier
) {

    var currentIndex by remember { mutableIntStateOf(0) }
    val currentImage = ImageDetails.availableRecord[currentIndex]
    var enabled by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        ImageCard(currentImage.artPhoto)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DetailedInfoCard(
                title = currentImage.title,
                artist = currentImage.artist,
                yearReleased = currentImage.yearReleased
            )
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                PreviousButton(onButtonClick = {
                    if (currentIndex > 0) currentIndex--
                }, enabled = enabled)
                Spacer(modifier = Modifier.padding(horizontal = 15.dp))
                NextButton(onButtonClick = {
                    if (currentIndex < ImageDetails.availableRecord.lastIndex) {
                        currentIndex++
                    }
                }, enabled = enabled)
            }
        }
    }
}

@Composable
fun ImageCard(
    @DrawableRes artworkImage: Int,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(
         defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(0),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier.width(340.dp).height(450.dp)
    ) {
        Image(
            painter = painterResource(artworkImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().padding(20.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun DetailedInfoCard(
    title: String,
    artist: String,
    yearReleased: String,
    modifier: Modifier = Modifier
) {
    Box (
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.width(335.dp).height(100.dp).background(
            color = Color.LightGray
        )
    ) {
        Column(
            modifier = modifier.padding(15.dp)
        ) {
            Text(text = title)
            Text(
                text = "$artist ($yearReleased)",
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun NextButton(
    onButtonClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    AppButton(
        text = R.string.next_button,
        enabled = enabled,
        onButtonClick = onButtonClick,
        modifier = modifier
    )
}

@Composable
fun PreviousButton(
    onButtonClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    AppButton(
        text = R.string.previous_button,
        enabled = enabled,
        onButtonClick = onButtonClick,
        modifier = modifier
    )
}

@Composable
fun AppButton(
    text: Int,
    enabled: Boolean,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray
        ),
        enabled = enabled,
        modifier = modifier.size(width = 150.dp, height = 40.dp)
    ) {
        Text(text = stringResource(text))
    }
}