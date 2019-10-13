package edu.stthomas.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class holding information about errors.
 */
public class Errors {
   private List<String> errors = new ArrayList();

   public List<String> getErrors() {
      return errors;
   }

   public void addError(String error) {
      this.errors.add(error);
   }
}
