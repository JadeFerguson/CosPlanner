package com.example.cosplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cosplanner.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        super.onCreate(savedInstanceState)
        binding = FragmentNotesBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTaskSheet().show(childFragmentManager, "newTaskTag")
        }

        taskViewModel.name.observe(viewLifecycleOwner) {
            binding.taskName.text = String.format("Name: %s", it)
        }
        taskViewModel.desc.observe(viewLifecycleOwner) {
            binding.taskDesc.text = String.format("Description: %s", it)
        }

        return binding.root
        // inflater.inflate(R.layout.fragment_notes, container, false)
    }
}

