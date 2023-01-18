package com.example.taomlarroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Taomlar(
    var name: String? = null,
    var masaliq: String? = null,
    var tat: String? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) : java.io.Serializable