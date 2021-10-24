package com.school.core.mapper

import com.school.core.model.Studant
import com.school.entry.model.StudantDto
import com.school.infra.model.StudantEntity
import jakarta.inject.Singleton

@Singleton
class StudantConverter {
    companion object {
        fun studantDtoToStudant(studantDto: StudantDto) =
            Studant(
                studantDto.id,
                studantDto.nome,
                studantDto.cpf,
                studantDto.idade
            )

        fun studantToStudantEntity(studant: Studant) =
            StudantEntity(
                studant.id,
                studant.nome,
                studant.cpf,
                studant.idade
            )

        fun studantEntityToStudant(studantEntity: StudantEntity) =
            Studant(
                studantEntity.id,
                studantEntity.nome,
                studantEntity.cpf,
                studantEntity.idade
            )

        fun studantToStudantDto(studant: Studant) =
            StudantDto(
                studant.id,
                studant.nome,
                studant.cpf,
                studant.idade
            )
    }
}