[![Java CI with Maven](https://github.com/Minres/CoreDSL/actions/workflows/maven.yml/badge.svg)](https://github.com/Minres/CoreDSL/actions/workflows/maven.yml)

# CoreDSL

This repo contains the XText bundles/plugins for [CoreDSL](https://minres.github.io/CoreDSL). The OSGI bundles can be installed from https://minres.github.io/CoreDSL/repository.

## Language documentation

[Programmer's manual](https://github.com/Minres/CoreDSL/wiki/CoreDSL-2-programmer's-manual)

## Standalone validator

The project provides a standalone validator. After building the project with Maven:

```
mvn package
```

the com.minres.coredsl.repository bundle contains an all-in-one jar for the validator. It can be used as follows:

```
java -jar com.minres.coredsl.repository/target/com.minres.coredsl.validator-2.0.20.jar -r <path to inc dir> <core_desc file>
```

## Building VSCode plugin

* fix version number in build.gradle
* run 
  ```
  (cd vscode-extension-self-contained/; ../gradlew clean vscodeExtension)
  ```

## References

https://www.lysator.liu.se/c/ANSI-C-grammar-y.html

## EBNF

The generated ANTLR grammar (DebugInternalCoreDsl.g) can be converted into EBNF using https://bottlecaps.de/convert/ to create a formal specification of the language
