package com.particeep.test

/**
  * Tell developer names by the department code
  * Expected result:
  * Map(frontend -> List(Remy, Alexandre), analytics -> List(Pierre), api -> List(Noe))
  */

import scala.util.control.Breaks._
object MapYourMap {

/*the Idea is very Simple it's will be make a loop around the devNames and will be regard 
if i passed before to a devDepartments if yes I take devNames and i will be add it to the list
of devNames existing before if no i will be create a new departements.
*/

  val devNames = Map("dev1" -> "Pierre", "dev2" -> "Remy", "dev3" -> "Noe", "dev4" -> "Alexandre")
  val devDepartments = Map("dev1" -> "analytics", "dev2" -> "frontend", "dev3" -> "api", "dev4" -> "frontend")

  val namesInDepartments:Map[String, List[String]] = {
      //declare variable result
      var res = Map[String, List[String]]();
      
      //get a keys
      var keys = devNames.keys;
      
//make a loop around the keys
      for (x <- keys){
//if empty this means that are to first element of keys list
          if (res.isEmpty) {
              //create new departement
              res = res + (devDepartments(x) -> List(devNames(x)));
          }
          //if else we will make again a loop around res in this time
//and we will make a search to now if the devDepartments(x) has already exist
//in a another words if devDepartments(x) is a key in res Map
          else {
              var exist = false;
              var keystemp = res.keys;
              
    breakable  
    { 
              for (y <- keystemp) {
//if yes we don't have to create a new devDepartments
                  if (y == devDepartments(x)) {
                      res = res +(y -> (devNames(x) :: res(y)));
                      exist = true;
                      break;
                  } 
              }
    }
              //if exit = false this means that the departement is not exist 
              // and it's will be created
              if (!exist) {
                   res = res + (devDepartments(x) -> List(devNames(x)));
              }
              
          }
      }
      
      res;
}

}
