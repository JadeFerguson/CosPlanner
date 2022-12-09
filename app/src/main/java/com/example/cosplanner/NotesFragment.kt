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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    private lateinit var binding: FragmentNotesBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = FragmentNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            val supportFragmentManager = null
            NewTaskSheet().show(supportFragmentManager, "newTaskTag")
        }

        taskViewModel.name.observe(this){
            binding.taskName.text = String.format("Task Name: %s", it)
        }
        taskViewModel.desc.observe(this){
            binding.taskDesc.text = String.format("Task Desc: %s", it)
        }
    }

    private fun setContentView(root: RelativeLayout) {

    }
}

