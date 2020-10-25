// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragments_with_type_condition_nullable.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.String
import kotlin.Suppress

/**
 * An autonomous mechanical character in the Star Wars universe
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
interface DroidDetails : GraphqlFragment {
  val __typename: String

  /**
   * What others call this droid
   */
  val name: String

  /**
   * This droid's primary function
   */
  val primaryFunction: String?

  /**
   * An autonomous mechanical character in the Star Wars universe
   */
  data class DroidDetailsImpl(
    override val __typename: String = "Droid",
    /**
     * What others call this droid
     */
    override val name: String,
    /**
     * This droid's primary function
     */
    override val primaryFunction: String?
  ) : DroidDetails {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        DroidDetails_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment DroidDetails on Droid {
        |  __typename
        |  name
        |  primaryFunction
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): DroidDetails {
      return DroidDetails_ResponseAdapter.fromResponse(reader)
    }

    fun Mapper(): ResponseFieldMapper<DroidDetails> {
      return ResponseFieldMapper { reader ->
        DroidDetails_ResponseAdapter.fromResponse(reader)
      }
    }
  }
}
