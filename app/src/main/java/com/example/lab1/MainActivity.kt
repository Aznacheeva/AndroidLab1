package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.controllers.ItemAdapter
import com.example.lab1.controllers.RecyclerListDecorator
import com.example.lab1.entities.DataItem
import com.example.lab1.entities.HeaderItem
import com.example.lab1.entities.Item
import com.example.lab1.entities.TariffItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smileTariff =
            TariffItem("Тариф <Улыбка (бесплатно)>", "Скорость 100 Мбит/сек", "0 Р/мес")

        val content: List<Item> = listOf(
            HeaderItem("Тариф"),
            smileTariff,
            smileTariff,
            HeaderItem("Пользователь"),
            DataItem(
                "Иванов иван Иваныч",
                applicationContext.getDrawable(R.drawable.account_circle)
            ),
            DataItem(
                "Сахалин, ул. Пушкина, д. Колотушкина",
                applicationContext.getDrawable(R.drawable.home)
            ),
            DataItem(
                "Доступые услуги",
                applicationContext.getDrawable(R.drawable.apps)
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        val adapter = ItemAdapter()
        adapter.submitList(content)
        recyclerView.addItemDecoration(
            RecyclerListDecorator(
                content,
                ResourcesCompat.getDrawable(resources, R.drawable.partition, null)!!
            )
        )
        recyclerView.adapter = adapter
    }
}