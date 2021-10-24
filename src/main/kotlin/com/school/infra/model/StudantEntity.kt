package com.school.infra.model

import io.micronaut.core.annotation.Introspected
import org.bson.types.ObjectId
import java.util.*

@Introspected
data class StudantEntity(
    var id: String? = null,
    val nome: String = "",
    val cpf: String = "",
    val idade: Int = 0,
)
