package com.fatihbaser.footballapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatihbaser.footballapp.R
import com.fatihbaser.footballapp.base.BaseVMFragment
import com.fatihbaser.footballapp.util.CustomSharedPreferences
import kotlinx.android.synthetic.main.fragment_top_scorer.*

class TopScorerFragment : BaseVMFragment<TopScorerViewModel>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_scorer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var customPreferences = CustomSharedPreferences(activity?.applicationContext!!)
        val leagueId = customPreferences.getCountryId()

        viewModel.getTopScorers(leagueId!!)
        viewModel.topScorerList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvTopScorers?.layoutManager = LinearLayoutManager(this.context)
                rvTopScorers?.adapter = TopScorerAdapter(it)
            }
        })

        viewModel.loadingTopScorer.observe(viewLifecycleOwner, Observer {
            it.let {
                if (it){
                    rvTopScorers.visibility = View.GONE
                    progressBarTopScorer.visibility = View.VISIBLE
                }else{
                    progressBarTopScorer.visibility = View.GONE
                    rvTopScorers.visibility = View.VISIBLE
                }
            }
        })

    }

    override fun getViewModel(): Class<TopScorerViewModel> = TopScorerViewModel::class.java

}
