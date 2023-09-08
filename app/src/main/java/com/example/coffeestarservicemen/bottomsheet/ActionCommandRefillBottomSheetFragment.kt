package com.example.coffeestarservicemen.bottomsheet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.databinding.BottomDialogActionsCommandsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import javax.sql.StatementEvent

class ActionCommandRefillBottomSheetFragment(val context: Context, val layoutInflater: LayoutInflater) {
    private var bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context)
    private var binding:BottomDialogActionsCommandsBinding = BottomDialogActionsCommandsBinding.inflate(layoutInflater)

    init {
        binding.ivClose.setOnClickListener {
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.setContentView(binding.root)
    }

    fun show(message:String){
        binding.title.text = message
        binding.btnAction.apply {
            text = "Отметить пополненым"
            setOnClickListener {
                Toast.makeText(context,"Ингридиент поплнен", Toast.LENGTH_LONG).show()
                bottomSheetDialog.dismiss()
            }
        }
        bottomSheetDialog.show()
    }

}