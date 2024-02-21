package com.example.designcomponents.ui

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import com.example.designcomponents.R
import com.google.android.material.tabs.TabLayout

class CustomChipTabLayout : TabLayout {
    constructor(context: Context) : super(context) {
        initUi()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context, attrs
    ) {
        initUi()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        initUi()

    }

    private fun initUi() {
        setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        setTabTextColors(
            ContextCompat.getColor(context, R.color.textColor),
            ContextCompat.getColor(context, R.color.primaryColor)
        )
        tabRippleColor = null
        setPadding(0, 0, dpToPx(24f), 0)
        setSelectedTabIndicatorColor(Color.parseColor("#00000000"))
        setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_CENTER)
        tabIndicatorAnimationMode = INDICATOR_ANIMATION_MODE_ELASTIC
    }

    fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
    fun Context.dpToPx(dp: Float): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

}