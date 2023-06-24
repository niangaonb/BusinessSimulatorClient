import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun BSMain() {
    MaterialTheme {
        Column {
            Button(onClick = { println("单人模式")}) {
                Text("单人模式")
            }
            Button(onClick = { println("多人模式")}) {
                Text("多人模式")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "营业模拟器") {
        BSMain()
    }
}
