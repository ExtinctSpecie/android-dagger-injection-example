package com.skarra.basetask.app

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun ImageView.bindUrl(url: String?) {
        url?.let {
            Glide.with(this)
                .load(url)
                .into(this)
        }
    }

    @BindingAdapter("visibleOrGone")
    @JvmStatic
    fun View.bindVisibleOrGone(visible: Boolean?) {
        this.visibility = if (visible == true) View.VISIBLE else View.GONE
    }
}