package main

import (
	"fmt"
	"math/rand"
	"time"
)

func random(min, max int) int {
	rand.Seed(time.Now().UTC().UnixNano())
	return rand.Intn((max-min)+1) + min
}

func main() {
	rand.Seed(time.Now().UTC().UnixNano())
	myrand := random(0, 2)
	fmt.Println(myrand)
}
