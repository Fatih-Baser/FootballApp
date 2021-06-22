package com.fatihbaser.footballapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatihbaser.footballapp.R
import com.fatihbaser.footballapp.base.BaseVMFragment
import com.fatihbaser.footballapp.util.CustomSharedPreferences
import kotlinx.android.synthetic.main.fragment_league_table.*

class LeagueTableFragment : BaseVMFragment<LeagueTableViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league_table, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var customPreferences = CustomSharedPreferences(activity?.applicationContext!!)
        val leagueId = customPreferences.getCountryId()
        Toast.makeText(requireContext(), " id : "+leagueId, Toast.LENGTH_SHORT).show()


        viewModel.getLeagueTable(leagueId!!)
        viewModel.leagueTable.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvLeagueTable?.layoutManager = LinearLayoutManager(this.context)
                rvLeagueTable?.adapter = LeagueTableAdapter(it){
                    Toast.makeText(requireContext(), " tıklandı", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.loadingLeagueTable.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    progressBarLeagueTable.visibility = View.VISIBLE
                    rvLeagueTable.visibility = View.GONE
                }else{
                    progressBarLeagueTable.visibility = View.GONE
                    rvLeagueTable.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun getViewModel(): Class<LeagueTableViewModel> = LeagueTableViewModel::class.java

}
