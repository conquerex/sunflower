/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.HomeViewPagerFragmentDirections
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings
import com.google.samples.apps.sunflower.databinding.ListItemGardenPlantingBinding
import com.google.samples.apps.sunflower.viewmodels.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter :
    ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(
        GardenPlantDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_garden_planting, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListItemGardenPlantingBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.viewModel?.plantId?.let { plantId ->
                    navigateToPlant(plantId, view)
                }
            }
        }

        private fun navigateToPlant(plantId: String, view: View) {
            /*
                p365, 생성된 클래스에는 원래 목적지에 정의된 각 액션에 대한 정적 메서드가 포함된다.
                 이 메서든는 정의된 액션 매개변수를 사용하고
                 navigate() 메서드에 전달할 수 있는 NavDirections 오브젝트를 리턴한다.

                Safe Args는 단일 메서드를 갖는 HomeViewPagerFragmentDirections 클래스를 생성한다.
                 actionViewPagerFragmentToPlantDetailFragment() 메서드는
                 NavDirections 객체를 반환하며 이 반환된 NavDirections 객체는 navigate() 메서드의 인자로 전달된다.
             */
            val direction = HomeViewPagerFragmentDirections
                .actionViewPagerFragmentToPlantDetailFragment(plantId)
            // p364, 목적지로 이동하기
            view.findNavController().navigate(direction)
        }

        fun bind(plantings: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }
    }
}

private class GardenPlantDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {

    override fun areItemsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant.plantId == newItem.plant.plantId
    }

    override fun areContentsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant == newItem.plant
    }
}