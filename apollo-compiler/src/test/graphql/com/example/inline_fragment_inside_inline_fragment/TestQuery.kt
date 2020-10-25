// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragment_inside_inline_fragment

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery : Query<TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      TestQuery_ResponseAdapter.fromResponse(reader)
    }
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return parse(Buffer().write(byteString), scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> {
    return parse(source, DEFAULT)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> {
    return parse(byteString, DEFAULT)
  }

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString {
    return OperationRequestBodyComposer.compose(
      operation = this,
      autoPersistQueries = false,
      withQueryDocument = true,
      scalarTypeAdapters = scalarTypeAdapters
    )
  }

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  /**
   * A character from the Star Wars universe
   */
  interface Character : Search {
    override val __typename: String

    /**
     * The name of the character
     */
    val name: String

    override fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * An autonomous mechanical character in the Star Wars universe
   */
  interface Droid : Search {
    override val __typename: String

    /**
     * What others call this droid
     */
    val name: String

    /**
     * This droid's primary function
     */
    val primaryFunction: String?

    override fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * A character from the Star Wars universe
   */
  interface Character1 : Search {
    override val __typename: String

    /**
     * The name of the character
     */
    val name: String

    override fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * A humanoid creature from the Star Wars universe
   */
  interface Human : Search {
    override val __typename: String

    /**
     * What this human calls themselves
     */
    val name: String

    /**
     * The home planet of the human, or null if unknown
     */
    val homePlanet: String?

    override fun marshaller(): ResponseFieldMarshaller
  }

  data class CharacterDroidSearch(
    override val __typename: String,
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * This droid's primary function
     */
    override val primaryFunction: String?
  ) : Character1, Droid, Search {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestQuery_ResponseAdapter.CharacterDroidSearch_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  data class CharacterHumanSearch(
    override val __typename: String,
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The home planet of the human, or null if unknown
     */
    override val homePlanet: String?
  ) : Character1, Human, Search {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestQuery_ResponseAdapter.CharacterHumanSearch_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  data class OtherSearch(
    override val __typename: String = "SearchResult"
  ) : Search {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestQuery_ResponseAdapter.OtherSearch_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  interface Search {
    val __typename: String

    fun asCharacter1(): Character1? = this as? Character1

    fun asDroid(): Droid? = this as? Droid

    fun asHuman(): Human? = this as? Human

    fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val search: List<Search?>?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestQuery_ResponseAdapter.toResponse(writer, this)
      }
    }

    fun searchFilterNotNull(): List<Search>? = search?.filterNotNull()
  }

  companion object {
    const val OPERATION_ID: String =
        "4f32ea4bdd2a95a29bde61273602c22c698cd333f1701001d1a339fb276c6438"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  search(text: "bla-bla") {
          |    __typename
          |    ... on Character {
          |      __typename
          |      name
          |      ... on Human {
          |        homePlanet
          |      }
          |      ... on Droid {
          |        primaryFunction
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "TestQuery"
      }
    }
  }
}
