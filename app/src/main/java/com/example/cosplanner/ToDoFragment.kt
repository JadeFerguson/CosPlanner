package com.example.cosplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cosplanner.databinding.FragmentToDoBinding

class ToDoFragment : Fragment() {
    private var _binding: FragmentToDoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentToDoBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = ToDoDatabase.getInstance(application).toDoDao

        val viewModelFactory = ToDoViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(ToDoViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = TaskItemAdapter() { taskId ->
            Toast.makeText(context, "Clicked task $taskId", Toast.LENGTH_SHORT).show()
        }
        binding.tasksList.adapter = adapter

        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}