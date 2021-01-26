package com.skarra.basetask.app.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import com.skarra.basetask.R


class SkipHeaderLineDividerItemDecoration(val context: Context) : RecyclerView.ItemDecoration() {
    private val mDivider: Drawable = context.resources.getDrawable(R.drawable.line_divider, null)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        for (i in 1 until childCount - 1) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight
            val left = child.left + child.paddingStart
            val right = child.right - child.paddingEnd

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }
}