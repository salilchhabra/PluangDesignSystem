package com.example.designcomponents.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.designcomponents.R

enum class ChipState {
    INACTIVE, ACTIVE_PRIMARY, ACTIVE_SECONDARY, DISABLED, DANGER, WITHOUT_BACKGROUND
}

enum class ChipIconState {
    NO_ICON, LEFT_ICON, RIGHT_ICON, ONLY_ICON, MIDDLE_ICON, TWO_ICONS
}

enum class LabelState {
    PRIMARY_DEFAULT, PRIMARY_SUCCESS, PRIMARY_WARNING, PRIMARY_ERROR, PRIMARY_INFO, PRIMARY_INTERMEDIATE, PRIMARY_ADVANCE, PRIMARY_NEUTRAL, SECONDARY_DEFAULT, SECONDARY_SUCCESS, SECONDARY_WARNING, SECONDARY_ERROR, SECONDARY_INFO, SECONDARY_INTERMEDIATE, SECONDARY_ADVANCE, SECONDARY_NEUTRAL
}

fun Context.getCustomChipView(chipState: ChipState, chipIconState: ChipIconState): View {
    val view: View = LayoutInflater.from(this).inflate(R.layout.layout_custom_chip, null)
    val text = view.findViewById<AppCompatTextView>(R.id.tv_name)
    val leftIcon = view.findViewById<AppCompatImageView>(R.id.iv_left)
    val rightIcon = view.findViewById<AppCompatImageView>(R.id.iv_right)
    when (chipIconState) {
        ChipIconState.NO_ICON -> {
            setViewVisibilities(View.GONE, leftIcon, rightIcon)
        }

        ChipIconState.LEFT_ICON -> {
            leftIcon.showView()
            rightIcon.hideView()
        }

        ChipIconState.RIGHT_ICON -> {
            leftIcon.hideView()
            rightIcon.showView()
        }

        ChipIconState.ONLY_ICON -> {
            leftIcon.hideView()
            rightIcon.showView()
            text.hideView()
        }

        else -> {}
    }
    when (chipState) {
        ChipState.INACTIVE -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_gray9ba2_corner20_solid_body
            )
            text.setTextColor(ContextCompat.getColor(this, R.color.textColor))
        }

        ChipState.ACTIVE_PRIMARY -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_blue_corners20dp_solid_body
            )
            text.setTextColor(ContextCompat.getColor(this, R.color.white))
        }

        ChipState.ACTIVE_SECONDARY -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_blue_stroke_blue_20_solid_body
            )
            text.setTextColor(ContextCompat.getColor(this, R.color.primaryColor))
        }

        ChipState.DISABLED -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_gray_stroke_gray_20_solid_body
            )
            text.setTextColor(ContextCompat.getColor(this, R.color.grayA0A4AB))
        }

        ChipState.DANGER -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_redff5_white_corner20_solid_body
            )
            text.setTextColor(ContextCompat.getColor(this, R.color.redFF5))
        }
        ChipState.WITHOUT_BACKGROUND -> {
            view.background = null
            text.setTextColor(ContextCompat.getColor(this, R.color.textColor))
        }
    }
    return view
}
fun Context.getCustomLabelView(labelState: LabelState, labelIconState: ChipIconState): View {
    val view: View = if (labelIconState == ChipIconState.TWO_ICONS) {
        LayoutInflater.from(this).inflate(R.layout.layout_custom_label_two, null)
    } else {
        LayoutInflater.from(this).inflate(R.layout.layout_custom_label, null)
    }
    val leftIcon = view.findViewById<AppCompatImageView>(R.id.iv_left)
    val rightIcon = view.findViewById<AppCompatImageView>(R.id.iv_right)
    val text1 = view.findViewById<AppCompatTextView>(R.id.tv_name_one)
    lateinit var text2: AppCompatTextView
    lateinit var middleIcon: AppCompatImageView
    if (labelIconState != ChipIconState.TWO_ICONS) {
        text2 = view.findViewById(R.id.tv_name_two)
        middleIcon = view.findViewById(R.id.iv_middle)
    }
    when (labelIconState) {
        ChipIconState.NO_ICON -> {
            text1.showView()
            setViewVisibilities(View.GONE, leftIcon, rightIcon, text2, middleIcon)
        }

        ChipIconState.LEFT_ICON -> {
            setViewVisibilities(View.VISIBLE, text1, leftIcon)
            setViewVisibilities(View.GONE, rightIcon, text2, middleIcon)
        }

        ChipIconState.RIGHT_ICON -> {
            setViewVisibilities(View.VISIBLE, text2, rightIcon)
            setViewVisibilities(View.GONE, leftIcon, text1, middleIcon)
        }

        ChipIconState.MIDDLE_ICON -> {
            setViewVisibilities(View.VISIBLE, text2, text1, middleIcon)
            setViewVisibilities(View.GONE, leftIcon, rightIcon)
        }

        ChipIconState.TWO_ICONS -> {
            setViewVisibilities(View.VISIBLE, leftIcon, text1, rightIcon)
        }

        else -> {}
    }
    when (labelState) {

        LabelState.PRIMARY_DEFAULT -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_blue006f_corners4dp_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.white))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }

        LabelState.PRIMARY_SUCCESS -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_greend1fc_corners4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.white))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }

        LabelState.PRIMARY_WARNING -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_orangeffb5_corners4dp_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.white))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }

        LabelState.PRIMARY_ERROR -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_redff5_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.white))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }

        LabelState.PRIMARY_INFO -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_grayeb_4_empty_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            }
        }

        LabelState.PRIMARY_INTERMEDIATE -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_blue008_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.white))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }

        LabelState.PRIMARY_ADVANCE -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_magentafd00_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.white))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }

        LabelState.PRIMARY_NEUTRAL -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_grayd5_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            }
        }

        LabelState.SECONDARY_DEFAULT -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_blueeef_bluebcb_corners4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.primaryColor))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.primaryColor))
            }
        }

        LabelState.SECONDARY_SUCCESS -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_greend8f_corners4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.green1FC))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.green1FC))
            }
        }

        LabelState.SECONDARY_WARNING -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_orangefff_orangeffe_corners4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.yellowFF8))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.yellowFF8))
            }
        }

        LabelState.SECONDARY_ERROR -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_redfff_redffcb_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.redFF5))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.redFF5))
            }
        }

        LabelState.SECONDARY_INFO -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_grayeb_4_empty_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            }
        }

        LabelState.SECONDARY_INTERMEDIATE -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_bluecde_blue90c_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.blue008))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.blue008))
            }
        }

        LabelState.SECONDARY_ADVANCE -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_magentaffd_magentafe9_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.megantaFD00))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.megantaFD00))
            }
        }

        LabelState.SECONDARY_NEUTRAL -> {
            view.background = ContextCompat.getDrawable(
                this, R.drawable.background_rect_grayf3f_graye6e_corner4_solid_body
            )
            text1.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            if (labelIconState != ChipIconState.TWO_ICONS) {
                text2.setTextColor(ContextCompat.getColor(this, R.color.textColor))
            }
        }
    }
    return view
}


fun View.showView() {
    visibility = View.VISIBLE
}

fun View.hideView() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun setViewVisibilities(visibility: Int, vararg view: View) {
    for (v in view) v.visibility = visibility
}
