package com.particeep.test

/**
  * This is basic language questions so don't use external library or build in function
  */
object BasicScala {


  /**
    * Encode parameter in url format
    *
    * Example:
    *
    * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
    * output : "?sort_by=name&order_by=asc&user_id=12"
    *
    * input  : Map()
    * output : ""
    */
  def encodeParamsInUrl(params: Map[String, String]): String = {
        //check if the Map is empty if true return "";
        if (params.isEmpty) {
            return "";
            
        }
       // if else we make a loop arround the map and adding "&"
       // we can immediatly observe that the last character will be "&"
//to solve this problem we will juste "remove" this character after the loop
        else {
             val keys = params.keys;
             var s = "?";
             for (x <- keys){
            s = s+x+"="+params(x)+"&";
           }
        //we remove the last character beacause it is "&"
        s = s.substring(0,s.length()-1);
        
        return s;
        }
        
        
    }


  /**
    * Test if a String is an email
    * NB : I have any information of your side can't tell me what's exacly a valid mail. so I use google
    * and for google this is the requirements :
    *A valid email address is comprised of three sections: a local part, the at-sign (@), and a domain name. If this format is not followed, then the address becomes invalid.

    *According to the specifications of most Internet mail systems, the local part may use any of the following ASCII standard characters:

    *digits—0 to 9
    *lowercase and uppercase Latin letters—a to z and A to Z
    *printable characters—!#$%&’*+-/=?^_`{|}~
    *dot—., as long as it is not the initial or final character, or is not used consecutively
    *
    *
    *Furthermore, the domain name section of the email address may consist of the following characters:

    *digits—0 to 9
    *lowercase and uppercase Latin letters—a to z and A to Z
    *hyphen or dot — – or . , as long as they are not the initial or final characters 
    *
    *so this Algorithme solve the probleme for this requierements
    */
     def isEmail(maybeEmail: String): Boolean = {
       var localDomain = maybeEmail.split("@");
       
       //character valid in local party
       val regexLocal:String = "[a-zA-Z0-9!#$%&'*+-/=?^_`{|}~.]";
       // character valid in domain party
       var regexDomain:String = "[a-zA-Z0-9.-]";
       
       // test if they don't have one @ or more than 2 in the maybeEmail
       if (localDomain.length == 0 || localDomain.length == 1 || localDomain.length>2)
                return false;
        else{
            var local:String = localDomain(0);
            var domain:String = localDomain(1);
            // if else maybe one element of localDomain is an empty so that means 
            // that @ is the first or the last character

            if (local == "" || domain == "") {
                return false;
            }
            
//verify if the initial or the last character not are .(dot) or -(dash) in local
//apply the same things for domain and verify if we have a consecutivly .(dot)
            if (local.charAt(0) == '.' || local.charAt(local.length-1) == '.' || domain.charAt(0) == '-' || domain.charAt(0) == '.'  
            || domain.charAt(domain.length-1) == '-' || domain.charAt(domain.length-1) == '.' || theyHaveTwoSuccessiveDot(local) ){
                return false;
            } 
            
            
            //First Nested Function
             // this function verify if they have a consecutivly .(dot) in a word

               def theyHaveTwoSuccessiveDot(maybeEmail: String): Boolean = {
                var s= maybeEmail.indexOf(".");
                
// if .(dot) don't exist or exist in the last element we are sure that we haven't 
// a consecutivly .(dot)
                  if (s == -1 || s == maybeEmail.length-1){
                        return false;
                  }else {
// we strored the position and search from s+1 to maybeEmail.length-1
                      for (i <- s+1 to maybeEmail.length-1){
//if we passed per an other .(dot) we comparing the difference with 1
                          if (maybeEmail.charAt(i) == '.' && (i-s) == 1){
                                return true;
                          } 
                          if(maybeEmail.charAt(i) == '.' && (i-s) != 1){
                              s=i;
                          }
                      }
                      
                      return false;
                  }
    }
  
// verify if the local party content the allowed character          
              for (i <- 0 to local.length -1) {
                  if (!(""+local.charAt(i)).matches(regexLocal))
                     return false;
              }
 
//   verify if the domain party content the allowed character            
              for (j <- 0 to domain.length -1){
                  if (!(""+domain.charAt(j)).matches(regexDomain))
                     return false;
              }
              
              return true;
              
              
        }
        
       
   }


  /**
    * Compute i ^ n
    *
    * Example:
    *
    * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
    * output : 8
    *
    * input : (i = 99, n = 38997)
    * output : 1723793299
    */
  def power(i:Int, n:Int):Int = {
        var res:Int = 1;

//this is a basic algorithme we make a loop from 1 to n and multiply the last result
//by i. we can observe that in this case we will not a try to solve the problem when
//the value of n is negative because in this case the exact value will be a decimal
//or the signature of fonction return Int.

             for(x <- 1 to n) {
               res = res*i;
            }
            
            return res;
        }
}
