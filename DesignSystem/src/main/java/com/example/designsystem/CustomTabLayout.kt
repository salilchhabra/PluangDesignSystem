package com.example.designcomponents.ui

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.designcomponents.R
import com.google.android.material.internal.ViewUtils.dpToPx
import com.google.android.material.tabs.TabLayout

class CustomTabLayout : TabLayout {
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
        setSelectedTabIndicatorColor(ContextCompat.getColor(context, R.color.primaryColor))
        setTabTextColors(
            ContextCompat.getColor(context, R.color.textColor),
            ContextCompat.getColor(context, R.color.primaryColor)
        )
        tabRippleColor = null
        setSelectedTabIndicatorHeight(dpToPx(2f))
        tabIndicatorAnimationMode = INDICATOR_ANIMATION_MODE_ELASTIC
    }

    private fun setTabTypeface(tab: Tab, typeface: Typeface) {
        for (i in 0 until tab.view.childCount) {
            val tabViewChild = tab.view.getChildAt(i)
            if (tabViewChild is TextView) tabViewChild.typeface = typeface
        }
    }

    fun setMediumFont(tab: Tab) {
        ResourcesCompat.getFont(context, R.font.founders_grotesk_pro_medium)
            ?.let {
                setTabTypeface(
                    tab,
                    it
                )
            }
    }

    fun setRegularFont(tab: Tab) {
        ResourcesCompat.getFont(context, R.font.founders_grotesk_pro_regular)
            ?.let {
                setTabTypeface(
                    tab,
                    it
                )
            }
    }

    fun addCustomTabWithNumber(context: Context): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_custom_tab_with_number, null)
    }

    fun addCustomTabWithIcons(context: Context): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_custom_tab_with_icons, null)
    }

    fun addCustomTabWithLabel(context: Context): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_custom_tab_with_label, null)
    }

    fun addCustomTabWithNewLabel(context: Context): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_custom_tab_with_new_label, null)
    }
    fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
    fun Context.dpToPx(dp: Float): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

}