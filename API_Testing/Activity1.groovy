package com.groovyTests

class Activity1 {

	static void main(args) {
		
		def x
		int y
		
		def arr = [1, 2.0, "Three", true, x, y]
		
		arr.each { println "Element : ${it} | Data Type: ${it.getClass()}" }
		
	}
}
