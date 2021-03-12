package com.groovyTests

class Activity5 {

	static void main(args) {
		
		def mixedValues = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		
		def intList = []
		def strList = []
		
		mixedValues.each { 
			(it.getClass()==Integer) ? intList.add(it) 
				: (it.getClass()==String) ? strList.add(it)
				: '' 
		}
		
		println "Actual list : ${mixedValues}"
		println "Integer list : ${intList}"
		println "String list : ${strList}"
	}
}
