package com.example.exercise_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.exercise_9.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var itemsList: MutableList<Data.Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
//        get data from Data obj
        itemsList = Data.getItems()

        setDataToRecycler(itemsList)
        val layoutManager = GridLayoutManager(this,2)
        binding.recycler.layoutManager = layoutManager

        listeners()
    }

    private fun setDataToRecycler(data: MutableList<Data.Item>){
        val adapter = RecyclerAdapter()
        adapter.setData(data)
        binding.recycler.adapter = adapter
    }

    private fun listeners() {
        binding.tvAllCategory.setOnClickListener {
            setDataToRecycler(itemsList)
        }

        binding.tvPartyCategory.setOnClickListener {
            val partyItems = filterList("category_party")
            setDataToRecycler(partyItems)
        }

        binding.tvBeachCategory.setOnClickListener {
            val beachItems = filterList("category_beach")
            setDataToRecycler(beachItems)
        }

        binding.tvSchoolCategory.setOnClickListener {
            val schoolItems = filterList("category_school")
            setDataToRecycler(schoolItems)
        }

        binding.tvClubCategory.setOnClickListener {
            val clubItems = filterList("category_club")
            setDataToRecycler(clubItems)
        }

        binding.tvDenimCategory.setOnClickListener {
            val denimItems = filterList("category_denim")
            setDataToRecycler(denimItems)
        }

        binding.tvHikingCategory.setOnClickListener {
            val hikingItems = filterList("category_hiking")
            setDataToRecycler(hikingItems)
        }
    }

    private fun filterList(type: String): MutableList<Data.Item> {
        val filteredList = mutableListOf<Data.Item>()
        itemsList.forEach {
            if (it.categoryType == type) {
                filteredList.add(it)
            }
        }
        return filteredList
    }
}