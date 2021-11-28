package com.example.customcard

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class CustomView(context: Context, attrs: AttributeSet?) :
    CardView(context, attrs) {
    private val attributes: TypedArray
    private val imageView: ImageView
    private val textView1: TextView
    private val descView: TextView
    var root: ViewGroup? = null
    private fun setText(text: String?) {
        textView1.text = text
    }

    private fun setDescription(description: String?) {
        descView.text = description
    }

    init {
        inflate(context, R.layout.custom_view, also { root = it })
        attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        imageView = findViewById(R.id.image_view)
        textView1 = findViewById(R.id.text_view)
        descView = findViewById(R.id.text_view_description)
        imageView.setImageResource(
            attributes.getResourceId(
                R.styleable.CustomView_Image,
                R.color.black
            )
        )
        setText(attributes.getString(R.styleable.CustomView_Text))
        setDescription(attributes.getString(R.styleable.CustomView_Description))
    }
}
