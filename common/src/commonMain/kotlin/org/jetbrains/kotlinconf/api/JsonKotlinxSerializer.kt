package org.jetbrains.kotlinconf.api

import io.ktor.client.call.TypeInfo
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.http.ContentType
import io.ktor.http.content.OutgoingContent
import io.ktor.http.content.TextContent
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JSON
import org.jetbrains.kotlinconf.data.Repository
import kotlin.reflect.KClass

class JsonKotlinxSerializer : JsonSerializer {
    val mappers = mutableMapOf<KClass<Any>, KSerializer<Any>>()

    /**
     * Set mapping from [type] to generated [KSerializer].
     */
    //fun <T : Any> setMapper(type: KClass<T>, serializer: KSerializer<T>) {
    //    mappers[type as KClass<Any>] = serializer as KSerializer<Any>
    //}

    inline fun <reified T> setMapper(serializer: KSerializer<T>) {
        mappers[T::class as KClass<Any>] = serializer as KSerializer<Any>
    }

    override fun write(data: Any): OutgoingContent {
        @Suppress("UNCHECKED_CAST")
        val content = JSON.nonstrict.stringify(mappers[data::class]!!, data)
        return TextContent(content, ContentType.Application.Json)
    }

    override suspend fun read(type: TypeInfo, response: HttpResponse): Any {
        val mapper = mappers[type.type]!!
        val text = response.readText()

        return JSON.nonstrict.parse(mapper, text)
    }
}