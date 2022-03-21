package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

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
                applicationContext.getDrawable(R.drawable.ic_baseline_account_circle_24)
            ),
            DataItem(
                "Сахалин, ул. Пушкина, д. Колотушкина",
                applicationContext.getDrawable(R.drawable.ic_baseline_home_24)
            ),
            DataItem(
                "Доступые услуги",
                applicationContext.getDrawable(R.drawable.ic_baseline_apps_24)
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