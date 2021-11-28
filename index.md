# Introduction

CoreDSL 2 is a domain-specific language to model processor cores at the level of their *instruction set architecture* (ISA).
Its use cases include the generation of ISA-specific artifacts for compilers, instruction set simulators (ISS) and other validation purposes, as well as the the user-friendly specification of custom ISA extensions (ISAX) in conjunction with a high-level synthesis (HLS) tool.

Note that we consider supporting the generation of a *complete* core implementation solely from CoreDSL 2 to be a *non-goal*, as the language currently does not express any micro-architectural details.

Those who want to start with it should have a look at the [Programmer's manual](https://github.com/Minres/CoreDSL/wiki/CoreDSL-2-programmer's-manual).

Editor support is available for the Eclipse IDE, you can ad the plugins using the [update site](https://minres.github.io/CoreDSL/repository) https://minres.github.io/CoreDSL/repository.
