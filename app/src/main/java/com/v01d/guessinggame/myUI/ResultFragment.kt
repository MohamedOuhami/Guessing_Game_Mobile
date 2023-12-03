package com.v01d.guessinggame.myUI

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.v01d.guessinggame.R
import com.v01d.guessinggame.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding:FragmentResultBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ResultFragment()
    }

    private lateinit var viewModel: ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.wonLost.text = ResultFragmentArgs.fromBundle(requireArguments()).message

        binding.newGameButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
        }

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ResultViewModel::class.java)
        // TODO: Use the ViewModel
    }

}