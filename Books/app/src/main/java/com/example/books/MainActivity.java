package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = findViewById(R.id.listview);

        //шаг 1 - готовим список данных.
        LinkedList<Book> myBooks = new LinkedList<>();
        myBooks.add(new Book("А.Азимов", "Основание", R.drawable.osnovanie));
        myBooks.add(new Book("Ф.Достоевский", "Преступление и наказание", R.drawable.prestuplenie));
        myBooks.add(new Book("Н.Гоголь", "Шинель", R.drawable.shinel));
        myBooks.add(new Book("Е.Гогловв", "Зерцалия", R.drawable.zertsalia));
        myBooks.add(new Book("А.Камю", "Падение", R.drawable.book));
        myBooks.add(new Book("Р.ХейнЛайн", "Гражданин галактики", R.drawable.book));

        //шаг 2 - преобразование списка данных для адаптера.
        LinkedList<HashMap<String, Object>> library = new LinkedList<>();
        for (int i = 0; i < myBooks.size(); i++){
            HashMap<String, Object> book = new HashMap<>();
            book.put("author", myBooks.get(i).author);
            book.put("name", myBooks.get(i).name);
            book.put("cover", myBooks.get(i).cover);
            library.add(book);
        }

        //шаг 3 - подготовка массивов
        String[] from = {"author", "name", "cover"};
        int[] to = {R.id.author, R.id.name, R.id.cover};

        //шаг 4 - содание адаптера.
        SimpleAdapter adapter = new SimpleAdapter(this, library, R.layout.list_item, from, to);

        //шаг 5 - применение адаптера
        bookList.setAdapter(adapter);

    }
}