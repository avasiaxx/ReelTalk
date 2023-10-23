package com.avasia.reeltalk.selectionscreen.selectionpages.tvshowselection


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.avasia.reeltalk.data.models.Show
import com.avasia.reeltalk.databinding.FragmentMovieTvSelectionBinding
import com.avasia.reeltalk.selectionscreen.selectionpages.Tvselection.TvSelectionAdapter

class TvSelectionFragment : Fragment() {

    private var _binding: FragmentMovieTvSelectionBinding? = null
    private val binding
        get() = _binding!!

    private var columnCount = 2

    private lateinit var adapter: TvSelectionAdapter

    private val tvSelectionViewModel: TvSelectionViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieTvSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TvSelectionAdapter(tvSelectionViewModel::onTvSelected)
        val originalString: String = binding.title.text.toString()
        val newString = originalString.replace("movies", "TV shows")
        binding.title.text = newString
        binding.recyclerview.apply {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = this@TvSelectionFragment.adapter
        }
        tvSelectionViewModel.tvShows.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
        tvSelectionViewModel.selectedTvShows.observe(viewLifecycleOwner) {
            showSelectionChanged(it)
        }
        binding.searchview.setupWithSearchBar(binding.search)
        binding.searchview.setOnMenuItemClickListener { true }
        binding.searchview
            .editText
            .setOnEditorActionListener { _, _, _ ->
                binding.search.setText(binding.searchview.text)
                binding.searchview.hide()
                false
            }
    }

    private fun showSelectionChanged(newSelection: List<Show>) {
        val amountSelected = newSelection.size
        val newSelectionTest = "$amountSelected${binding.selected.text.substring(1)}"
        binding.selected.text = newSelectionTest
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"
    }
}