package com.avasia.reeltalk.selectionscreen.selectionpages.movietvselection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.avasia.reeltalk.databinding.FragmentMovieTvSelectionBinding

class MovieTVSelectionFragment : Fragment() {

    private var _binding: FragmentMovieTvSelectionBinding? = null
    private val binding
        get() = _binding!!

    private var columnCount = 2

    private lateinit var adapter: MovieTVSelectionAdapter

    private val movieTVSelectionViewModel: MovieTVSelectionViewModel by activityViewModels()
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
        adapter = MovieTVSelectionAdapter()
        binding.recyclerview.apply {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = this@MovieTVSelectionFragment.adapter
        }
        movieTVSelectionViewModel.movies.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"
    }
}