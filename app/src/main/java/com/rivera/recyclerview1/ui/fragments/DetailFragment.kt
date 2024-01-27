package com.rivera.recyclerview1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rivera.recyclerview1.R
import com.rivera.recyclerview1.databinding.FragmentDetailBinding
import com.rivera.recyclerview1.logic.entities.FullInfoAnimeLG
import com.rivera.recyclerview1.logic.usercase.jikan.JikanAnimeUsercase
import com.rivera.recyclerview1.ui.adapters.DetailAdapterDiff
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailFragment : Fragment() {
    private lateinit var binding :FragmentDetailBinding

    private var animeDetail : MutableList<FullInfoAnimeLG> = ArrayList()
    private val detailDiffAdapter = DetailAdapterDiff()

    val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentDetailBinding.bind(inflater.inflate(R.layout.fragment_detail, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.txtIdAnime.text = args.idAnime.toString()
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rvDetails.adapter = detailDiffAdapter
        binding.rvDetails.layoutManager=
            LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        loadDataRecyclerView()

    }

    private fun loadDataRecyclerView(){
        lifecycleScope.launch (Dispatchers.Main) {
            binding.progresBar.visibility = View.VISIBLE

            val resp = withContext(Dispatchers.IO){
                JikanAnimeUsercase().getFullAnimeInfo(args.idAnime) // POSIBLE ERROR
            }
            resp.onSuccess {
                animeDetail.add(it)
                detailDiffAdapter.submitList(animeDetail.toList())
            }
            resp.onFailure {ex ->
                Snackbar.make(
                    requireActivity(),
                    binding.rvDetails,
                    ex.message.toString(),
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }

            binding.progresBar.visibility = View.GONE
        }
    }
    
}