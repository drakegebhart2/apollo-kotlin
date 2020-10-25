// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_inline_fragment

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.root_query_inline_fragment.type.Episode
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forObject("hero", "hero", null, true, null),
    ResponseField.forObject("droid", "droid", mapOf<String, Any>(
      "id" to "1"), true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var __typename: String? = __typename
      var hero: TestQuery.Hero? = null
      var droid: TestQuery.Droid? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> hero = readObject<TestQuery.Hero>(RESPONSE_FIELDS[1]) { reader ->
            TestQuery_ResponseAdapter.Hero_ResponseAdapter.fromResponse(reader)
          }
          2 -> droid = readObject<TestQuery.Droid>(RESPONSE_FIELDS[2]) { reader ->
            TestQuery_ResponseAdapter.Droid_ResponseAdapter.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        __typename = __typename!!,
        hero = hero,
        droid = droid
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[1], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[1]) { writer ->
        TestQuery_ResponseAdapter.Hero_ResponseAdapter.toResponse(writer, value.hero)
      }
    }
    if(value.droid == null) {
      writer.writeObject(RESPONSE_FIELDS[2], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
        TestQuery_ResponseAdapter.Droid_ResponseAdapter.toResponse(writer, value.droid)
      }
    }
  }

  object HumanHero_ResponseAdapter : ResponseAdapter<TestQuery.HumanHero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forList("appearsIn", "appearsIn", null, false, null),
      ResponseField.forDouble("height", "height", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.HumanHero {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var appearsIn: List<Episode?>? = null
        var height: Double? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
              Episode.safeValueOf(reader.readString())
            }
            3 -> height = readDouble(RESPONSE_FIELDS[3])
            else -> break
          }
        }
        TestQuery.HumanHero(
          __typename = __typename!!,
          name = name!!,
          appearsIn = appearsIn!!,
          height = height
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.HumanHero) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { values, listItemWriter ->
        values?.forEach { value ->
          listItemWriter.writeString(value?.rawValue)}
      }
      writer.writeDouble(RESPONSE_FIELDS[3], value.height)
    }
  }

  object OtherHero_ResponseAdapter : ResponseAdapter<TestQuery.OtherHero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forList("appearsIn", "appearsIn", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.OtherHero {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var appearsIn: List<Episode?>? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
              Episode.safeValueOf(reader.readString())
            }
            else -> break
          }
        }
        TestQuery.OtherHero(
          __typename = __typename!!,
          name = name!!,
          appearsIn = appearsIn!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.OtherHero) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { values, listItemWriter ->
        values?.forEach { value ->
          listItemWriter.writeString(value?.rawValue)}
      }
    }
  }

  object Hero_ResponseAdapter : ResponseAdapter<TestQuery.Hero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forList("appearsIn", "appearsIn", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Hero {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "Human" -> TestQuery_ResponseAdapter.HumanHero_ResponseAdapter.fromResponse(reader, typename)
        else -> TestQuery_ResponseAdapter.OtherHero_ResponseAdapter.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Hero) {
      when(value) {
        is TestQuery.HumanHero -> TestQuery_ResponseAdapter.HumanHero_ResponseAdapter.toResponse(writer, value)
        is TestQuery.OtherHero -> TestQuery_ResponseAdapter.OtherHero_ResponseAdapter.toResponse(writer, value)
      }
    }
  }

  object Droid_ResponseAdapter : ResponseAdapter<TestQuery.Droid> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Droid {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var primaryFunction: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> primaryFunction = readString(RESPONSE_FIELDS[2])
            else -> break
          }
        }
        TestQuery.Droid(
          __typename = __typename!!,
          name = name!!,
          primaryFunction = primaryFunction
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Droid) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
    }
  }
}
