package com.example.testbottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val bottomSheet: LinearLayout by lazy{findViewById<LinearLayout>(R.id.bottom_sheet)}
    lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bottom sheet의 behavior를 .from 메소드를 이용해 받아온다.
        sheetBehavior= BottomSheetBehavior.from(bottomSheet)
        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //슬라이드 될 때
            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED-> {
                        Toast.makeText(applicationContext,"최소화",Toast.LENGTH_LONG).show()
                    }
                    BottomSheetBehavior.STATE_DRAGGING-> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED-> {
                        Toast.makeText(applicationContext,"확장",Toast.LENGTH_LONG).show()
                    }
                    BottomSheetBehavior.STATE_HIDDEN-> {
                    }
                    BottomSheetBehavior.STATE_SETTLING-> {
                    }
                }
            }
        })
        //열기 닫기 버튼 클릭 리스너
        button_open.setOnClickListener {
            sheetBehavior.state=BottomSheetBehavior.STATE_EXPANDED
        }
        button_close.setOnClickListener {
            sheetBehavior.state=BottomSheetBehavior.STATE_HIDDEN
        }
    }
}