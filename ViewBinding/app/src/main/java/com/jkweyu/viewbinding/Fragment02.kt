package com.jkweyu.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jkweyu.viewbinding.databinding.Fragment02Binding

/** 다양한 구성에 대한 힌트 제공
 *  가로,세로 모드별 동일한 ID를 가지는 서로다른 타입의 뷰를 처리하는 방법
 *  tools:viewBindingType="android.widget.TextView" 을 추가해 동일한 ID를 가진 뷰를 다르게 처리
 *  tools:viewBindingType 속성은 레이아웃 XML에서 특정 뷰의 바인딩 타입을 명시적으로 지정할 때 사용
 */


class Fragment02 : Fragment() {

    private var _binding: Fragment02Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 데이터 바인딩 객체를 생성
        _binding = Fragment02Binding.inflate(inflater, container, false)
        /** 세로모드인경우 textView2 는 TextView로 동작
         */
        binding.textView2.text = "fragment02"

        /**가로모드인경우 textView2 는 EditText로 동작
         */
        binding.textView2.setOnFocusChangeListener { view, b ->
            Toast.makeText(requireContext(),"focus changed",Toast.LENGTH_SHORT).show()
        }

        val view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
