package com.android.example.paintproject

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.android.example.paintproject.PaintView.Companion.currentBrush

class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var paintBrush = Paint()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val redBtn = findViewById<ImageButton>(R.id.red)
        val blueBtn = findViewById<ImageButton>(R.id.blue)
        val yellowBtn = findViewById<ImageButton>(R.id.yellow)
        val greenBtn = findViewById<ImageButton>(R.id.green)
        val eraser = findViewById<Button>(R.id.eraser)

        redBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.RED)
            currentColor(paintBrush.color)

        }

        blueBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.BLUE)
            currentColor(paintBrush.color)
        }

        yellowBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.YELLOW)
            currentColor(paintBrush.color)
        }

        greenBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.GREEN)
            currentColor(paintBrush.color)
        }

        eraser.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.WHITE)
            currentColor(paintBrush.color)
        }
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()

    }
}