package com.android.example.paintproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.android.example.paintproject.MainActivity.Companion.paintBrush
import com.android.example.paintproject.MainActivity.Companion.path


class PaintView : View {

    var params : ViewGroup.LayoutParams? = null

    // store all the paths that the user draws on the screen
    companion object {
        var pathList = ArrayList<Path>()
        val colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK

    }
    //implement constructor methods for view
    constructor(context: Context) : this(context, null){
        init()

    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()

    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()

    }

    // initalizes the brush
    private fun init(){
        paintBrush.isAntiAlias = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 8f
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x,y)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else -> return false
        }
        // something changed in the UI
        postInvalidate()
        return false;

    }
// to draw something
    override fun onDraw(canvas: Canvas) {

        //get all the paths from the added list and draw it on the screen
        for(i in pathList.indices) {
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i],paintBrush)
            invalidate()


        }

    }



}