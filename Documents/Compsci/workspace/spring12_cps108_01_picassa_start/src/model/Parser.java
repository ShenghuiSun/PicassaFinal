package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser
{

    public Parser()
    {
        constructExpressionTypes();
    }
    
    // state of the parser
    private int myCurrentPosition;
    private String myInput;
    private List<Expression.Factory> expressionTypes;
    
    private void constructExpressionTypes()
    {
        expressionTypes = new ArrayList<Expression.Factory>();
        expressionTypes.add(new NumberExpression.Factory());
        expressionTypes.add(new PerlinColorExpression.Factory());
        expressionTypes.add(new PerlinBWExpression.Factory());
        expressionTypes.add(new PlusExpression.Factory());
        expressionTypes.add(new MinusExpression.Factory());
        expressionTypes.add(new ColorExpression.Factory());
        expressionTypes.add(new XExpression.Factory());
        expressionTypes.add(new YExpression.Factory()); 
        expressionTypes.add(new DivideExpression.Factory());
        expressionTypes.add(new ExponentialExpression.Factory());
        expressionTypes.add(new ModulusExpression.Factory());
        expressionTypes.add(new MultiplyExpression.Factory());
        expressionTypes.add(new NegateExpression.Factory());
        expressionTypes.add(new RandomExpression.Factory());
        expressionTypes.add(new FloorExpression.Factory());
        expressionTypes.add(new CeilExpression.Factory());
        expressionTypes.add(new AbsoluteExpression.Factory());
        expressionTypes.add(new ClampExpression.Factory());
        expressionTypes.add(new WrapExpression.Factory());
        expressionTypes.add(new SineExpression.Factory()); 
        expressionTypes.add(new CosineExpression.Factory());
        expressionTypes.add(new TangentExpression.Factory());
        expressionTypes.add(new aTangentExpression.Factory());
        expressionTypes.add(new LogExpression.Factory());
        expressionTypes.add(new LogTenExpression.Factory());
        expressionTypes.add(new RGBtoYUVExpression.Factory());
        expressionTypes.add(new YUVtoRGBExpression.Factory());


    }

    /**
     * Converts given string into expression tree.
     * 
     * @param input expression given in the language to be parsed
     * @return expression tree representing the given formula
     */
    public Expression makeExpression (String input)
    {
        myInput = input;
        myCurrentPosition = 0;
        Expression result = parseExpression();
        skipWhiteSpace();
        if (notAtEndOfString())
        {
            throw new ParserException("Unexpected characters at end of the string: " +
                                      stringAtCurrentPosition(),
                                      ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }

    public Expression parseExpression ()
    {
        skipWhiteSpace();
        for(Expression.Factory type : expressionTypes) {
            if(type.isThisKindofExpression(this)) {
                return type.parseExpression(this);
            }
        }
        throw new ParserException("Unparsable expression: " + stringAtCurrentPosition());
    }


    public String stringAtCurrentPosition() {
        return myInput.substring(myCurrentPosition);
    }

 
    public void skipWhiteSpace ()
    {
        while (notAtEndOfString() && Character.isWhitespace(currentCharacter()))
        {
            myCurrentPosition++;
        }
    }

    public char currentCharacter ()
    {
        return myInput.charAt(myCurrentPosition);
    }

    public void advanceCurrentPosition(int chars)
    {
        myCurrentPosition += chars;
    }
    
    private boolean notAtEndOfString ()
    {
        return myCurrentPosition < myInput.length();
    }

	public CharSequence getmyInput() {
		return myInput; 
	}
	
	public int getCurrentPosition(){
		return myCurrentPosition;
	}
	
	public void setCurrentPosition(int num){
		myCurrentPosition = num; 
	}
}
