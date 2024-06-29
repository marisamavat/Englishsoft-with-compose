package bottombar


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
            import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
            import androidx.compose.ui.Alignment
            import androidx.compose.ui.Modifier
            import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
            import androidx.compose.ui.text.style.TextAlign
            import androidx.compose.ui.text.style.TextOverflow
import com.example.englishsoft.R

@Composable
            fun about() {
                LazyColumn( ){
                    item { updatebutton() }
                    item { textabout() }
                }

            }
    @Composable
    fun updatebutton() {
        Spacer(modifier = Modifier.size(10.dp))
        Column ( horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier.padding(10.dp))
        {
            Text(text = "To update the program to a newer version, please click below",
                color= Color.Blue,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedButton(shape= RoundedCornerShape(10.dp)
                , colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                border = BorderStroke(2.dp , Color.Black)
                ,onClick = { /*TODO*/ } ) {
                Text(text = "update")

            }
        }

    }

    @Composable
    fun textabout() {
        Column (Modifier.padding(10.dp)) {
            Text(
                stringResource(id = R.string.about),
                maxLines = 25
                ,overflow = TextOverflow.Ellipsis
                , textAlign = TextAlign.Start)
        }

    }