# CoreDSL

CoreDSL 2 is a domain-specific language to model processor cores at the level of their instruction set architecture (ISA). Its use cases include the generation of ISA-specific artifacts for compilers, instruction set simulators (ISS) and other validation purposes, as well as the user-friendly specification of custom ISA extensions (ISAX) in conjunction with a high-level synthesis (HLS) tool.

The VSCode extension provides a language server for the [CoreDSL](https://github.com/Minres/CoreDSL) language which resolves cross references and validates the syntax.

## Language documentation

[Programmer's manual](https://github.com/Minres/CoreDSL/wiki/CoreDSL-2-programmer's-manual)

## Standalone validator

The project provides a standalone validator as part of the releases, the bundle com.minres.coredsl.validator-2.Y.ZZ.jar contains an all-in-one jar for the validator. It can be used after downloading as follows:

```
java -jar com.minres.coredsl.repository/target/com.minres.coredsl.validator-2.Y.ZZ.jar -r <path to inc dir> <core_desc file>
```
