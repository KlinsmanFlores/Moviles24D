package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.example.exploracioncomponentes.ui.theme.ExploracionComponentesTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

@Composable
fun ComponentSelector() {
    var selectedComponent by remember { mutableStateOf("LazyColumn") }

    Column {
        // Selector básico con más componentes
        LazyRow(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val components = listOf(
                "LazyColumn", "LazyRow", "Grid", "Scaffold", "Surface", "FlowRow",
                "Box", "Column", "Row", "Dialog", "Card", "Checkbox", "RadioButton",
                "Slider", "Switch", "TextField", "Button", "Pager", "TabRow",
                "Dropdown", "Progress", "Snackbar", "FAB", "Chip", "TopAppBar",
                "BottomNav", "Spacer", "Image", "Icon", "Divider"
            )

            items(components) { component ->
                FilterChip(
                    onClick = { selectedComponent = component },
                    label = { Text(component, fontSize = 12.sp) },
                    selected = selectedComponent == component
                )
            }
        }

        Divider()

        // Mostrar componente seleccionado
        Box(modifier = Modifier.fillMaxSize()) {
            when (selectedComponent) {
                // CONTENEDORES
                "LazyColumn" -> MiLazyColumn()
                "LazyRow" -> MiLazyRow()
                "Grid" -> MiGrid()
                "Scaffold" -> MiScaffold()
                "Surface" -> MiSurface()
                "FlowRow" -> MiFlowRow()
                "Box" -> MiBox()
                "Column" -> MiColumn()
                "Row" -> MiRow()
                "Card" -> MiCard()

                // CONTROLES
                "Button" -> MiButton()
                "TextField" -> MiTextField()
                "Checkbox" -> MiCheckbox()
                "RadioButton" -> MiRadioGroup()
                "Slider" -> MiSlider()
                "Switch" -> MiSwitch()
                "Dialog" -> MiAlertDialog()
                "Dropdown" -> MiDropdown()
                "Pager" -> MiPager()
                "TabRow" -> MiTabRow()
                "Progress" -> MiProgress()
                //"Snackbar" -> MiSnackbar()
                "FAB" -> MiFAB()
                //"Chip" -> MiChip()
                //"TopAppBar" -> MiTopAppBar()
                "BottomNav" -> MiBottomNav()
                "Spacer" -> MiSpacer()
                "Image" -> MiImage()
                "Icon" -> MiIcon()
                "Divider" -> MiDivider()

                else -> MiLazyColumn()
            }
        }
    }
}

// ============ CONTENEDORES ============

@Composable
fun MiLazyColumn() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(10) { index ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Text("LazyColumn Item $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun MiLazyRow() {
    LazyRow(modifier = Modifier.padding(16.dp)) {
        items(8) { index ->
            Card(modifier = Modifier.size(100.dp).padding(4.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("$index")
                }
            }
        }
    }
}

@Composable
fun MiGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp)
    ) {
        items(12) { index ->
            Card(modifier = Modifier.padding(4.dp).height(80.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("Grid $index")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiScaffold() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("TopAppBar") }) },
        floatingActionButton = { FloatingActionButton(onClick = {}) { Text("+") } },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true, onClick = {},
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false, onClick = {},
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Profile") }
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("Scaffold Content")
        }
    }
}

@Composable
fun MiSurface() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.size(200.dp),
            shadowElevation = 8.dp
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text("Surface")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MiFlowRow() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("FlowRow:")
        FlowRow {
            repeat(10) { index ->
                AssistChip(onClick = {}, label = { Text("Chip $index") })
            }
        }
    }
}

@Composable
fun MiBox() {
    Box(modifier = Modifier.fillMaxSize()) {
        Card(modifier = Modifier.size(100.dp).align(Alignment.TopStart)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text("Top")
            }
        }
        Card(modifier = Modifier.size(100.dp).align(Alignment.Center)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text("Center")
            }
        }
        Card(modifier = Modifier.size(100.dp).align(Alignment.BottomEnd)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text("Bottom")
            }
        }
    }
}

