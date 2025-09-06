package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.exploracioncomponentes.ui.theme.ExploracionComponentesTheme


// Selector de componentes para probar fácilmente
@Composable
fun ComponentSelector() {
    var selectedComponent by remember { mutableStateOf("LazyColumn") }

    Column {
        // Selector de componentes
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { selectedComponent = "LazyColumn" },
                colors = if (selectedComponent == "LazyColumn")
                    ButtonDefaults.buttonColors()
                else
                    ButtonDefaults.outlinedButtonColors()
            ) {
                Text("LazyColumn", fontSize = 10.sp)
            }
            Button(
                onClick = { selectedComponent = "Scaffold" },
                colors = if (selectedComponent == "Scaffold")
                    ButtonDefaults.buttonColors()
                else
                    ButtonDefaults.outlinedButtonColors()
            ) {
                Text("Scaffold", fontSize = 10.sp)
            }
            Button(
                onClick = { selectedComponent = "Dialog" },
                colors = if (selectedComponent == "Dialog")
                    ButtonDefaults.buttonColors()
                else
                    ButtonDefaults.outlinedButtonColors()
            ) {
                Text("Dialog", fontSize = 10.sp)
            }
        }

        // Mostrar el componente seleccionado
        Box(modifier = Modifier.fillMaxSize()) {
            when (selectedComponent) {
                "LazyColumn" -> MiLazyColumn()
                "LazyRow" -> MiLazyRow()
                "Grid" -> MiGrid()
                "Scaffold" -> MiScaffold()
                "Surface" -> MiSurface()
                "FlowRow" -> MiFlowRow()
                "Dialog" -> MiAlertDialog()
                "Card" -> MiCard()
                "Checkbox" -> MiCheckbox()
                "RadioButton" -> MiRadioGroup()
                "Slider" -> MiSlider()
                "Switch" -> MiSwitch()
                "TextField" -> MiOutlinedTextField()
                "Pager" -> MiPager()
                "TabRow" -> MiTabRow()
                else -> MiLazyColumn()
            }
        }
    }
}

// ---------------- CONTENEDORES ----------------

@Composable
fun MiLazyColumn() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        items(20) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = "Item LazyColumn $index",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun MiLazyRow() {
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        items(10) { index ->
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(80.dp)
                    .padding(horizontal = 4.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Item $index")
                }
            }
        }
    }
}

@Composable
fun MiGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        items(12) { index ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Grid $index")
                }
            }
        }
    }
}



// ✅ SCAFFOLD CORREGIDO
@OptIn(ExperimentalMaterial3Api::class) // 👈 ESTA LÍNEA FALTABA
@Composable
fun MiScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi TopAppBar") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción del FAB */ }
            ) {
                Text("+")
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Perfil") }
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Contenido del Scaffold\ncon TopBar, BottomBar y FAB",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun MiSurface() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.size(200.dp),
            color = MaterialTheme.colorScheme.primary,
            shadowElevation = 8.dp,
            shape = MaterialTheme.shapes.large
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Surface\ncon Elevación",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MiFlowRow() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        item {
            Text(
                text = "FlowRow - Se adapta al ancho:",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(15) { index ->
                    AssistChip(
                        onClick = {},
                        label = { Text("Chip $index") }
                    )
                }
            }
        }
    }
}

// ---------------- CONTROLES ----------------

@Composable
fun MiAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { showDialog = true }
        ) {
            Text("Mostrar Dialog")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Título del Dialog") },
                text = { Text("Este es el contenido del AlertDialog. Puedes poner cualquier información aquí.") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}

@Composable
fun MiCard() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(5) { index ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Card $index",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "Este es el contenido de la card. Puede tener texto, imágenes, botones, etc.",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MiCheckbox() {
    var checkedStates by remember { mutableStateOf(List(5) { false }) }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        item {
            Text(
                text = "Checkboxes:",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(checkedStates.size) { index ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Checkbox(
                    checked = checkedStates[index],
                    onCheckedChange = { isChecked ->
                        checkedStates = checkedStates.toMutableList().apply {
                            this[index] = isChecked
                        }
                    }
                )
                Text(
                    text = "Opción ${index + 1}",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun MiRadioGroup() {
    var selectedOption by remember { mutableStateOf("Opción 1") }
    val options = listOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "RadioButtons:",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option }
                )
                Text(
                    text = option,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Text(
            text = "Seleccionado: $selectedOption",
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun MiSlider() {
    var sliderValue by remember { mutableStateOf(50f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Slider Value: ${sliderValue.toInt()}",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun MiSwitch() {
    var switches by remember { mutableStateOf(List(4) { false }) }
    val labels = listOf("Wi-Fi", "Bluetooth", "Datos móviles", "Ubicación")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Switches:",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        switches.forEachIndexed { index, isChecked ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = labels[index])
                Switch(
                    checked = isChecked,
                    onCheckedChange = { newValue ->
                        switches = switches.toMutableList().apply {
                            this[index] = newValue
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun MiOutlinedTextField() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "TextFields:",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text3,
            onValueChange = { text3 = it },
            label = { Text("Mensaje") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MiPager() {
    val pagerState = rememberPagerState(pageCount = { 4 })

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = when (page) {
                        0 -> Color.Red.copy(alpha = 0.2f)
                        1 -> Color.Green.copy(alpha = 0.2f)
                        2 -> Color.Blue.copy(alpha = 0.2f)
                        else -> Color.Yellow.copy(alpha = 0.2f)
                    }
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Página ${page + 1}",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }

        Text(
            text = "Desliza horizontalmente para cambiar de página",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun MiTabRow() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    Column {
        TabRow(
            selectedTabIndex = selectedTab
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Contenido de ${tabs[selectedTab]}",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}