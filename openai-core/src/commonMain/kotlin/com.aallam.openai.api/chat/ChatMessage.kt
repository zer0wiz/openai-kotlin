package com.aallam.openai.api.chat

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.OpenAIDsl
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The messages to generate chat completions for.
 */
@BetaOpenAI
@Serializable
public data class ChatMessage(
    /**
     * The role of the author of this message.
     */
    @SerialName("role") public val role: ChatRole,

    /**
     * The contents of the message.
     */
    @SerialName("content") public val content: String? = null,

    /**
     * The name of the author of this message.
     * [name] is required if role is `[ChatRole.Function], and it should be the name of the function whose response is
     * in the [content]. May contain a-z, A-Z, 0-9, and underscores, with a maximum length of 64 characters.
     */
    @SerialName("name") public val name: String? = null,

    /**
     * The name and arguments of a function that should be called, as generated by the model.
     */
    @SerialName("function_call") public val functionCall: FunctionCall? = null
)

/**
 * The messages to generate chat completions for.
 */
@BetaOpenAI
public fun chatMessage(block: ChatMessageBuilder.() -> Unit): ChatMessage =
    ChatMessageBuilder().apply(block).build()

/**
 * Builder of [ChatMessageBuilder] instances.
 */
@BetaOpenAI
@OpenAIDsl
public class ChatMessageBuilder {

    /**
     * The role of the author of this message.
     */
    public var role: ChatRole? = null

    /**
     * The contents of the message.
     */
    public var content: String? = null

    /**
     * The name of the author of this message.
     * [name] is required if role is `[ChatRole.Function], and it should be the name of the function whose response is
     * in the [content]. May contain a-z, A-Z, 0-9, and underscores, with a maximum length of 64 characters.
     */
    public var name: String? = null

    /**
     * The name and arguments of a function that should be called, as generated by the model.
     */
    public var functionCall: FunctionCall? = null

    /**
     * Create [ChatMessageBuilder] instance.
     */
    public fun build(): ChatMessage = ChatMessage(
        role = requireNotNull(role) { "role is required" },
        content = content,
        name = name,
        functionCall = functionCall,
    )
}
