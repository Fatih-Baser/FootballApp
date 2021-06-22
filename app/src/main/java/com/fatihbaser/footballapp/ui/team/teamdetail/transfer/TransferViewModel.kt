package com.fatihbaser.footballapp.ui.team.teamdetail.transfer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatihbaser.footballapp.model.transfer.Transfer
import com.fatihbaser.footballapp.model.transfer.TransferResponse
import com.fatihbaser.footballapp.remotedata.ApiClient

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class TransferViewModel : ViewModel() {
    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val transferList = MutableLiveData<List<Transfer>>()
    val loadingTransfer = MutableLiveData<Boolean>()

    fun getAllTransfersOfTeam(teamId:Int){
        loadingTransfer.value = true
        disposable.add(apiClient.getAllTransfersOfTeam(teamId)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<TransferResponse>(){
                override fun onSuccess(t: TransferResponse) {
                    transferList.value = t.api.transfers
                    loadingTransfer.value = false
                }

                override fun onError(e: Throwable) {

                }

            })
        )
    }



    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
