package model;

import java.util.List;

import model.util.ColorCombinations;

 
public class MultiplyExpression extends ParenExpression{
 
    protected MultiplyExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.multiply(results.get(0), results.get(1));
	}
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			// TODO Auto-generated method stub
			return "mul";
		}

		@Override 
		protected int getNumParam() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			// TODO Auto-generated method stub
			return new MultiplyExpression(subExpressions);
		} 
		
	}
}
