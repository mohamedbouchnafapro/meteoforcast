package com.meteo.meteoforecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.meteo.meteoforecast.adapter.WeatherForecastAdapter
import com.meteo.meteoforecast.databinding.ActivityMainBinding
import com.meteo.meteoforecast.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    @Inject lateinit var forecastAdapter : WeatherForecastAdapter


    val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
        binding.forecastRecyclerView.adapter = forecastAdapter
        viewModel.callWeatherForecastService()
        lifecycleScope.launch {
            viewModel.forecastStateFlow.collectLatest {
                forecastAdapter.updateItems(it)
            }
            viewModel.forecastErrorStateFlow.collectLatest { error ->
                binding.textError.visibility = if(error) View.VISIBLE else View.GONE
            }
        }

    }

}
