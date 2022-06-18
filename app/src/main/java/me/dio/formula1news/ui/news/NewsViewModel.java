package me.dio.formula1news.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.formula1news.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover Mock de Noticias
        List<News> news = new ArrayList<>();
                news.add(new News("Verstappen lidera 1º treino do GP do Canadá, em retorno da etapa à F1","Leclerc e Sainz completam top 3 da sessão com desempenho melhor da Ferrari, embora não suficiente para destronar RBR em primeiro dia de ação no Circuito de Gilles Villeneuve"));
                news.add(new News("Chefe da RBR não superestima má fase da Ferrari","Escuderia italiana começou temporada vencendo, mas perdeu liderança do campeonato da F1 para a rival com sucessão de erros ou falhas nas últimas cinco etapas"));
                news.add(new News("GP da Austrália renova com F1 até 2035 e abrirá cinco temporadas","Etapa sediada no Circuito de Albert Park em Melbourne vai dar pontapé inicial ao campeonato da categoria em 2024, 2025 e mais três temporadas ainda a serem decididas"));

                this.news.setValue(news);
    }

  public LiveData<List<News>> getNews(){
        return  this.news;
  }

}