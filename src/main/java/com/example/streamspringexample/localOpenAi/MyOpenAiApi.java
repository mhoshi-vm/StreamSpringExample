package com.example.streamspringexample.localOpenAi;

import com.theokanning.openai.client.OpenAiApi;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import io.reactivex.Single;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

public interface MyOpenAiApi extends OpenAiApi {

    @POST("v1/completions")
    Single<CompletionResult> createCompletion(@Body CompletionRequest var1);

    @Streaming
    @POST("v1/completions")
    Call<ResponseBody> createCompletionStream(@Body CompletionRequest var1);

    @POST("v1/chat/completions")
    Single<ChatCompletionResult> createChatCompletion(@Body ChatCompletionRequest var1);

    @Streaming
    @POST("v1/chat/completions")
    Call<ResponseBody> createChatCompletionStream(@Body ChatCompletionRequest var1);

}
