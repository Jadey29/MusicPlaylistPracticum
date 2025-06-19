//Student Number:10471357
// Full Name: Jadene Naidoo
package vcmsa.jadenenaidoo.musicplaylistpracticum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.jadenenaidoo.musicplaylistpracticum.MainActivity.AppCompatActivity

class MainActivity : AppCompatActivity() {
    annotation class ratings
    annotation class AppCompatActivity

    object songTitles {

    }

} override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Four Parallel arrays to store song details
        val songTitles = arrayListOf<String>()
        val artistNames = arrayListOf<String>()
        val ratingsList = arrayListOf<Int>()
        val commentsList = arrayListOf<String>()
// Code Starts Here
//Declare UI elements
        val btnAddToPlaylist = findViewById<Button>(R.id.addPlaylist)
        val btnSecondScreen = findViewById<Button>(R.id.secondScreen)
        val btnExitApp = findViewById<Button>(R.id.exitApp)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val edtMusicTitle = findViewById<EditText>(R.id.edtMusicTitle)
        val edtText = findViewById<EditText>(R.id.edtText)
        val edtTitle = findViewById<EditText>(R.id.edtTitle)
        val edtArtist = findViewById<EditText>(R.id.edtArtist)
        val edtRating = findViewById<EditText>(R.id.edtRating)
        val edtComments = findViewById<EditText>(R.id.edtComments)

//Add Song
        btnAddToPlaylist.setOnClickListener {
            try {
                val title = edtTitle.text.toString()
                val artist = edtArtist.text.toString()
                val ratingString = edtRating.text.toString()
                val commentsInput = edtComments.text.toString()

                if (title.isNotEmpty() && artist.isNotEmpty() && ratingString.isNotEmpty()) {

                    val rating = ratingString.toInt()
                    if (rating in 1..5) {
                        songTitles.add(title)
                        artistNames.add(artist)
                        ratingsList.add(rating)
                        commentsList.add(commentsInput)
                        Toast.makeText(this, "Song Added", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Rating must be between 1 and 5", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid rating format", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "An error occurred: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

// Proceed to Detailed View
        btnSecondScreen.setOnClickListener {
            val intent = Intent(this, ScreenView::class.java)
            startActivity(intent)
        }

//To exit App
        btnExitApp.setOnClickListener {
            finishAffinity()
        }
    }

private fun Unit.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}

fun findViewById(i: Int) {
    TODO("Not yet implemented")
}

fun finishAffinity() {
    TODO("Not yet implemented")
}

fun startActivity(intent: Intent) {
    TODO("Not yet implemented")
}

fun enableEdgeToEdge() {
    TODO("Not yet implemented")
}
