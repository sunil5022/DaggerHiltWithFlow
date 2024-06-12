package com.example.flowapidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowapidemo.Adapter.PostAdapter
import com.example.flowapidemo.Repository.MainRepository
import com.example.flowapidemo.Utils.ApiState
import com.example.flowapidemo.ViewModel.MainViewModel
import com.example.flowapidemo.databinding.ActivityPostBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostActivity : ComponentActivity() {

    private lateinit var binding: ActivityPostBinding
    private lateinit var postAdapter: PostAdapter
    @Inject
    lateinit var repository: MainRepository

    // private lateinit var mainViewModel: MainViewModel
    private val mainViewModel: MainViewModel by viewModels()
//    private val mainViewModel by viewModels<MainViewModel>()
//   private val mainViewModel: MainViewModel by viewModels {
//       MyViewModelFactory(
//           this,
//           application,
//           repository
//       )
//   }
//  private val mainViewModel: MainViewModel by viewModels {
//      MyViewModelFactory(this, application)
//  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPostBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initRecyclerview()
       // mainViewModel = ViewModelProvider(this,MyViewModelFactory(application,"")).get(MainViewModel::class.java)

        mainViewModel.getPost()

        lifecycleScope.launchWhenCreated {
            mainViewModel._postStateFlow.collect{it->
                when(it){
                    is ApiState.Loading->{
                        binding.recyclerview.visibility=View.GONE
                        binding.progressBar.visibility=View.VISIBLE
                    }
                    is ApiState.Failure -> {
                        binding.recyclerview.visibility = View.GONE
                        binding.progressBar.visibility = View.GONE
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is ApiState.Success->{
                        binding.recyclerview.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        postAdapter.setData(it.data)
                        postAdapter.notifyDataSetChanged()
                    }
                    is ApiState.Empty->{

                    }
                    else -> {}
                }

            }
        }

    }

    private fun initRecyclerview() {
        postAdapter= PostAdapter(ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@PostActivity)
            adapter=postAdapter
        }
    }

}