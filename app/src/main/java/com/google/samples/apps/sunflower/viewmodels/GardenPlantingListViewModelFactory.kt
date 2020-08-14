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

package com.google.samples.apps.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.samples.apps.sunflower.data.GardenPlantingRepository

/**
 * Factory for creating a [GardenPlantingListViewModel] with a constructor that takes a
 * [GardenPlantingRepository].
 */
/*
    (p277, 프래그먼트 간 데이터 공유하기)
    프래그먼트 내에서 뷰 모델을 생성하는 데 사용한 액티비티를 얻고,
    이를 사용하여 ViewModelProviders로부터 공통된 SharedViewModel 인스턴스를 얻을 수 있다.
 */
class GardenPlantingListViewModelFactory(
    private val repository: GardenPlantingRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }
}