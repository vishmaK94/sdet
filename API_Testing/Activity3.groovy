package com.groovyTests

class Activity3 {

	static void main(args) {
		
		def first = 0, second = 1, next = 0
		1.upto(10) { 			
			println "Fibonacci number ${it} : ${first}"
			next = first+second
			(first, second) = [second, next]					
		}
		
	}
}
