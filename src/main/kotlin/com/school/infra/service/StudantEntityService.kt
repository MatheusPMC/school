package com.school.infra.service

import com.school.core.mapper.StudantConverter
import com.school.core.model.Studant
import com.school.core.port.StudantRepositoryPort
import com.school.infra.model.StudantEntity
import com.school.infra.repository.StudantEntityRepository
import jakarta.inject.Singleton

@Singleton
class StudantEntityService(private val studantEntityRepository: StudantEntityRepository): StudantRepositoryPort {
    override fun studantFindCpf(cpf: String): Studant {
        val studantEntityResult = studantEntityRepository.getCpfStudant(cpf)
        return StudantConverter.studantEntityToStudant(studantEntityResult!!)
    }

    override fun studantCreated(studantEntity: StudantEntity): Studant? {
        val studantEntityResult = studantEntityRepository.createdStudant(studantEntity)
        return StudantConverter.studantEntityToStudant(studantEntityResult)
    }
}