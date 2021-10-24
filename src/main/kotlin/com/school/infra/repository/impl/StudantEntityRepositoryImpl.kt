package com.school.infra.repository.impl

import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Filters.eq
import com.school.core.model.Studant
import com.school.infra.model.StudantEntity
import com.school.infra.repository.StudantEntityRepository
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import java.util.*
import javax.management.ObjectName
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Singleton
class StudantEntityRepositoryImpl(private val mongoClient: MongoClient) : StudantEntityRepository {
    override fun getCpfStudant(cpf: String): StudantEntity? {
        var result = colletion
            .find(eq("cpf", cpf))
            .toList()

        println(result)

        return StudantEntity()
    }

    override fun createdStudant(studantEntity: StudantEntity): StudantEntity {
        studantEntity.id = UUID.randomUUID().toString()
        println(studantEntity)
        colletion
            .insertOne(studantEntity)
        println(studantEntity)
        return studantEntity
    }
//    fun create(company: Company): InsertOneResult =
//        getCollection()
//            .insertOne(company)
//
//    fun findAll(): List<Company> =
//        getCollection()
//            .find()
//            .toList()
//
//
//    fun update(id: String, update: Company): UpdateResult =
//        getCollection()
//            .replaceOne(
//                Filters.eq("_id", ObjectId(id)),
//                update
//            )
//
//    fun deleteById(id: String): DeleteResult =
//        getCollection()
//            .deleteOne(
//                Filters.eq("_id", ObjectId(id))
//            )

    private val colletion =
        mongoClient
            .getDatabase("school")
            .getCollection("studant", StudantEntity::class.java)
}