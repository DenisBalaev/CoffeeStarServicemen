package com.example.coffeestarservicemen.fragment.car_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coffeestarservicemen.R
import com.example.coffeestarservicemen.adapter.car_screen.NotesAdapter
import com.example.coffeestarservicemen.databinding.FragmentCarScreenNotesBinding


class CarScreenNotesFragment : Fragment(R.layout.fragment_car_screen_notes) {
    private val binding by viewBinding(FragmentCarScreenNotesBinding::bind)

    private val listNote = mutableListOf<String>(
        "Получилось настроить контейнер на подачу 21 мая",
        "Контейнер 4 некорректно срабатывает, не получается настроить подачу ингредиента. 20.05.22",
        "Контейнер 4 некорректно срабатывает, не получается настроить подачу ингредиента. 20.05.22\nПолучилось настроить контейнер на подачу 21 мая"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding){
            rvNotes.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = NotesAdapter(items = listNote)
            }

            cardNewNote.setOnClickListener {
                findNavController().navigate(R.id.newNoteFragment)
            }
        }
    }
}