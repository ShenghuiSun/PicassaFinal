package model;

import java.util.List;

import model.util.ColorCombinations;


public class RandomExpression extends ParenExpression{

	double r =  Math.random(); 
	double g =  Math.random(); 
	double b =  Math.random(); 
	
    protected RandomExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        return ColorCombinations.random(r, g, b);
	}
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			// TODO Auto-generated method stub
			return "random";
		}

		@Override 
		protected int getNumParam() {
			return 0;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			return new RandomExpression(subExpressions);
		} 
		
	}
}
