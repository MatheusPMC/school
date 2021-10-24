package com.school.core.model

import org.bson.types.ObjectId
import java.util.*

data class Studant(
    var id: String? = null,
    val nome: String = "",
    val cpf: String = "",
    val idade: Int = 0,
)
