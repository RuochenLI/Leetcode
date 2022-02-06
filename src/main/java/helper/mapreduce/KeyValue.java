package helper.mapreduce;

/**
 * A key-value pair.
 */
public final class KeyValue implements Comparable<KeyValue> {

  private final String key;
  private final String value;

  public KeyValue(String key, String value) {
    if (key == null) {
      throw new IllegalArgumentException("You must always supply a key.");
    }
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("(");
    builder.append(key);
    builder.append(", ");
    builder.append(value);
    builder.append(")");
    return builder.toString();
  }

  @Override
  public int compareTo(KeyValue o) {
    return key.compareTo(o.key);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    KeyValue other = (KeyValue) obj;
    if (key == null) {
      if (other.key != null) {
        return false;
      }
    } else if (!key.equals(other.key)) {
      return false;
    }
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
    }
    return true;
  }

}
