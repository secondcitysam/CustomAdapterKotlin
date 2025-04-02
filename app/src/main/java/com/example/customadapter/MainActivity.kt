package com.example.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView : ListView = findViewById(R.id.listView)

        val arrayList = listOf(

            Item("Mercury","The smallest planet in the solar system ",R.drawable.mercury),
            Item("Venus","The hottest plant in the solar system",R.drawable.venus),
            Item("Earth","The only planet to harbor life in the solar system",R.drawable.earth),
            Item("Mars","Often called the \"Red Planet\" due to the iron oxide (rust) on its surface.",R.drawable.mars),
            Item("Jupiter","The largest planet in our solar system, with a Great Red Spot that is a giant storm.",R.drawable.jupiter),
            Item("Saturn","Known for its prominent ring system, made of ice and rock particles.",R.drawable.saturn),
            Item("Uranus","Rotates on its side, with its axis of rotation almost parallel to the plane of its orbit.",R.drawable.uranus),
            Item("Neptune","Has the strongest winds in the solar system, reaching speeds of up to 2,000 kilometers per hour (1,240 mph).",R.drawable.neptune),
        )

        val adapter = CustomAdapter(this,arrayList)
        listView.adapter = adapter
    }
}