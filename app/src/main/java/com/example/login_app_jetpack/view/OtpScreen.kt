import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import java.util.Timer
import java.util.TimerTask

@Composable
fun OtpScreen() {
    var timeLeft by remember { mutableStateOf(60) }
    var otp by remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                if (timeLeft > 0) {
                    timeLeft--
                }
            }
        }, 1000, 1000)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Text("Enter OTP",fontSize = 16.sp, fontWeight = FontWeight.W600)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = otp,
            onValueChange = { otp = it },
            label = { Text("OTP", ) },
            shape = RoundedCornerShape(50), // Rounded corners
            modifier = Modifier.fillMaxWidth(),
            // isError = showError && name.isEmpty()
        )
        Spacer(modifier = Modifier.height(16.dp))
       if (timeLeft != 0)  Text("otp has sent: $timeLeft", fontWeight = FontWeight.W500,
            modifier = Modifier.align(Alignment.CenterHorizontally)
           ) else  Button(
           onClick = {

           },
           modifier = Modifier.align(Alignment.CenterHorizontally)
               .fillMaxWidth().padding(horizontal = 60.dp, vertical = 10.dp)
           ,shape = RoundedCornerShape(10.dp)

       ) {
           Text("ReSend", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.W600,
               modifier = Modifier.padding(10.dp)
           )
       }

    }
}