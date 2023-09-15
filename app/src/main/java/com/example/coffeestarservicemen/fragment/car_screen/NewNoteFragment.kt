package com.example.coffeestarservicemen.fragment.car_screen

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.MainActivity
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.SoftInputAssist
import com.example.coffeestarservicemen.databinding.FragmentNewNoteBinding


class NewNoteFragment : Fragment(R.layout.fragment_new_note) {
    private val binding by viewBinding(FragmentNewNoteBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            ViewCompat.setOnApplyWindowInsetsListener(requireActivity().window?.decorView!!) { _, insets ->
                val imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
                val navigationBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
                (requireActivity() as MainActivity).binding.root.setPadding(0, 0, 0, imeHeight)
                //requireActivity().window.decorView.setPadding(0, 0, 0, imeHeight - navigationBarHeight)
                insets
            }
            requireActivity().window?.let { WindowCompat.setDecorFitsSystemWindows(it, false) }
        } else {
            @Suppress("DEPRECATION")
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        }*/

        //activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        with(binding){
            etNote.requestFocus()
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(etNote, InputMethodManager.SHOW_IMPLICIT)

            ivArrowBack.setOnClickListener {
                findNavController().navigate(R.id.carScreenFragment, bundleOf("SelectorPage" to 1))
            }

            btnSave.setOnClickListener {
                Toast.makeText(requireContext(),"Сохранение",Toast.LENGTH_SHORT).show()
            }
        }
    }
}