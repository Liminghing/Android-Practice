package com.jkweyu.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/** 바인딩 클래스를 생성하지 않는 버전의 프래그먼트
 *
 * 레이아웃의 루트 뷰에 {tools:viewBindingIgnore="true"} 속성추가
 */

class Fragment03 : Fragment(R.layout.fragment_03) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** 뷰바인딩을 허용하지 않았으므로 자동을 바인딩클래스가 생성되지 않는다
         * 따라서 직접적으로 리소스ID를 통해 접근
         */
        val view = inflater.inflate(R.layout.fragment_03, container, false)
        return view
    }
}
