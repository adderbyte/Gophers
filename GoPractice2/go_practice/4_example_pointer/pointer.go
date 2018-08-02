package main

import "fmt"


func main() {

   i ,j := 32,43
   fmt.Printf(" i is %v, j is %v \n", i,j )
   p:= &i  // point to i
   fmt.Print("view value of what p point to : ")
   fmt.Println(*p) // read i through the pointer
   fmt.Print("\nset i through pointer : ")
   *p = 21 // set i through pointer
   fmt.Println(i)
   
   

   p   = &j
   *p = *p/j
   fmt.Println("\nChange Value of j :")
   fmt.Println(j)




}
