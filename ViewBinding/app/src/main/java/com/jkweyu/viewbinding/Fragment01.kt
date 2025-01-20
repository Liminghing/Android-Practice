package com.jkweyu.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jkweyu.viewbinding.databinding.Fragment01Binding
import kotlin.random.Random

/** 프래그먼트에서 뷰 바인딩
 *
 * 1. 바인딩 변수 선언
 *     프래그먼트 생명주기에 따라 바인딩 객체를 참조하는 바인딩 변수를 선언
 *
 * 2. 생성된 바인딩 클래스에 포함된 inflate() 메서드를 호출
 *     inflate() 메서드를 통해 바인딩 객체 생성
 *
 * 3. 루트 뷰 얻기
 *     바인딩 객체의 루트 뷰를 참조하여 가져오기
 *
 * 4. 루트 뷰 반환
 *     루트 뷰 반환을 통해 액티비티에 포함
 *
 * 5. 프래그먼트 제거 메서드 정의
 *     프래그먼트 제거시 바인딩 객체도 소멸되어야함
 */

class Fragment01 : Fragment() {
    /** [1. 바인딩 변수 선언]
     *  _binding : nullable한 변수로 Fragment01Binding을 초기화(전용)
     *  binding : non-null란 binding을 바인딩 객체에 접근
     */
    private var _binding: Fragment01Binding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** [2. inflate() 메서드 호출]
         * inflater : LayoutInflater 타입의 객체로서
         *          LayoutInflater는 이 XML을 읽어서 View 객체로 변환
         *
         * container : ViewGroup 타입의 객체로서 부모(레이아웃)를 명시하는 부분
         *          container는 프래그먼트를 포함하는 부모 레이아웃을 알려주는 역할
         *
         * false : 부모(레이아웃)에 붙이는 여부를 결정하는 부분
         *          inflate()는 뷰를 메모리에 로드만 하고, 부모 레이아웃에 붙이는 작업은 나중에 프래그먼트가 자동으로 처리
         */
        _binding = Fragment01Binding.inflate(inflater, container, false)

        adapter = RVAdapter()
        /** 프래그먼트 뷰의 객체에 접근시
         * non-null인 binding을 통해 접근
         */
        binding.myRecyclerView.adapter = adapter
        binding.myRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        // 데이터 추가
        var items = mutableListOf(
            RVItem("Title 1"),
            RVItem("Title 2"),
            RVItem("Title 3")
        )
        binding.button3.setOnClickListener {
            items.add(RVItem("Title " + Random.nextInt(100)))
            adapter.notifyDataSetChanged()
        }


        adapter.setItems(items)

        /** [3. 루트 뷰 얻기]
         *  바인딩 인스턴스에서 루트 뷰에대한 참조 가져오기
         *  root : binding이 참조하고 있는 레이아웃의 가장 뿌리 view
         */
        val view = binding.root
        /** [4. 루트 뷰 반환]
         *  프래그먼트는 독립적인 화면을 가지지 않으므로 뷰 객체를 생성을 처리한 뒤
         *  이를 시스템에 반환하여 프래그먼트를 구성한다
         */
        return view
    }

    /** 프래그먼트 제거시 바인딩 객체 소멸
     * _binding :_binding null로 설정하여 메모리 누수를 방지
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}