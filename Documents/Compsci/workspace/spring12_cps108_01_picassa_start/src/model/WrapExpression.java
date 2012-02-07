package model;

import java.util.List;

import model.util.ColorCombinations;


public class WrapExpression extends ParenExpression{

    protected WrapExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.wrap(results.get(0));
	}
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			// TODO Auto-generated method stub
			return "wrap";
		}

		@Override 
		protected int getNumParam() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			// TODO Auto-generated method stub
			return new WrapExpression(subExpressions);
		} 
		
	}
}
