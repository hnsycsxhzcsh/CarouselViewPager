package com.carouselviewpager

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class VpCarouselAdapter(
    private var mContext: Context,
    private var maxVppage: Int,
    private var picUrlList: MutableList<String>
) :
    PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return maxVppage
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val tempPosition = position % picUrlList.size  //用户可见的position
        val textView = TextView(mContext)
        textView.text = tempPosition.toString()
        if (tempPosition % 3 == 0) {
//            textView.setTextColor(Color.RED)
            textView.setBackgroundColor(Color.RED)
        } else if (tempPosition % 3 == 1) {
//            textView.setTextColor(Color.GREEN)
            textView.setBackgroundColor(Color.GREEN)
        } else {
//            textView.setTextColor(Color.BLUE)
            textView.setBackgroundColor(Color.BLUE)
        }
        container.addView(textView)
        return textView
    }
}