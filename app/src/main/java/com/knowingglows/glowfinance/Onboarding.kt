package com.knowingglows.glowfinance

import android.annotation.SuppressLint
import android.media.session.MediaSessionManager.OnSession2TokensChangedListener
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.color.MaterialColors
import com.knowingglows.glowfinance.ui.theme.GlowFinanceTheme
import com.knowingglows.glowfinance.ui.theme.PoppinsBold
import com.knowingglows.glowfinance.ui.theme.PoppinsRegular

class Onboarding : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnboardingFunction()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingFunction() {
    val (currentPage, setCurrentPage) = remember { mutableStateOf(1) }
    val totalPages = 7

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Onboarding Progress") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Page content here, replace with actual onboarding pages
            Text("Onboarding Page $currentPage of $totalPages")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .background(Color.LightGray)
            ) {
                val progress = (currentPage.toFloat() / totalPages.toFloat()) * 100
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .height(16.dp)
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                )
            }
            when (currentPage)
            {
                1 -> OnboardScreen1()
                2 -> OnboardScreen2()
                3 -> OnboardScreen3()
                4 -> OnboardScreen4()
                5 -> OnboardScreen5()
                6 -> Paywall()
                7 -> SignUp()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (currentPage > 1) {
                    Button(
                        onClick = { setCurrentPage(currentPage - 1) },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Previous")
                    }
                }

                if (currentPage < totalPages) {
                    Button(
                        onClick = { setCurrentPage(currentPage + 1) },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Next")
                    }
                }
            }
        }
    }
}

@Composable
fun SignUp() {
    TODO("Not yet implemented")
}

@Composable
fun Paywall() {
    TODO("Not yet implemented")
}

@Composable
fun OnboardScreen5() {
    TODO("Not yet implemented")
}

@Composable
fun OnboardScreen4() {
    TODO("Not yet implemented")
}

@Composable
fun OnboardScreen3() {
    TODO("Not yet implemented")
}

@Composable
fun OnboardScreen2()
{
   Text(text = "Hello")
}

@Composable
fun OnboardScreen1() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun PreviewFunction() {
    GlowFinanceTheme {
       OnboardScreen2()
    }
}