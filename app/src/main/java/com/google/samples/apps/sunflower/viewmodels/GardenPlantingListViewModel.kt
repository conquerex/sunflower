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

/*
    (p259, LiveData)
    관찰 가능한(Observable) 데이터 클래스, Lifecycle을 통해 생명 주기를 인식.

    ====

    p272, ViewModel 클래스는 생명 주기를 인식하며, UI와 관련된 데이터를 저장하고 관리한다.
    화면 회전 같은 구성 변경에서도 살아남아 데이터를 보존한다.
 */
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.samples.apps.sunflower.data.GardenPlantingRepository
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings

class GardenPlantingListViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
            gardenPlantingRepository.getPlantedGardens()
}
