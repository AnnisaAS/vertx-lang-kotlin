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
package io.vertx.kotlin.ext.auth.htpasswd

import io.vertx.ext.auth.htpasswd.HtpasswdAuthOptions

/**
 * A function providing a DSL for building [io.vertx.ext.auth.htpasswd.HtpasswdAuthOptions] objects.
 *
 * Options configuring htpasswd authentication.
 *
 * @param plainTextEnabled 
 * @param htpasswdFile 
 *
 * <p/>
 * NOTE: This function has been automatically generated from the [io.vertx.ext.auth.htpasswd.HtpasswdAuthOptions original] using Vert.x codegen.
 */
fun htpasswdAuthOptionsOf(
  plainTextEnabled: Boolean? = null,
  htpasswdFile: String? = null): HtpasswdAuthOptions = io.vertx.ext.auth.htpasswd.HtpasswdAuthOptions().apply {

  if (plainTextEnabled != null) {
    this.setPlainTextEnabled(plainTextEnabled)
  }
  if (htpasswdFile != null) {
    this.setHtpasswdFile(htpasswdFile)
  }
}

