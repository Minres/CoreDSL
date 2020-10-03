package com.minres.coredsl.util;

import com.minres.coredsl.coreDsl.BitField;
import com.minres.coredsl.coreDsl.DataTypes;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class DataType {
  private final DataTypes type;
  
  private final Integer size;
  
  public static DataType get(final BitField bf) {
    int _intValue = bf.getBitRange().getLeft().getValue().intValue();
    return new DataType(DataTypes.UNSIGNED, Integer.valueOf(_intValue));
  }
  
  public DataType(final DataTypes type, final Integer size) {
    super();
    this.type = type;
    this.size = size;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
    return prime * result + ((this.size== null) ? 0 : this.size.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DataType other = (DataType) obj;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    if (this.size == null) {
      if (other.size != null)
        return false;
    } else if (!this.size.equals(other.size))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("type", this.type);
    b.add("size", this.size);
    return b.toString();
  }
  
  @Pure
  public DataTypes getType() {
    return this.type;
  }
  
  @Pure
  public Integer getSize() {
    return this.size;
  }
}
