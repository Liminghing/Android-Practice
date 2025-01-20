package com.jkweyu.viewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.jkweyu.viewbinding.databinding.ActivityMainBinding

/** 액티비티에서 뷰 바인딩
 *
 * 1. 바인딩 변수 선언
 *     컴파일러에 의해 생성된 바인딩클래스을 타입으로 지정하는 binding변수 선언
 *
 * 2. 생성된 바인딩 클래스에 포함된 inflate() 메서드를 호출
 *     XML 레이아웃 파일을 읽어들여 해당 레이아웃에 대응하는 ActivityMainBinding 객체를 생성
 *
 * 3. 루트 뷰 얻기
 *     getRoot()` 메서드를 호출하거나 Kotlin 속성 구문을 사용해 루트 뷰에 대한 참조를 얻습니다.
 *
 * 4. 화면 표시하기
 *     루트 뷰를 `setContentView()`에 전달해 화면에 표시합니다.
 */

class MainActivity : AppCompatActivity() {
    /** [1. 바인딩 변수 선언]
     *  전역적으로 바이딩 변수를 선언
     *      ActivityMainBinding 타입의 binding 객체 선언
     */
    private lateinit var binding: ActivityMainBinding

    private val fragmentList = listOf(
        Fragment01(), Fragment02(), Fragment03()
    )
    private var currentFragmentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /** [2. inflate() 메서드를 호출]
         *  생성된 바인딩 클래스(ActivityMainBinding)의 inflate() 메서드 호출
         *  inflate() 메서드로 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
         *
         *  ActivityMainBinding.inflate(layoutInflater)
         *  - layoutInflater : 마크업 언어인 XML 레이아웃 파일을 실제 화면에 표시할 수 있는 View 객체로 변환해주는 도구
         *  - inflate() : View 객체를 바탕으로, 각 뷰 ID에 대한 참조를 가진 바인딩 객체를 생성
         */
        binding = ActivityMainBinding.inflate(layoutInflater)

        loadFragment(fragmentList[currentFragmentIndex])
        binding.button.setOnClickListener {
            if (currentFragmentIndex > 0) {
                currentFragmentIndex--
                loadFragment(fragmentList[currentFragmentIndex])
            }
        }
        binding.button2.setOnClickListener {
            if (currentFragmentIndex < fragmentList.size - 1) {
                currentFragmentIndex++
                loadFragment(fragmentList[currentFragmentIndex])
            }
        }
        /** [3. 루트 뷰 얻기]
         *  바인딩 인스턴스에서 루트 뷰에대한 참조 가져오기
         *  root : binding이 참조하고 있는 레이아웃의 가장 뿌리 view
         */
        val view = binding.root

        /** [4. 화면 표시하기]
         *  루트 뷰를 기반으로 setContentView()에 전달
         *  setContentView : 전달받은 뷰 객체를 기반으로 화면에 뷰들을 배치하는 역할
         */
        setContentView(view)
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.myFrame.id, fragment)
            .commit()
        when(fragment){
            is Fragment01 -> binding.fragName.text = "frag01"
            is Fragment02 -> binding.fragName.text = "frag02"
            is Fragment03 -> binding.fragName.text = "frag03"
        }
    }

}