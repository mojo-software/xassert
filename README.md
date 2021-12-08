# XAssert
Helper class for replacing if-statements that throw a RuntimeException.
## Example
Old code:
```
if (obj == null) {
  throw new RuntimeException("Object cannot be null");
}
if (obj == obj2) {
  throw new RuntimeException("Object cannot be the same");
}
if (obj.getCount() != 0) {
  throw new RuntimeException("Count must be zero");
}
```
New code:
```
XAssert.isNotNull(obj, new RuntimeException("Object cannot be null");
XAssert.isNotEqual(obj2, obj, new RuntimeException("Object cannot be the same");
XAssert.isZero(obj.getCount(), new RuntimeException("Count must be zero");
```