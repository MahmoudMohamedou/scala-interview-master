package com.particeep.test

object WhatsWrong1 {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {

    override val city = "Paris"
  }

/*first thing we suppose that the two sentences are write in a main method and inner a print
or println method if else no result will be appeard */


  Supporter.city //it's will be print "Paris" because the property are ovveride in a class Supporter. 
  Supporter.support /* it's will be we print "Ici c'est null !" because he inherit this
property from Interface, and in this interface city is not assign by anything so by default
 String object is null*/

/*for fix it you can just add after the first line in Supporter Class this sentences:
override val support: String = s"Ici c'est $city !";
and all code will be OK;
*/
}
