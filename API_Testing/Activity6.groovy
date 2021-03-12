package com.groovyTests

class Activity6 {

	static void main(args) {
		
		def myMap = [:]
		myMap.put("Gabbie", "gForGabbie@hotmail.com")
		myMap.put("Kevin", "kMalone@hotmail.com")
		myMap.put("Hannah", "hannahKeithMariann@yahoo.com")
		//println myMap
		
		def printMap = { println "First Name: ${it} | Email: ${myMap.get(it)}" }
		
		println "Original Map"
		myMap.keySet().each printMap
		
		def anotherMap = ["Farhad" : "farhadKhan90@gmail.com", "John" : "johnMc@gmail.com"]
		def newMap = myMap<<anotherMap
		//newMap = newMap.plus(["Hello" : "hello@gmail.com"])
		
		println "\nNew Map"
		newMap.keySet().each printMap
		
		println "\nSorted Values"
		//newMap.values().each { println "${it} : ${it.length()}" }
		def sortedValues = newMap.values().sort { it.length() }
		println sortedValues
	}
}
