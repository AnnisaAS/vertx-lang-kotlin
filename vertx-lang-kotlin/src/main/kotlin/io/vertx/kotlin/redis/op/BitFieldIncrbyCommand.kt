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
package io.vertx.kotlin.redis.op

import io.vertx.redis.op.BitFieldIncrbyCommand

/**
 * A function providing a DSL for building [io.vertx.redis.op.BitFieldIncrbyCommand] objects.
 *
 *
 * @param increment 
 * @param offset 
 * @param type 
 *
 * <p/>
 * NOTE: This function has been automatically generated from the [io.vertx.redis.op.BitFieldIncrbyCommand original] using Vert.x codegen.
 */
fun bitFieldIncrbyCommandOf(
  increment: Long? = null,
  offset: Long? = null,
  type: String? = null): BitFieldIncrbyCommand = io.vertx.redis.op.BitFieldIncrbyCommand().apply {

  if (increment != null) {
    this.setIncrement(increment)
  }
  if (offset != null) {
    this.setOffset(offset)
  }
  if (type != null) {
    this.setType(type)
  }
}

/**
 * A function providing a DSL for building [io.vertx.redis.op.BitFieldIncrbyCommand] objects.
 *
 *
 * @param increment 
 * @param offset 
 * @param type 
 *
 * <p/>
 * NOTE: This function has been automatically generated from the [io.vertx.redis.op.BitFieldIncrbyCommand original] using Vert.x codegen.
 */
@Deprecated(
  message = "This function will be removed in a future version",
  replaceWith = ReplaceWith("bitFieldIncrbyCommandOf(increment, offset, type)")
)
fun BitFieldIncrbyCommand(
  increment: Long? = null,
  offset: Long? = null,
  type: String? = null): BitFieldIncrbyCommand = io.vertx.redis.op.BitFieldIncrbyCommand().apply {

  if (increment != null) {
    this.setIncrement(increment)
  }
  if (offset != null) {
    this.setOffset(offset)
  }
  if (type != null) {
    this.setType(type)
  }
}

