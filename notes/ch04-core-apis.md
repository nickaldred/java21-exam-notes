# Chapter 4 - Core API's

## Array functions

### Compare

| Scenario | Comparison Logic | Return Value |
| :--- | :--- | :--- |
| **Identical Arrays** | Both arrays contain the same elements in the same order. | **0** |
| **Element Mismatch** | The first index `i` where `a[i] != b[i]`. | **Negative** if `a[i] < b[i]` <br> **Positive** if `a[i] > b[i]` |
| **Prefix Match** | One array is a shorter version (prefix) of the other. | **Negative** if `a` is shorter <br> **Positive** if `a` is longer |
| **Null Elements** | Comparing a `null` element vs a non-null element. | **Negative** if `a[i]` is null <br> **Positive** if `b[i]` is null |
| **Null Arrays** | One or both of the actual array references are `null`. | **0** if both null <br> **Negative** if `a` is null <br> **Positive** if `b` is null |

### Mismatch

| Scenario | Mismatch Logic | Return Value |
| :--- | :--- | :--- |
| **Identical Arrays** | All elements match and lengths are equal. | **-1** |
| **Element Mismatch** | The first index `i` where `a[i]` does not equal `b[i]`. | **The index `i`** (e.g., 0, 1, 2...) |
| **Prefix Match** | One array is a shorter version of the other (e.g., `{1}` vs `{1, 2}`). | **Length of shorter array** |
| **One Array Empty** | One array has elements, the other is `length = 0`. | **0** |
| **Both Arrays Empty** | Both arrays have `length = 0`. | **-1** |
| **Null Elements** | Comparing a `null` vs a non-null object. | **The index `i`** where the null is found |

## Math functions

| Method | Argument Type(s) | Return Type | Description |
| :--- | :--- | :--- | :--- |
| **Math.min(a, b)** | int, long, float, double | **Same as input** | Returns the smaller of two values. |
| **Math.max(a, b)** | int, long, float, double | **Same as input** | Returns the larger of two values. |
| **Math.round(a)** | float | **int** | Rounds to nearest whole number (.5 rounds up). |
| | double | **long** | |
| **Math.ceil(a)** | double | **double** | Rounds **up** (toward positive infinity). |
| **Math.floor(a)** | double | **double** | Rounds **down** (toward negative infinity). |
| **Math.pow(a, b)** | double, double | **double** | Returns first argument raised to the power of the second. |
| **Math.random()** | None | **double** | Returns a value $x$ where $0.0 \le x < 1.0$. |

## DateTime
