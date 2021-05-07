# CoreDSL

This repo contains the XText bundles/plugins for CoreDSL. The bundles can be installed from https://minres.com/download/repository/CoreDSL

## References

https://www.lysator.liu.se/c/ANSI-C-grammar-y.html

## EBNF

The generated ANTLR grammar (DebugInternalCoreDsl.g) can be converted into EBNF using https://bottlecaps.de/convert/ to create a formal specification of the language


## Type conversion rules

### The C language rules for implicit conversions

1. If one operand is of type long double, then the other operand will be converted to long double and then the result of the operation will be a long double.

2. Otherwise, If one operand is of type double then the other operand will be converted to double and the result of the operation will be a double.

3. Otherwise, If one operand is of type float then the other operand will be converted to float and the result of the operation will be a float.

4. Otherwise, If one operand is of type unsigned long int then the other operand will be converted to unsigned long int and the result of the operation will be an unsigned long int.

5. Otherwise, If one operand is of type long intand the other is of type unsigned int then there are two possibilities:
   
   If long int can represent all the values of an unsigned int, the operand of type unsigned int will be converted to long int and the result will be a long int.
   
   Otherwise, If long int can't represent all the values of an unsigned int, the operand of both of the operands will be converted to unsigned long int and the result will be an unsigned long int.

6. Otherwise, If one operand is of type long int then the other operand will be converted to long int and the result of the operation will be a long int.
    
7. Otherwise, If one operand is of type unsigned int then the other operand will be converted to unsigned int and the result of the operation will be an unsigned int.

8. Otherwise, If one operand is of type int then the other operand will be converted to int and the result of the operation will be an int.

### Proposed implicit type conversion rules for CoreDSL

1. If one operand is of type long double, then the other operand will be converted to long double and then the result of the operation will be a long double.

2. Otherwise, if one operand is of type double then the other operand will be converted to double and the result of the operation will be a double.

3. Otherwise, if one operand is of type float then the other operand will be converted to float and the result of the operation will be a float.

4. Otherwise, if both operands are unsigned the shorter operand will be converted to the size of the larger operand

5. Otherwise, if both operands are signed the shorter operand will be converted to the size of the larger operand

6. Otherwise, if one operand is signed and the other is unsigned the unsigned operand will be converted to the signed with the size of the signed operand if the signed operand can hold the numeric range of the unsigned (e.g. is at least 1 bit larger)

7. Otherwise no implicit type conversion happens
