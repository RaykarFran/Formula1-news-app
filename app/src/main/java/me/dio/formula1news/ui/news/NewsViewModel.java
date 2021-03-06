package me.dio.formula1news.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.formula1news.data.remote.FormulaNewsApi;
import me.dio.formula1news.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final FormulaNewsApi api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raykarfran.github.io/Formula1-news-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(FormulaNewsApi.class);
        this.findNews();
    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()) {
                    news.setValue(response.body());
                }else{
                    //TODO pesnsar em uma estrategia para tratamento de erro
                }
             }

            @Override
            public void onFailure(Call<List<News>> call,Throwable t){
                //TODO pesnsar em uma estrategia para tratamento de erro

            }
        });
    }

    public LiveData<List<News>> getNews(){
        return  this.news;
  }

}