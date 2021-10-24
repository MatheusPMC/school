package com.school.entry.rest

import com.school.core.mapper.StudantConverter
import com.school.core.port.StudantServicePort
import com.school.entry.model.StudantDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

@Controller
class StudantController(private val studantServicePort: StudantServicePort) {

    @Get
    fun getStudant() {

    }

    @Get("/{cpf}")
    fun getCpfStudant(@PathVariable cpf: String): HttpResponse<Any> {
        return HttpResponse.ok(HttpStatus.OK).body(studantServicePort.getCpfStudant(cpf))

    }

    @Post
    fun postStudant(@Body studantDto: StudantDto): HttpResponse<Any> {
        val result = StudantConverter.studantDtoToStudant(studantDto)
        return HttpResponse.created(HttpStatus.CREATED).body(studantServicePort.createStudant(result))
    }

    @Delete("/{cpf}")
    fun deleteStudant(@PathVariable cpf: String) {

    }
}