package com.school.core.service

import com.school.core.mapper.StudantConverter
import com.school.core.model.Studant
import com.school.core.port.StudantRepositoryPort
import com.school.core.port.StudantServicePort
import com.school.entry.model.StudantDto
import jakarta.inject.Singleton

@Singleton
class StudantService(
    private val studantRepositoryPort: StudantRepositoryPort): StudantServicePort {
    override fun getCpfStudant(cpf: String): StudantDto? {
        val studantEntityResult = studantRepositoryPort.studantFindCpf(cpf)
        return StudantConverter.studantToStudantDto(studantEntityResult!!)
    }

    override fun createStudant(studant: Studant): StudantDto {
        val result = StudantConverter.studantToStudantEntity(studant)
        val studantEntityResult = studantRepositoryPort.studantCreated(result)
        return StudantConverter.studantToStudantDto(studantEntityResult!!)
    }

}