#Goal:#

To create an app to crawl http://wiprodigital.com. The crawling should be limited to the internal links wit in the domain, i.e,wiprodigital and should also display the media/images used in the crawled page.

#Technology:#
The technology stack used to implement this application are as below

~ jsoup
~ java
~ log4j
~ junit & mockito
~ Maven

#Build & Excecution:#

+Prerequisites required to build and run this application is
- Java 1.8 installed and setup on the local box
- Maven installed and setup on the local box

- CheckOut the project from github
- Run the cmd in console 'mvn clean install' to build and package the jar
- On successfull execution of the above step, the jar file should be available in target folder as 'webcrawler-1.0.jar'
- Run the jar from the target folder by using cmd 'java -jar webcrawler-1.0.jar > crawloutput.txt '

On successfully completing the execution, the output file will have the list of links along with the media/images in a tree structure in the crawloutput.txt file, which will be available parallel to the jar file.

#Improvements:#

- Implement the presentation layer to display the spilled output
- Provide the output in a json response format to the client


