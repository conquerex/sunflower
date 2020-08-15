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

package com.google.samples.apps.sunflower.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * This class captures the relationship between a [Plant] and a user's [GardenPlanting], which is
 * used by Room to fetch the related entities.
 */
data class PlantAndGardenPlantings(
    // p289, 내장된 객체 생성하기
    @Embedded
    val plant: Plant,

    /*
        (p304, 관계있느느 엔티티 가져오기)
        @Relation은 POJO에서 관계 엔티티를 자동으로 가져오는데 사용할 수 있는 편리한 애노테이션이다.
        @Relation 애노테이션이 달린 필드의 유형은 반드시 List 또는 Set여야 한다.
     */
    @Relation(parentColumn = "id", entityColumn = "plant_id")
    val gardenPlantings: List<GardenPlanting> = emptyList()
)
