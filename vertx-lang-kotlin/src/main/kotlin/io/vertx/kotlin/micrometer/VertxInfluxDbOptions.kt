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
package io.vertx.kotlin.micrometer

import io.vertx.micrometer.VertxInfluxDbOptions

/**
 * A function providing a DSL for building [io.vertx.micrometer.VertxInfluxDbOptions] objects.
 *
 * Vert.x InfluxDb micrometer configuration.
 *
 * @param enabled  Set true to enable InfluxDB reporting
 * @param uri  URI of the InfluxDB server. <i>Example: http://influx:8086</i>.
 * @param db  Database name used to store metrics. Default is "default".
 * @param userName  Username used for authenticated connections
 * @param password  Password used for authenticated connections
 * @param retentionPolicy  InfluxDB retention policy
 * @param compressed  Activate or deactivate GZIP compression. It is activated by default.
 * @param step  Push interval steps, in seconds. Default is 10 seconds.
 * @param numThreads  Number of threads to use by the push scheduler. Default is 2.
 * @param connectTimeout  Connection timeout for InfluxDB server connections, in seconds. Default is 1 second.
 * @param readTimeout  Read timeout for InfluxDB server connections, in seconds. Default is 10 seconds.
 * @param batchSize  Maximum number of measurements sent per request to the InfluxDB server. When the maximum is reached, several requests are made. Default is 10000.
 * @param org  Specifies the destination organization for writes. Takes either the ID or Name interchangeably. This is only used with InfluxDB v2.
 * @param bucket  Specifies the destination bucket for writes. Takes either the ID or Name interchangeably. This is only used with InfluxDB v2.
 * @param token  Authentication token for the InfluxDB API. This takes precedence over userName/password if configured.
 *
 * <p/>
 * NOTE: This function has been automatically generated from the [io.vertx.micrometer.VertxInfluxDbOptions original] using Vert.x codegen.
 */
fun vertxInfluxDbOptionsOf(
  enabled: Boolean? = null,
  uri: String? = null,
  db: String? = null,
  userName: String? = null,
  password: String? = null,
  retentionPolicy: String? = null,
  compressed: Boolean? = null,
  step: Int? = null,
  numThreads: Int? = null,
  connectTimeout: Int? = null,
  readTimeout: Int? = null,
  batchSize: Int? = null,
  org: String? = null,
  bucket: String? = null,
  token: String? = null): VertxInfluxDbOptions = io.vertx.micrometer.VertxInfluxDbOptions().apply {

  if (enabled != null) {
    this.setEnabled(enabled)
  }
  if (uri != null) {
    this.setUri(uri)
  }
  if (db != null) {
    this.setDb(db)
  }
  if (userName != null) {
    this.setUserName(userName)
  }
  if (password != null) {
    this.setPassword(password)
  }
  if (retentionPolicy != null) {
    this.setRetentionPolicy(retentionPolicy)
  }
  if (compressed != null) {
    this.setCompressed(compressed)
  }
  if (step != null) {
    this.setStep(step)
  }
  if (numThreads != null) {
    this.setNumThreads(numThreads)
  }
  if (connectTimeout != null) {
    this.setConnectTimeout(connectTimeout)
  }
  if (readTimeout != null) {
    this.setReadTimeout(readTimeout)
  }
  if (batchSize != null) {
    this.setBatchSize(batchSize)
  }
  if (org != null) {
    this.setOrg(org)
  }
  if (bucket != null) {
    this.setBucket(bucket)
  }
  if (token != null) {
    this.setToken(token)
  }
}

