package com.example.runapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.runapp.data.InfoCard
import com.example.runapp.data.cards
import com.example.runapp.ui.theme.RunAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RunAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.tertiary
                ) {
                    RunApp()
                }
            }
        }
    }
}

@Composable
fun RunApp() {
    Scaffold(topBar = {
        RunTopAppBar()
    }){ it ->
        LazyColumn(contentPadding = it) {
            items(cards) {
                CardItem(card = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RunTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Text displaying the app name
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }
                // Text displaying additional information
                Text(
                    text = "RunRise: 30-Day 5K Challenge",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        },
        modifier = modifier
    )
}


@Composable
fun CardItem(
    card: InfoCard,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) Color(0xFF6CDBAC) else MaterialTheme.colorScheme.primaryContainer,
    )

    Card(
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .background(color = color)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Card Icon with click functionality
                CardIcon(
                    cardIcon = card.imageResourceId,
                    onClick = { expanded = !expanded }
                )

                // Card information
                CardInformation(card.dayOfTrainning, card.description)
            }

            // Message displayed if expanded
            if (expanded) {
                CardMessage(
                    cardMessage = card.message,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
fun CardIcon(
    @DrawableRes cardIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)
            .clickable { onClick.invoke() },
        painter = painterResource(cardIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun CardInformation(
    @StringRes trainnigDay: Int,
    trainningDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(trainnigDay),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource( trainningDescription),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
fun CardMessage(
    @StringRes cardMessage: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.message),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(cardMessage),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

// Previews for light and dark themes
@Preview
@Composable
fun RunAppPreview() {
    RunAPPTheme(darkTheme = false) {
        RunApp()
    }
}
@Preview
@Composable
fun RunAppDarkThemePreview() {
    RunAPPTheme(darkTheme = true) {
        RunApp()
    }
}

// Greeting preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RunAPPTheme {
        RunApp()
    }
}
