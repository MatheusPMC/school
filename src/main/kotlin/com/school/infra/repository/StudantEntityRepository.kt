package com.school.infra.repository

import com.school.core.model.Studant
import com.school.infra.model.StudantEntity
import jakarta.inject.Singleton

@Singleton
interface StudantEntityRepository {
    fun getCpfStudant(cpf: String): StudantEntity?
    fun createdStudant(studantEntity: StudantEntity): StudantEntity
}