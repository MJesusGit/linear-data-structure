package lists;

import java.util.*;
import java.util.function.UnaryOperator;

class Op implements UnaryOperator<String> {
   public String apply(String str) {
      return str.toUpperCase();
   }
}
