package com.school.entry.model

import org.bson.types.ObjectId
import java.util.*

data class StudantDto(
    var id: String? = null,
    val nome: String = "",
    val cpf: String = "",
    val idade: Int = 0,
)
