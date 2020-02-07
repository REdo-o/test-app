package com.example.gift_card_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.common.base.BaseFragment
import com.example.common.base.BaseViewModel
import com.example.common.utils.SharedViewModel
import com.example.gift_card_details.databinding.FragmentGiftCardDetailsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class GiftCardDetailsFragment : BaseFragment() {

    private val viewModel: GiftCardDetailsViewModel by viewModel()
    private lateinit var binding: FragmentGiftCardDetailsBinding

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = activity?.run {
            ViewModelProviders.of(this).get(SharedViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        sharedViewModel.giftCardDetailsEvent.observe(this, Observer { bool ->
            if (bool) {
                viewModel.fillInfo()
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGiftCardDetailsBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.sharedViewModel = sharedViewModel

        return binding.root
    }

    override fun getViewModel(): BaseViewModel = viewModel
}
