package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentDetailCategoryBinding


class DetailCategoryFragment : Fragment() {
    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//       ======= METODE MENGGUNAKAN BUNDLE =======
//        val dataName = arguments?.getString(CategoryFragment.EXTRA_NAME)
//        val dataDescription = arguments?.getLong(CategoryFragment.EXTRA_STOCK)

//       ======= METODE MENGGUNAKAN SafeArg =======
        val dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDescription = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock


        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "Stock : $dataDescription"

        Log.d("TAGNAVIGATION","$dataDescription")

        binding.btnProfile.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}