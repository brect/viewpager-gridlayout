package com.blimas.visaolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Book> lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
//        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));
//        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
//        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
//        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
//        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
//        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));
//        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
//        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
//        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
//        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
//        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.viewpager);
        pagerAdapter = new ScreenSlidePagerAdapter(this, this, lstBook);
        viewPager.setAdapter(pagerAdapter);
    }
}