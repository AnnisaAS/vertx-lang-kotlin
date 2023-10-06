/*
 * Copyright 2019 Red Hat, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The Apache License v2.0 is available at
 * http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.kotlin.core.http

import io.vertx.core.http.HttpClient
import io.vertx.core.http.HttpClientRequest
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.RequestOptions
import io.vertx.core.net.SSLOptions
import io.vertx.kotlin.coroutines.awaitResult

/**
 * Suspending version of method [io.vertx.core.http.HttpClient.request]
 *
 * @param options the request options
 * @return [HttpClientRequest]
 *
 * NOTE: This function has been automatically generated from [io.vertx.core.http.HttpClient] using Vert.x codegen.
 */
@Deprecated(message = "Instead use request returning a future and chain with await()", replaceWith = ReplaceWith("request(options).await()"))
suspend fun HttpClient.requestAwait(options: RequestOptions): HttpClientRequest {
  return awaitResult {
    this.request(options, it)
  }
}

/**
 * Suspending version of method [io.vertx.core.http.HttpClient.request]
 *
 * @param method the HTTP method
 * @param port the port
 * @param host the host
 * @param requestURI the relative URI
 * @return [HttpClientRequest]
 *
 * NOTE: This function has been automatically generated from [io.vertx.core.http.HttpClient] using Vert.x codegen.
 */
@Deprecated(message = "Instead use request returning a future and chain with await()", replaceWith = ReplaceWith("request(method, port, host, requestURI).await()"))
suspend fun HttpClient.requestAwait(method: HttpMethod, port: Int, host: String, requestURI: String): HttpClientRequest {
  return awaitResult {
    this.request(method, port, host, requestURI, it)
  }
}

/**
 * Suspending version of method [io.vertx.core.http.HttpClient.request]
 *
 * @param method the HTTP method
 * @param host the host
 * @param requestURI the relative URI
 * @return [HttpClientRequest]
 *
 * NOTE: This function has been automatically generated from [io.vertx.core.http.HttpClient] using Vert.x codegen.
 */
@Deprecated(message = "Instead use request returning a future and chain with await()", replaceWith = ReplaceWith("request(method, host, requestURI).await()"))
suspend fun HttpClient.requestAwait(method: HttpMethod, host: String, requestURI: String): HttpClientRequest {
  return awaitResult {
    this.request(method, host, requestURI, it)
  }
}

/**
 * Suspending version of method [io.vertx.core.http.HttpClient.request]
 *
 * @param method the HTTP method
 * @param requestURI the relative URI
 * @return [HttpClientRequest]
 *
 * NOTE: This function has been automatically generated from [io.vertx.core.http.HttpClient] using Vert.x codegen.
 */
@Deprecated(message = "Instead use request returning a future and chain with await()", replaceWith = ReplaceWith("request(method, requestURI).await()"))
suspend fun HttpClient.requestAwait(method: HttpMethod, requestURI: String): HttpClientRequest {
  return awaitResult {
    this.request(method, requestURI, it)
  }
}

/**
 * Suspending version of method [io.vertx.core.http.HttpClient.updateSSLOptions]
 *
 * @param options the new SSL options
 *
 * NOTE: This function has been automatically generated from [io.vertx.core.http.HttpClient] using Vert.x codegen.
 */
@Deprecated(message = "Instead use updateSSLOptions returning a future and chain with await()", replaceWith = ReplaceWith("updateSSLOptions(options).await()"))
suspend fun HttpClient.updateSSLOptionsAwait(options: SSLOptions): Unit {
  return awaitResult {
    this.updateSSLOptions(options, io.vertx.core.Handler { ar -> it.handle(ar.mapEmpty()) })
  }
}

/**
 * Suspending version of method [io.vertx.core.http.HttpClient.close]
 *
 *
 * NOTE: This function has been automatically generated from [io.vertx.core.http.HttpClient] using Vert.x codegen.
 */
@Deprecated(message = "Instead use close returning a future and chain with await()", replaceWith = ReplaceWith("close().await()"))
suspend fun HttpClient.closeAwait(): Unit {
  return awaitResult {
    this.close(io.vertx.core.Handler { ar -> it.handle(ar.mapEmpty()) })
  }
}

