package software.mojo.xassert.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import software.mojo.xassert.XAssert;
import software.mojo.xassert.test.obj.CustomRuntimeException;
import software.mojo.xassert.test.obj.EqualClass;
import software.mojo.xassert.test.obj.SimpleClass;

public class XAssertTest {

  String error = "Runtime Exception Triggered";
  CustomRuntimeException ex = new CustomRuntimeException("Custom: " + error);

  // true
  @Test
  void isTrueTest() {
    XAssert.isTrue(true, error);
  }
  @Test
  void isTrueNoMessageTest() {
    XAssert.isTrue(true);
  }
  @Test
  void isTrueExceptionTest() {
    XAssert.isTrue(true, ex);
  }

  // true fail
  @Test
  void isTrueFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isTrue(false, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isTrueNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isTrue(false));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isTrueExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isTrue(false, ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // false
  @Test
  void isFalseTest() {
    XAssert.isFalse(false, error);
  }
  @Test
  void isFalseNoMessageTest() {
    XAssert.isFalse(false);
  }
  @Test
  void isFalseExceptionTest() {
    XAssert.isFalse(false, ex);
  }

  // false fail
  @Test
  void isFalseFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isFalse(true, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isFalseNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isFalse(true));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isFalseExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isFalse(true, ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // equal (string)
  @ParameterizedTest
  @ValueSource(strings = {"test", "", " ", " a", "a "})
  void isEqualStringTest(String s) {
    XAssert.isEqual(s, s, error);
  }
  @ParameterizedTest
  @ValueSource(strings = {"test", "", " ", " a", "a "})
  void isEqualStringNoMessageTest(String s) {
    XAssert.isEqual(s, s);
  }
  @ParameterizedTest
  @ValueSource(strings = {"test", "", " ", " a", "a "})
  void isEqualStringExceptionTest(String s) {
    XAssert.isEqual(s, s, ex);
  }

  // equal (string) fail
  @Test
  void isEqualStringFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual("test", "fail", error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isEqualStringNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual("test", "fail"));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isEqualStringExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isEqual("test", "fail", ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // equal (int)
  @Test
  void isEqualIntTest() {
    XAssert.isEqual(1, 1, error);
  }
  @Test
  void isEqualIntNoMessageTest() {
    XAssert.isEqual(1, 1);
  }
  @Test
  void isEqualIntExceptionTest() {
    XAssert.isEqual(1, 1, ex);
  }

  // equal (int) fail
  @Test
  void isEqualIntFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual(1, 0, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isEqualIntFailNoMessageTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual(1, 0));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isEqualIntFailExceptionTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isEqual(1, 0, ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // not equal (int)
  @Test
  void isNotEqualIntTest() {
    XAssert.isNotEqual(1, 0, error);
  }
  @Test
  void isNotEqualIntNoMessageTest() {
    XAssert.isNotEqual(1, 0);
  }
  @Test
  void isNotEqualExceptionIntTest() {
    XAssert.isNotEqual(1, 0, ex);
  }

  // not equal (int) fail
  @Test
  void isNotEqualIntFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotEqual(1, 1, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isNotEqualIntNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotEqual(1, 1));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isNotEqualIntExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isNotEqual(1, 1, ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // other Number
  @Test
  void isEqualDoubleTest() {
    XAssert.isEqual(1.0, 1.0, error);
  }
  @Test
  void isEqualDoubleFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual(1.0, 0.0, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isNotEqualDoubleTest() {
    XAssert.isNotEqual(1.0, 0.0, error);
  }
  @Test
  void isNotEqualDoubleFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotEqual(1.0, 1.0, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isEqualFloatTest() {
    XAssert.isEqual(1f, 1f, error);
  }
  @Test
  void isEqualFloatFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual(1f, 0f, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isNotEqualFloatTest() {
    XAssert.isNotEqual(1f, 0f, error);
  }
  @Test
  void isNotEqualFloatFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotEqual(1f, 1f, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  // equals (obj)
  @Test
  void isEqualObjRefTest() {
    var obj = new SimpleClass(1);
    XAssert.isEqual(obj, obj, error);
  }
  @Test
  void isEqualObjRefFailTest() {
    var obj1 = new SimpleClass(1);
    var obj2 = new SimpleClass(1);
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual(obj1, obj2, error));
  }
  @Test
  void isEqualObjEqualsTest() {
    var obj1 = new EqualClass(1);
    var obj2 = new EqualClass(1);
    XAssert.isEqual(obj1, obj2, error);
  }
  @Test
  void isEqualObjEqualsFailTest() {
    var obj1 = new EqualClass(1);
    var obj2 = new EqualClass(2);
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEqual(obj1, obj2, error));
  }

  // null
  @Test
  void isNullTest() {
    XAssert.isNull(null, error);
  }
  @Test
  void isNullNoMessageTest() {
    XAssert.isNull(null);
  }
  @Test
  void isNullExceptionTest() {
    XAssert.isNull(null, ex);
  }

  // null fail
  @Test
  void isNullFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNull(new SimpleClass(1), error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isNullFailNoMessageTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNull(new SimpleClass(1)));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isNullFailExceptionTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isNull(new SimpleClass(1), ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // not null
  @Test
  void isNotNullTest() {
    XAssert.isNotNull(new SimpleClass(1), error);
  }
  @Test
  void isNotNullNoMessageTest() {
    XAssert.isNotNull(new SimpleClass(1));
  }
  @Test
  void isNotNullExceptionTest() {
    XAssert.isNotNull(new SimpleClass(1), ex);
  }

  // not null fail
  @Test
  void isNotNullFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotNull(null, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isNotNullNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotNull(null));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isNotNullExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isNotNull(null, ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }


  // zero (int)
  @Test
  void isZeroIntTest() {
    XAssert.isZero(0, error);
  }
  @Test
  void isZeroIntNoMessageTest() {
    XAssert.isZero(0);
  }
  @Test
  void isZeroIntExceptionTest() {
    XAssert.isZero(0, ex);
  }

  // zero (other numbers)
  @Test
  void isZeroDoubleTest() {
    XAssert.isZero(0.0, error);
  }

  @Test
  void isZeroShortTest() {
    short s = 0;
    XAssert.isZero(s, error);
  }

  @Test
  void isZeroLongTest() {
    XAssert.isZero(0L, error);
  }

  @Test
  void isZeroFloatTest() {
    XAssert.isZero(0.0F, error);
  }

  // zero fail (int)
  @Test
  void isZeroIntFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isZero(1, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isZeroIntNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isZero(1));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isZeroIntExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isZero(1, ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // zero fail (other number)
  @Test
  void isZeroDoubleFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isZero(0.1, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  @Test
  void isZeroShortFailTest() {
    short s = 1;
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isZero(s, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  @Test
  void isZeroLongFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isZero(1L, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  @Test
  void isZeroFloatFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isZero(0.1F, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  // not zero (int)
  @Test
  void isNotZeroIntTest() {
    XAssert.isNotZero(1, error);
  }
  @Test
  void isNotZeroNoMessageIntTest() {
    XAssert.isNotZero(1);
  }
  @Test
  void isNotZeroExceptionIntTest() {
    XAssert.isNotZero(1, ex);
  }

  // not zero (other number)
  @Test
  void isNotZeroDoubleTest() {
    XAssert.isNotZero(0.1, error);
  }

  @Test
  void isNotZeroShortTest() {
    short s = 1;
    XAssert.isNotZero(s, error);
  }

  @Test
  void isNotZeroLongTest() {
    XAssert.isNotZero(1L, error);
  }

  @Test
  void isNotZeroFloatTest() {
    XAssert.isNotZero(0.1F, error);
  }

  // not zero fail (int)
  @Test
  void isNotZeroIntFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotZero(0, error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isNotZeroNoMessageIntFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotZero(0));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isNotZeroIntExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isNotZero(0, ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // not zero fail (other number)
  @Test
  void isNotZeroDoubleFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotZero(0.0, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  @Test
  void isNotZeroShortFailTest() {
    short s = 0;
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotZero(s, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  @Test
  void isNotZeroLongFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotZero(0L, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  @Test
  void isNotZeroFloatFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotZero(0.0F, error));
    Assertions.assertEquals(error, exception.getMessage());
  }

  // empty string
  @Test
  void isEmptyStringTest() {
    XAssert.isEmptyString("", error);
  }
  @Test
  void isEmptyStringNoMessageTest() {
    XAssert.isEmptyString("");
  }
  @Test
  void isEmptyStringExceptionTest() {
    XAssert.isEmptyString("", ex);
  }

  // empty string fail
  @Test
  void isEmptyStringFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEmptyString("string", error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isEmptyStringNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isEmptyString("string"));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isEmptyStringExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isEmptyString("string", ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }

  // not empty string
  @Test
  void isNotEmptyStringTest() {
    XAssert.isNotEmptyString("string", error);
  }
  @Test
  void isNotEmptyStringNoMessageTest() {
    XAssert.isNotEmptyString("string");
  }
  @Test
  void isNotEmptyStringExceptionTest() {
    XAssert.isNotEmptyString("string", ex);
  }

  // not empty string fail
  @Test
  void isNotEmptyStringFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotEmptyString("", error));
    Assertions.assertEquals(error, exception.getMessage());
  }
  @Test
  void isNotEmptyStringNoMessageFailTest() {
    Exception exception = Assertions.assertThrows(RuntimeException.class, () -> XAssert.isNotEmptyString(""));
    Assertions.assertTrue(exception.getMessage().startsWith("XAssert:"));
  }
  @Test
  void isNotEmptyStringExceptionFailTest() {
    Exception exception = Assertions.assertThrows(CustomRuntimeException.class, () -> XAssert.isNotEmptyString("", ex));
    Assertions.assertEquals(ex.getMessage(), exception.getMessage());
  }
}
