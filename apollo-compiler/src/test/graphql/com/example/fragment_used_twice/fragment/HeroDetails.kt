// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.Any
import kotlin.String
import kotlin.Suppress

/**
 * A character from the Star Wars universe
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
interface HeroDetails : GraphqlFragment {
  val __typename: String

  /**
   * The name of the character
   */
  val name: String

  /**
   * A character from the Star Wars universe
   */
  data class HeroDetailsImpl(
    override val __typename: String = "Character",
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The date character was born.
     */
    override val birthDate: Any
  ) : HeroDetails, CharacterDetails {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetails_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment HeroDetails on Character {
        |  __typename
        |  name
        |  ...CharacterDetails
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): HeroDetails {
      return HeroDetails_ResponseAdapter.fromResponse(reader)
    }

    fun Mapper(): ResponseFieldMapper<HeroDetails> {
      return ResponseFieldMapper { reader ->
        HeroDetails_ResponseAdapter.fromResponse(reader)
      }
    }
  }
}
