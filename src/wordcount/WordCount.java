package wordcount;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class WordCount {
	
	final static Logger logger = Logger.getLogger(WordCount.class);
    public static void main(String[] args) {
    	logger.info("Hello to word count application" );
    	logger.info("this is an extra log line" );
        try {
            File f = new File("c:/afile1.txt");
            logger.debug("Reading from file" + f.getName());
            Scanner sc;
            sc = new Scanner(f);
            // sc.useDelimiter("[^a-zA-Z']+");
            Map<String, Integer> wordCount = new TreeMap<String, Integer>();
            while(sc.hasNext()) {
                String word = sc.next();
                if(!wordCount.containsKey(word))
                    wordCount.put(word, 1);
                else
                    wordCount.put(word, wordCount.get(word) + 1);
            }
            
            // show results
            //for(String word : wordCount.keySet())
           //     System.out.println(word + " " + wordCount.get(word));
            logger.debug("numbe of words: " + wordCount.size());
        }
        catch(IOException e) {
        	logger.error("Unable to read from file.");
        }
    }
}
