package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Expression 
{
	
	public abstract RGBColor evaluate(double X, double Y); 
	
	public static abstract class Factory
    {
        public abstract boolean isThisKindofExpression(Parser parser);
        public abstract Expression parseExpression(Parser parser);
        
        protected boolean regexMatches(Pattern regex, Parser parser) {
            Matcher expMatcher =
                regex.matcher(parser.stringAtCurrentPosition());
            return expMatcher.lookingAt();
        }
    }   
	
}