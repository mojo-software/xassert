package software.mojo.xassert;

public class XAssert {

  //
  // boolean
  //

  // true

  /**
   * Returns if the {@code boolean} expression evaluates to {@code true}, otherwise the
   * {@code RuntimeException} is thrown.
   *
   * @param expression
   *        The expression to be evaluated
   * @param throwable
   *        The {@code RuntimeException} that will be thrown
   */
  public static void isTrue(boolean expression, RuntimeException throwable) {
    if (!expression) {
      throw throwable;
    }
  }

  /**
   * Returns if the {@code boolean} expression evaluates to {@code true}, otherwise a
   * {@code RuntimeException} is thrown with the error message.
   *
   * @param expression
   *        The expression to be evaluated
   * @param error
   *        The error message to be added to the {@code RuntimeException}
   */
  public static void isTrue(boolean expression, String error) {
    isTrue(expression, new RuntimeException(error));
  }

  /**
   * Returns if the {@code boolean} expression evaluates to {@code true}, otherwise a
   * {@code RuntimeException} is thrown with a generic message indicating that the expression
   * evaluated to {@code false}.
   *
   * @param expression
   *        The expression to be evaluated
   */
  public static void isTrue(boolean expression) {
    isTrue(expression, new RuntimeException(XAssertMessage.IS_FALSE.message));
  }

  // false

  /**
   * Returns if the {@code boolean} expression evaluates to {@code false}, otherwise the
   * {@code RuntimeException} is thrown.
   *
   * @param expression
   *        The expression to be evaluated
   * @param throwable
   *        The {@code RuntimeException} that will be thrown
   */
  public static void isFalse(boolean expression, RuntimeException throwable) {
    isTrue(!expression, throwable);
  }

  /**
   * Returns if the {@code boolean} expression evaluates to {@code false}, otherwise a
   * {@code RuntimeException} is thrown with a generic message indicating that the expression
   * evaluated to {@code true}.
   *
   * @param expression
   *        The expression to be evaluated
   */
  public static void isFalse(boolean expression) {
    isFalse(expression, new RuntimeException(XAssertMessage.IS_TRUE.message));
  }

  /**
   * Returns if the {@code boolean} expression evaluates to {@code false}, otherwise a
   * {@code RuntimeException} is thrown with the error message.
   *
   * @param expression
   *        The expression to be evaluated
   * @param error
   *        The error message to be added to the {@code RuntimeException}
   */
  public static void isFalse(boolean expression, String error) {
    isFalse(expression, new RuntimeException(error));
  }

  //
  // Object
  //

  // Equal

  /**
   * Returns if the expected object and the object are "equal" according to the expected object's
   * {@code equals} method or if both the expected object and object are {@code null}, otherwise the
   * {@code RuntimeException} is thrown.
   *
   * @param expected
   *        The expected object to be compared to
   * @param obj
   *        The object to compare
   * @param throwable
   *        The {@code RuntimeException} that will be thrown
   */
  public static void isEqual(Object expected, Object obj, RuntimeException throwable) {
    if (expected == null) {
      isNull(obj, throwable);
      return;
    }
    isTrue(expected.equals(obj), throwable);
  }

  /**
   * Returns if the expected object and the object are "equal" according to the expected object's
   * {@code equals} method or if both the expected object and object are both {@code null},
   * otherwise a {@code RuntimeException} is thrown with a generic message indicating that objects
   * are not equal or that they are not both @{code null} if the expected object is {@code null}.
   *
   * @param expected
   *        The expected object to be compared to
   * @param obj
   *        The object to compare
   */
  public static void isEqual(Object expected, Object obj) {
    if (expected == null) {
      isNull(obj);
      return;
    }
    isTrue(expected.equals(obj), new RuntimeException(XAssertMessage.NOT_EQUAL.message));
  }

  /**
   * Returns if the expected object and the object are "equal" according to the expected object's
   * {@code equals} method or if both the expected object and object are {@code null},
   * otherwise a {@code RuntimeException} is thrown with the error message.
   *
   * @param expected
   *        The expected object to be compared to
   * @param obj
   *        The object to compare
   * @param error
   *        The error message to be added to the {@code RuntimeException}
   */
  public static void isEqual(Object expected, Object obj, String error) {
    if (expected == null) {
      isNull(obj, error);
      return;
    }
    isTrue(expected.equals(obj), new RuntimeException(error != null ? error : XAssertMessage.NOT_EQUAL.message));
  }

  // Not equal

  /**
   * Returns if the expected object and the object are not "equal" according to the
   * expected object's {@code equals} method or if the expected object is {@code null} and the
   * object is not {@code null}, otherwise a {@code RuntimeException} is thrown with a
   * generic message indicating that objects are equal.
   *
   * @param expected
   *        The expected object to be compared to
   * @param obj
   *        The object to compare
   */
  public static void isNotEqual(Object expected, Object obj) {
    if (expected == null) {
      isNotNull(obj);
      return;
    }
    isTrue(!expected.equals(obj), new RuntimeException(XAssertMessage.EQUAL.message));
  }

  /**
   * Returns if the expected object and the object are not "equal" according to the
   * expected object's {@code equals} method or if the expected object is {@code null} and the
   * object is not {@code null}, otherwise a {@code RuntimeException} is thrown with the error
   * message.
   *
   * @param expected
   *        The expected object to be compared to
   * @param obj
   *        The object to compare
   * @param error
   *        The error message to be added to the {@code RuntimeException}
   */
  public static void isNotEqual(Object expected, Object obj, String error) {
    if (expected == null) {
      isNotNull(error);
      return;
    }
    isTrue(!expected.equals(obj), new RuntimeException(error));
  }

