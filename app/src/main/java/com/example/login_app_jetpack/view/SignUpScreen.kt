import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Sign Up", color = Color.Black)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                       Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon",
                           tint = Color.Black
                           )
                    }
                },
                backgroundColor = Color.White,
                //MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 5.dp
            )
        }, content = { its ->
            Column(
                modifier = Modifier
                    .padding(its)
                    .padding(16.dp)
            ) {

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    singleLine = true,
                    label = { Text("Name") },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && name.isEmpty()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    singleLine = true,
                    label = { Text("Last Name") },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && lastName.isEmpty()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    singleLine = true,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && email.isEmpty()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Address") },
                    singleLine = true,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && address.isEmpty()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth(),
                    isError = showError && password.isEmpty()
                )


                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        showError = name.isEmpty() || lastName.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty()
                        if (!showError) {
                            navController.navigate("otp")
                        }
                    },
                    shape = RoundedCornerShape(8.dp), // Square rounded corners

                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .fillMaxWidth().padding(horizontal = 60.dp, vertical = 10.dp)

                ) {
                    Text("Sign Up",fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.W600,
                        modifier = Modifier.padding(10.dp))
                }
            }

        })



}