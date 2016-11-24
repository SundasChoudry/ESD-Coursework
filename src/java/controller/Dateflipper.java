package controller;
/**
 *
 * @author n2-duran
 */
public class Dateflipper {
    String date = "10-4-1999";
   
    String flip = date.replaceAll("(..)-(..)-(....)", "$3-$2-$1");
}
