package com.school.core.port

import com.school.core.model.Studant
import com.school.infra.model.StudantEntity
import jakarta.inject.Singleton

@Singleton
interface StudantRepositoryPort {
    fun studantFindCpf(cpf: String): Studant
    fun studantCreated(studantEntity: StudantEntity): Studant?
}