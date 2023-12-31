package com.example.utsmobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.utsmobcom.model.DataMatkul
import com.example.utsmobcom.model.Matkul
import com.example.utsmobcom.ui.theme.UTSMobcomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTSMobcomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFffcd4f)
                ) {
                    UTSMobcom()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UTSMobcom() {
    Column {
        CenterAlignedTopAppBar(
            title =
            {
                Text(text = "KRS Semester 119",
                    color = Color(0xffffcd4f),
                    fontWeight = FontWeight.Bold)
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        ListMatkul(matkul = DataMatkul.matkul)
    }
}

@Composable
fun ListMatkul(matkul: List<Matkul>) {
    LazyColumn {
        items(matkul.size) {
            CardMatkul(
                matkul = matkul[it],
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun CardMatkul(matkul: Matkul, modifier: Modifier = Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(
        containerColor = Color(0xFFffcd4f),
    )) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .sizeIn(minHeight = 64.dp)
        ) {
            Box(
                modifier = Modifier
                    .sizeIn(minWidth = 64.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = matkul.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.size(64.dp)
                )
            }
            Column {
                Text(
                    text = stringResource(id = matkul.matkul),
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "SKS : " + stringResource(id = matkul.sks),
                        modifier = Modifier.padding(8.dp),
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListMatkulApp() {
    UTSMobcomTheme {
        UTSMobcom()
    }
}