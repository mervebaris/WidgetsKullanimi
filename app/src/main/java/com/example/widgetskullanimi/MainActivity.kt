package com.example.widgetskullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.widgetskullanimi.ui.theme.WidgetsKullanimiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WidgetsKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SayfaSwitch()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WidgetsKullanimiTheme {
        SayfaSwitch()
    }
}


@Composable
fun SayfaSwitch() {
    val switchDurum = remember { mutableStateOf(false) }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = switchDurum.value,
            onCheckedChange = {
                switchDurum.value = it
                Log.e("Switch Seçildi", it.toString())
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Red,
                checkedThumbColor = Color.White,
                uncheckedTrackColor = Color.DarkGray,
                uncheckedThumbColor = Color.LightGray
            )
        )
        
        Button(onClick = {
            Log.e("Switch en son durum", switchDurum.value.toString())
        }) {
            Text(text = "Göster")
            
        }
    }

}


@Composable
fun SayfaFab() {
    Scaffold (
        content = {
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Log.e("Fab", "Tıklandı")
                },
                containerColor = Color.Red,
                content = {
                    Icon(painter = painterResource(id = R.drawable.ekle_resim), contentDescription = "", tint = Color.White)
                }
            )
        }
    )

}
@Composable
fun SayfaExtend() {
    Scaffold (
        content = {
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    Log.e("Fab", "Tıklandı")
                },
                text = { Text(text = "Ekle", color = Color.White)},
                containerColor = Color.Red,
                icon = {
                    Icon(painter = painterResource(id = R.drawable.ekle_resim), contentDescription = "", tint = Color.White)
                }
            )
        }
    )

}

@Composable
fun SayfaButtonTextField() {

    val tf = remember { mutableStateOf("") }
    val tfOutlined = remember { mutableStateOf("") }
    val alinanVeri = remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = "Gelen Veri : ${alinanVeri.value}",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            style = TextStyle(
                background = Color.Green
            )
        )

        TextField(
            value = tf.value,
            onValueChange = { tf.value= it },
            label = { Text(text = "Veri Giriniz")},
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedIndicatorColor = Color.Red,
                focusedLabelColor = Color.Yellow
            ),
            visualTransformation = PasswordVisualTransformation(), // şifre girme özelliği verdik
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) //Klavyenin özelliği number dediğimizde sayılar klavyesi açılır
            ) //placeholder kısmı
        
        Button(onClick = {
            alinanVeri.value = tf.value //textfield içerisindeki içeriğini alinan veriye aktarıyoruz
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.Cyan),
            shape = RoundedCornerShape(50)

        ) {
            Text(text = "Veriyi Al")
        }

//----------------------------------------------------------------------------------------------

        OutlinedTextField(
            value = tfOutlined.value,
            onValueChange = { tfOutlined.value= it },
            label = { Text(text = "Veri Giriniz")} ) //placeholder kısmı

        OutlinedButton(onClick = {
            alinanVeri.value = tfOutlined.value //textfield içerisindeki içeriğini alinan veriye aktarıyoruz
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.DarkGray),
            shape = RoundedCornerShape(50)

            ) {
            Text(text = "Veriyi Al Outlined")
        }
    }

}