@Composable
fun MiColumn() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(5) { index ->
            Card(modifier = Modifier.fillMaxWidth().height(60.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("Column Item $index")
                }
            }
        }
    }
}

@Composable
fun MiRow() {
    Column(modifier = Modifier.padding(16.dp)) {
        repeat(4) { rowIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(3) { colIndex ->
                    Card(modifier = Modifier.weight(1f).height(60.dp)) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Text("${rowIndex}.${colIndex}")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MiCard() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(5) { index ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Card $index")
                    Text("Card content")
                }
            }
        }
    }
}

// ============ CONTROLES ============

@Composable
fun MiButton() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = {}) { Text("Button") }
        ElevatedButton(onClick = {}) { Text("ElevatedButton") }
        FilledTonalButton(onClick = {}) { Text("FilledTonalButton") }
        OutlinedButton(onClick = {}) { Text("OutlinedButton") }
        TextButton(onClick = {}) { Text("TextButton") }
        IconButton(onClick = {}) { Icon(Icons.Default.Favorite, contentDescription = null) }
    }
}

@Composable
fun MiTextField() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("TextField") }
        )
        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("OutlinedTextField") }
        )
    }
}

@Composable
fun MiCheckbox() {
    var checked by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text("Checkbox 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked2, onCheckedChange = { checked2 = it })
            Text("Checkbox 2")
        }
    }
}

@Composable
fun MiRadioGroup() {
    var selected by remember { mutableStateOf("Option 1") }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selected == option,
                    onClick = { selected = option }
                )
                Text(option)
            }
        }
    }
}

@Composable
fun MiSlider() {
    var value by remember { mutableStateOf(50f) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Value: ${value.toInt()}")
        Slider(value = value, onValueChange = { value = it }, valueRange = 0f..100f)
    }
}

@Composable
fun MiSwitch() {
    var switch1 by remember { mutableStateOf(false) }
    var switch2 by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("WiFi")
            Switch(checked = switch1, onCheckedChange = { switch1 = it })
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Bluetooth")
            Switch(checked = switch2, onCheckedChange = { switch2 = it })
        }
    }
}

@Composable
fun MiAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Dialog Title") },
                text = { Text("Dialog content") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) { Text("OK") }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) { Text("Cancel") }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("Select option") }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = { selected = option; expanded = false }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MiPager() {
    val pagerState = rememberPagerState(pageCount = { 3 })

    Column {
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Page ${page + 1}")
            }
        }
        Text("Swipe to navigate", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun MiTabRow() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    Column {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Content of ${tabs[selectedTab]}")
        }
    }
}

@Composable
fun MiProgress() {
    var progress by remember { mutableStateOf(0.3f) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(100)
            progress = (progress + 0.01f) % 1f
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        LinearProgressIndicator(progress = progress)
        CircularProgressIndicator(progress = progress)
        CircularProgressIndicator()
    }
}


@Composable
fun MiFAB() {
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
        }

        SmallFloatingActionButton(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
        ) {
            Icon(Icons.Default.Edit, contentDescription = null)
        }

        ExtendedFloatingActionButton(
            onClick = {},
            text = { Text("Extended") },
            icon = { Icon(Icons.Default.Add, contentDescription = null) },
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun MiBottomNav() {
    var selectedItem by remember { mutableStateOf(0) }

    Column {
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text("Bottom Navigation Demo")
        }

        NavigationBar {
            listOf("Home", "Search", "Profile").forEachIndexed { index, label ->
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text(label) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }
    }
}

@Composable
fun MiSpacer() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Before Spacer")
        Spacer(modifier = Modifier.height(50.dp))
        Text("After Spacer")
    }
}

@Composable
fun MiImage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Image component - use painterResource() or rememberImagePainter()")
    }
}

@Composable
fun MiIcon() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(Icons.Default.Home, contentDescription = null)
        Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.Red)
        Icon(Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(48.dp))
    }
}

@Composable
fun MiDivider() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Item 1")
        Divider()
        Text("Item 2")
        HorizontalDivider()
        Text("Item 3")
    }
}