package com.example.testapp.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.testapp.R
import com.example.testapp.databinding.FragmentDetailsBinding
import com.example.testapp.presenter.details.DetailsPresenter
import com.example.testapp.presenter.details.PresenterDetailsContract
import java.util.*

class DetailsFragment : Fragment(), ViewDetailsContract {
    private var _binding: FragmentDetailsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private val presenter: PresenterDetailsContract = DetailsPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
    }

    private fun setUI() {
        arguments?.let {
            val counter = it.getInt(TOTAL_COUNT_EXTRA, 0)
            presenter.setCounter(counter)
            setCountText(counter)
        }

        _binding?.decrementButton?.setOnClickListener { presenter.onDecrement() }
        _binding?.incrementButton?.setOnClickListener { presenter.onIncrement() }
    }

    override fun setCount(count: Int) {
        setCountText(count)
    }

    private fun setCountText(count: Int) {

        _binding?.totalCountTextView?.text =
            String.format(Locale.getDefault(), getString(R.string.results_count), count)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val TOTAL_COUNT_EXTRA = "TOTAL_COUNT_EXTRA"

        @JvmStatic
        fun newInstance(counter: Int) =
            DetailsFragment().apply { arguments = bundleOf(TOTAL_COUNT_EXTRA to counter) }
    }
}
