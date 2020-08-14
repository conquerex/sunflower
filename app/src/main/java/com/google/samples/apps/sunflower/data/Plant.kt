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

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

/*
    (p278, Room)
    SQLite에 대한 추상화 계층을 제공하여 SQLite의 모든 기능을 활용하면서 쉬운 데이터베이스 액세스를 허용.

    ====

    (p282, 엔티티 정의하기)
    SQLite에서 테이블 이름은 대소문자를 구분하지 않는다.
 */
@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey @ColumnInfo(name = "id") val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7, // how often the plant should be watered, in days
    val imageUrl: String = ""
) {

    /**
     * Determines if the plant should be watered.  Returns true if [since]'s date > date of last
     * watering + watering Interval; false otherwise.
     */
    fun shouldBeWatered(since: Calendar, lastWateringDate: Calendar) =
        since > lastWateringDate.apply { add(DAY_OF_YEAR, wateringInterval) }

    override fun toString() = name
}
