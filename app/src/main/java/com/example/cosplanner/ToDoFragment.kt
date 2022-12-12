package com.example.cosplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            this, viewModelFactory)[ToDoViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}