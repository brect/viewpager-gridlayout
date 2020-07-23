package com.blimas.visaolista;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends AndroidViewModel {

    public static final int UMA_COLUNA = 1;
    public static final int DUAS_COLUNAS = 2;

    private MutableLiveData<Integer> qtdColunasSelecionada = new MutableLiveData<Integer>();

    public ViewModel(@NonNull Application application) {
        super(application);
    }

    public void setQtdColunasSelecionada(Integer qtdColuna){
        qtdColunasSelecionada.postValue(qtdColuna);
    }

    public MutableLiveData<Integer> getQtdColunasSelecionadas(){
        return qtdColunasSelecionada;
    }
}
