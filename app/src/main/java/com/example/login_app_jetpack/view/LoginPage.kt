
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginPage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", fontSize = 30.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            shape = RoundedCornerShape(50),
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibility) Icons.Filled.Lock else Icons.Default.Lock
                //   val image = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisibility) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )


        /* OutlinedTextField(
             value = password,
             onValueChange = { password = it },
             label = { Text("Password") },
             singleLine = true,
             visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
             trailingIcon = {
                 IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                     Icon(
                         painter = painterResource(id = if (passwordVisibility) R.drawable.ic_visibility_off else R.drawable.ic_visibility),
                         contentDescription = "Toggle password visibility"
                     )
                 }
             },
             modifier = Modifier.fillMaxWidth()
         )*/

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("signup") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .fillMaxWidth().padding(horizontal = 60.dp, vertical = 10.dp)
              ,shape = RoundedCornerShape(10.dp)

        ) {
            Text("Login", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.W600,
                modifier = Modifier.padding(10.dp)
                )
        }
    }
}