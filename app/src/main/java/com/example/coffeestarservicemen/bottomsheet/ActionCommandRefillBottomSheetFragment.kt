package com.example.coffeestarservicemen.bottomsheet

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.coffeestarservicemen.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import javax.sql.StatementEvent

class ActionCommandRefillBottomSheetFragment(private val context: Context, private val layoutInflater: LayoutInflater) {
    private var bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context)
    private val sheetView = layoutInflater.inflate(R.layout.bottom_dialog_actions_commands,null, false)
    init {
        sheetView.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.setContentView(sheetView)
        bottomSheetDialog.setCancelable(false)
    }

    fun show(message:String){
        sheetView.findViewById<TextView>(R.id.title).text = message
        sheetView.findViewById<Button>(R.id.btn_action).text = "Отметить пополненым"
        bottomSheetDialog.show()
    }

}