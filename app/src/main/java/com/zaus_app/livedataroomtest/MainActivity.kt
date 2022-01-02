package com.zaus_app.livedataroomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.zaus_app.livedataroomtest.databinding.ActivityMainBinding
import com.zaus_app.livedataroomtest.entity.StringEntity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Подписываемся на данные от LiveData
        mainActivityViewModel.stringLiveData.observe(this) {
            if (it == null) return@observe
            val string = "ID: ${it.id} with Text: ${it.string}"
            binding.textLastDbValue.text = string
        }
        //По нажатию на кнопку создаем объект StringEntity и кладем в него то, что
        //было в EditText
        binding.button.setOnClickListener {
            val data = binding.editText.text.toString()
            mainActivityViewModel.putDataToDB(StringEntity(string = data))
        }
    }
}