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
package io.vertx.kotlin.ext.web.client

import io.vertx.ext.web.client.CachingWebClientOptions
import io.netty.handler.logging.ByteBufFormat
import io.vertx.core.http.Http2Settings
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.JksOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.ProxyOptions
import io.vertx.core.tracing.TracingPolicy
import io.vertx.uritemplate.ExpandOptions
import java.util.concurrent.TimeUnit

/**
 * A function providing a DSL for building [io.vertx.ext.web.client.CachingWebClientOptions] objects.
 *
 *
 * @param sendBufferSize  Set the TCP send buffer size
 * @param receiveBufferSize  Set the TCP receive buffer size
 * @param reuseAddress  Set the value of reuse address
 * @param trafficClass  Set the value of traffic class
 * @param logActivity  Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
 * @param activityLogDataFormat  Set the value of Netty's logging handler's data format: Netty's pipeline is configured for logging on Netty's logger.
 * @param reusePort  Set the value of reuse port. <p/> This is only supported by native transports.
 * @param tcpNoDelay  Set whether TCP no delay is enabled
 * @param tcpKeepAlive  Set whether TCP keep alive is enabled
 * @param soLinger  Set whether SO_linger keep alive is enabled
 * @param idleTimeout  Set the idle timeout, default time unit is seconds. Zero means don't timeout. This determines if a connection will timeout and be closed if no data is received nor sent within the timeout. If you want change default time unit, use [io.vertx.ext.web.client.CachingWebClientOptions]
 * @param readIdleTimeout  Set the read idle timeout, default time unit is seconds. Zero means don't timeout. This determines if a connection will timeout and be closed if no data is received within the timeout. If you want change default time unit, use [io.vertx.ext.web.client.CachingWebClientOptions]
 * @param writeIdleTimeout  Set the write idle timeout, default time unit is seconds. Zero means don't timeout. This determines if a connection will timeout and be closed if no data is sent within the timeout. If you want change default time unit, use [io.vertx.ext.web.client.CachingWebClientOptions]
 * @param idleTimeoutUnit  Set the idle timeout unit. If not specified, default is seconds.
 * @param ssl  Set whether SSL/TLS is enabled
 * @param keyStoreOptions  Set the key/cert options in jks format, aka Java keystore.
 * @param pfxKeyCertOptions  Set the key/cert options in pfx format.
 * @param pemKeyCertOptions  Set the key/cert store options in pem format.
 * @param trustOptions  Set the trust options.
 * @param trustStoreOptions  Set the trust options in jks format, aka Java truststore
 * @param pfxTrustOptions  Set the trust options in pfx format
 * @param pemTrustOptions  Set the trust options in pem format
 * @param enabledCipherSuites  Add an enabled cipher suite, appended to the ordered suites.
 * @param crlPaths  Add a CRL path
 * @param crlValues  Add a CRL value
 * @param useAlpn  Set the ALPN usage.
 * @param sslEngineOptions  Set to use SSL engine implementation to use.
 * @param jdkSslEngineOptions 
 * @param openSslEngineOptions 
 * @param tcpFastOpen  Enable the <code>TCP_FASTOPEN</code> option - only with linux native transport.
 * @param tcpCork  Enable the <code>TCP_CORK</code> option - only with linux native transport.
 * @param tcpQuickAck  Enable the <code>TCP_QUICKACK</code> option - only with linux native transport.
 * @param tcpUserTimeout  Sets the <code>TCP_USER_TIMEOUT</code> option - only with linux native transport.
 * @param enabledSecureTransportProtocols  Sets the list of enabled SSL/TLS protocols.
 * @param sslHandshakeTimeout  Set the SSL handshake timeout, default time unit is seconds.
 * @param sslHandshakeTimeoutUnit  Set the SSL handshake timeout unit. If not specified, default is seconds.
 * @param trustAll  Set whether all server certificates should be trusted
 * @param connectTimeout  Set the connect timeout
 * @param metricsName  Set the metrics name identifying the reported metrics, useful for grouping metrics with the same name.
 * @param proxyOptions  Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
 * @param nonProxyHosts  Set a list of remote hosts that are not proxied when the client is configured to use a proxy. This list serves the same purpose than the JVM <code>nonProxyHosts</code> configuration. <p> Entries can use the <i>*</i> wildcard character for pattern matching, e.g <i>*.example.com</i> matches <i>www.example.com</i>.
 * @param localAddress  Set the local interface to bind for network connections. When the local address is null, it will pick any local address, the default local address is null.
 * @param http2MultiplexingLimit  Set a client limit of the number concurrent streams for each HTTP/2 connection, this limits the number of streams the client can create for a connection. The effective number of streams for a connection is the min of this value and the server's initial settings. <p/> Setting the value to <code>-1</code> means to use the value sent by the server's initial settings. <code>-1</code> is the default value.
 * @param http2ConnectionWindowSize  Set the default HTTP/2 connection window size. It overrides the initial window size set by , so the connection window size is greater than for its streams, in order the data throughput. <p/> A value of <code>-1</code> reuses the initial window size setting.
 * @param http2KeepAliveTimeout  Set the keep alive timeout for HTTP/2 connections, in seconds. <p/> This value determines how long a connection remains unused in the pool before being evicted and closed. <p/> A timeout of <code>0</code> means there is no timeout.
 * @param keepAlive  Set whether keep alive is enabled on the client
 * @param keepAliveTimeout  Set the keep alive timeout for HTTP/1.x, in seconds. <p/> This value determines how long a connection remains unused in the pool before being evicted and closed. <p/> A timeout of <code>0</code> means there is no timeout.
 * @param pipelining  Set whether pipe-lining is enabled on the client
 * @param pipeliningLimit  Set the limit of pending requests a pipe-lined HTTP/1 connection can send.
 * @param verifyHost  Set whether hostname verification is enabled
 * @param tryUseCompression  Set whether compression is enabled
 * @param defaultHost  Set the default host name to be used by this client in requests if none is provided when making the request.
 * @param defaultPort  Set the default port to be used by this client in requests if none is provided when making the request.
 * @param protocolVersion  Set the protocol version.
 * @param maxChunkSize  Set the maximum HTTP chunk size
 * @param maxInitialLineLength  Set the maximum length of the initial line for HTTP/1.x (e.g. <code>"HTTP/1.1 200 OK"</code>)
 * @param maxHeaderSize  Set the maximum length of all headers for HTTP/1.x .
 * @param initialSettings  Set the HTTP/2 connection settings immediately sent by to the server when the client connects.
 * @param alpnVersions  Set the list of protocol versions to provide to the server during the Application-Layer Protocol Negotiation. When the list is empty, the client provides a best effort list according to [io.vertx.ext.web.client.CachingWebClientOptions]: <ul>   <li>: [ "h2", "http/1.1" ]</li>   <li>otherwise: [[io.vertx.core.http.HttpClientOptions]]</li> </ul>
 * @param http2ClearTextUpgrade  Set to <code>true</code> when an <i>h2c</i> connection is established using an HTTP/1.1 upgrade request, and <code>false</code> when an <i>h2c</i> connection is established directly (with prior knowledge).
 * @param http2ClearTextUpgradeWithPreflightRequest  Set to <code>true</code> when an <i>h2c</i> connection established using an HTTP/1.1 upgrade request should perform a preflight <code>OPTIONS</code> request to the origin server to establish the <i>h2c</i> connection.
 * @param maxRedirects  Set to <code>maxRedirects</code> the maximum number of redirection a request can follow.
 * @param forceSni  By default, the server name is only sent for Fully Qualified Domain Name (FQDN), setting this property to <code>true</code> forces the server name to be always sent.
 * @param decoderInitialBufferSize  set to <code>initialBufferSizeHttpDecoder</code> the initial buffer of the HttpDecoder.
 * @param tracingPolicy  Set the tracing policy for the client behavior when Vert.x has tracing enabled.
 * @param shared  Set to <code>true</code> to share the client. <p> There can be multiple shared clients distinguished by [io.vertx.core.http.HttpClientOptions], when no specific name is set, the [io.vertx.core.http.HttpClientOptions] is used.
 * @param name  Set the client name, used when the client is shared, otherwise ignored.
 * @param userAgentEnabled  Sets whether the Web Client should send a user agent header. Defaults to true.
 * @param userAgent  Sets the Web Client user agent header. Defaults to Vert.x-WebClient/&lt;version&gt;.
 * @param followRedirects  Configure the default behavior of the client to follow HTTP <code>30x</code> redirections.
 * @param templateExpandOptions 
 * @param enableVaryCaching  Configure the client cache behavior for <code>Vary</code> responses.
 * @param cachedStatusCodes  Configure the status codes that can be cached.
 * @param cachedMethods  Configure the HTTP methods that can be cached.
 * @param keyCertOptions  Set the key/cert options.
 *
 * <p/>
 * NOTE: This function has been automatically generated from the [io.vertx.ext.web.client.CachingWebClientOptions original] using Vert.x codegen.
 */
