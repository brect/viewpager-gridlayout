package com.blimas.visaolista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private FragmentStateAdapter pagerAdapter;

    private ViewModel viewModel;

    private  List<Book> lstBook = new ArrayList<>();

    private final Observer<Integer> qtdColunasObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer qtdColunasObserver) {
            if (qtdColunasObserver != null) {
                pagerAdapter = new ScreenSlidePagerAdapter(MainActivity.this, MainActivity.this, lstBook,qtdColunasObserver);
                viewPager.setAdapter(pagerAdapter);
            }
            else{
                pagerAdapter = new ScreenSlidePagerAdapter(MainActivity.this, MainActivity.this, lstBook,ViewModel.UMA_COLUNA);
                viewPager.setAdapter(pagerAdapter);
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (viewModel.getQtdColunasSelecionadas().getValue().equals(ViewModel.DUAS_COLUNAS)) {
            menu.add(0,ViewModel.DUAS_COLUNAS,0,"LISTA").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);;
        }
        else{
            menu.add(0,ViewModel.DUAS_COLUNAS,0,"GRID").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);;
        }



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (viewModel.getQtdColunasSelecionadas().getValue().equals(ViewModel.DUAS_COLUNAS)) {
            viewModel.setQtdColunasSelecionada(ViewModel.UMA_COLUNA);
        }
        else{
            viewModel.setQtdColunasSelecionada(ViewModel.DUAS_COLUNAS);
        }
        pagerAdapter.notifyDataSetChanged();
        invalidateOptionsMenu();

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.setQtdColunasSelecionada(ViewModel.DUAS_COLUNAS);


        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.viewpager);

    }

    @Override
    protected void onResume() {
        super.onResume();

        viewModel.getQtdColunasSelecionadas().observe(this, qtdColunasObserver);
    }
}