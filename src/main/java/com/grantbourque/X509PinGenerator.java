package com.grantbourque;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * X509PinGenerator takes a local X.509 certificate file as input
 * and generates a certificate pin in this format:
 * sha1/AAAAAAAAAAAAAAAAAAAAAAAAAAA=
 * <p>
 * This format is a SHA1 hash of the certificate's public key encoded in Base64
 * and is used by Google Chrome and the OkHttp library for certificate pinning.
 */
public class X509PinGenerator {

   /**
    *
    * @param args file name of X.509 certificate
    */
   public static void main(String[] args) throws IOException {
      if (args.length == 1 && !args[0].equalsIgnoreCase("help")) {
         generateAndPrintPin(args[0]);
      } else {
         printUsage();
      }
   }

   private static void printUsage() {
      System.out.println("Usage: java -jar X509PinGenerator-1.0.jar [certificate file name]");
   }

   /**
    *
    * @param fileName file name of X.509 certificate
    */
   private static void generateAndPrintPin(String fileName) throws IOException {
      InputStream inStream = null;
      try {
         inStream = new FileInputStream(fileName);
         CertificateFactory cf = CertificateFactory.getInstance("X.509");
         X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
         MessageDigest digest = MessageDigest.getInstance("SHA-1");
         byte[] pubKey = cert.getPublicKey().getEncoded();
         final byte[] hash = digest.digest(pubKey);
         System.out.println("sha1/" + Base64.getEncoder().encodeToString(hash));
      } catch (FileNotFoundException | CertificateException | NoSuchAlgorithmException e) {
         e.printStackTrace();
      } finally {
         if (inStream != null) {
            inStream.close();
         }
      }
   }
}
