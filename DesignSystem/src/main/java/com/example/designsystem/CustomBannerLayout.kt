package com.example.designcomponents.ui

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.designcomponents.R

class CustomBannerLayout : ConstraintLayout {
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
        inflate(context, R.layout.layout_custom_banner, this)
    }

    fun setBackground(state: BannerState) {
        val parentLayout = findViewById<ConstraintLayout>(R.id.cl_parent)
        when (state) {
            BannerState.NEUTRAL -> {
                parentLayout.background = ContextCompat.getDrawable(
                    parentLayout.context,
                    R.drawable.background_rect_bluee6_corners12_solid_body
                )
            }

            BannerState.SUCCESS -> {
                parentLayout.background = ContextCompat.getDrawable(
                    parentLayout.context,
                    R.drawable.background_rect_greend8f_green1fc_corners12_solid_body
                )
            }

            BannerState.WARNING -> {
                parentLayout.background = ContextCompat.getDrawable(
                    parentLayout.context,
                    R.drawable.background_rect_orangeffaf_corners_12_solid_body
                )
            }

            BannerState.ERROR -> {
                parentLayout.background = ContextCompat.getDrawable(
                    parentLayout.context,
                    R.drawable.background_rect_redfff_stroke_redff5_corner12_solid_body
                )
            }

            BannerState.INFO -> {
                parentLayout.background = ContextCompat.getDrawable(
                    parentLayout.context,
                    R.drawable.background_rect_greye6_corner12_white_solid_body
                )
            }
        }
    }


}
enum class BannerState {
    NEUTRAL, SUCCESS, WARNING, ERROR, INFO
}