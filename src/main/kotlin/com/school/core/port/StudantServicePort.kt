package com.school.core.port

import com.school.core.model.Studant
import com.school.entry.model.StudantDto
import jakarta.inject.Singleton

@Singleton
interface StudantServicePort {
    fun getCpfStudant(cpf: String): StudantDto?
    fun createStudant(studant: Studant): StudantDto
}