  /**
   * Returns if the expected object and the object are not "equal" according to the
   * expected object's {@code equals} method or if the expected object is {@code null} and the
   * object is not {@code null}, otherwise the {@code RuntimeException} is thrown.
   *
   * @param expected
   *        The expected object to be compared to
   * @param obj
   *        The object to compare
   * @param throwable
   *        The {@code RuntimeException} that will be thrown
   */
  public static void isNotEqual(Object expected, Object obj, RuntimeException throwable) {
    if (expected == null) {
      isNotNull(obj, throwable);
      return;
    }
    isTrue(!expected.equals(obj), throwable);
  }

  // NULL

  /**
   * Returns if the object is {@code null}, otherwise a {@code RuntimeException} is thrown with a
   * generic message indicating that the object is not @{code null}.
   *
   * @param obj
   *        The object that should be null
   */
  public static void isNull(Object obj) {
    isNull(obj, XAssertMessage.NOT_NULL.message);
  }

  /**
   * Returns if the object is {@code null}, otherwise a {@code RuntimeException} is thrown with the
   * error message.
   *
   * @param obj
   *        The object that should be null
   * @param error
   *        The error message to be added to the {@code RuntimeException}
   */
  public static void isNull(Object obj, String error) {
    isTrue(obj == null, error);
  }

  /**
   * Returns if the object is {@code null}, otherwise the {@code RuntimeException} is thrown.
   *
   * @param obj
   *        The object that should be null
   * @param throwable
   *        The {@code RuntimeException} that will be thrown
   */
  public static void isNull(Object obj, RuntimeException throwable) {
    isTrue(obj == null, throwable);
  }

  // Not NULL

  /**
   * Returns if the object is not {@code null}, otherwise a {@code RuntimeException} is thrown with
   * a generic message indicating that the object is not {@code null}.
   *
   * @param obj
   *        The object that should not be null
   */
  public static void isNotNull(Object obj) {
    isNotNull(obj, XAssertMessage.NULL.message);
  }

  /**
   * Returns if the object is not {@code null}, otherwise a {@code RuntimeException} is thrown with
   * the error message.
   *
   * @param obj
   *        The object that should not be null
   * @param error
   *        The error message to be added to the {@code RuntimeException}
   */
  public static void isNotNull(Object obj, String error) {
    isTrue(obj != null, error);
  }

  /**
   * Returns if the object is not {@code null}, otherwise the {@code RuntimeException} is thrown.
   *
   * @param obj
   *        The object that should not be null
   * @param throwable
   *        The {@code RuntimeException} that will be thrown
   */
  public static void isNotNull(Object obj, RuntimeException throwable) {
    isTrue(obj != null, throwable);
  }

  //
  // Number
  //

  // Zero
  public static void isZero(Number n) {
    isTrue(isZeroValue(n), XAssertMessage.NOT_ZERO.message);
  }
  public static void isZero(Number n, String error) {
    isTrue(isZeroValue(n), error);
  }
  public static void isZero(Number n, RuntimeException ex) {
    isTrue(isZeroValue(n), ex);
  }

  // Not zero
  public static void isNotZero(Number n) {
    isTrue(!isZeroValue(n), XAssertMessage.ZERO.message);
  }
  public static void isNotZero(Number n, String error) {
    isTrue(!isZeroValue(n), error);
  }
  public static void isNotZero(Number n, RuntimeException ex) {
    isTrue(!isZeroValue(n), ex);
  }

  private static boolean isZeroValue(Number n) {
    return (
        n instanceof Integer ? n.intValue() == 0 :
            n instanceof Long ? n.longValue() == 0 :
                n instanceof Double ? n.doubleValue() == 0 :
                    n instanceof Short ? n.shortValue() == 0 :
                        n.floatValue() == 0
    );
  }

  //
  // String
  //

  // Empty
  public static void isEmptyString(String s) {
    isTrue(s.isEmpty(), XAssertMessage.NOT_EMPTY_STRING.message);
  }
  public static void isEmptyString(String s, String error) {
    isTrue(s.isEmpty(), error);
  }
  public static void isEmptyString(String s, RuntimeException ex) {
    isTrue(s.isEmpty(), ex);
  }

  // Not empty
  public static void isNotEmptyString(String s) {
    isTrue(!s.isEmpty(), XAssertMessage.EMPTY_STRING.message);
  }
  public static void isNotEmptyString(String s, String error) {
    isTrue(!s.isEmpty(), error);
  }
  public static void isNotEmptyString(String s, RuntimeException ex) {
    isTrue(!s.isEmpty(), ex);
  }

  //
  // private
  //

  private enum XAssertMessage {
    IS_FALSE("expression is false"),
    IS_TRUE("expression is true"),
    NOT_EQUAL("objects are not equal"),
    EQUAL("objects are equal"),
    NOT_NULL("not null value"),
    NULL("null value"),
    NOT_ZERO("not zero"),
    ZERO("zero"),
    NOT_EMPTY_STRING("non-empty string"),
    EMPTY_STRING("empty string");

    private final String message;

    XAssertMessage(String message) {
      this.message = String.format("XAssert: %s. ", message);
    }
  }
}
