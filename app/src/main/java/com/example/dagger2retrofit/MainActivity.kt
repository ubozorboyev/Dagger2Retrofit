package com.example.dagger2retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.dagger2retrofit.viewmodel.DaggerComponentInterface
import com.example.dagger2retrofit.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
@Inject lateinit var viewModel: MainViewModel
private val adapter=MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       viewModel= DaggerComponentInterface.create().getViewModel()
        recView.adapter=adapter
        viewModel.allItems.observe(this, Observer {
            progerssBar.visibility= View.GONE
            adapter.setData(it)
        })
    }
}