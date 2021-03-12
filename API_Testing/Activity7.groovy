package com.groovyTests

class Activity7 {

	static void main(args) {

		try {
			def path = "src/com/groovyTests/myFile.txt";
			File file = new File(path);
			def isCreated = file.createNewFile()


			def line1 = "A quick brown Fox jumped over the lazy Cow\n"
			def line2 = "John Jimbo jingeled happily ever after\n"
			def line3 = "Th1\$ 1\$ v3ry c0nfus1ng\n"

			file.write(line1)
			file.append(line2)
			file.append(line3)

			file.eachLine {
				if(it ==~ /.*Cow$/) println "Line with \"Cows\" in the end : \"${it}\"\n"
			}
			
			file.eachLine { 
				if(it ==~ /^J.*/) println "Line with \"J\" at the start : \"${it}\"\n"
			}
			
			file.eachLine { 
				if( it ==~ /.*\d\d.*/)  println "Two numbers one after another : \"${it}\"\n"
			}
			
			file.eachLine {
				def matchStr = it=~ /\S+er/
				//println "The string \"${matchStr}\" is present in line : \"${line}\"\n"
				println "Matches with regex - (/\\S+er/) : ${matchStr.findAll()}"
			}
			
			file.eachLine {
				def matchStr = it=~ /\S*\d\W/
				//println "The string \"${matchStr}\" is present in line : \"${line}\"\n"
				println "Matches with regex - (/\\S*\\d\\W/) : ${matchStr.findAll()}"
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace()
		}
	}
}
