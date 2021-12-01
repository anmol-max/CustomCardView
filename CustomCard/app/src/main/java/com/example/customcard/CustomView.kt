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
    private val brandName: TextView
    private val productName: TextView
    private val itemNumber:TextView
    private val note:TextView
    private val price:TextView
    var root: ViewGroup? = null
    private fun seBrandName(text: String?) {
        brandName.text = text
    }

    private fun setProdName(prodName: String?) {
        productName.text = prodName
    }
    private fun setItemNum(item: String?){
        itemNumber.text=item
    }
    private fun setNote(noteText:String?){
        note.text=noteText
    }
    private fun setPrice(priceText:String?){
        price.text=priceText
    }

    init {
        inflate(context, R.layout.custom_view, also { root = it })
        attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        imageView = findViewById(R.id.image_view)
        brandName = findViewById(R.id.textViewBrandName)
        productName = findViewById(R.id.textViewProductName)
        itemNumber=findViewById(R.id.textViewItemNumber)
        note=findViewById(R.id.textViewNote)
        price=findViewById(R.id.textViewPrice)
        imageView.setImageResource(
            attributes.getResourceId(
                R.styleable.CustomView_Image,
                R.color.black
            )
        )
        seBrandName(attributes.getString(R.styleable.CustomView_BrandName))
        setProdName(attributes.getString(R.styleable.CustomView_ProductName))
        setItemNum(attributes.getString(R.styleable.CustomView_ItemNumber))
        setNote(attributes.getString(R.styleable.CustomView_Note))
        setPrice(attributes.getString(R.styleable.CustomView_Price))
    }
}
