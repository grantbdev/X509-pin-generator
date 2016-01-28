package com.grantbourque;

/**
 * X509PinGenerator takes a local X.509 certificate file as input
 * and generates a certificate pin in this format:
 * sha1/AAAAAAAAAAAAAAAAAAAAAAAAAAA=
 * <p>
 * This format is a SHA1 hash of the certificate's public key encoded in Base64
 * and is used by Google Chrome and the OkHttp library for certificate pinning.
 */
public class X509PinGenerator {
}
