package vcmsa.jadenenaidoo.musicplaylistpracticum

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class ScreenView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val edtOutputView = findViewById<TextView>(R.id.edtOutputView)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnShow.setOnClickListener {
            val builder = StringBuilder()

            if (MainActivity.songTitles.isEmpty()) {
                builder.append("No songs in the playlist.")
            } else {
                for (i in MainActivity.songTitles.indices) {
                    builder.append("Song: ${MainActivity.songTitles.getOrNull(i) ?: "N/A"}\n")
                    builder.append("Artist: ${MainActivity.artistNames.getOrNull(i) ?: "N/A"}\n")
                    builder.append("Rating: ${MainActivity.ratings.getOrNull(i) ?: "N/A"}\n")
                    builder.append("Comments: ${MainActivity.comments.getOrNull(i) ?: "N/A"}\n\n")
                }
            }
            edtOutputView.text = builder.toString()
        }
        //Calculate Average
        btnAverage.setOnClickListener {
            val ratings = MainActivity.ratings
            if (ratings.isNotEmpty()) {
            val average = ratings.sum().toFloat() / ratings.size
                edtOutputView.text ="Average rating: %.2f".format(average)
            } else {
                edtOutputView.text= "No ratings available"
            }
            val average = null
            edtOutputView.text = "Average Rating: %.2f".format(average)
        }
        //Return to main screen
        btnReturn.setOnClickListener {
            finish()
        }
    }
}

private fun ViewCompat.Companion.setOnApplyWindowInsetsListener(unit: Any, function: Any) {
    TODO("Not yet implemented")
}

class ViewCompat {
    companion object

}

private fun MainActivity.songTitles.isEmpty(): Boolean {
    TODO("Not yet implemented")
}

private fun ScreenView.finish() {
    TODO("Not yet implemented")
}

private fun MainActivity.ratings.isNotEmpty(): Boolean {
    TODO("Not yet implemented")
}

private fun Unit.toFloat() {
    TODO("Not yet implemented")
}

private fun MainActivity.ratings.sum() {
    TODO("Not yet implemented")
}

private fun MainActivity.songTitles.getOrNull(value: Any): String {
    TODO("Not yet implemented")
}






