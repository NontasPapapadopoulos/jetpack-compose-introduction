package com.example.jetcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField

import androidx.compose.material3.Button
import androidx.compose.material3.Divider

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetcomposetutorial.ui.theme.JetComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeTutorialTheme {
                var name by remember {
                    mutableStateOf("")
                }

                var names by remember {
                    mutableStateOf(listOf<String>())
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BasicTextField(
                            modifier = Modifier.border(2.dp, Color.Black)
                                .weight(1f)
                                .height(40.dp),

                            value = name,
                            onValueChange = { text ->
                                name = text
                            },
                            textStyle = androidx.compose.ui.text.TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.DarkGray
                            )
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Button(onClick = {
                            if (name.isNotBlank()) {
                                names = names + name
                                name = ""
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }
                    LazyColumn {
                        items(names) {currentName ->
                            Text(text = currentName,
                            modifier = Modifier.fillMaxWidth()
                                .padding(16.dp)
                            )
                            Divider()
                        }
                    }
                }
            }



//    JetComposeTutorialTheme {
//            var count = remember {
//                mutableStateOf(0)
//            }
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = count.value.toString(),
//                    fontSize = 30.sp
//                )
//
//                Button(onClick = {
//                    count.value ++
//                }) {
//                    Text(text = "Click me!")
//                    }
//                }
//            }
        }
    }
}


