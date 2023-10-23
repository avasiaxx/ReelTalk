package com.avasia.reeltalk.selectionscreen.selectionpages.movieselection

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




class MovieSelectionFragment : Fragment() {

    private var _binding: FragmentMovieTvSelectionBinding? = null
    private val binding
        get() = _binding!!

    private var columnCount = 2

    private lateinit var adapter: MovieSelectionAdapter

    private val movieSelectionViewModel: MovieSelectionViewModel by activityViewModels()
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
        adapter = MovieSelectionAdapter(movieSelectionViewModel::onMovieSelected)
        binding.recyclerview.apply {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = this@MovieSelectionFragment.adapter
        }
        movieSelectionViewModel.movies.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
        movieSelectionViewModel.selectedMovies.observe(viewLifecycleOwner) {
            showSelectionChanged(it)
        }
//        binding.searchview.setupWithSearchBar(binding.search)
//        binding.searchview.setOnMenuItemClickListener { true }
//        binding.searchview
//            .editText
//            .setOnEditorActionListener { _, _, _ ->
//                binding.search.setText(binding.searchview.text)
//                binding.searchview.hide()
//                false
//            }
//        binding.searchview.addTransitionListener { _, _, newState ->
//            if (newState === TransitionState.SHOWING) {
//                // Handle search view opened.
//            }
//        }
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