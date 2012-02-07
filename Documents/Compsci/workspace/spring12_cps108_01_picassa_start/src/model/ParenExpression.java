package model;

import java.util.*;
import java.util.regex.*;

public abstract class ParenExpression extends Expression {
    
    private List<Expression> subexpressions;
    
    protected ParenExpression(List<Expression> subexpressions)
    {
        this.subexpressions = subexpressions;
    }
    
    protected List<RGBColor> evaluateSubexpressions(double X, double Y)
    {
        List<RGBColor> result = new ArrayList<RGBColor>(subexpressions.size());
        for(Expression exp : subexpressions) {
            result.add(exp.evaluate(X, Y));
        }
        return result;
    }
    
    protected List<Expression> getSubexpressions()
    {
        return Collections.unmodifiableList(subexpressions);
    }
    
    public abstract static class Factory extends Expression.Factory
    {
        private static final Pattern EXPRESSION_BEGIN_REGEX =
            Pattern.compile("\\(([a-z]+)");

        protected String getCommand(Parser parser) {
            Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(parser.stringAtCurrentPosition());
            expMatcher.find(0);
            return expMatcher.group(1);
        } 
        
        @Override
        public boolean isThisKindofExpression(Parser parser) {
            if(!regexMatches(EXPRESSION_BEGIN_REGEX,parser))
                return false;
            return getCommand(parser).equals(commandName());
        }

        protected abstract String commandName();
        protected abstract int getNumParam();
        protected abstract ParenExpression constructParenExp(List<Expression> subExpressions);
        
        @Override
        public Expression parseExpression(Parser parser) {
            if(!isThisKindofExpression(parser))
                throw new ParserException("Attempt to parse invalid string as " + commandName() + " paren expression");

            parser.advanceCurrentPosition(commandName().length() + 1);

            List<Expression> subexpressions = new ArrayList<Expression>();
            for(int i = 0; i < getNumParam(); i++) {
                subexpressions.add(parser.parseExpression());
            }
            
            parser.skipWhiteSpace();
            if (parser.currentCharacter() == ')')
            {
                parser.advanceCurrentPosition(1);
                return constructParenExp(subexpressions);
            }
            else
            {
                throw new ParserException("Expected close paren, instead found " +
                                          parser.stringAtCurrentPosition());
            }
        }
            
    }
}
