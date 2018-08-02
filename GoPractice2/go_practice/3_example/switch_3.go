package main 


import (

        "fmt"
        "time"
)


func main () {

        defer fmt.Println("Greetings test")

        today := time.Now()

        switch {
        case today.Hour() < 12 :
                fmt.Println("Good morning")
        case today.Hour() < 17 :
                fmt.Println("Good afternoon")
        default:
                fmt.Println("Good evening")

	}


}
