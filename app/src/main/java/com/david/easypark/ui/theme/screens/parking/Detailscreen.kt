package com.david.easypark.ui.theme.screens.parking

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Detailscreen(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    names: Array<String>,
    descriptions: Array<String>,
    itemIndex: Int?
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {

        Box(modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ){
            Image(painter = painterResource(id = photos[itemIndex!!]),
                contentDescription = names[itemIndex],
                modifier.width(400.dp).height(200.dp).clip(RoundedCornerShape(10.dp))
            )
        }
        Text(text = names[itemIndex!!], fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
        Text(text = descriptions[itemIndex], fontSize = 18.sp)

    }

}
