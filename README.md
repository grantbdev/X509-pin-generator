# X509-pin-generator
Java program to generate a Base64 encoded SHA1 hash of an X509 certificate's public key. The pin format is compatible with OkHttp.

I was inspired by [scottyab's similar tool](https://github.com/scottyab/ssl-pin-generator), which generates the same type of pins by connecting to a network host. The main motivation for my tool is to generate certificate pins before the certificate is deployed to a server.

##Usage

Download the [latest release](https://github.com/grantbdev/X509-pin-generator/releases) compiled jar or source code. The project uses Gradle as its build system.

This tool does not use the network. It will only generate the pin for the certificate file you pass to it:

`java -jar X509PinGenerator-1.1.jar [certificate file name]`

Output format:

`sha1/AAAAAAAAAAAAAAAAAAAAAAAAAAA=`

##License
The MIT License

Copyright (c) 2016 Grant Bourque http://grantbourque.com