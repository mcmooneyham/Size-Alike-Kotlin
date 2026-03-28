package com.mcmooneyham.exampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mcmooneyham.exampleproject.ui.theme.ExampleProjectTheme
import com.sizealike.count
import com.sizealike.length
import com.sizealike.size

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleProjectTheme {
                SizeAlikeDemo()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SizeAlikeDemo() {
    val string = "Hello, world!"
    val list = listOf(1, 2, 3, 4, 5)
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    val set = setOf("kotlin", "size", "alike")
    val array = intArrayOf(10, 20, 30)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("SizeAlike") }) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            item { SectionHeader("String — \"$string\"") }
            item { PropertyRow(".length", string.length) }
            item { PropertyRow(".size", string.size) }
            item { PropertyRow(".count", string.count) }

            item { HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp)) }

            item { SectionHeader("List — $list") }
            item { PropertyRow(".size", list.size) }
            item { PropertyRow(".length", list.length) }
            item { PropertyRow(".count", list.count) }

            item { HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp)) }

            item { SectionHeader("Map — {${map.keys.sorted().joinToString(", ")}}") }
            item { PropertyRow(".size", map.size) }
            item { PropertyRow(".length", map.length) }
            item { PropertyRow(".count", map.count) }

            item { HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp)) }

            item { SectionHeader("Set — {${set.sorted().joinToString(", ")}}") }
            item { PropertyRow(".size", set.size) }
            item { PropertyRow(".length", set.length) }
            item { PropertyRow(".count", set.count) }

            item { HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp)) }

            item { SectionHeader("IntArray — [10, 20, 30]") }
            item { PropertyRow(".size", array.size) }
            item { PropertyRow(".length", array.length) }
            item { PropertyRow(".count", array.count) }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
    )
}

@Composable
fun PropertyRow(label: String, value: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = "$value",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SizeAlikeDemoPreview() {
    ExampleProjectTheme {
        SizeAlikeDemo()
    }
}
