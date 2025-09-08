package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4) // Verde menta claro
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Espaciador superior para centrar el contenido
        Spacer(modifier = Modifier.weight(1f))

        // Sección superior con logo, nombre y título
        ProfileSection()

        // Espaciador entre secciones
        Spacer(modifier = Modifier.weight(1f))

        // Sección inferior con información de contacto
        ContactSection()

        // Espaciador inferior
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 24.dp)
    ) {
        // Logo de Android
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(
                    color = Color(0xFF073042), // Azul oscuro del logo
                    shape = MaterialTheme.shapes.medium
                ),
            contentAlignment = Alignment.Center
        ) {
            // Simulación del logo de Android (usando texto)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🤖",
                    fontSize = 40.sp,
                    color = Color(0xFF3DDC84) // Verde Android
                )
                Text(
                    text = "android",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Nombre
        Text(
            text = "Jennifer Doe",
            fontSize = 42.sp,
            fontWeight = FontWeight.Light,
            color = Color(0xFF2B2B2B),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título profesional
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF006D3B), // Verde oscuro
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Teléfono
        ContactItem(
            icon = Icons.Rounded.Phone,
            text = "+11 (123) 444 555 666",
            iconColor = Color(0xFF006D3B)
        )

        // Redes sociales / Handle
        ContactItem(
            icon = Icons.Rounded.Share,
            text = "@AndroidDev",
            iconColor = Color(0xFF006D3B)
        )

        // Email
        ContactItem(
            icon = Icons.Rounded.Email,
            text = "jen.doe@android.com",
            iconColor = Color(0xFF006D3B)
        )
    }
}

@Composable
fun ContactItem(
    icon: ImageVector,
    text: String,
    iconColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Icono
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(24.dp))

        // Texto
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(0xFF2B2B2B),
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFD2E8D4)
        ) {
            BusinessCard()
        }
    }
}