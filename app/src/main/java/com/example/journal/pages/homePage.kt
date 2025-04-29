package com.example.journal.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.journal.R
import com.example.journal.ui.theme.JournalTheme
import com.example.journal.ui.theme.TimberWolf

@Composable
fun HomePage() {
    var journalPassword by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon: Painter = if (passwordVisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else
        painterResource(id = R.drawable.baseline_visibility_off_24)

    Column(
        modifier = Modifier
            .background(TimberWolf)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "GÜNLÜK",
            color = Color(0xFF2D3142),
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(7.dp))
        HorizontalDivider(
            thickness = 2.dp,
            color = Color(0xFF2D3142),
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(start = 20.dp, end = 20.dp),
            value = journalPassword,
            onValueChange = {
                journalPassword = it
            },
            placeholder = {
                Text(
                    text = "Günlük Şifre",
                    fontSize = 16.sp,
                    color = Color(0xFF2D3142)
                )
            },
            label = {
                Text(
                    text = "Günlük Şifre",
                    fontSize = 16.sp,
                    color = Color(0xFF2D3142)
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        tint = Color(0xFF2D3142)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF2D3142),
                unfocusedTextColor = Color(0xFF2D3142),
                focusedLabelColor = Color(0xFF2D3142),
                unfocusedLabelColor = Color(0xFF2D3142)
            )
        )
        Spacer(modifier = Modifier.height(17.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            onClick = { /* DataStore kayıt işlemi sha250*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF2D3142))
        ) {
            Text(
                text = "Giriş",
                fontSize = 16.sp,
                color = Color(0xFFD8D4C8),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(7.dp)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    JournalTheme {
        HomePage()
    }
}