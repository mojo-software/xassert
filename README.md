# XAssert
Helper class for replacing if-statements that throw a RuntimeException.

## Supported Assertions
|Assertion|Parameter(s) Type|
|---|---|
|isTrue, isFalse|boolean|
|isEqual, isNotEqual|Object|
|isNull, isNotNull|Object|
|isZero, isNotZero|Number|
|isEmptyString, isNotEmptyString|String|

## Examples
### Null Check (simple) throws RuntimeException
Java:
```
if (obj == null) {
  throw new RuntimeException();
}
```
XAssert replacement:
```
XAssert.isNotNull(obj);
```
Log output:
```
XAssert: null value
```

### Null Check (custom message) throws RuntimeException
Java:
```
if (obj == null) {
  throw new RuntimeException("obj cannot be null");
}
```
XAssert replacement:
```
XAssert.isNotNull(obj, "obj cannot be null");
```
Log output:
```
obj cannot be null
```

### Null Check (custom exception)
Java:
```
if (obj == null) {
  throw new MyCutsomRuntimeException("obj cannot be null");
}
```
XAssert replacement:
```
XAssert.isNotNull(obj, new MyCustomRuntimeException("obj cannot be null"));
```