fun cachingWebClientOptionsOf(
  sendBufferSize: Int? = null,
  receiveBufferSize: Int? = null,
  reuseAddress: Boolean? = null,
  trafficClass: Int? = null,
  logActivity: Boolean? = null,
  activityLogDataFormat: ByteBufFormat? = null,
  reusePort: Boolean? = null,
  tcpNoDelay: Boolean? = null,
  tcpKeepAlive: Boolean? = null,
  soLinger: Int? = null,
  idleTimeout: Int? = null,
  readIdleTimeout: Int? = null,
  writeIdleTimeout: Int? = null,
  idleTimeoutUnit: TimeUnit? = null,
  ssl: Boolean? = null,
  keyStoreOptions: io.vertx.core.net.JksOptions? = null,
  pfxKeyCertOptions: io.vertx.core.net.PfxOptions? = null,
  pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions? = null,
  trustOptions: io.vertx.core.net.TrustOptions? = null,
  trustStoreOptions: io.vertx.core.net.JksOptions? = null,
  pfxTrustOptions: io.vertx.core.net.PfxOptions? = null,
  pemTrustOptions: io.vertx.core.net.PemTrustOptions? = null,
  enabledCipherSuites: Iterable<String>? = null,
  crlPaths: Iterable<String>? = null,
  crlValues: Iterable<io.vertx.core.buffer.Buffer>? = null,
  useAlpn: Boolean? = null,
  sslEngineOptions: io.vertx.core.net.SSLEngineOptions? = null,
  jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions? = null,
  openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions? = null,
  tcpFastOpen: Boolean? = null,
  tcpCork: Boolean? = null,
  tcpQuickAck: Boolean? = null,
  tcpUserTimeout: Int? = null,
  enabledSecureTransportProtocols: Iterable<String>? = null,
  sslHandshakeTimeout: Long? = null,
  sslHandshakeTimeoutUnit: TimeUnit? = null,
  trustAll: Boolean? = null,
  connectTimeout: Int? = null,
  metricsName: String? = null,
  proxyOptions: io.vertx.core.net.ProxyOptions? = null,
  nonProxyHosts: Iterable<String>? = null,
  localAddress: String? = null,
  http2MultiplexingLimit: Int? = null,
  http2ConnectionWindowSize: Int? = null,
  http2KeepAliveTimeout: Int? = null,
  keepAlive: Boolean? = null,
  keepAliveTimeout: Int? = null,
  pipelining: Boolean? = null,
  pipeliningLimit: Int? = null,
  verifyHost: Boolean? = null,
  tryUseCompression: Boolean? = null,
  defaultHost: String? = null,
  defaultPort: Int? = null,
  protocolVersion: HttpVersion? = null,
  maxChunkSize: Int? = null,
  maxInitialLineLength: Int? = null,
  maxHeaderSize: Int? = null,
  initialSettings: io.vertx.core.http.Http2Settings? = null,
  alpnVersions: Iterable<HttpVersion>? = null,
  http2ClearTextUpgrade: Boolean? = null,
  http2ClearTextUpgradeWithPreflightRequest: Boolean? = null,
  maxRedirects: Int? = null,
  forceSni: Boolean? = null,
  decoderInitialBufferSize: Int? = null,
  tracingPolicy: TracingPolicy? = null,
  shared: Boolean? = null,
  name: String? = null,
  userAgentEnabled: Boolean? = null,
  userAgent: String? = null,
  followRedirects: Boolean? = null,
  templateExpandOptions: io.vertx.uritemplate.ExpandOptions? = null,
  enableVaryCaching: Boolean? = null,
  cachedStatusCodes: Iterable<Int>? = null,
  cachedMethods: Iterable<io.vertx.core.http.HttpMethod>? = null,
  keyCertOptions: io.vertx.core.net.KeyCertOptions? = null): CachingWebClientOptions = io.vertx.ext.web.client.CachingWebClientOptions().apply {

  if (sendBufferSize != null) {
    this.setSendBufferSize(sendBufferSize)
  }
  if (receiveBufferSize != null) {
    this.setReceiveBufferSize(receiveBufferSize)
  }
  if (reuseAddress != null) {
    this.setReuseAddress(reuseAddress)
  }
  if (trafficClass != null) {
    this.setTrafficClass(trafficClass)
  }
  if (logActivity != null) {
    this.setLogActivity(logActivity)
  }
  if (activityLogDataFormat != null) {
    this.setActivityLogDataFormat(activityLogDataFormat)
  }
  if (reusePort != null) {
    this.setReusePort(reusePort)
  }
  if (tcpNoDelay != null) {
    this.setTcpNoDelay(tcpNoDelay)
  }
  if (tcpKeepAlive != null) {
    this.setTcpKeepAlive(tcpKeepAlive)
  }
  if (soLinger != null) {
    this.setSoLinger(soLinger)
  }
  if (idleTimeout != null) {
    this.setIdleTimeout(idleTimeout)
  }
  if (readIdleTimeout != null) {
    this.setReadIdleTimeout(readIdleTimeout)
  }
  if (writeIdleTimeout != null) {
    this.setWriteIdleTimeout(writeIdleTimeout)
  }
  if (idleTimeoutUnit != null) {
    this.setIdleTimeoutUnit(idleTimeoutUnit)
  }
  if (ssl != null) {
    this.setSsl(ssl)
  }
  if (keyStoreOptions != null) {
    this.setKeyStoreOptions(keyStoreOptions)
  }
  if (pfxKeyCertOptions != null) {
    this.setPfxKeyCertOptions(pfxKeyCertOptions)
  }
  if (pemKeyCertOptions != null) {
    this.setPemKeyCertOptions(pemKeyCertOptions)
  }
  if (trustOptions != null) {
    this.setTrustOptions(trustOptions)
  }
  if (trustStoreOptions != null) {
    this.setTrustStoreOptions(trustStoreOptions)
  }
  if (pfxTrustOptions != null) {
    this.setPfxTrustOptions(pfxTrustOptions)
  }
  if (pemTrustOptions != null) {
    this.setPemTrustOptions(pemTrustOptions)
  }
  if (enabledCipherSuites != null) {
    for (item in enabledCipherSuites) {
      this.addEnabledCipherSuite(item)
    }
  }
  if (crlPaths != null) {
    for (item in crlPaths) {
      this.addCrlPath(item)
    }
  }
  if (crlValues != null) {
    for (item in crlValues) {
      this.addCrlValue(item)
    }
  }
  if (useAlpn != null) {
    this.setUseAlpn(useAlpn)
  }
  if (sslEngineOptions != null) {
    this.setSslEngineOptions(sslEngineOptions)
  }
  if (jdkSslEngineOptions != null) {
    this.setJdkSslEngineOptions(jdkSslEngineOptions)
  }
  if (openSslEngineOptions != null) {
    this.setOpenSslEngineOptions(openSslEngineOptions)
  }
  if (tcpFastOpen != null) {
    this.setTcpFastOpen(tcpFastOpen)
  }
  if (tcpCork != null) {
    this.setTcpCork(tcpCork)
  }
  if (tcpQuickAck != null) {
    this.setTcpQuickAck(tcpQuickAck)
  }
  if (tcpUserTimeout != null) {
    this.setTcpUserTimeout(tcpUserTimeout)
  }
  if (enabledSecureTransportProtocols != null) {
    this.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.toSet())
  }
  if (sslHandshakeTimeout != null) {
    this.setSslHandshakeTimeout(sslHandshakeTimeout)
  }
  if (sslHandshakeTimeoutUnit != null) {
    this.setSslHandshakeTimeoutUnit(sslHandshakeTimeoutUnit)
  }
  if (trustAll != null) {
    this.setTrustAll(trustAll)
  }
  if (connectTimeout != null) {
    this.setConnectTimeout(connectTimeout)
  }
  if (metricsName != null) {
    this.setMetricsName(metricsName)
  }
  if (proxyOptions != null) {
    this.setProxyOptions(proxyOptions)
  }
  if (nonProxyHosts != null) {
    this.setNonProxyHosts(nonProxyHosts.toList())
  }
  if (localAddress != null) {
    this.setLocalAddress(localAddress)
  }
  if (http2MultiplexingLimit != null) {
    this.setHttp2MultiplexingLimit(http2MultiplexingLimit)
  }
  if (http2ConnectionWindowSize != null) {
    this.setHttp2ConnectionWindowSize(http2ConnectionWindowSize)
  }
  if (http2KeepAliveTimeout != null) {
    this.setHttp2KeepAliveTimeout(http2KeepAliveTimeout)
  }
  if (keepAlive != null) {
    this.setKeepAlive(keepAlive)
  }
  if (keepAliveTimeout != null) {
    this.setKeepAliveTimeout(keepAliveTimeout)
  }
  if (pipelining != null) {
    this.setPipelining(pipelining)
  }
  if (pipeliningLimit != null) {
    this.setPipeliningLimit(pipeliningLimit)
  }
  if (verifyHost != null) {
    this.setVerifyHost(verifyHost)
  }
  if (tryUseCompression != null) {
    this.setTryUseCompression(tryUseCompression)
  }
  if (defaultHost != null) {
    this.setDefaultHost(defaultHost)
  }
  if (defaultPort != null) {
    this.setDefaultPort(defaultPort)
  }
  if (protocolVersion != null) {
    this.setProtocolVersion(protocolVersion)
  }
  if (maxChunkSize != null) {
    this.setMaxChunkSize(maxChunkSize)
  }
  if (maxInitialLineLength != null) {
    this.setMaxInitialLineLength(maxInitialLineLength)
  }
  if (maxHeaderSize != null) {
    this.setMaxHeaderSize(maxHeaderSize)
  }
  if (initialSettings != null) {
    this.setInitialSettings(initialSettings)
  }
  if (alpnVersions != null) {
    this.setAlpnVersions(alpnVersions.toList())
  }
  if (http2ClearTextUpgrade != null) {
    this.setHttp2ClearTextUpgrade(http2ClearTextUpgrade)
  }
  if (http2ClearTextUpgradeWithPreflightRequest != null) {
    this.setHttp2ClearTextUpgradeWithPreflightRequest(http2ClearTextUpgradeWithPreflightRequest)
  }
  if (maxRedirects != null) {
    this.setMaxRedirects(maxRedirects)
  }
  if (forceSni != null) {
    this.setForceSni(forceSni)
  }
  if (decoderInitialBufferSize != null) {
    this.setDecoderInitialBufferSize(decoderInitialBufferSize)
  }
  if (tracingPolicy != null) {
    this.setTracingPolicy(tracingPolicy)
  }
  if (shared != null) {
    this.setShared(shared)
  }
  if (name != null) {
    this.setName(name)
  }
  if (userAgentEnabled != null) {
    this.setUserAgentEnabled(userAgentEnabled)
  }
  if (userAgent != null) {
    this.setUserAgent(userAgent)
  }
  if (followRedirects != null) {
    this.setFollowRedirects(followRedirects)
  }
  if (templateExpandOptions != null) {
    this.setTemplateExpandOptions(templateExpandOptions)
  }
  if (enableVaryCaching != null) {
    this.setEnableVaryCaching(enableVaryCaching)
  }
  if (cachedStatusCodes != null) {
    this.setCachedStatusCodes(cachedStatusCodes.toSet())
  }
  if (cachedMethods != null) {
    this.setCachedMethods(cachedMethods.toSet())
  }
  if (keyCertOptions != null) {
    this.setKeyCertOptions(keyCertOptions)
  }
}

