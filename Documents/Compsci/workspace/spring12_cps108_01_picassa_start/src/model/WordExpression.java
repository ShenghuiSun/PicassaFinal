package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class WordExpression extends Expression {
	
	private double myX; 
	private double myY; 
	
    private static final Pattern EXPRESSION_CHAR_REGEX = 
        	Pattern.compile("([a-z]+)");

    
    public static abstract class Factory extends Expression.Factory
    {
		
		protected abstract String commandWordName();   
		protected abstract WordExpression constructWordExp();
		
		@Override 
		public boolean isThisKindofExpression(Parser parser) {
	        Matcher expMatcher =
	                EXPRESSION_CHAR_REGEX.matcher(parser.stringAtCurrentPosition());
	            if(expMatcher.lookingAt())
	            {
	            	return getWordCommand(parser).equals(commandWordName());
	            }
	            return false;  
		}
		 
		
		protected String getWordCommand(Parser parser){
	        Matcher charMatcher = EXPRESSION_CHAR_REGEX.matcher(parser.getmyInput());    /// changed getcurrentpos to getmyinput
	        charMatcher.find(parser.getCurrentPosition());  							// changed find(0) to find(getcurrentpos) 
	        String charMatch =
	        		((String) parser.getmyInput()).substring(charMatcher.start(), charMatcher.end());    /// changed getcurrentpos to getmyinput
	        return charMatch; 
	    }
		
		@Override 
		public Expression parseExpression(Parser parser) {
			parser.advanceCurrentPosition(commandWordName().length());
			parser.skipWhiteSpace();
			
	        return constructWordExp(); // took out parser.parseExpression(). check later if necessary since it's only one word and we know
	                                   // by default what word it is bc we're calling that specific class
		}
    }
    
}
