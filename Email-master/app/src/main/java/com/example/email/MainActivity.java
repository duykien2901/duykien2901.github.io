package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.email.adapters.EmailAdapter;
import com.example.email.models.Email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<Email> emails;
    Faker faker = new Faker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emails = new ArrayList<>();
        for (int i  = 0; i < 100; i++){
            String sender = faker.name.name();
            String title = faker.lorem.sentence();
            String content = faker.lorem.sentence();
            Date date = faker.date.forward();
            String time = date.toString();
            emails.add(new Email(sender, title, content, time));
        }
        EmailAdapter adapter = new EmailAdapter(this, emails);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}